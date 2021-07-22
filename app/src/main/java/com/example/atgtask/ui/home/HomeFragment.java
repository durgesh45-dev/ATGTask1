package com.example.atgtask.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atgtask.FlickrApi;
import com.example.atgtask.PhotoAdapter;
import com.example.atgtask.PhotoSources;
import com.example.atgtask.Photos;
import com.example.atgtask.R;
import com.example.atgtask.RetrofitClient;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private TextView textView;

    private FlickrApi flickrApi;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        textView = root.findViewById(R.id.text_home);


        getPhotos();

        return root;
    }

    private void getPhotos() {


        FlickrApi flickrApi = RetrofitClient.getClient().create(FlickrApi.class);
        flickrApi.getPhotos().enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {
                Log.d("TAG", "" + response.code());

                if (!response.isSuccessful()) {
                    String string = "Code" + response.code();
                    textView.setText(string);
                    return;
                }

                if (response.body().getPhoto().getPhotoItems() != null) {
                    Photos photos = response.body();
                    ArrayList<PhotoSources> photoSourceList = photos.getPhoto().getPhotoItems();
                    setRecyclerView(photoSourceList);
                    Toast.makeText(getActivity().getApplicationContext(), "Size " + photos.getPhoto().getPhotoItems().size(), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity().getApplicationContext(), "Null response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Photos> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });


    }

    private void setRecyclerView(ArrayList<PhotoSources> photoSourceList) {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        PhotoAdapter photoAdapter = new PhotoAdapter(photoSourceList, getActivity().getApplicationContext());
        recyclerView.setAdapter(photoAdapter);
    }


}