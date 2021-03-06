package org.rtspviewer.player.util;

import android.util.Log;

/**
 *
 * Created by giovanni on 11/5/15.
 */
public class RTSPOptionsBackground extends Thread {

    private String targetUrl;
    private RTSPControl rtspControl;

    public RTSPOptionsBackground(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(5000);
                Log.d("THREAD", "Background task");
                if(rtspControl == null) {
                    this.rtspControl = new RTSPControl(targetUrl);
                    this.rtspControl.RTSPOptions();
                }
                else {
                    this.rtspControl.RTSPOptions();
                }
            }
            catch (Exception err) {
                Log.e(getClass().getName(), "Ex: " + err.getMessage());
            }
        }
    }
}
