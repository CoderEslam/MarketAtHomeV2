// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import com.todkars.shimmer.ShimmerRecyclerView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCommentGroupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ShimmerRecyclerView Comments;

  @NonNull
  public final ConstraintLayout constraintLayout14;

  @NonNull
  public final ImageView send;

  @NonNull
  public final EditText textComment;

  private ActivityCommentGroupBinding(@NonNull ConstraintLayout rootView,
      @NonNull ShimmerRecyclerView Comments, @NonNull ConstraintLayout constraintLayout14,
      @NonNull ImageView send, @NonNull EditText textComment) {
    this.rootView = rootView;
    this.Comments = Comments;
    this.constraintLayout14 = constraintLayout14;
    this.send = send;
    this.textComment = textComment;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCommentGroupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCommentGroupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_comment_group, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCommentGroupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Comments;
      ShimmerRecyclerView Comments = ViewBindings.findChildViewById(rootView, id);
      if (Comments == null) {
        break missingId;
      }

      id = R.id.constraintLayout14;
      ConstraintLayout constraintLayout14 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout14 == null) {
        break missingId;
      }

      id = R.id.send;
      ImageView send = ViewBindings.findChildViewById(rootView, id);
      if (send == null) {
        break missingId;
      }

      id = R.id.textComment;
      EditText textComment = ViewBindings.findChildViewById(rootView, id);
      if (textComment == null) {
        break missingId;
      }

      return new ActivityCommentGroupBinding((ConstraintLayout) rootView, Comments,
          constraintLayout14, send, textComment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
