// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class ResetPasswordActivity_ViewBinding<T extends ResetPasswordActivity> implements Unbinder {
  protected T target;

  private View view2131231009;

  @UiThread
  public ResetPasswordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.register_btn, "field 'registerBtn' and method 'resetPassword'");
    target.registerBtn = Utils.castView(view, R.id.register_btn, "field 'registerBtn'", Button.class);
    view2131231009 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.resetPassword();
      }
    });
    target.passwordInputEt = Utils.findRequiredViewAsType(source, R.id.password_input_et, "field 'passwordInputEt'", EditText.class);
    target.requirePasswordInputEt = Utils.findRequiredViewAsType(source, R.id.require_password_input_et, "field 'requirePasswordInputEt'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.registerBtn = null;
    target.passwordInputEt = null;
    target.requirePasswordInputEt = null;

    view2131231009.setOnClickListener(null);
    view2131231009 = null;

    this.target = null;
  }
}
