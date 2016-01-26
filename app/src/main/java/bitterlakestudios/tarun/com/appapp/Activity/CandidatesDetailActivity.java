package bitterlakestudios.tarun.com.appapp.Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import java.util.Collections;

import bitterlakestudios.tarun.com.appapp.R;

public class CandidatesDetailActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates_detail);

        ListView listView = getListView();

    }
}
