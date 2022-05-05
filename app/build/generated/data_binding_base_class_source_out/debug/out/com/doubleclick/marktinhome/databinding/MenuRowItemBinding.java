// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MenuRowItemBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final CardView backgroundCV;

  @NonNull
  public final ImageView backgroundIV;

  @NonNull
  public final RelativeLayout rootRL;

  @NonNull
  public final View tintView;

  @NonNull
  public final TextView titleTV;

  @NonNull
  public final TextView titleTV1;

  private MenuRowItemBinding(@NonNull RelativeLayout rootView, @NonNull CardView backgroundCV,
      @NonNull ImageView backgroundIV, @NonNull RelativeLayout rootRL, @NonNull View tintView,
      @NonNull TextView titleTV, @NonNull TextView titleTV1) {
    this.rootView = rootView;
    this.backgroundCV = backgroundCV;
    this.backgroundIV = backgroundIV;
    this.rootRL = rootRL;
    this.tintView = tintView;
    this.titleTV = titleTV;
    this.titleTV1 = titleTV1;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MenuRowItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MenuRowItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.menu_row_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MenuRowItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backgroundCV;
      CardView backgroundCV = ViewBindings.findChildViewById(rootView, id);
      if (backgroundCV == null) {
        break missingId;
      }

      id = R.id.backgroundIV;
      ImageView backgroundIV = ViewBindings.findChildViewById(rootView, id);
      if (backgroundIV == null) {
        break missingId;
      }

      RelativeLayout rootRL = (RelativeLayout) rootView;

      id = R.id.tintView;
      View tintView = ViewBindings.findChildViewById(rootView, id);
      if (tintView == null) {
        break missingId;
      }

      id = R.id.titleTV;
      TextView titleTV = ViewBindings.findChildViewById(rootView, id);
      if (titleTV == null) {
        break missingId;
      }

      id = R.id.titleTV1;
      TextView titleTV1 = ViewBindings.findChildViewById(rootView, id);
      if (titleTV1 == null) {
        break missingId;
      }

      return new MenuRowItemBinding((RelativeLayout) rootView, backgroundCV, backgroundIV, rootRL,
          tintView, titleTV, titleTV1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}