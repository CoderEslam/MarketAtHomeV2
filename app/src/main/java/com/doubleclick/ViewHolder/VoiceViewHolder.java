package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.doubleclick.OnMessageClick;
import com.doubleclick.OnOptionMessage;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class VoiceViewHolder extends BaseViewHolder {

    private VideoView voice;
    private ConstraintLayout ContinerVoice;
    private ImageView downloadVoice, playVoice;
    private boolean isPlay = false;
    private ProgressBar progress;
    private OnMessageClick onMessageClick;
    private OnOptionMessage onOptionMessage;


    public VoiceViewHolder(@NonNull View itemView, OnMessageClick onMessageClick, OnOptionMessage onOptionMessage) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        this.onOptionMessage = onOptionMessage;
        voice = itemView.findViewById(R.id.video);
        downloadVoice = itemView.findViewById(R.id.downloadVoice);
        ContinerVoice = itemView.findViewById(R.id.ContinerVoice);
        progress = itemView.findViewById(R.id.progress);
        playVoice = itemView.findViewById(R.id.playVoice);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Play(Chat chat, int position) {
        if (!chat.getMessage().equals("")) {
            progress.setVisibility(View.GONE);
            downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play));
            voice.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            voice.stopPlayback();
            voice.pause();
        }
//        else {
//            downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.download));
//        }
        voice.setOnCompletionListener(mp -> downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play)));
        MediaController mediaController = new MediaController(itemView.getContext());
        mediaController.setMediaPlayer(voice);
        mediaController.findFocus();
        mediaController.show(0);
        mediaController.setAnchorView(voice);
        mediaController.setEnabled(true);
        voice.setMediaController(mediaController);
        voice.requestFocus();
//        downloadVoice.setOnClickListener(v -> {
//            onMessageClick.onMessageClickListner(chat, getAdapterPosition());
//        });

        downloadVoice.setOnClickListener(v -> {
            if (!chat.getMessage().equals("")) {
                if (isPlay) {
                    downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play));
                    voice.pause();
                    voice.stopPlayback();
                    isPlay = false;
                } else {
                    downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.pause));
                    voice.setVideoURI(Uri.parse(chat.getMessage()));
                    voice.start();
                    isPlay = true;
                }
            }
        });
    }

}
