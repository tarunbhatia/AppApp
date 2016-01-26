package bitterlakestudios.tarun.com.appapp.PListHelper;

import android.os.AsyncTask;
import android.util.Log;

import com.dd.plist.NSArray;
import com.dd.plist.NSDate;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.PropertyListParser;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;

import bitterlakestudios.tarun.com.appapp.Pojos.Candidate;
import bitterlakestudios.tarun.com.appapp.SDCardHelper.SDCardHelper;

/**
 * Created by Tarun on 8/29/2015.
 */
public class CandidatePListHelper {

    ArrayList<Candidate> candidates = new ArrayList<Candidate>();
    SDCardHelper sdCardHelper = new SDCardHelper();

    public ArrayList<Candidate> readCandidateInfo() {

        new CandidatePlistURLHelper().execute(candidates);
        return candidates;
    }

    public class CandidatePlistURLHelper extends AsyncTask<ArrayList<Candidate>, Void, ArrayList<Candidate>> {
        ArrayList<Candidate> localCandidates = new ArrayList<Candidate>();
        Candidate candidate = null;
        @Override
        protected ArrayList<Candidate> doInBackground(ArrayList<Candidate>... params) {
            try {
                URL url = new URL("https://dl.dropboxusercontent.com/s/go8lkt9w3rg4nkk/Candidates.plist");
                URLConnection urlConnection = url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(in);
                NSObject[] parameters = ((NSArray) rootDict.objectForKey("candidates")).getArray();
                for (NSObject dict : parameters) {
                    if(((NSDictionary)dict)!=null){
                        candidate = new Candidate();
                        if((((NSDictionary)dict).objectForKey("bio")!=null) && (((NSDictionary)dict).objectForKey("bio").toString()!=null))
                        {
                            candidate.setBio(((NSDictionary)dict).objectForKey("bio").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("candidateKey")!=null) && (((NSDictionary)dict).objectForKey("candidateKey").toString()!=null))
                        {
                            candidate.setCandidateKey(((NSDictionary) dict).objectForKey("candidateKey").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("name")!=null) && (((NSDictionary)dict).objectForKey("name").toString()!=null))
                        {
                            candidate.setName(((NSDictionary) dict).objectForKey("name").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("candidatePhoto")!=null) && (((NSDictionary)dict).objectForKey("candidatePhoto").toString()!=null))
                        {
                            candidate.setCandidatePhoto(((NSDictionary) dict).objectForKey("candidatePhoto").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("currentTown")!=null) && (((NSDictionary)dict).objectForKey("currentTown").toString()!=null))
                        {
                            candidate.setCurrentTown(((NSDictionary) dict).objectForKey("currentTown").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("dateOfBirth")!=null) && (((NSDictionary)dict).objectForKey("dateOfBirth").toString()!=null))
                        {
                            NSDate dob = ((NSDate) ((NSDictionary) dict).objectForKey("dateOfBirth"));
                            Date date = dob.getDate();

                            candidate.setDateOfBirth(date);
                        }
                        if(((NSDictionary)dict).objectForKey("hashTags")!=null && ((NSArray) ((NSDictionary) dict).objectForKey("hashTags")).getArray()!=null)
                        {
                            NSObject[] hashTags = ((NSArray) ((NSDictionary) dict).objectForKey("hashTags")).getArray();
                            String[] hashTagArray = new String[hashTags.length];
                            int i = 0;
                            for(NSObject hashTag : hashTags){
                                hashTagArray[i]=hashTag.toString();
                                i++;
                            }
                            candidate.setHashTags(hashTagArray);
                        }

                        if((((NSDictionary)dict).objectForKey("homeTown")!=null) && (((NSDictionary)dict).objectForKey("homeTown").toString()!=null))
                        {
                            candidate.setHomeTown(((NSDictionary) dict).objectForKey("homeTown").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("officialURL")!=null) && (((NSDictionary)dict).objectForKey("officialURL").toString()!=null))
                        {
                            candidate.setOfficialURL(((NSDictionary) dict).objectForKey("officialURL").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("party")!=null) && (((NSDictionary)dict).objectForKey("party").toString()!=null))
                        {
                            candidate.setParty(((NSDictionary) dict).objectForKey("party").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("religion")!=null) && (((NSDictionary)dict).objectForKey("religion").toString()!=null))
                        {
                            candidate.setReligion(((NSDictionary) dict).objectForKey("religion").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("sortName")!=null) && (((NSDictionary)dict).objectForKey("sortName").toString()!=null))
                        {
                            candidate.setSortName(((NSDictionary) dict).objectForKey("sortName").toString());
                        }
                        if((((NSDictionary)dict).objectForKey("twitterHandle")!=null) && (((NSDictionary)dict).objectForKey("twitterHandle").toString()!=null))
                        {
                            candidate.setTwitterHandle(((NSDictionary) dict).objectForKey("twitterHandle").toString());
                        }

                        //String candidateImageName = candidate.getCandidateKey().toLowerCase()+".jpg";
                        //candidate.setImage(sdCardHelper.getCandidateImage(candidateImageName));

                        localCandidates.add(candidate);
                        candidate = null;
                    }
                }

                in.close();

            } catch (Exception e){
                e.printStackTrace();

            }
            Log.v("APP APP", "LOCAL CANDIDATES SIZE" + localCandidates.size());
            return localCandidates;
        }
    }
}
