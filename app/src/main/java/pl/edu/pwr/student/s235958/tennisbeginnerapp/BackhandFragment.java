package pl.edu.pwr.student.s235958.tennisbeginnerapp;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.time.format.TextStyle;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;
import static android.text.Layout.JUSTIFICATION_MODE_NONE;


public class BackhandFragment extends Fragment {


    VideoView videoView;
    String path;
    //TextView backhandDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_backhand, container, false);


        path = "android.resource://" +  getActivity().getPackageName() + "/raw/backhand";

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
        mediaController.setAnchorView(videoView);


        return view;
    }

}
