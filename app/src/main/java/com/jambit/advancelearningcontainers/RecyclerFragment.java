package com.jambit.advancelearningcontainers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerFragment extends Fragment {

    private int mColumnCount;

    private OnFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecyclerFragment() { }

    public static RecyclerFragment createInstance(int columnCount) {
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.mColumnCount = columnCount;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {

            Context context = view.getContext();

            RecyclerView recyclerView = (RecyclerView) view;

            RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new RecyclerViewAdapter(Content.SECTIONS, mListener);

            if (mColumnCount <= 1) {

                recyclerView.setLayoutManager(new LinearLayoutManager(context));

            } else {

                GridLayoutManager layoutManager = new GridLayoutManager(context, mColumnCount);

                layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        switch (adapter.getItemViewType(position)) {
                            case RecyclerViewAdapter.TYPE_HEADER:
                                return mColumnCount;
                            default:
                                return 1;
                        }
                    }
                });
                recyclerView.setLayoutManager(layoutManager);
            }
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onListFragmentInteraction(String message);
    }
}
