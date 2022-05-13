package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class LocationViewHolder extends BaseViewHolder {
    private LottieAnimationView location_lotte;
    private ImageView seen;
    private OnMessageClick onMessageClick;

    public LocationViewHolder(@NonNull View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        location_lotte = itemView.findViewById(R.id.location_lotte);
        seen = itemView.findViewById(R.id.seen);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void OpenLocation(Chat chat, int position) {
        seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));

        itemView.setOnClickListener(new View.OnClickListener() {
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
