package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;


/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class FileViewHolder extends BaseViewHolder {
    private LottieAnimationView lottieAnimationView;
    private OnMessageClick onMessageClick;
    private ImageView download, seen;

    public FileViewHolder(View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        lottieAnimationView = itemView.findViewById(R.id.file);
        download = itemView.findViewById(R.id.download);
        seen = itemView.findViewById(R.id.seen);
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public void downloadFile(Chat chat, int position) {
        seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMessageClick.download(chat, getAdapterPosition());
            }
        });
        itemView.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(itemView.getContext(), v);
            popupMenu.getMenuInflater().inflate(R.menu.text_chat_option, popupMenu.getMenu());
            popupMenu.getMenu().findItem(R.id.copy).setVisible(false);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.deleteForme) {
                        onMessageClick.deleteForMe(chat, position);
                        return true;
                    } else if (item.getItemId() == R.id.deleteforeveryone) {
                        onMessageClick.deleteForAll(chat, position);
                        return true;
                    } else if (item.getItemId() == R.id.open) {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(chat.getMessage()));
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.setPackage("com.android.chrome");
                        try {
                            itemView.getContext().startActivity(i);
                        } catch (ActivityNotFoundException e) {
                            // Chrome is probably not installed
                            // Try with the default browser
                            i.setPackage(null);
                            itemView.getContext().startActivity(i);
                        }
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
