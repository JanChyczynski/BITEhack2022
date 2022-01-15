package com.example.bitehack2022;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
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

        for (Product product : storage.getProducts())
        {

        }

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