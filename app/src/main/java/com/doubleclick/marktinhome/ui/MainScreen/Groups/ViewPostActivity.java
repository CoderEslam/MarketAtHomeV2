package com.doubleclick.marktinhome.ui.MainScreen.Groups;

import static com.doubleclick.marktinhome.Model.Constantes.LIKES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doubleclick.marktinhome.Model.PostData;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.carouselrecyclerviewReflaction.CarouselRecyclerview;
import com.doubleclick.marktinhome.Views.socialtextview.SocialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewPostActivity extends AppCompatActivity {

    private PostData postData;
    private String postId, groupId, myId;
    private CarouselRecyclerview images;
    private ConstraintLayout ConstraintLayoutimage_name;
    private ImageView option, like_img, playVideo;
    private TextView namePublisher, like_text;
    private LinearLayout likeButton, comment, share;
    private CircleImageView imagePublisher;
    private ImageView video;
    private SocialTextView caption;
    private DatabaseReference reference;
    private RecyclerView Comments;
    private EditText textComment;
    private ImageView send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        reference = FirebaseDatabase.getInstance().getReference();
        postData = (PostData) getIntent().getSerializableExtra("post");
        postId = getIntent().getStringExtra("postId"/* post id*/);
        groupId = getIntent().getStringExtra("groupId" /* group id*/);
        myId = getIntent().getStringExtra("myId");
        ConstraintLayoutimage_name = findViewById(R.id.ConstraintLayoutimage_name);
        option = findViewById(R.id.option);
        Comments = findViewById(R.id.Comments);
        send = findViewById(R.id.send);
        textComment = findViewById(R.id.textComment);
        likeButton = findViewById(R.id.likeButton);
        comment = findViewById(R.id.comment);
        namePublisher = findViewById(R.id.namePublisher);
        imagePublisher = findViewById(R.id.imagePublisher);
        share = findViewById(R.id.share);
        caption = findViewById(R.id.caption);
        like_img = findViewById(R.id.like_img);
        like_text = findViewById(R.id.like_text);
        video = findViewById(R.id.video);
        playVideo = findViewById(R.id.playVideo);


    }

    private void setLike(String PostKey) {

        reference.child(LIKES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.child(PostKey).hasChild(myId)) {
                        like_text.setText(String.format("%s Like", String.valueOf(dataSnapshot.child(postId).getChildrenCount())));
                        like_img.setImageResource(R.drawable.like_thumb_up);
                    } else {
                        like_text.setText(String.format("%s Like", String.valueOf(dataSnapshot.child(postId).getChildrenCount())));
                        like_img.setImageResource(R.drawable.ic_like);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}