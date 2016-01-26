package bitterlakestudios.tarun.com.appapp.AdapterHelper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import bitterlakestudios.tarun.com.appapp.Activity.CandidateDetailActivity;
import bitterlakestudios.tarun.com.appapp.Activity.CandidatesListActivity;
import bitterlakestudios.tarun.com.appapp.R;

/**
 * Created by Tarun on 1/23/2016.
 */
public class AboutArrayAdapter extends ArrayAdapter<String> {
    private String[] aboutStr;
    Context context = getContext();

    public AboutArrayAdapter(Context context, int resource, String[] arrStr) {
        super(context, resource, arrStr);
        aboutStr = new String[arrStr.length];
        aboutStr = arrStr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_about, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.aboutStr);
        textView.setText(aboutStr[position]);
        if(position==1){
            textView.setTypeface(null, Typeface.BOLD);
        }

        if(position==4){
            AdView mAdView = (AdView) rowView.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }

        return rowView;
    }

    public AdapterView.OnItemClickListener onItemClickListenerHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Send out email only on the first position
            if(position == 1) {
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"support@bitterlakestudios.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback");
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        }
    };
}
