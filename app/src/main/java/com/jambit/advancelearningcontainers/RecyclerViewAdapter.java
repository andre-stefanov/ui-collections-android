package com.jambit.advancelearningcontainers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jambit.advancelearningcontainers.RecyclerFragment.OnFragmentInteractionListener;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int TYPE_HEADER = 0;

    private static final int TYPE_ITEM = 1;

    private final Content.ColorSection[] sections;

    private final OnFragmentInteractionListener fragmentInteractionListener;

    RecyclerViewAdapter(Content.ColorSection[] sections, OnFragmentInteractionListener fragmentInteractionListener) {
        this.sections = sections;
        this.fragmentInteractionListener = fragmentInteractionListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false);
                return new HeaderViewHolder(headerView);
            case TYPE_ITEM:
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
                ColorViewHolder.OnSelectedListener colorSelectedListener = fragmentInteractionListener::onListFragmentInteraction;
                return new ColorViewHolder(itemView, colorSelectedListener);
            default:
                throw new IllegalArgumentException("unknown view type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        int section = position / sections.length;
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.setText(sections[section].name);
                return;
            case TYPE_ITEM:
                ColorViewHolder colorViewHolder = (ColorViewHolder) holder;
                int item = position % sections.length - 1;
                colorViewHolder.setColor(sections[section].colors[item]);
                return;
            default:
                throw new IllegalArgumentException("unknown view type");
        }
    }

    @Override
    public int getItemCount() {
        int sum = 0;
        for (Content.ColorSection section : sections) {
            sum += 1 + section.colors.length;
        }
        return sum;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % sections.length == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

}
