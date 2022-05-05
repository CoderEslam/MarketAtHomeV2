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
import com.doubleclick.marktinhome.Views.PhotoView.PhotoView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemImageRightBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout ContinnerImage;

  @NonNull
  public final CardView cardView4;

  @NonNull
  public final ConstraintLayout constraintLayout13;

  @NonNull
  public final PhotoView image;

  @NonNull
  public final ImageView optins;

  private ItemImageRightBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout ContinnerImage, @NonNull CardView cardView4,
      @NonNull ConstraintLayout constraintLayout13, @NonNull PhotoView image,
      @NonNull ImageView optins) {
    this.rootView = rootView;
    this.ContinnerImage = ContinnerImage;
    this.cardView4 = cardView4;
    this.constraintLayout13 = constraintLayout13;
    this.image = image;
    this.optins = optins;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemImageRightBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemImageRightBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_image_right, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemImageRightBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout ContinnerImage = (ConstraintLayout) rootView;

      id = R.id.cardView4;
      CardView cardView4 = ViewBindings.findChildViewById(rootView, id);
      if (cardView4 == null) {
        break missingId;
      }

      id = R.id.constraintLayout13;
      ConstraintLayout constraintLayout13 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout13 == null) {
        break missingId;
      }

      id = R.id.image;
      PhotoView image = ViewBindings.findChildViewById(rootView, id);
      if (image == null) {
        break missingId;
      }

      id = R.id.optins;
      ImageView optins = ViewBindings.findChildViewById(rootView, id);
      if (optins == null) {
        break missingId;
      }

      return new ItemImageRightBinding((ConstraintLayout) rootView, ContinnerImage, cardView4,
          constraintLayout13, image, optins);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}