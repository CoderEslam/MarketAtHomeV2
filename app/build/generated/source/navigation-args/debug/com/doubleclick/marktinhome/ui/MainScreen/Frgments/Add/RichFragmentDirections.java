package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class RichFragmentDirections {
  private RichFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRichFragmentToTableFragment() {
    return new ActionOnlyNavDirections(R.id.action_RichFragment_to_TableFragment);
  }

  @NonNull
  public static NavDirections actionRichFragmentToLinkFragment() {
    return new ActionOnlyNavDirections(R.id.action_RichFragment_to_LinkFragment);
  }
}
