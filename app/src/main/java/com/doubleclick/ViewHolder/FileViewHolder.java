package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

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
                onMessageClick.download(chat, getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onMessageClick.deleteForAll(chat, position);
                return true;
            }
        });
    }
}
