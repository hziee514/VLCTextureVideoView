package me.wrh.widget.vlctexturevideoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.wrh.widget.VLCTextureVideoView;

public class MainActivity extends AppCompatActivity {

    VLCTextureVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VLCTextureVideoView)findViewById(R.id.vlc_video);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final String url = "http://media.caratech.cn/VR/%E5%85%9A%E5%BB%BA/%E7%AC%AC1%E9%9B%86%EF%BC%9A%E6%97%B6%E4%BB%A3%E4%B9%8B%E9%97%AE.mp4";
        videoView.setOnStateChangedListener(new VLCTextureVideoView.OnStateChangedListener() {
            @Override
            public void onStateChanged(VLCTextureVideoView view, VLCTextureVideoView.State state) {
                if (state == VLCTextureVideoView.State.PREPARING) {
                    view.play();
                }
            }
        });
        videoView.prepare(Uri.parse(url));
    }
}
