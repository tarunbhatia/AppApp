package bitterlakestudios.tarun.com.appapp.AdapterHelper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import bitterlakestudios.tarun.com.appapp.Activity.CandidateDetailActivity;
import bitterlakestudios.tarun.com.appapp.Pojos.Candidate;
import bitterlakestudios.tarun.com.appapp.R;
import bitterlakestudios.tarun.com.appapp.SDCardHelper.SDCardHelper;

/**
 * Created by Tarun on 10/7/2015.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<Candidate> {

    Context context = getContext();
    private final String[] candidateNames;
    private final String[] candidateParty;
    private final Bitmap[] candidateImages;
    private Candidate[] localCandidates;
    private ArrayList<Candidate> localCandidates2;
    SDCardHelper sdCardHelper = new SDCardHelper();
    private int i = 0;

    public MySimpleArrayAdapter(Context context, int resource, Candidate[] candidates) {
        super(context, resource, candidates);
        //Adding an extra size for the add
        localCandidates2 = new ArrayList<>(candidates.length);
        int i = 0;
        for(Candidate candidate : candidates){
            i++;
            localCandidates2.add(candidate);

        }
        Collections.sort(localCandidates2, new Comparator<Candidate>() {
            public int compare(Candidate cnd1, Candidate cnd2) {
                return cnd1.getName().compareToIgnoreCase(cnd2.getName());
            }
        });

        i=0;
        candidateNames = new String[localCandidates2.size()];
        candidateParty = new String[localCandidates2.size()];
        candidateImages = new Bitmap[localCandidates2.size()];
        localCandidates = new Candidate[localCandidates2.size()];
        for(Candidate candidate : localCandidates2){
            this.candidateNames[i] =  candidate.getName();
            this.candidateParty[i] = candidate.getParty();
            String candidateImageName = candidate.getCandidateKey().toLowerCase()+".jpg";
            Bitmap bmp = BitmapFactory.decodeFile("/storage/emulated/0/AppApp/cache/"+candidateImageName);
            if(candidate.getCandidateKey().equalsIgnoreCase("c10001")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10001);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10002")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10002);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10003")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10003);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10004")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10004);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10005")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10005);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10006")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10006);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10007")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10007);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10008")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10008);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10009")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10009);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10010")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10010);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10011")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10011);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10012")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10012);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c100013")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10013);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c100014")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10014);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10015")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10015);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10016")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10016);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10017")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10017);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10018")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10018);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10019")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10019);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10020")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10020);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10021")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10021);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10022")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10022);
            }
            else if(candidate.getCandidateKey().equalsIgnoreCase("c10023")){
                bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.c10023);
            }

            this.candidateImages[i] = bmp;
            localCandidates[i] = candidate;
            i++;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_mainpage, parent, false);
        if(position!=(candidateNames.length-1)) {
            TextView textView = (TextView) rowView.findViewById(R.id.candidateFirstLine);
            TextView secondTextView = (TextView) rowView.findViewById(R.id.candidateSecondLine);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.candidateIcon);
            textView.setText(candidateNames[position]);

            secondTextView.setText(candidateParty[position]);
            if (secondTextView.getText().toString().equalsIgnoreCase("Republican")) {
                secondTextView.setTextColor(Color.RED);
            } else {
                secondTextView.setTextColor(Color.BLUE);
            }
            if (candidateImages[position] != null) {
                //imageView.setImageDrawable(candidateImages[position].getDrawable());
                //String candidateImageName = candidate.getCandidateKey().toLowerCase()+".jpg";
                imageView.requestLayout();
                imageView.getLayoutParams().height = 200;
                imageView.getLayoutParams().width = 150;
                imageView.setImageBitmap(candidateImages[position]);
            }
        }
        //Show an add at the end
        if(position == (candidateNames.length-1)){
            AdView mAdView = (AdView) rowView.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
        return rowView;
    }

    public AdapterView.OnItemClickListener onItemClickListenerHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(getContext(), CandidateDetailActivity.class);
            intent.putExtra("Candidate", localCandidates[position]);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
        }
    };


}
