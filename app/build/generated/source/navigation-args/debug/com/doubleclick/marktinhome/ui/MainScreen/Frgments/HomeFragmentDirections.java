package com.doubleclick.marktinhome.ui.MainScreen.Frgments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToMenuCart() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_menu_Cart);
  }
}
