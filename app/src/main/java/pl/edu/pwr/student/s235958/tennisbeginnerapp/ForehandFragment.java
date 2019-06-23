package pl.edu.pwr.student.s235958.tennisbeginnerapp;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class ForehandFragment extends Fragment {


    VideoView videoView;
    String path = "android.resource://" +  getContext() + "/" + R.raw.forehand;
//    public static final String API_KEY = "AIzaSyCjnSHTmUAzu-3nUhk1Oyro3j4zUccfAs4";
//    private static final String VIDEO_ID = "GKlNsxdEf3U";
//    private static final int RECOVERY_DIALOG_REQUEST = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forehand, container, false);

//        videoView = (VideoView) view.findViewById(R.id.videoView);
        //String path = Environment.getExternalStorageDirectory().getPath()+"/forehand.mp4";

//        videoView.setVideoPath(path);
//        videoView.start();
//
//

        //VideoView videoView = (VideoView)view.findViewById(R.id.videoView);
        //videoView.setVideoURI(Uri.parse(path));

        videoView = (VideoView) view.findViewById(R.id.videoView);
        videoView.setVideoPath(path);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.requestFocus();
                videoView.start();
            }
        });


        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);




        return view;
    }


}
