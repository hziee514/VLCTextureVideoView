package me.wrh.widget;

import android.content.Context;

import org.videolan.libvlc.LibVLC;

import java.util.ArrayList;

/**
 * VLC版本: 2.0.6
 * @author wurenhai
 * @date 2017/4/11
 */
public class VLC {

    private static LibVLC libVLC = null;

    public static synchronized LibVLC get(Context context) {
        if (libVLC == null) {
            libVLC = new LibVLC(context.getApplicationContext(), options());
        }
        return libVLC;
    }

    public static ArrayList<String> options() {
        ArrayList<String> options = new ArrayList<>();
        /*options.add("--avcodec-skiploopfilter");
        options.add("-1");
        options.add("--avcodec-skip-frame");
        options.add("0");
        options.add("--network-caching=1000");
        options.add("--androidwindow-chroma");
        options.add("YV12");
        options.add("--audio-resampler");
        options.add("soxr");
        options.add("--freetype-rel-fontsize=16");
        options.add("--freetype-color=16777215");
        options.add("--freetype-background-opacity=128");*/
        /*options.add("--ffmpeg-hw");
        options.add("--no-http-reconnect");
        options.add("--http-continuous");*/
        options.add("-vvv");
        return options;
    }

    public static synchronized void release() {
        if (libVLC != null) {
            libVLC.release();
            libVLC = null;
        }
    }

}
