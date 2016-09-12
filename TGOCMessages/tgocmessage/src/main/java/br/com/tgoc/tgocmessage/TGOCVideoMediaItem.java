package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by rodrigocavalcante on 9/12/16.
 */
public class TGOCVideoMediaItem implements TGOCMessageMediaInterface {

    Uri uri;

    public TGOCVideoMediaItem (Uri uri) {
        this.uri = uri;
    }

    @Override
    public View getView(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tgoc_video_message_content, null);

        final VideoView tgoc_video_view = (VideoView) view.findViewById(R.id.tgoc_video_view);

        final Button tgoc_play = (Button) view.findViewById(R.id.tgoc_play);
        tgoc_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tgoc_play.setVisibility(View.GONE);
                MediaController mediaController = new MediaController(context);
                mediaController.setAnchorView(tgoc_video_view);
                tgoc_video_view.setMediaController(mediaController);
                tgoc_video_view.setVideoURI(uri);
                tgoc_video_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        tgoc_play.setVisibility(View.VISIBLE);
                    }
                });
                tgoc_video_view.start();
            }
        });

        return view;
    }

    @Override
    public <T> T getData() {

        if(uri != null)
            return (T) uri;

        return null;
    }
}
