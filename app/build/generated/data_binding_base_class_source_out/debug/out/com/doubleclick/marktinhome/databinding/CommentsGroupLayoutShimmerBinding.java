// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CommentsGroupLayoutShimmerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView8;

  @NonNull
  public final ImageView comment;

  @NonNull
  public final CircleImageView imageUser;

  @NonNull
  public final ImageView userName;

  private CommentsGroupLayoutShimmerBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView cardView8, @NonNull ImageView comment, @NonNull CircleImageView imageUser,
      @NonNull ImageView userName) {
    this.rootView = rootView;
    this.cardView8 = cardView8;
    this.comment = comment;
    this.imageUser = imageUser;
    this.userName = userName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CommentsGroupLayoutShimmerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CommentsGroupLayoutShimmerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.comments_group_layout_shimmer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CommentsGroupLayoutShimmerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView8;
      CardView cardView8 = ViewBindings.findChildViewById(rootView, id);
      if (cardView8 == null) {
        break missingId;
      }

      id = R.id.comment;
      ImageView comment = ViewBindings.findChildViewById(rootView, id);
      if (comment == null) {
        break missingId;
      }

      id = R.id.imageUser;
      CircleImageView imageUser = ViewBindings.findChildViewById(rootView, id);
      if (imageUser == null) {
        break missingId;
      }

      id = R.id.userName;
      ImageView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      return new CommentsGroupLayoutShimmerBinding((ConstraintLayout) rootView, cardView8, comment,
          imageUser, userName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
