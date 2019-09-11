// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class ForgetPasswordActivity_ViewBinding<T extends ForgetPasswordActivity> implements Unbinder {
  protected T target;

  private View view2131230948;

  @UiThread
  public ForgetPasswordActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.phoneInputEt = Utils.findRequiredViewAsType(source, R.id.phone_input_et, "field 'phoneInputEt'", EditText.class);
    target.msgInputEt = Utils.findRequiredViewAsType(source, R.id.msg_input_et, "field 'msgInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.next_step_btn, "field 'nextStepBtn' and method 'nextStep'");
    target.nextStepBtn = Utils.castView(view, R.id.next_step_btn, "field 'nextStepBtn'", Button.class);
    view2131230948 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.nextStep();
      }
    });
    target.msgSendBtn = Utils.findRequiredViewAsType(source, R.id.msg_send_btn, "field 'msgSendBtn'", Button.class);
    target.msgLinear = Utils.findRequiredViewAsType(source, R.id.msg_linear, "field 'msgLinear'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.phoneInputEt = null;
    target.msgInputEt = null;
    target.nextStepBtn = null;
    target.msgSendBtn = null;
    target.msgLinear = null;

    view2131230948.setOnClickListener(null);
    view2131230948 = null;

    this.target = null;
  }
}
