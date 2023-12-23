// Generated by view binder compiler. Do not edit!
package com.example.career.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.career.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout branchGroup1;

  @NonNull
  public final LinearLayout branchGroup2;

  @NonNull
  public final Button civilBranch;

  @NonNull
  public final Button cseBranch;

  @NonNull
  public final Button eceBranch;

  @NonNull
  public final Button hnsBranch;

  private FragmentHomeBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout branchGroup1,
      @NonNull LinearLayout branchGroup2, @NonNull Button civilBranch, @NonNull Button cseBranch,
      @NonNull Button eceBranch, @NonNull Button hnsBranch) {
    this.rootView = rootView;
    this.branchGroup1 = branchGroup1;
    this.branchGroup2 = branchGroup2;
    this.civilBranch = civilBranch;
    this.cseBranch = cseBranch;
    this.eceBranch = eceBranch;
    this.hnsBranch = hnsBranch;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.branch_group1;
      LinearLayout branchGroup1 = ViewBindings.findChildViewById(rootView, id);
      if (branchGroup1 == null) {
        break missingId;
      }

      id = R.id.branch_group2;
      LinearLayout branchGroup2 = ViewBindings.findChildViewById(rootView, id);
      if (branchGroup2 == null) {
        break missingId;
      }

      id = R.id.civil_branch;
      Button civilBranch = ViewBindings.findChildViewById(rootView, id);
      if (civilBranch == null) {
        break missingId;
      }

      id = R.id.cse_branch;
      Button cseBranch = ViewBindings.findChildViewById(rootView, id);
      if (cseBranch == null) {
        break missingId;
      }

      id = R.id.ece_branch;
      Button eceBranch = ViewBindings.findChildViewById(rootView, id);
      if (eceBranch == null) {
        break missingId;
      }

      id = R.id.hns_branch;
      Button hnsBranch = ViewBindings.findChildViewById(rootView, id);
      if (hnsBranch == null) {
        break missingId;
      }

      return new FragmentHomeBinding((LinearLayout) rootView, branchGroup1, branchGroup2,
          civilBranch, cseBranch, eceBranch, hnsBranch);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}