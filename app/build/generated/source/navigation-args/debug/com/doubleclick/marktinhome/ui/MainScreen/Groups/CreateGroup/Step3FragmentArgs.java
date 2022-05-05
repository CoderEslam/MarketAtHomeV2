package com.doubleclick.marktinhome.ui.MainScreen.Groups.CreateGroup;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class Step3FragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private Step3FragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private Step3FragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static Step3FragmentArgs fromBundle(@NonNull Bundle bundle) {
    Step3FragmentArgs __result = new Step3FragmentArgs();
    bundle.setClassLoader(Step3FragmentArgs.class.getClassLoader());
    if (bundle.containsKey("id")) {
      String id;
      id = bundle.getString("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static Step3FragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    Step3FragmentArgs __result = new Step3FragmentArgs();
    if (savedStateHandle.contains("id")) {
      String id;
      id = savedStateHandle.get("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getId() {
    return (String) arguments.get("id");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("id")) {
      String id = (String) arguments.get("id");
      __result.putString("id", id);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("id")) {
      String id = (String) arguments.get("id");
      __result.set("id", id);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    Step3FragmentArgs that = (Step3FragmentArgs) object;
    if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
      return false;
    }
    if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getId() != null ? getId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Step3FragmentArgs{"
        + "id=" + getId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull Step3FragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable String id) {
      this.arguments.put("id", id);
    }

    @NonNull
    public Step3FragmentArgs build() {
      Step3FragmentArgs result = new Step3FragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setId(@Nullable String id) {
      this.arguments.put("id", id);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getId() {
      return (String) arguments.get("id");
    }
  }
}
