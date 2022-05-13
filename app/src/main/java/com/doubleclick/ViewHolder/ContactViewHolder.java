package com.doubleclick.ViewHolder;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.OnMessageClick;
import com.doubleclick.marktinhome.Model.Chat;
import com.doubleclick.marktinhome.R;

/**
 * Created By Eslam Ghazy on 2/7/2022
 */
public class ContactViewHolder extends BaseViewHolder {

    private TextView nameContact, numberContact;
    private String massege;
    private OnMessageClick onMessageClick;
    private ImageView seen;

    public ContactViewHolder(@NonNull View itemView, OnMessageClick onMessageClick) {
        super(itemView);
        this.onMessageClick = onMessageClick;
        nameContact = itemView.findViewById(R.id.nameContact);
        numberContact = itemView.findViewById(R.id.numberContact);
        seen = itemView.findViewById(R.id.seen);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setText(massege);
                Toast.makeText(itemView.getContext(), "Copied", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void Contact(Chat chat, int position) {
        this.massege = chat.getMessage();
        seen.setImageDrawable(chat.isSeen() ? itemView.getContext().getResources().getDrawable(R.drawable.done_all) : itemView.getContext().getResources().getDrawable(R.drawable.done));
        String[] n = massege.split("\n");
        nameContact.setText(n[0]);
        numberContact.setText(n[1]);
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onMessageClick.deleteForAll(chat, position);
                return true;
            }
        });
    }
}
