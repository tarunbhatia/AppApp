package bitterlakestudios.tarun.com.appapp.SDCardHelper;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitterlakestudios.tarun.com.appapp.Pojos.Candidate;

/**
 * Created by Tarun on 11/11/2015.
 */
public class SDCardHelper {

    public void saveCandidateBitmapToSDCard(String fileName, Bitmap candidateBitmap) {
        FileOutputStream fileOutputStream = null;
        //ObjectOutputStream objectOutputStream = null;

        if (Environment.getExternalStorageState() != null) {
            File dir = new File(Environment.getExternalStorageDirectory(),
                        "AppApp/cache");
                try {
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                    File file = new File(dir, fileName);
                    fileOutputStream = new FileOutputStream(file);
                    //objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    candidateBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    //objectOutputStream.writeObject(candidateBitmap);
                    //objectOutputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
            } catch (Exception e) {
                Log.v("ERROR WRITING BITMAP", e.getMessage());
            }
        }
    }

    public Bitmap getCandidateImage(String fileName){
        Bitmap candidateBitmap = null;
        FileInputStream fileInputStream = null;
        //Check if External storage is mounted
        if (Environment.getExternalStorageState() != null) {
            File dir = new File(Environment.getExternalStorageDirectory(),
                    "AppApp/cache");

            try {
                if (!dir.exists()) {
                    Log.v("FileIOService", "No Such Directory Exists");
                }
                File file = new File(dir, fileName);
                fileInputStream = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                candidateBitmap = (Bitmap) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //TODO DO something to warn the user; maybe throw a toast
        else {
        }

        return candidateBitmap;
    }

    public void saveCandidateToSDCard(String fileName, ArrayList<Candidate> candidates){

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        if (Environment.getExternalStorageState() != null) {
            File dir = new File(Environment.getExternalStorageDirectory(),
                    "AppApp/cache");

            try {
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, fileName);
                fileOutputStream = new FileOutputStream(file);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                //for(Candidate candidate : candidates){
                //    candidate.getImage().compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                //}
                objectOutputStream.writeObject(candidates);
                objectOutputStream.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public static ArrayList<Candidate> restoreCandidatesFromSDCard(String fileName) {

        FileInputStream fileInputStream = null;

        ArrayList<Candidate> localCandidates = new ArrayList<Candidate>();
        //Check if External storage is mounted
        if (Environment.getExternalStorageState() != null) {
            File dir = new File(Environment.getExternalStorageDirectory(),
                    "AppApp/cache");

            try {
                if (!dir.exists()) {
                    Log.v("FileIOService", "No Such Directory Exists");
                }
                File file = new File(dir, fileName);
                fileInputStream = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                localCandidates = (ArrayList<Candidate>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //TODO DO something to warn the user; maybe throw a toast
        else {
        }

        return localCandidates;
    }
}
