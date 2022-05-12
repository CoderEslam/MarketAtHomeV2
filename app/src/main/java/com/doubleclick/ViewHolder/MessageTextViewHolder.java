package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

import java.text.SimpleDateFormat;


/**
 * Created By Eslam Ghazy on 2/5/2022
 */
public class MessageTextViewHolder extends BaseViewHolder {

    public TextView textMessage, textTime;
    private ImageView seen;
    private OnMessageClick onMessageClick;
//    public ImageView profile_image;
//    public TextView txt_seen;
//    public ImageView image_message;

    public MessageTextViewHolder(View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        textMessage = itemView.findViewById(R.id.textMessage);
        textTime = itemView.findViewById(R.id.textTime);
        seen = itemView.findViewById(R.id.seen);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setText(textMessage.getText());
                Toast.makeText(itemView.getContext(), itemView.getResources().getString(R.string.text_copied), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @SuppressLint({"SimpleDateFormat", "UseCompatLoadingForDrawables"})
    public void SetTextMessage(Chat chat, int postion) {
        textMessage.setText(chat.getMessage());
        textTime.setText(new SimpleDateFormat().format(chat.getDate()).toString());
        seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onMessageClick.deleteForAll(chat, postion);
                return false;
            }
        });
    }
}
