package com.archpoem.poemlist.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archpoem.poemlist.R;
import com.archpoem.poemlist.viewmodel.PoemListViewModel;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class PeomDetailFragment extends Fragment {

    public static String TAG = "PeomDetailFragment";

    private static final String KEY_POEM_ID = "key_poem_id";

    private TextView mPoemDetail;

    private int poemId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poemdetail_layout, container, false);

        mPoemDetail = rootView.findViewById(R.id.tv_poem_detail);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        poemId = (int) getArguments().get(KEY_POEM_ID);

        PoemListViewModel poemListViewModel = ViewModelProviders.of(this).get(PoemListViewModel.class);
        subscribeOnUi(poemListViewModel);
    }

    private void subscribeOnUi(PoemListViewModel poemListViewModel) {
        poemListViewModel.loadPoemById(poemId).observe(this, poem -> {
            if (poem != null) {
                mPoemDetail.setText(poem.getPoemContent());
            }
        });
    }

    public static PeomDetailFragment productPoemDetailFragment(int poemId) {
        PeomDetailFragment poemListFragment = new PeomDetailFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POEM_ID, poemId);
        poemListFragment.setArguments(args);

        return poemListFragment;
    }
}
