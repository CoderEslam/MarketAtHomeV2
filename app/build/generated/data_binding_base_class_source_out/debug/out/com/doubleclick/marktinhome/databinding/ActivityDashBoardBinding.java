// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import com.github.anastr.speedviewlib.AwesomeSpeedometer;
import com.github.anastr.speedviewlib.SpeedView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDashBoardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FrameLayout containerMonth;

  @NonNull
  public final FrameLayout containerStatistics;

  @NonNull
  public final FrameLayout mapContiner;

  @NonNull
  public final AwesomeSpeedometer speedView;

  @NonNull
  public final SpeedView speedViewBestProduct;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView totalSales;

  private ActivityDashBoardBinding(@NonNull ConstraintLayout rootView,
      @NonNull FrameLayout containerMonth, @NonNull FrameLayout containerStatistics,
      @NonNull FrameLayout mapContiner, @NonNull AwesomeSpeedometer speedView,
      @NonNull SpeedView speedViewBestProduct, @NonNull TextView textView1,
      @NonNull TextView textView11, @NonNull TextView textView17, @NonNull TextView textView2,
      @NonNull TextView totalSales) {
    this.rootView = rootView;
    this.containerMonth = containerMonth;
    this.containerStatistics = containerStatistics;
    this.mapContiner = mapContiner;
    this.speedView = speedView;
    this.speedViewBestProduct = speedViewBestProduct;
    this.textView1 = textView1;
    this.textView11 = textView11;
    this.textView17 = textView17;
    this.textView2 = textView2;
    this.totalSales = totalSales;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDashBoardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDashBoardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dash_board, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDashBoardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.containerMonth;
      FrameLayout containerMonth = ViewBindings.findChildViewById(rootView, id);
      if (containerMonth == null) {
        break missingId;
      }

      id = R.id.containerStatistics;
      FrameLayout containerStatistics = ViewBindings.findChildViewById(rootView, id);
      if (containerStatistics == null) {
        break missingId;
      }

      id = R.id.mapContiner;
      FrameLayout mapContiner = ViewBindings.findChildViewById(rootView, id);
      if (mapContiner == null) {
        break missingId;
      }

      id = R.id.speedView;
      AwesomeSpeedometer speedView = ViewBindings.findChildViewById(rootView, id);
      if (speedView == null) {
        break missingId;
      }

      id = R.id.speedViewBestProduct;
      SpeedView speedViewBestProduct = ViewBindings.findChildViewById(rootView, id);
      if (speedViewBestProduct == null) {
        break missingId;
      }

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.total_sales;
      TextView totalSales = ViewBindings.findChildViewById(rootView, id);
      if (totalSales == null) {
        break missingId;
      }

      return new ActivityDashBoardBinding((ConstraintLayout) rootView, containerMonth,
          containerStatistics, mapContiner, speedView, speedViewBestProduct, textView1, textView11,
          textView17, textView2, totalSales);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
