// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentUploadBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button Upload;

  @NonNull
  public final ImageView addColor;

  @NonNull
  public final ImageView addSizes;

  @NonNull
  public final NestedScrollView addToggleButtonColor;

  @NonNull
  public final ImageView addkeyword;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout constraintLayout2;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final SingleSelectToggleGroup groupColor;

  @NonNull
  public final SingleSelectToggleGroup groupSize;

  @NonNull
  public final RecyclerView keyword;

  @NonNull
  public final EditText productLastPrice;

  @NonNull
  public final EditText productName;

  @NonNull
  public final EditText productPrice;

  @NonNull
  public final RatingBar ratingSeller;

  @NonNull
  public final TextView textView18;

  @NonNull
  public final TextView textView19;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final AppCompatSpinner trademark;

  private FragmentUploadBinding(@NonNull ConstraintLayout rootView, @NonNull Button Upload,
      @NonNull ImageView addColor, @NonNull ImageView addSizes,
      @NonNull NestedScrollView addToggleButtonColor, @NonNull ImageView addkeyword,
      @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2,
      @NonNull ConstraintLayout constraintLayout3, @NonNull SingleSelectToggleGroup groupColor,
      @NonNull SingleSelectToggleGroup groupSize, @NonNull RecyclerView keyword,
      @NonNull EditText productLastPrice, @NonNull EditText productName,
      @NonNull EditText productPrice, @NonNull RatingBar ratingSeller, @NonNull TextView textView18,
      @NonNull TextView textView19, @NonNull TextView textView20,
      @NonNull AppCompatSpinner trademark) {
    this.rootView = rootView;
    this.Upload = Upload;
    this.addColor = addColor;
    this.addSizes = addSizes;
    this.addToggleButtonColor = addToggleButtonColor;
    this.addkeyword = addkeyword;
    this.constraintLayout = constraintLayout;
    this.constraintLayout2 = constraintLayout2;
    this.constraintLayout3 = constraintLayout3;
    this.groupColor = groupColor;
    this.groupSize = groupSize;
    this.keyword = keyword;
    this.productLastPrice = productLastPrice;
    this.productName = productName;
    this.productPrice = productPrice;
    this.ratingSeller = ratingSeller;
    this.textView18 = textView18;
    this.textView19 = textView19;
    this.textView20 = textView20;
    this.trademark = trademark;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentUploadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentUploadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_upload, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentUploadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Upload;
      Button Upload = ViewBindings.findChildViewById(rootView, id);
      if (Upload == null) {
        break missingId;
      }

      id = R.id.addColor;
      ImageView addColor = ViewBindings.findChildViewById(rootView, id);
      if (addColor == null) {
        break missingId;
      }

      id = R.id.addSizes;
      ImageView addSizes = ViewBindings.findChildViewById(rootView, id);
      if (addSizes == null) {
        break missingId;
      }

      id = R.id.addToggleButtonColor;
      NestedScrollView addToggleButtonColor = ViewBindings.findChildViewById(rootView, id);
      if (addToggleButtonColor == null) {
        break missingId;
      }

      id = R.id.addkeyword;
      ImageView addkeyword = ViewBindings.findChildViewById(rootView, id);
      if (addkeyword == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.constraintLayout2;
      ConstraintLayout constraintLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout2 == null) {
        break missingId;
      }

      id = R.id.constraintLayout3;
      ConstraintLayout constraintLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout3 == null) {
        break missingId;
      }

      id = R.id.groupColor;
      SingleSelectToggleGroup groupColor = ViewBindings.findChildViewById(rootView, id);
      if (groupColor == null) {
        break missingId;
      }

      id = R.id.groupSize;
      SingleSelectToggleGroup groupSize = ViewBindings.findChildViewById(rootView, id);
      if (groupSize == null) {
        break missingId;
      }

      id = R.id.keyword;
      RecyclerView keyword = ViewBindings.findChildViewById(rootView, id);
      if (keyword == null) {
        break missingId;
      }

      id = R.id.productLastPrice;
      EditText productLastPrice = ViewBindings.findChildViewById(rootView, id);
      if (productLastPrice == null) {
        break missingId;
      }

      id = R.id.productName;
      EditText productName = ViewBindings.findChildViewById(rootView, id);
      if (productName == null) {
        break missingId;
      }

      id = R.id.productPrice;
      EditText productPrice = ViewBindings.findChildViewById(rootView, id);
      if (productPrice == null) {
        break missingId;
      }

      id = R.id.ratingSeller;
      RatingBar ratingSeller = ViewBindings.findChildViewById(rootView, id);
      if (ratingSeller == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = ViewBindings.findChildViewById(rootView, id);
      if (textView18 == null) {
        break missingId;
      }

      id = R.id.textView19;
      TextView textView19 = ViewBindings.findChildViewById(rootView, id);
      if (textView19 == null) {
        break missingId;
      }

      id = R.id.textView20;
      TextView textView20 = ViewBindings.findChildViewById(rootView, id);
      if (textView20 == null) {
        break missingId;
      }

      id = R.id.trademark;
      AppCompatSpinner trademark = ViewBindings.findChildViewById(rootView, id);
      if (trademark == null) {
        break missingId;
      }

      return new FragmentUploadBinding((ConstraintLayout) rootView, Upload, addColor, addSizes,
          addToggleButtonColor, addkeyword, constraintLayout, constraintLayout2, constraintLayout3,
          groupColor, groupSize, keyword, productLastPrice, productName, productPrice, ratingSeller,
          textView18, textView19, textView20, trademark);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
