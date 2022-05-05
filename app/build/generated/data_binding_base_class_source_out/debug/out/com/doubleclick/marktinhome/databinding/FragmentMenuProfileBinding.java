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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMenuProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout AddAdv;

  @NonNull
  public final ConstraintLayout AddProduct;

  @NonNull
  public final ConstraintLayout AddTradmark;

  @NonNull
  public final TextView address;

  @NonNull
  public final ConstraintLayout chat;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final ConstraintLayout constraintLayout4;

  @NonNull
  public final ConstraintLayout constraintLayout5;

  @NonNull
  public final ConstraintLayout constraintLayout6;

  @NonNull
  public final ImageView editAddress;

  @NonNull
  public final ImageView editPhone;

  @NonNull
  public final ImageView editname;

  @NonNull
  public final TextView email;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final ImageView imageView12;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView30;

  @NonNull
  public final ImageView imageView32;

  @NonNull
  public final ImageView imageView51;

  @NonNull
  public final ImageView imageView55;

  @NonNull
  public final ImageView imageView555;

  @NonNull
  public final ImageView imageView556;

  @NonNull
  public final ImageView imageView56;

  @NonNull
  public final ImageView imageView564;

  @NonNull
  public final ImageView imageView566;

  @NonNull
  public final ConstraintLayout joinUs;

  @NonNull
  public final ConstraintLayout logout;

  @NonNull
  public final CircleImageView person;

  @NonNull
  public final TextView phone;

  @NonNull
  public final ConstraintLayout recentOrder;

  @NonNull
  public final ConstraintLayout statistices;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView username;

  private FragmentMenuProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout AddAdv, @NonNull ConstraintLayout AddProduct,
      @NonNull ConstraintLayout AddTradmark, @NonNull TextView address,
      @NonNull ConstraintLayout chat, @NonNull ConstraintLayout constraintLayout3,
      @NonNull ConstraintLayout constraintLayout4, @NonNull ConstraintLayout constraintLayout5,
      @NonNull ConstraintLayout constraintLayout6, @NonNull ImageView editAddress,
      @NonNull ImageView editPhone, @NonNull ImageView editname, @NonNull TextView email,
      @NonNull FloatingActionButton fab, @NonNull ImageView imageView12,
      @NonNull ImageView imageView3, @NonNull ImageView imageView30, @NonNull ImageView imageView32,
      @NonNull ImageView imageView51, @NonNull ImageView imageView55,
      @NonNull ImageView imageView555, @NonNull ImageView imageView556,
      @NonNull ImageView imageView56, @NonNull ImageView imageView564,
      @NonNull ImageView imageView566, @NonNull ConstraintLayout joinUs,
      @NonNull ConstraintLayout logout, @NonNull CircleImageView person, @NonNull TextView phone,
      @NonNull ConstraintLayout recentOrder, @NonNull ConstraintLayout statistices,
      @NonNull TextView textView3, @NonNull TextView username) {
    this.rootView = rootView;
    this.AddAdv = AddAdv;
    this.AddProduct = AddProduct;
    this.AddTradmark = AddTradmark;
    this.address = address;
    this.chat = chat;
    this.constraintLayout3 = constraintLayout3;
    this.constraintLayout4 = constraintLayout4;
    this.constraintLayout5 = constraintLayout5;
    this.constraintLayout6 = constraintLayout6;
    this.editAddress = editAddress;
    this.editPhone = editPhone;
    this.editname = editname;
    this.email = email;
    this.fab = fab;
    this.imageView12 = imageView12;
    this.imageView3 = imageView3;
    this.imageView30 = imageView30;
    this.imageView32 = imageView32;
    this.imageView51 = imageView51;
    this.imageView55 = imageView55;
    this.imageView555 = imageView555;
    this.imageView556 = imageView556;
    this.imageView56 = imageView56;
    this.imageView564 = imageView564;
    this.imageView566 = imageView566;
    this.joinUs = joinUs;
    this.logout = logout;
    this.person = person;
    this.phone = phone;
    this.recentOrder = recentOrder;
    this.statistices = statistices;
    this.textView3 = textView3;
    this.username = username;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMenuProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMenuProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_menu_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMenuProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AddAdv;
      ConstraintLayout AddAdv = ViewBindings.findChildViewById(rootView, id);
      if (AddAdv == null) {
        break missingId;
      }

      id = R.id.AddProduct;
      ConstraintLayout AddProduct = ViewBindings.findChildViewById(rootView, id);
      if (AddProduct == null) {
        break missingId;
      }

      id = R.id.AddTradmark;
      ConstraintLayout AddTradmark = ViewBindings.findChildViewById(rootView, id);
      if (AddTradmark == null) {
        break missingId;
      }

      id = R.id.address;
      TextView address = ViewBindings.findChildViewById(rootView, id);
      if (address == null) {
        break missingId;
      }

      id = R.id.chat;
      ConstraintLayout chat = ViewBindings.findChildViewById(rootView, id);
      if (chat == null) {
        break missingId;
      }

      id = R.id.constraintLayout3;
      ConstraintLayout constraintLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout3 == null) {
        break missingId;
      }

      id = R.id.constraintLayout4;
      ConstraintLayout constraintLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout4 == null) {
        break missingId;
      }

      id = R.id.constraintLayout5;
      ConstraintLayout constraintLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout5 == null) {
        break missingId;
      }

      id = R.id.constraintLayout6;
      ConstraintLayout constraintLayout6 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout6 == null) {
        break missingId;
      }

      id = R.id.editAddress;
      ImageView editAddress = ViewBindings.findChildViewById(rootView, id);
      if (editAddress == null) {
        break missingId;
      }

      id = R.id.editPhone;
      ImageView editPhone = ViewBindings.findChildViewById(rootView, id);
      if (editPhone == null) {
        break missingId;
      }

      id = R.id.editname;
      ImageView editname = ViewBindings.findChildViewById(rootView, id);
      if (editname == null) {
        break missingId;
      }

      id = R.id.email;
      TextView email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);
      if (fab == null) {
        break missingId;
      }

      id = R.id.imageView12;
      ImageView imageView12 = ViewBindings.findChildViewById(rootView, id);
      if (imageView12 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView30;
      ImageView imageView30 = ViewBindings.findChildViewById(rootView, id);
      if (imageView30 == null) {
        break missingId;
      }

      id = R.id.imageView32;
      ImageView imageView32 = ViewBindings.findChildViewById(rootView, id);
      if (imageView32 == null) {
        break missingId;
      }

      id = R.id.imageView51;
      ImageView imageView51 = ViewBindings.findChildViewById(rootView, id);
      if (imageView51 == null) {
        break missingId;
      }

      id = R.id.imageView55;
      ImageView imageView55 = ViewBindings.findChildViewById(rootView, id);
      if (imageView55 == null) {
        break missingId;
      }

      id = R.id.imageView555;
      ImageView imageView555 = ViewBindings.findChildViewById(rootView, id);
      if (imageView555 == null) {
        break missingId;
      }

      id = R.id.imageView556;
      ImageView imageView556 = ViewBindings.findChildViewById(rootView, id);
      if (imageView556 == null) {
        break missingId;
      }

      id = R.id.imageView56;
      ImageView imageView56 = ViewBindings.findChildViewById(rootView, id);
      if (imageView56 == null) {
        break missingId;
      }

      id = R.id.imageView564;
      ImageView imageView564 = ViewBindings.findChildViewById(rootView, id);
      if (imageView564 == null) {
        break missingId;
      }

      id = R.id.imageView566;
      ImageView imageView566 = ViewBindings.findChildViewById(rootView, id);
      if (imageView566 == null) {
        break missingId;
      }

      id = R.id.joinUs;
      ConstraintLayout joinUs = ViewBindings.findChildViewById(rootView, id);
      if (joinUs == null) {
        break missingId;
      }

      id = R.id.logout;
      ConstraintLayout logout = ViewBindings.findChildViewById(rootView, id);
      if (logout == null) {
        break missingId;
      }

      id = R.id.person;
      CircleImageView person = ViewBindings.findChildViewById(rootView, id);
      if (person == null) {
        break missingId;
      }

      id = R.id.phone;
      TextView phone = ViewBindings.findChildViewById(rootView, id);
      if (phone == null) {
        break missingId;
      }

      id = R.id.recentOrder;
      ConstraintLayout recentOrder = ViewBindings.findChildViewById(rootView, id);
      if (recentOrder == null) {
        break missingId;
      }

      id = R.id.statistices;
      ConstraintLayout statistices = ViewBindings.findChildViewById(rootView, id);
      if (statistices == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new FragmentMenuProfileBinding((ConstraintLayout) rootView, AddAdv, AddProduct,
          AddTradmark, address, chat, constraintLayout3, constraintLayout4, constraintLayout5,
          constraintLayout6, editAddress, editPhone, editname, email, fab, imageView12, imageView3,
          imageView30, imageView32, imageView51, imageView55, imageView555, imageView556,
          imageView56, imageView564, imageView566, joinUs, logout, person, phone, recentOrder,
          statistices, textView3, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}