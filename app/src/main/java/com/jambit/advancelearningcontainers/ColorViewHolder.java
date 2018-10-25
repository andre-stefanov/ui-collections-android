package com.jambit.advancelearningcontainers;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ColorViewHolder extends RecyclerView.ViewHolder {

    interface OnSelectedListener {
        void onColorClicked(String color);
    }

    private final View rootView;
    private final TextView textView;
    private final OnSelectedListener listener;

    public ColorViewHolder(View view, OnSelectedListener listener) {
        super(view);
        this.rootView = view;
        this.textView = view.findViewById(R.id.textview_color);
        this.listener = listener;
    }

    public void setColor(String color) {
        textView.setText(color);
        rootView.setBackgroundColor(Color.parseColor(color));
        rootView.setOnClickListener(v -> listener.onColorClicked(color));
    }
}
