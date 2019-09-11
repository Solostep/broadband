// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class PasswordLoginActivity_ViewBinding<T extends PasswordLoginActivity> implements Unbinder {
  protected T target;

  private View view2131230921;

  private View view2131230865;

  @UiThread
  public PasswordLoginActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.phoneInputEt = Utils.findRequiredViewAsType(source, R.id.phone_input_et, "field 'phoneInputEt'", EditText.class);
    target.passwordInputEt = Utils.findRequiredViewAsType(source, R.id.password_input_et, "field 'passwordInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.login_btn, "field 'registerBtn' and method 'loginClick'");
    target.registerBtn = Utils.castView(view, R.id.login_btn, "field 'registerBtn'", Button.class);
    view2131230921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loginClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.forget_password_tv, "field 'forgetPasswordTv' and method 'resetPassword'");
    target.forgetPasswordTv = Utils.castView(view, R.id.forget_password_tv, "field 'forgetPasswordTv'", TextView.class);
    view2131230865 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.resetPassword();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.phoneInputEt = null;
    target.passwordInputEt = null;
    target.registerBtn = null;
    target.forgetPasswordTv = null;

    view2131230921.setOnClickListener(null);
    view2131230921 = null;
    view2131230865.setOnClickListener(null);
    view2131230865 = null;

    this.target = null;
  }
}
