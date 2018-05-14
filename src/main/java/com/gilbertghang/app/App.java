package com.gilbertghang.app;

import com.google.transit.realtime.NyctSubway;
import com.google.transit.realtime.GtfsRealtime;

import java.net.MalformedURLException;
import java.net.URL;

public class App
{

    private static String BASE_URL = "http://datamine.mta.info/mta_esi.php?key=%s&feed_id=%d";

    public static void main(String[] args)
    {
        URL mtaGtfsUrl = null;
        try {
            mtaGtfsUrl = buildMtaGtfsUrl(26);
        } catch (MalformedURLException me) {
            System.out.println("Could not build url");
            me.printStackTrace();
            return;
        }

        System.out.println(mtaGtfsUrl);
    }

    private static URL buildMtaGtfsUrl(int feedId) throws MalformedURLException {
        String mtaApiKey = System.getenv("MTA_KEY");
        String mtaGtfsDataUrlString = String.format(BASE_URL, mtaApiKey, feedId);
        return new URL(mtaGtfsDataUrlString);
    }
}
