package com.doubleclick.marktinhome.ui.MainScreen.Chat;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.Model.User;
import com.doubleclick.marktinhome.R;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ChatListFragmentDirections {
  private ChatListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionChatListFragmentToAllUsersFragment() {
    return new ActionOnlyNavDirections(R.id.action_chatListFragment_to_allUsersFragment);
  }

  @NonNull
  public static ActionChatListFragmentToChatFragment actionChatListFragmentToChatFragment(
      @NonNull User user) {
    return new ActionChatListFragmentToChatFragment(user);
  }

  public static class ActionChatListFragmentToChatFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionChatListFragmentToChatFragment(@NonNull User user) {
      if (user == null) {
        throw new IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("user", user);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionChatListFragmentToChatFragment setUser(@NonNull User user) {
      if (user == null) {
        throw new IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("user", user);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("user")) {
        User user = (User) arguments.get("user");
        if (Parcelable.class.isAssignableFrom(User.class) || user == null) {
          __result.putParcelable("user", Parcelable.class.cast(user));
        } else if (Serializable.class.isAssignableFrom(User.class)) {
          __result.putSerializable("user", Serializable.class.cast(user));
        } else {
          throw new UnsupportedOperationException(User.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_chatListFragment_to_chatFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public User getUser() {
      return (User) arguments.get("user");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionChatListFragmentToChatFragment that = (ActionChatListFragmentToChatFragment) object;
      if (arguments.containsKey("user") != that.arguments.containsKey("user")) {
        return false;
      }
      if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null) {
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
      result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionChatListFragmentToChatFragment(actionId=" + getActionId() + "){"
          + "user=" + getUser()
          + "}";
    }
  }
}
