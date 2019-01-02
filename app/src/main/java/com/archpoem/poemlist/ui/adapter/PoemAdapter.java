package com.archpoem.poemlist.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archpoem.poemlist.R;
import com.archpoem.poemlist.model.Poem;

import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class PoemAdapter extends RecyclerView.Adapter<PoemAdapter.PoemViewHodler> {

    private List<Poem> mPoems;

    public void addData(List<Poem> poems) {
        this.mPoems = poems;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PoemViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_poem_layout, parent, false);

        return new PoemViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PoemViewHodler holder, int position) {
        holder.mTvPoem.setText(mPoems.get(position).getPoemContent());
    }

    @Override
    public int getItemCount() {
        return mPoems == null ? 0 : mPoems.size();
    }

    public class PoemViewHodler extends RecyclerView.ViewHolder {

        private TextView mTvPoem;

        public PoemViewHodler(View itemView) {
            super(itemView);

           mTvPoem = itemView.findViewById(R.id.tv_poem);
        }
    }
}
