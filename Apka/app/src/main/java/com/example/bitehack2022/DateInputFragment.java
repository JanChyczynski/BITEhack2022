package com.example.bitehack2022;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
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

import java.util.Date;

public class DateInputFragment extends Fragment {

    private FragmentDateInputBinding binding;

    public DateInputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDateInputBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = binding.datePicker1.getYear();
                int month = binding.datePicker1.getMonth();
                int day = binding.datePicker1.getDayOfMonth();
                Date date = new Date(year - 1900, month, day);
                Bitmap bitmap = ((MainActivity) getActivity()).bitmap;
                Storage storage = ((MainActivity) getActivity()).storage;

                storage.addProduct(new Product(date, bitmap));

                NavHostFragment.findNavController(DateInputFragment.this)
                        .navigate(R.id.action_DateInputFragment_to_SecondFragment);
            }
        });
    }


}