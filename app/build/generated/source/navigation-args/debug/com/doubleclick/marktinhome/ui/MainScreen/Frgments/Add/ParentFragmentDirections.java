package com.doubleclick.marktinhome.ui.MainScreen.Frgments.Add;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.Model.ParentCategory;
import com.doubleclick.marktinhome.R;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ParentFragmentDirections {
  private ParentFragmentDirections() {
  }

  @NonNull
  public static ActionParentFragmentToChildFragment actionParentFragmentToChildFragment(
      @Nullable ParentCategory Parent) {
    return new ActionParentFragmentToChildFragment(Parent);
  }

  @NonNull
  public static ActionParentFragmentToEditFragment actionParentFragmentToEditFragment(
      @Nullable String id, @Nullable String type, @NonNull String image, @Nullable String name,
      @Nullable String order) {
    return new ActionParentFragmentToEditFragment(id, type, image, name, order);
  }

  public static class ActionParentFragmentToChildFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionParentFragmentToChildFragment(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToChildFragment setParent(@Nullable ParentCategory Parent) {
      this.arguments.put("Parent", Parent);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Parent")) {
        ParentCategory Parent = (ParentCategory) arguments.get("Parent");
        if (Parcelable.class.isAssignableFrom(ParentCategory.class) || Parent == null) {
          __result.putParcelable("Parent", Parcelable.class.cast(Parent));
        } else if (Serializable.class.isAssignableFrom(ParentCategory.class)) {
          __result.putSerializable("Parent", Serializable.class.cast(Parent));
        } else {
          throw new UnsupportedOperationException(ParentCategory.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_parentFragment_to_childFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public ParentCategory getParent() {
      return (ParentCategory) arguments.get("Parent");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionParentFragmentToChildFragment that = (ActionParentFragmentToChildFragment) object;
      if (arguments.containsKey("Parent") != that.arguments.containsKey("Parent")) {
        return false;
      }
      if (getParent() != null ? !getParent().equals(that.getParent()) : that.getParent() != null) {
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
      result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionParentFragmentToChildFragment(actionId=" + getActionId() + "){"
          + "Parent=" + getParent()
          + "}";
    }
  }

  public static class ActionParentFragmentToEditFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionParentFragmentToEditFragment(@Nullable String id, @Nullable String type,
        @NonNull String image, @Nullable String name, @Nullable String order) {
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
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToEditFragment setId(@Nullable String id) {
      this.arguments.put("id", id);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToEditFragment setType(@Nullable String type) {
      this.arguments.put("type", type);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToEditFragment setImage(@NonNull String image) {
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("image", image);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToEditFragment setName(@Nullable String name) {
      this.arguments.put("name", name);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionParentFragmentToEditFragment setOrder(@Nullable String order) {
      this.arguments.put("order", order);
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

    @Override
    public int getActionId() {
      return R.id.action_parentFragment_to_editFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionParentFragmentToEditFragment that = (ActionParentFragmentToEditFragment) object;
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
      if (getActionId() != that.getActionId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionParentFragmentToEditFragment(actionId=" + getActionId() + "){"
          + "id=" + getId()
          + ", type=" + getType()
          + ", image=" + getImage()
          + ", name=" + getName()
          + ", order=" + getOrder()
          + "}";
    }
  }
}
