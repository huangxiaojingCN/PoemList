package com.archpoem.poemlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.archpoem.poemlist.model.Poem;
import com.archpoem.poemlist.ui.PeomDetailFragment;
import com.archpoem.poemlist.ui.PoemListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            PoemListFragment poemListFragment = new PoemListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, poemListFragment, PoemListFragment.TAG)
                    .commit();
        }
    }

    public void show(Poem poem) {
        PeomDetailFragment peomDetailFragment = PeomDetailFragment.productPoemDetailFragment(poem.getId());
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("product")
                .replace(R.id.fragment_container, peomDetailFragment, PeomDetailFragment.TAG)
                .commit();
    }
}
