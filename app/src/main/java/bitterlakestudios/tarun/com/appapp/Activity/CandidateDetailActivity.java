package bitterlakestudios.tarun.com.appapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import bitterlakestudios.tarun.com.appapp.Pojos.Candidate;
import bitterlakestudios.tarun.com.appapp.R;

public class CandidateDetailActivity extends Activity implements View.OnClickListener {

    Candidate item = new Candidate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        item = (Candidate) intent.getExtras().getSerializable("Candidate");
        setTitle(item.getName());
        setContentView(R.layout.activity_candidate_detail);
        TextView candidateBioTextView = (TextView) findViewById(R.id.candidateBioTextView);
        candidateBioTextView.setText(item.getBio());
        candidateBioTextView.setVerticalScrollBarEnabled(true);
        candidateBioTextView.setMovementMethod(new ScrollingMovementMethod());

        //TextView candidateDOBEditTextView = (TextView)findViewById(R.id.candidateDOBEditTextView);
        //candidateDOBEditTextView.setText(item.getDateOfBirth().toString());

        //Get the AGE from DOB
        TextView candidateAgeEditTextView = (TextView)findViewById(R.id.candidateAgeEditTextView);
        Date dob = item.getDateOfBirth();
        Date currentDate = new Date(System.currentTimeMillis());
        Calendar a = getCalendar(dob);
        Calendar b = getCalendar(currentDate);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        String ageStr = ""+diff;
        candidateAgeEditTextView.setText(ageStr);
        TextView candidateEditResidenceEditTextView = (TextView)findViewById(R.id.candidateEditResidenceEditTextView);
        candidateEditResidenceEditTextView.setText(item.getCurrentTown());
        TextView candidateEditHomeTownTextView = (TextView)findViewById(R.id.candidateEditHomeTownTextView);
        candidateEditHomeTownTextView.setText(item.getHomeTown());
        //TextView candidateYearsInOfficeEdiTextView = (TextView)findViewById(R.id.candidateYearsInOfficeEdiTextView);
        //candidateYearsInOfficeEdiTextView.setText(item.get());
        TextView candidateReligionEdiTextView = (TextView) findViewById(R.id.candidateReligionEdiTextView);
        candidateReligionEdiTextView.setText(item.getReligion());

        //Adding Image to the Candidate Detail
        String candidateImageName = item.getCandidateKey().toLowerCase()+".jpg";
        Bitmap bmp = BitmapFactory.decodeFile("/storage/emulated/0/AppApp/cache/" + candidateImageName);
            ImageView candidateImage = (ImageView)findViewById(R.id.candidateImageView);
        candidateImage.setMinimumHeight(400);
        candidateImage.setMinimumWidth(300);
        candidateImage.requestLayout();
        candidateImage.getLayoutParams().height = 400;
        candidateImage.getLayoutParams().width = 300;
        candidateImage.setImageBitmap(bmp);
        TextView candidateHomePageTextView = (TextView) findViewById(R.id.candidateWebsite);
        candidateHomePageTextView.setText(item.getOfficialURL());
        candidateHomePageTextView.setOnClickListener(this);
        candidateHomePageTextView.setPaintFlags(candidateHomePageTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        TextView candidateTwitterTextView = (TextView) findViewById(R.id.candidateTwitter);
        candidateTwitterTextView.setText(item.getTwitterHandle());
        candidateTwitterTextView.setOnClickListener(this);
        candidateTwitterTextView.setPaintFlags(candidateTwitterTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_settings, menu);
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
        //noinspection SimplifiableIfStatement
        else if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.candidateWebsite:
                    Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getOfficialURL()));
                    if(!item.getOfficialURL().isEmpty()) {
                        startActivity(urlIntent);
                    }
                    break;
                case R.id.candidateTwitter:
                    urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"+item.getTwitterHandle().substring(1)));
                    if(!item.getTwitterHandle().isEmpty()) {
                        startActivity(urlIntent);
                    }
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, "An Error Occurred. Please Try Again.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
