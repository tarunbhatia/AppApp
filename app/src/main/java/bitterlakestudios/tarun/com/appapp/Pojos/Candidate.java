package bitterlakestudios.tarun.com.appapp.Pojos;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

import com.google.android.gms.plus.model.people.Person;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tarun on 8/29/2015.
 */
public class Candidate implements Serializable {

    private String name;
    private String bio;
    private String candidateKey;
    private String candidatePhoto;
    private String currentTown;
    private Date dateOfBirth;
    private String[] hashTags;
    private String homeTown;
    private String officialURL;
    private String party;
    private String religion;
    private String sortName;
    private String twitterHandle;
    //private Bitmap image;
    //public Bitmap getImage(){ return image; }
    //public void setImage(Bitmap image) { this.image = image;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public String getBio(){
        return bio;
    }

    public String getCandidateKey() {
        return candidateKey;
    }

    public void setCandidateKey(String candidateKey) {
        this.candidateKey = candidateKey;
    }

    public String getCandidatePhoto() {
        return candidatePhoto;
    }

    public void setCandidatePhoto(String candidatePhoto) {
        this.candidatePhoto = candidatePhoto;
    }

    public String getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(String currentTown) {
        this.currentTown = currentTown;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getHashTags() {
        return hashTags;
    }

    public void setHashTags(String[] hashTags) {
        this.hashTags = hashTags;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getOfficialURL() {
        return officialURL;
    }

    public void setOfficialURL(String officialURL) {
        this.officialURL = officialURL;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }
}
