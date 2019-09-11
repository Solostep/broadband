// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

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

public class ResetNewPasswordActivity_ViewBinding<T extends ResetNewPasswordActivity> implements Unbinder {
  protected T target;

  private View view2131231001;

  @UiThread
  public ResetNewPasswordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.oldPwdInputEt = Utils.findRequiredViewAsType(source, R.id.old_pwd_input_et, "field 'oldPwdInputEt'", EditText.class);
    target.newPwdInputEt = Utils.findRequiredViewAsType(source, R.id.new_pwd_input_et, "field 'newPwdInputEt'", EditText.class);
    target.requirePwdInputEt = Utils.findRequiredViewAsType(source, R.id.require_pwd_input_et, "field 'requirePwdInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.register_btn, "field 'registerBtn' and method 'onSubmitClick'");
    target.registerBtn = Utils.castView(view, R.id.register_btn, "field 'registerBtn'", Button.class);
    view2131231001 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSubmitClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.oldPwdInputEt = null;
    target.newPwdInputEt = null;
    target.requirePwdInputEt = null;
    target.registerBtn = null;

    view2131231001.setOnClickListener(null);
    view2131231001 = null;

    this.target = null;
  }
}
