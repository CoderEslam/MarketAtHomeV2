package com.doubleclick.ViewHolder;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.OnMessageClick;
import com.doubleclick.OnOptionMessage;
import com.doubleclick.ViewModel.ChatViewModel;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;


/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class VideoViewHolder extends BaseViewHolder {

    private VideoView video;
    private ConstraintLayout ContinerViedo;
    private ImageView options;
    private OnMessageClick onMessageClick;
    private OnOptionMessage onOptionMessage;
    private ImageView download;

    public VideoViewHolder(@NonNull View itemView, OnMessageClick onMessageClick, OnOptionMessage onOptionMessage) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        this.onOptionMessage = onOptionMessage;
        video = itemView.findViewById(R.id.video);
        ContinerViedo = itemView.findViewById(R.id.ContinerViedo);
        options = itemView.findViewById(R.id.options);
        download = itemView.findViewById(R.id.download);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void play(Chat chat, int position) {
        if (!chat.getMessage().equals("")) {
            video.setVideoURI(Uri.parse(chat.getMessage())); //the string of the URL mentioned above
            video.stopPlayback();
            video.pause();
        }
        MediaController ctlr = new MediaController(itemView.getContext());
        ctlr.setMediaPlayer(video);
        video.setMediaController(ctlr);
        video.requestFocus();
        ContinerViedo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Intent intent = new Intent(itemView.getContext(), ViewActivity.class);
//                intent.putExtra("chat", chat);
//                itemView.getContext().startActivity(intent);
                return true;
            }
        });
        options.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(itemView.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_chat, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (R.id.deleteforeveryone == id) {
                        onOptionMessage.deleteForAll(chat, position);
                        Toast.makeText(itemView.getContext(), "deleteforeveryone", Toast.LENGTH_LONG).show();
                    }
                    if (R.id.deleteForme == id) {
                        onOptionMessage.deleteForMe(chat, position);
                        Toast.makeText(itemView.getContext(), "deleteForme", Toast.LENGTH_LONG).show();
                    }
                    return true;
                }
            });
            popupMenu.show();
        });

        download.setOnClickListener(v -> {
            onMessageClick.onMessageClickListner(chat, getAdapterPosition());
        });
    }


}
