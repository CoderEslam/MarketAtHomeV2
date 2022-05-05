package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

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

public class EditFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private EditFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private EditFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static EditFragmentArgs fromBundle(@NonNull Bundle bundle) {
    EditFragmentArgs __result = new EditFragmentArgs();
    bundle.setClassLoader(EditFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("id")) {
      String id;
      id = bundle.getString("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("type")) {
      String type;
      type = bundle.getString("type");
      __result.arguments.put("type", type);
    } else {
      throw new IllegalArgumentException("Required argument \"type\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("image")) {
      String image;
      image = bundle.getString("image");
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("image", image);
    } else {
      throw new IllegalArgumentException("Required argument \"image\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("name")) {
      String name;
      name = bundle.getString("name");
      __result.arguments.put("name", name);
    } else {
      throw new IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("order")) {
      String order;
      order = bundle.getString("order");
      __result.arguments.put("order", order);
    } else {
      throw new IllegalArgumentException("Required argument \"order\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static EditFragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    EditFragmentArgs __result = new EditFragmentArgs();
    if (savedStateHandle.contains("id")) {
      String id;
      id = savedStateHandle.get("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("type")) {
      String type;
      type = savedStateHandle.get("type");
      __result.arguments.put("type", type);
    } else {
      throw new IllegalArgumentException("Required argument \"type\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("image")) {
      String image;
      image = savedStateHandle.get("image");
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("image", image);
    } else {
      throw new IllegalArgumentException("Required argument \"image\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("name")) {
      String name;
      name = savedStateHandle.get("name");
      __result.arguments.put("name", name);
    } else {
      throw new IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("order")) {
      String order;
      order = savedStateHandle.get("order");
      __result.arguments.put("order", order);
    } else {
      throw new IllegalArgumentException("Required argument \"order\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getId() {
    return (String) arguments.get("id");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getType() {
    return (String) arguments.get("type");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getImage() {
    return (String) arguments.get("image");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getName() {
    return (String) arguments.get("name");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getOrder() {
    return (String) arguments.get("order");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("id")) {
      String id = (String) arguments.get("id");
      __result.putString("id", id);
    }
    if (arguments.containsKey("type")) {
      String type = (String) arguments.get("type");
      __result.putString("type", type);
    }
    if (arguments.containsKey("image")) {
      String image = (String) arguments.get("image");
      __result.putString("image", image);
    }
    if (arguments.containsKey("name")) {
      String name = (String) arguments.get("name");
      __result.putString("name", name);
    }
    if (arguments.containsKey("order")) {
      String order = (String) arguments.get("order");
      __result.putString("order", order);
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
    if (arguments.containsKey("type")) {
      String type = (String) arguments.get("type");
      __result.set("type", type);
    }
    if (arguments.containsKey("image")) {
      String image = (String) arguments.get("image");
      __result.set("image", image);
    }
    if (arguments.containsKey("name")) {
      String name = (String) arguments.get("name");
      __result.set("name", name);
    }
    if (arguments.containsKey("order")) {
      String order = (String) arguments.get("order");
      __result.set("order", order);
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
    EditFragmentArgs that = (EditFragmentArgs) object;
    if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
      return false;
    }
    if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
      return false;
    }
    if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
      return false;
    }
    if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
      return false;
    }
    if (arguments.containsKey("image") != that.arguments.containsKey("image")) {
      return false;
    }
    if (getImage() != null ? !getImage().equals(that.getImage()) : that.getImage() != null) {
      return false;
    }
    if (arguments.containsKey("name") != that.arguments.containsKey("name")) {
      return false;
    }
    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
      return false;
    }
    if (arguments.containsKey("order") != that.arguments.containsKey("order")) {
      return false;
    }
    if (getOrder() != null ? !getOrder().equals(that.getOrder()) : that.getOrder() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getId() != null ? getId().hashCode() : 0);
    result = 31 * result + (getType() != null ? getType().hashCode() : 0);
    result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "EditFragmentArgs{"
        + "id=" + getId()
        + ", type=" + getType()
        + ", image=" + getImage()
        + ", name=" + getName()
        + ", order=" + getOrder()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull EditFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@Nullable String id, @Nullable String type, @NonNull String image,
        @Nullable String name, @Nullable String order) {
      this.arguments.put("id", id);
      this.arguments.put("type", type);
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("image", image);
      this.arguments.put("name", name);
      this.arguments.put("order", order);
    }

    @NonNull
    public EditFragmentArgs build() {
      EditFragmentArgs result = new EditFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setId(@Nullable String id) {
      this.arguments.put("id", id);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setType(@Nullable String type) {
      this.arguments.put("type", type);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setImage(@NonNull String image) {
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("image", image);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setName(@Nullable String name) {
      this.arguments.put("name", name);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setOrder(@Nullable String order) {
      this.arguments.put("order", order);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getId() {
      return (String) arguments.get("id");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getType() {
      return (String) arguments.get("type");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getImage() {
      return (String) arguments.get("image");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getName() {
      return (String) arguments.get("name");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getOrder() {
      return (String) arguments.get("order");
    }
  }
}
