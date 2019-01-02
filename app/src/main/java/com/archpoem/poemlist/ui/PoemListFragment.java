package com.archpoem.poemlist.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archpoem.poemlist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class PoemListFragment extends Fragment {

    public static final String TAG = "PoemListFragment";

    @BindView(R.id.recyclerview)
    RecyclerView mPoemListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poemlist_fragment_layout, container, false);
        ButterKnife.bind(rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
