// Generated by view binder compiler. Do not edit!
package com.example.career.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.career.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final TextInputEditText gmail;

  @NonNull
  public final TextInputEditText password;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final TextView registerNow;

  private ActivityLoginBinding(@NonNull LinearLayout rootView, @NonNull Button btnLogin,
      @NonNull TextInputEditText gmail, @NonNull TextInputEditText password,
      @NonNull ProgressBar progressbar, @NonNull TextView registerNow) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.gmail = gmail;
    this.password = password;
    this.progressbar = progressbar;
    this.registerNow = registerNow;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_login;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.gmail;
      TextInputEditText gmail = ViewBindings.findChildViewById(rootView, id);
      if (gmail == null) {
        break missingId;
      }

      id = R.id.password;
      TextInputEditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.registerNow;
      TextView registerNow = ViewBindings.findChildViewById(rootView, id);
      if (registerNow == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, btnLogin, gmail, password,
          progressbar, registerNow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
