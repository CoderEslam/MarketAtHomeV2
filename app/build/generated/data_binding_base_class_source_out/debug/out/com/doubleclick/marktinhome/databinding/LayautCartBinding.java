// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayautCartBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView CartName;

  @NonNull
  public final ImageView add;

  @NonNull
  public final ImageView delete;

  @NonNull
  public final CircleImageView imageCart;

  @NonNull
  public final ImageView mins;

  @NonNull
  public final TextView price;

  @NonNull
  public final TextView quantity;

  @NonNull
  public final View view;

  private LayautCartBinding(@NonNull ConstraintLayout rootView, @NonNull TextView CartName,
      @NonNull ImageView add, @NonNull ImageView delete, @NonNull CircleImageView imageCart,
      @NonNull ImageView mins, @NonNull TextView price, @NonNull TextView quantity,
      @NonNull View view) {
    this.rootView = rootView;
    this.CartName = CartName;
    this.add = add;
    this.delete = delete;
    this.imageCart = imageCart;
    this.mins = mins;
    this.price = price;
    this.quantity = quantity;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayautCartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayautCartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layaut_cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayautCartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CartName;
      TextView CartName = ViewBindings.findChildViewById(rootView, id);
      if (CartName == null) {
        break missingId;
      }

      id = R.id.add;
      ImageView add = ViewBindings.findChildViewById(rootView, id);
      if (add == null) {
        break missingId;
      }

      id = R.id.delete;
      ImageView delete = ViewBindings.findChildViewById(rootView, id);
      if (delete == null) {
        break missingId;
      }

      id = R.id.imageCart;
      CircleImageView imageCart = ViewBindings.findChildViewById(rootView, id);
      if (imageCart == null) {
        break missingId;
      }

      id = R.id.mins;
      ImageView mins = ViewBindings.findChildViewById(rootView, id);
      if (mins == null) {
        break missingId;
      }

      id = R.id.price;
      TextView price = ViewBindings.findChildViewById(rootView, id);
      if (price == null) {
        break missingId;
      }

      id = R.id.quantity;
      TextView quantity = ViewBindings.findChildViewById(rootView, id);
      if (quantity == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new LayautCartBinding((ConstraintLayout) rootView, CartName, add, delete, imageCart,
          mins, price, quantity, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
