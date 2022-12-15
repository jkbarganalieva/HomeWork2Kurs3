package com.geektech.homework2kurs3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private TextView tvResult;
    private Button btnPlus;
    private Button btnMinus;
    int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPlus=view.findViewById(R.id.btn_plus);
        btnMinus=view.findViewById(R.id.btn_minus);
        tvResult=view.findViewById(R.id.tv_result);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                String result=Integer.toString(count);

                tvResult.setText(result);

                if (count==20){
                    getActivity().getSupportFragmentManager().
                            beginTransaction().replace(R.id.container, new SecondFragment())
                            .addToBackStack(null).commit();
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count--;
                String result=Integer.toString(count);

                tvResult.setText(result);
            }
        });


    }
}