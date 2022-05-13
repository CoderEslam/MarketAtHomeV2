package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;

import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;


/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class VideoViewHolder extends BaseViewHolder {

    private VideoView video;
    private ImageView options;
    private OnMessageClick onMessageClick;
    private ImageView download, seen;

    public VideoViewHolder(@NonNull View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        video = itemView.findViewById(R.id.video);
        options = itemView.findViewById(R.id.options);
        download = itemView.findViewById(R.id.download);
        seen = itemView.findViewById(R.id.seen);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void play(Chat chat, int position) {
        seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
        if (!chat.getMessage().equals("")) {
            video.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            video.stopPlayback();
            video.pause();
        }
        MediaController ctlr = new MediaController(itemView.getContext());
        ctlr.setMediaPlayer(video);
        video.setMediaController(ctlr);
        video.requestFocus();

        options.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(itemView.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_chat_image_video, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (R.id.deleteforeveryone == id) {
                        onMessageClick.deleteForAll(chat, position);
                    }
                    if (R.id.deleteForme == id) {
                        onMessageClick.deleteForMe(chat, position);
                    }
                    return true;
                }
            });
            popupMenu.show();
        });

        download.setOnClickListener(v -> {
            onMessageClick.download(chat, getAdapterPosition());
        });
    }


}
