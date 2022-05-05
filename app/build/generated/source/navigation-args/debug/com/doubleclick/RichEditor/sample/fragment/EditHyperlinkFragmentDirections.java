package com.doubleclick.RichEditor.sample.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class EditHyperlinkFragmentDirections {
  private EditHyperlinkFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLinkFragmentToRichFragment() {
    return new ActionOnlyNavDirections(R.id.action_LinkFragment_to_RichFragment);
  }
}
