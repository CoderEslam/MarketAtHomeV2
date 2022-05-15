package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class VoiceViewHolder extends BaseViewHolder {

    private VideoView voice;
    private ImageView downloadVoice, playVoice;
    private boolean isPlay = false;
    private ProgressBar progress;
    private OnMessageClick onMessageClick;
    private String myId;
    private ImageView seen;
    private ProgressBar progressBar;
    private TextView time;

    public VoiceViewHolder(@NonNull View itemView, OnMessageClick onMessageClick, String myId) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        this.myId = myId;
        voice = itemView.findViewById(R.id.video);
        downloadVoice = itemView.findViewById(R.id.downloadVoice);
        progress = itemView.findViewById(R.id.progress);
        playVoice = itemView.findViewById(R.id.playVoice);
        seen = itemView.findViewById(R.id.seen);
        progressBar = itemView.findViewById(R.id.progressBar);
        time = itemView.findViewById(R.id.time);

    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SimpleDateFormat"})
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Play(Chat chat, int position) {
        time.setText(new SimpleDateFormat("M/d/yy, h:mm a").format(chat.getDate()).toString());
        if (!chat.getMessage().equals("")) {
            if (chat.getReceiver().equals(myId)) {
                seen.setVisibility(View.INVISIBLE);
            } else {
                seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
            }
            progress.setVisibility(View.GONE);
            playVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play));
            voice.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            voice.stopPlayback();
            voice.pause();
        }

//        else {
//            downloadVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.download));
//        }
        voice.setOnCompletionListener(mp -> playVoice.setImageDrawable(itemView.getResources().getDrawable(R.drawable.play)));
        MediaController mediaController = new MediaController(itemView.getContext());
        mediaController.setMediaPlayer(voice);
        mediaController.findFocus();
        mediaController.show(0);
        mediaController.setAnchorView(voice);
        mediaController.setEnabled(true);
        voice.setMediaController(mediaController);
        voice.requestFocus();
        downloadVoice.setOnClickListener(v -> {
            onMessageClick.download(chat, getAdapterPosition(), progressBar);
        });

        playVoice.setOnClickListener(v -> {
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

            /*if (!chat.getUri().equals("") && chat.getSender().equals(myId)){

            }*/
        });
        itemView.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(itemView.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.text_chat_option, popupMenu.getMenu());
            popupMenu.getMenu().findItem(R.id.copy).setVisible(false);
            popupMenu.getMenu().findItem(R.id.open).setVisible(false);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.deleteForme) {
                        onMessageClick.deleteForMe(chat, position);
                        return true;
                    } else if (item.getItemId() == R.id.deleteforeveryone) {
                        onMessageClick.deleteForAll(chat, position);
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            popupMenu.show();
        });
    }

}
