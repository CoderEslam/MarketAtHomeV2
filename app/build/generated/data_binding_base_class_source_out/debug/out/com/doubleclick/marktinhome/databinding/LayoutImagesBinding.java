// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import com.doubleclick.marktinhome.Views.PhotoView.PhotoView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutImagesBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView6;

  @NonNull
  public final PhotoView image;

  private LayoutImagesBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView6,
      @NonNull PhotoView image) {
    this.rootView = rootView;
    this.cardView6 = cardView6;
    this.image = image;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutImagesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutImagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_images, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutImagesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView6;
      CardView cardView6 = ViewBindings.findChildViewById(rootView, id);
      if (cardView6 == null) {
        break missingId;
      }

      id = R.id.image;
      PhotoView image = ViewBindings.findChildViewById(rootView, id);
      if (image == null) {
        break missingId;
      }

      return new LayoutImagesBinding((ConstraintLayout) rootView, cardView6, image);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
