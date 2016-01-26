package bitterlakestudios.tarun.com.appapp.Activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import bitterlakestudios.tarun.com.appapp.AdapterHelper.AboutArrayAdapter;
import bitterlakestudios.tarun.com.appapp.R;

public class AboutActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String aboutStr[] = new String[6];
        aboutStr[0] = getString(R.string.AboutStr);
        aboutStr[1] = getString(R.string.FeedbackStr);
        aboutStr[2] = "";
        aboutStr[3] = "";
        aboutStr[4] = "";
        aboutStr[5] = "";
        //TextView aboutTxt = (TextView) findViewById(R.id.aboutStr);
        //aboutTxt.setText(R.string.AboutStr);


        ListView listView = getListView();
        AboutArrayAdapter arrayAdapter = new AboutArrayAdapter(this, 6, aboutStr);
        listView.setAdapter(arrayAdapter);

        //Launching the candidate list page
        listView.setOnItemClickListener(arrayAdapter.onItemClickListenerHandler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(getApplicationContext(), CandidatesListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
