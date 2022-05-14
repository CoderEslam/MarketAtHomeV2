// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemVideoRightBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout ContinerViedo;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final ImageView download;

  @NonNull
  public final ImageView options;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final ImageView seen;

  @NonNull
  public final VideoView video;

  private ItemVideoRightBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout ContinerViedo, @NonNull CardView cardView2,
      @NonNull ImageView download, @NonNull ImageView options, @NonNull ProgressBar progressBar,
      @NonNull ImageView seen, @NonNull VideoView video) {
    this.rootView = rootView;
    this.ContinerViedo = ContinerViedo;
    this.cardView2 = cardView2;
    this.download = download;
    this.options = options;
    this.progressBar = progressBar;
    this.seen = seen;
    this.video = video;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemVideoRightBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemVideoRightBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_video_right, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemVideoRightBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout ContinerViedo = (ConstraintLayout) rootView;

      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.download;
      ImageView download = ViewBindings.findChildViewById(rootView, id);
      if (download == null) {
        break missingId;
      }

      id = R.id.options;
      ImageView options = ViewBindings.findChildViewById(rootView, id);
      if (options == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.seen;
      ImageView seen = ViewBindings.findChildViewById(rootView, id);
      if (seen == null) {
        break missingId;
      }

      id = R.id.video;
      VideoView video = ViewBindings.findChildViewById(rootView, id);
      if (video == null) {
        break missingId;
      }

      return new ItemVideoRightBinding((ConstraintLayout) rootView, ContinerViedo, cardView2,
          download, options, progressBar, seen, video);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
