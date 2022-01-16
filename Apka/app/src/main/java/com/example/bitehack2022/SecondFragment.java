package com.example.bitehack2022;

import android.os.Bundle;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.bitehack2022.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private static final int CAMERA_PERMISSION_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 2;
    private FragmentSecondBinding binding;
    private Storage storage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        storage = ((MainActivity) getActivity()).storage;

        Log.d("BLETAG", "przed petla");
        Log.d("BLETAG", "liczba produktów: "+storage.getProducts().size());

        for (Product product : storage.getProducts())
        {
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);

            ImageView imageView = new ImageView(getActivity());
            imageView.setImageBitmap(product.getBitmap());
            layout.addView(imageView);

            TextView textView = new TextView(getActivity());
            String month = Integer.toString(product.getExpirationDate().getMonth());
            String date = Integer.toString(product.getExpirationDate().getDate());
            textView.setText(date+"."+month);
            layout.addView(textView);


            Button btn1 = new Button(getActivity());
            btn1.setText("Open");
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (btn1.getText().equals("Open")) {
                        // product.open()
                        btn1.setText("Close");
                    } else {
                        // product.close()
                        btn1.setText("Open");
                    }
                }
            });
            layout.addView(btn1);

            Button btn2 = new Button(getActivity());
            btn2.setText("remove");
            layout.addView(btn2);
            binding.favoritesGrid.addView(layout);
        }

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, CAMERA_PERMISSION_CODE);
                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_PERMISSION_CODE) {
            Log.d("DebugTAG", "in Activity Result");
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ((MainActivity)getActivity()).bitmap = (Bitmap) extras.get("data");
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_DateInputFragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}