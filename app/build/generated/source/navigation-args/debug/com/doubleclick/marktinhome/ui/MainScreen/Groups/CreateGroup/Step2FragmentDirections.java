package com.doubleclick.marktinhome.ui.MainScreen.Groups.CreateGroup;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class Step2FragmentDirections {
  private Step2FragmentDirections() {
  }

  @NonNull
  public static ActionStepTwoFragmentToStepThreeFragment actionStepTwoFragmentToStepThreeFragment(
      @Nullable String id) {
    return new ActionStepTwoFragmentToStepThreeFragment(id);
  }

  @NonNull
  public static NavDirections actionStepTwoFragmentToStepOneFragment() {
    return new ActionOnlyNavDirections(R.id.action_stepTwoFragment_to_stepOneFragment);
  }

  public static class ActionStepTwoFragmentToStepThreeFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionStepTwoFragmentToStepThreeFragment(@Nullable String id) {
      this.arguments.put("id", id);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionStepTwoFragmentToStepThreeFragment setId(@Nullable String id) {
      this.arguments.put("id", id);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("id")) {
        String id = (String) arguments.get("id");
        __result.putString("id", id);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_stepTwoFragment_to_stepThreeFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getId() {
      return (String) arguments.get("id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionStepTwoFragmentToStepThreeFragment that = (ActionStepTwoFragmentToStepThreeFragment) object;
      if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
        return false;
      }
      if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getId() != null ? getId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionStepTwoFragmentToStepThreeFragment(actionId=" + getActionId() + "){"
          + "id=" + getId()
          + "}";
    }
  }
}
