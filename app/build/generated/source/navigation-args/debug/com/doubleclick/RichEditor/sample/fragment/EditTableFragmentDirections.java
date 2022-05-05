package com.doubleclick.RichEditor.sample.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class EditTableFragmentDirections {
  private EditTableFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTableFragmentToRichFragment() {
    return new ActionOnlyNavDirections(R.id.action_TableFragment_to_RichFragment);
  }
}
