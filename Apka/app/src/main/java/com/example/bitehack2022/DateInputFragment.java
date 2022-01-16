package com.example.bitehack2022;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.bitehack2022.databinding.FragmentDateInputBinding;
import com.example.bitehack2022.databinding.FragmentSecondBinding;

public class DateInputFragment extends Fragment {

    private FragmentDateInputBinding binding;

    public DateInputFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        Log.d("hejAdam","siema0");
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("hejAdam","siema1");
        binding = FragmentDateInputBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("hejAdam","siema2");

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hejAdam", "siema3");
                NavHostFragment.findNavController(DateInputFragment.this)
                        .navigate(R.id.action_DateInputFragment_to_SecondFragment);
            }
        });
    }


}