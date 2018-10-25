package com.jambit.advancelearningcontainers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    HeaderViewHolder(@NonNull View view) {
        super(view);
        this.textView = view.findViewById(R.id.textview_header);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
