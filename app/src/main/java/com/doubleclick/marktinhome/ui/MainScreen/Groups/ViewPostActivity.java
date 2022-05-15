package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.doubleclick.marktinhome.Model.PostData;
import com.doubleclick.marktinhome.R;

public class ViewPostActivity extends AppCompatActivity {

    private PostData postData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        postData = (PostData) getIntent().getSerializableExtra("post");


    }
}