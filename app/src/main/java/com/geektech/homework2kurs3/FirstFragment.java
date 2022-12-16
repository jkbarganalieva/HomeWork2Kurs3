package com.geektech.homework2kurs3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    Handler handler = new Handler();
    Runnable runnable;


    ///

    private boolean downWithoutUp = false;

    private boolean mIsTouching = false;

    private TextView tvResult;
    private Button btnPlus;
    private Button btnMinus;
    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        initListener();
    }

    private void initView() {
        btnPlus = requireActivity().findViewById(R.id.btn_plus);
        btnMinus = requireActivity().findViewById(R.id.btn_minus);
        tvResult = requireActivity().findViewById(R.id.tv_result);
    }

    private void initListener() {

        btnPlus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (!btnPlus.isPressed()) return;
                        count++;
                        String result = Integer.toString(count);

                        tvResult.setText(result);

                        if (count == 20) {
                            getActivity().getSupportFragmentManager().
                                    beginTransaction().replace(R.id.container, new SecondFragment())
                                    .addToBackStack(null).commit();
                        }

                        handler.postDelayed(runnable, 100);
                    }
                };

                handler.postDelayed(runnable, 100);
                return false;
            }
        });
        btnMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (!btnMinus.isPressed()) return;
                        count--;
                        String result = Integer.toString(count);

                        tvResult.setText(result);

                        handler.postDelayed(runnable, 100);
                    }
                };

                handler.postDelayed(runnable, 100);
                return false;
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                String result = Integer.toString(count);

                tvResult.setText(result);

                if (count == 20) {
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
                String result = Integer.toString(count);

                tvResult.setText(result);
            }
        });
    }
}

