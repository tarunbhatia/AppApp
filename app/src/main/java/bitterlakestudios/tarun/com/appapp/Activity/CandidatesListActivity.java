package bitterlakestudios.tarun.com.appapp.Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import bitterlakestudios.tarun.com.appapp.AdapterHelper.MySimpleArrayAdapter;
import bitterlakestudios.tarun.com.appapp.Pojos.Candidate;
import bitterlakestudios.tarun.com.appapp.R;
import bitterlakestudios.tarun.com.appapp.SDCardHelper.SDCardHelper;

public class CandidatesListActivity extends ListActivity {

    ArrayList<Candidate> localCandidates = new ArrayList<>();
    SDCardHelper sdCardHelper = new SDCardHelper();
    DownloadCandidateBitmapHelper bitmapHelper = new DownloadCandidateBitmapHelper();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_candidates_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_candidates_list);

        localCandidates = sdCardHelper.restoreCandidatesFromSDCard("CandidateData");
        bitmapHelper.execute();

    }

    private class DownloadCandidateBitmapHelper extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //try {
            //    if (Environment.getExternalStorageState() != null) {
            //        File dir = new File(Environment.getExternalStorageDirectory(),
            //                "AppApp/cache");

            //        try {
            //            if (!dir.exists()) {
            //                dir.mkdirs();
            //           }

            //        } catch (Exception e) {
            //            Log.v("ERROR CREATING DIR", e.getMessage());
            //        }

            //        try {
            //            for (Candidate candidate : localCandidates) {
            //                File file = new File(dir, candidate.getCandidateKey() + "TEST.jpg");
            //                URL url = new URL(candidate.getCandidatePhoto());
            //                Log.v("TEST APP", candidate.getCandidatePhoto());
            //                URLConnection urlConnection = url.openConnection();
            //                InputStream inputStream = urlConnection.getInputStream();
                            //This is going to help push the image in the candidate pojos
                            //TODO take this out after we fix loading images from url
                            //candidate.setImage(sdCardHelper.getCandidateImage("c10001.jpg"));
            //                if (inputStream != null) {

                                //Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                //if(bitmap!=null){
                                //    sdCardHelper.saveCandidateBitmapToSDCard(candidate.getCandidateKey(), bitmap);
                                //    inputStream.close();
                                //}
            //                    OutputStream os = new FileOutputStream(file);
            //                    byte[] data = new byte[inputStream.available()];
            //                    inputStream.read(data);
            //                    os.write(data);
            //                    inputStream.close();
            //                    os.close();
            //                }
            //            }
            //        } catch (Exception e){
            //            Log.v("TEST APP", e.getMessage());
            //        }
            //    }
            //}catch(Exception e2){
            //    Log.v("ERR WRITING JPG SDCARD", e2.getMessage());
            //}
            return null;
        }

        @Override
        protected void onPostExecute(Void params) {
            super.onPostExecute(params);
            //Adding an extra one for adds
            Candidate[] subLocalCandidates = new Candidate[localCandidates.size()+1];
            int i = 0;
            for (Candidate candidate : localCandidates) {
                subLocalCandidates[i] = candidate;
                i++;
                if(candidate.getName().contains("Cruz")){
                    subLocalCandidates[i] = candidate;
                    i++;
                }
            }

            ListView listView = getListView();
            MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getApplicationContext(), i, subLocalCandidates);
            //MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,  localCandidates.toArray());
            listView.setAdapter(adapter);

            //Launching the candidate detail page
            listView.setOnItemClickListener(adapter.onItemClickListenerHandler);

        }
    }
}