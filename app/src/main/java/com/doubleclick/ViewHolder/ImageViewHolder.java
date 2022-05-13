package com.doubleclick.ViewHolder;

import android.net.Uri;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

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

    public ImageViewHolder(@NonNull View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        imageView = itemView.findViewById(R.id.image);
        optins = itemView.findViewById(R.id.optins);
        seen = itemView.findViewById(R.id.seen);
    }

    public void ShowImage(Chat chat, int position) {
        Glide.with(itemView.getContext()).load(Uri.parse(chat.getMessage())).into(imageView);
        seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
        optins.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(imageView.getContext(), v);
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
                        if (R.id.download == id) {
                            try {
                                onMessageClick.download(chat, position);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
