// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.doubleclick.marktinhome.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGroupBinding implements ViewBinding {
  @NonNull
  private final SwipeRefreshLayout rootView;

  @NonNull
  public final FloatingActionButton addGroup;

  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final SwipeRefreshLayout refresh;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final ViewPager viewpager;

  private FragmentGroupBinding(@NonNull SwipeRefreshLayout rootView,
      @NonNull FloatingActionButton addGroup, @NonNull AppBarLayout appbar,
      @NonNull SwipeRefreshLayout refresh, @NonNull TabLayout tabLayout,
      @NonNull ViewPager viewpager) {
    this.rootView = rootView;
    this.addGroup = addGroup;
    this.appbar = appbar;
    this.refresh = refresh;
    this.tabLayout = tabLayout;
    this.viewpager = viewpager;
  }

  @Override
  @NonNull
  public SwipeRefreshLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGroupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGroupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_group, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGroupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addGroup;
      FloatingActionButton addGroup = ViewBindings.findChildViewById(rootView, id);
      if (addGroup == null) {
        break missingId;
      }

      id = R.id.appbar;
      AppBarLayout appbar = ViewBindings.findChildViewById(rootView, id);
      if (appbar == null) {
        break missingId;
      }

      SwipeRefreshLayout refresh = (SwipeRefreshLayout) rootView;

      id = R.id.tab_layout;
      TabLayout tabLayout = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout == null) {
        break missingId;
      }

      id = R.id.viewpager;
      ViewPager viewpager = ViewBindings.findChildViewById(rootView, id);
      if (viewpager == null) {
        break missingId;
      }

      return new FragmentGroupBinding((SwipeRefreshLayout) rootView, addGroup, appbar, refresh,
          tabLayout, viewpager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
