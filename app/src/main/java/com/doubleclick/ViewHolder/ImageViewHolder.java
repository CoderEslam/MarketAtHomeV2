package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;

import com.bumptech.glide.Glide;
import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.PhotoView.PhotoView;


/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class ImageViewHolder extends BaseViewHolder {
    private PhotoView imageView;
    private ImageView optins, seen;
    private OnMessageClick onMessageClick;
    private ProgressBar progressBar;

    public ImageViewHolder(@NonNull View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        imageView = itemView.findViewById(R.id.image);
        optins = itemView.findViewById(R.id.optins);
        seen = itemView.findViewById(R.id.seen);
        progressBar = itemView.findViewById(R.id.progressBar);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void ShowImage(Chat chat, int position) {
        if (!chat.getUri().toString().equals("")) {
            Glide.with(itemView.getContext()).load(Uri.parse(chat.getUri())).into(imageView);
            seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
            optins.setOnClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(imageView.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_chat_image_video, popupMenu.getMenu());
                popupMenu.getMenu().findItem(R.id.download).setVisible(false);
                progressBar.setVisibility(View.GONE);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (R.id.deleteforeveryone == item.getItemId()) {
                            onMessageClick.deleteForAll(chat, position);
                        }
                        if (R.id.deleteForme == item.getItemId()) {
                            onMessageClick.deleteForMe(chat, position);
                        }

                        return true;
                    }
                });
                popupMenu.show();
            });
        } else {
            Glide.with(itemView.getContext()).load(chat.getMessage()).into(imageView);
            seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
            optins.setOnClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(imageView.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_chat_image_video, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (R.id.deleteforeveryone == item.getItemId()) {
                            onMessageClick.deleteForAll(chat, position);
                        }
                        if (R.id.deleteForme == item.getItemId()) {
                            onMessageClick.deleteForMe(chat, position);
                        }
                        if (R.id.download == item.getItemId()) {
                            onMessageClick.download(chat, position, progressBar);
                            progressBar.setVisibility(View.VISIBLE);
                        }
                        return true;
                    }
                });
                popupMenu.show();
            });
        }

    }
}
