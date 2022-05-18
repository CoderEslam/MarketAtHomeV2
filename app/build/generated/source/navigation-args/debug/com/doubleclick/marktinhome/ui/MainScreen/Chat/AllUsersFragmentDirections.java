package com.doubleclick.marktinhome.ui.MainScreen.Chat;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AllUsersFragmentDirections {
  private AllUsersFragmentDirections() {
  }

  @NonNull
  public static ActionAllUsersFragmentToChatFragment actionAllUsersFragmentToChatFragment(
      @NonNull String userId) {
    return new ActionAllUsersFragmentToChatFragment(userId);
  }

  public static class ActionAllUsersFragmentToChatFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionAllUsersFragmentToChatFragment(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userId", userId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAllUsersFragmentToChatFragment setUserId(@NonNull String userId) {
      if (userId == null) {
        throw new IllegalArgumentException("Argument \"userId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userId", userId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("userId")) {
        String userId = (String) arguments.get("userId");
        __result.putString("userId", userId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_allUsersFragment_to_chatFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUserId() {
      return (String) arguments.get("userId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAllUsersFragmentToChatFragment that = (ActionAllUsersFragmentToChatFragment) object;
      if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
        return false;
      }
      if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) {
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
      result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAllUsersFragmentToChatFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }
}
