// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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

public final class ItemContactLeftBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView13;

  @NonNull
  public final TextView nameContact;

  @NonNull
  public final TextView numberContact;

  @NonNull
  public final ImageView seen;

  @NonNull
  public final TextView time;

  private ItemContactLeftBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView13,
      @NonNull TextView nameContact, @NonNull TextView numberContact, @NonNull ImageView seen,
      @NonNull TextView time) {
    this.rootView = rootView;
    this.cardView13 = cardView13;
    this.nameContact = nameContact;
    this.numberContact = numberContact;
    this.seen = seen;
    this.time = time;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemContactLeftBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemContactLeftBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_contact_left, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemContactLeftBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView13;
      CardView cardView13 = ViewBindings.findChildViewById(rootView, id);
      if (cardView13 == null) {
        break missingId;
      }

      id = R.id.nameContact;
      TextView nameContact = ViewBindings.findChildViewById(rootView, id);
      if (nameContact == null) {
        break missingId;
      }

      id = R.id.numberContact;
      TextView numberContact = ViewBindings.findChildViewById(rootView, id);
      if (numberContact == null) {
        break missingId;
      }

      id = R.id.seen;
      ImageView seen = ViewBindings.findChildViewById(rootView, id);
      if (seen == null) {
        break missingId;
      }

      id = R.id.time;
      TextView time = ViewBindings.findChildViewById(rootView, id);
      if (time == null) {
        break missingId;
      }

      return new ItemContactLeftBinding((ConstraintLayout) rootView, cardView13, nameContact,
          numberContact, seen, time);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
