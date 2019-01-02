package com.archpoem.poemlist.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archpoem.poemlist.R;
import com.archpoem.poemlist.ui.adapter.PoemAdapter;
import com.archpoem.poemlist.viewmodel.PoemListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class PoemListFragment extends Fragment {

    public static final String TAG = "PoemListFragment";

    @BindView(R.id.recyclerview)
    RecyclerView mPoemListView;

    private PoemAdapter mPoemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poemlist_fragment_layout, container, false);
        ButterKnife.bind(rootView);

        mPoemListView = rootView.findViewById(R.id.recyclerview);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPoemAdapter = new PoemAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mPoemListView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(10, 10, 10, 10);
            }
        });
        mPoemListView.setLayoutManager(linearLayoutManager);
        mPoemListView.setAdapter(mPoemAdapter);

        PoemListViewModel poemListViewModel
                = ViewModelProviders.of(this).get(PoemListViewModel.class);
        subscribeOnUi(poemListViewModel);
    }

    private void subscribeOnUi(PoemListViewModel poemListViewModel) {
        poemListViewModel.getPoemList().observe(this, poems -> {
            mPoemAdapter.addData(poems);
        });
    }
}
