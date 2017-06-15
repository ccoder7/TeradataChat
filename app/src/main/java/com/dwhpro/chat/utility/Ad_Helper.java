package com.dwhpro.chat.utility;

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.dwhpro.chat.R;

import java.util.Arrays;
import java.util.Random;

public class Ad_Helper {
    private static int bigAdCounter = 0;
    public static int adCount = 1;
    public static int adCountGlobal = 1;

    public static final String AD_BANNER = "BANNER";
    public static final String AD_BANNER_MEDIUM = "MEDUIM_RECTANGLE";
    public static final String AD_NATIVE_SMALL = "NSMALL";
    public static final String AD_NATIVE_MEDIUM = "NMEDIUM";
    public static final String AD_NATIVE_BIG = "NBIG";


    public static String[] array = {Ad_Helper.AD_BANNER,Ad_Helper.AD_BANNER_MEDIUM,Ad_Helper.AD_NATIVE_BIG,
            Ad_Helper.AD_NATIVE_SMALL,Ad_Helper.AD_NATIVE_MEDIUM};
    public static String randomStr = array[new Random().nextInt(array.length)];

    public static boolean wannaSendPrivate(int n) {
        int[] bob = {20,35,55,70,90,105,125,140};
        Arrays.sort(bob);
        return Arrays.binarySearch(bob, n) >= 0;
    }

    public static boolean wannaSendGlobal(int n) {
        int[] bob = {20,50,70,100,120,150,170,200};
        Arrays.sort(bob);
        return Arrays.binarySearch(bob, n) >= 0;
    }

    public static InterstitialAd mInterstitialAd;

    public static void showInterstitialAD() {
        bigAdCounter++;
        Log.d("interstitial ", "" + bigAdCounter);
        if (bigAdCounter == 4) {
            showInterstitial();
            bigAdCounter = 0;
        }
    }

    public static void ShowBigAd(Activity activity) {
        // Create the InterstitialAd and set the adUnitId.
        mInterstitialAd = new InterstitialAd(activity);
        // Defined in res/values/strings.xml
        mInterstitialAd.setAdUnitId(activity.getString(R.string.admob_interstitial));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startGame();
            }
        });
        startGame();
    }


    public static void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        try {
            if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                //Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
                startGame();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startGame() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        try {
            if (!mInterstitialAd.isLoaded()) {
                AdRequest adRequest = new AdRequest.Builder().build();
                mInterstitialAd.loadAd(adRequest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}