// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.doubleclick.marktinhome.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class FragmentSplash3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  private FragmentSplash3Binding(@NonNull ConstraintLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSplash3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSplash3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_splash3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSplash3Binding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new FragmentSplash3Binding((ConstraintLayout) rootView);
  }
}
