package com.example.bitehack2022;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.bitehack2022.databinding.FragmentSecondBinding;
import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment {

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
//
//            Button btn1 = new Button(getActivity());
////            btn1.setGravity(Gravity.CENTER_HORIZONTAL);
//            btn1.setText("Opened");
//            constraintLayout.addView(btn1);
//
//            Button btn2 = new Button(getActivity());
//            btn2.setText("Eaten");
//            constraintLayout.addView(btn2);
//
            binding.favoritesGrid.addView(layout);
        }

        Log.d("BLETAG", "po petli");

        for (int i = 0; i < 5; i++) {
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView textView = new TextView(getActivity());
            textView.setText(storage.getAccessToken());
            layout.addView(textView);

            Button btn = new Button(getActivity());
            btn.setGravity(Gravity.CENTER_HORIZONTAL);
            btn.setText("blefs"+Integer.toString(i));
            layout.addView(btn);

            binding.favoritesGrid.addView(layout);
        }



        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                NavHostFragment.findNavController(SecondFragment.this)
////                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//                Log.d("TAGGG", "msg");
//            }
//        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}