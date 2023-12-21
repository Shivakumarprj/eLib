// Generated by view binder compiler. Do not edit!
package com.example.career.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.career.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button aidsBranch;

  @NonNull
  public final Button aimlBranch;

  @NonNull
  public final Button cseBranch;

  private FragmentDashboardBinding(@NonNull RelativeLayout rootView, @NonNull Button aidsBranch,
      @NonNull Button aimlBranch, @NonNull Button cseBranch) {
    this.rootView = rootView;
    this.aidsBranch = aidsBranch;
    this.aimlBranch = aimlBranch;
    this.cseBranch = cseBranch;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aids_branch;
      Button aidsBranch = ViewBindings.findChildViewById(rootView, id);
      if (aidsBranch == null) {
        break missingId;
      }

      id = R.id.aiml_branch;
      Button aimlBranch = ViewBindings.findChildViewById(rootView, id);
      if (aimlBranch == null) {
        break missingId;
      }

      id = R.id.cse_branch;
      Button cseBranch = ViewBindings.findChildViewById(rootView, id);
      if (cseBranch == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((RelativeLayout) rootView, aidsBranch, aimlBranch,
          cseBranch);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
