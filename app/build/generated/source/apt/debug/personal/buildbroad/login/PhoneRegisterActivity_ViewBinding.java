// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class PhoneRegisterActivity_ViewBinding<T extends PhoneRegisterActivity> implements Unbinder {
  protected T target;

  private View view2131231009;

  private View view2131231044;

  @UiThread
  public PhoneRegisterActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.phoneInputEt = Utils.findRequiredViewAsType(source, R.id.phone_input_et, "field 'phoneInputEt'", EditText.class);
    target.msgInputEt = Utils.findRequiredViewAsType(source, R.id.msg_input_et, "field 'msgInputEt'", EditText.class);
    target.msgSendBtn = Utils.findRequiredViewAsType(source, R.id.msg_send_btn, "field 'msgSendBtn'", Button.class);
    target.passwordInputEt = Utils.findRequiredViewAsType(source, R.id.password_input_et, "field 'passwordInputEt'", EditText.class);
    target.requirePasswordInputEt = Utils.findRequiredViewAsType(source, R.id.require_password_input_et, "field 'requirePasswordInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.register_btn, "field 'registerBtn' and method 'registerBtn'");
    target.registerBtn = Utils.castView(view, R.id.register_btn, "field 'registerBtn'", Button.class);
    view2131231009 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.registerBtn();
      }
    });
    view = Utils.findRequiredView(source, R.id.service_agrement_iv, "field 'serviceAgrementIv' and method 'serviceAgreement'");
    target.serviceAgrementIv = Utils.castView(view, R.id.service_agrement_iv, "field 'serviceAgrementIv'", ImageView.class);
    view2131231044 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.serviceAgreement(Utils.<ImageView>castParam(p0, "doClick", 0, "serviceAgreement", 0));
      }
    });
    target.serviceIsAgreementTv = Utils.findRequiredViewAsType(source, R.id.service_is_agreement_tv, "field 'serviceIsAgreementTv'", TextView.class);
    target.serviceAgreementTv = Utils.findRequiredViewAsType(source, R.id.service_agreement_tv, "field 'serviceAgreementTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.phoneInputEt = null;
    target.msgInputEt = null;
    target.msgSendBtn = null;
    target.passwordInputEt = null;
    target.requirePasswordInputEt = null;
    target.registerBtn = null;
    target.serviceAgrementIv = null;
    target.serviceIsAgreementTv = null;
    target.serviceAgreementTv = null;

    view2131231009.setOnClickListener(null);
    view2131231009 = null;
    view2131231044.setOnClickListener(null);
    view2131231044 = null;

    this.target = null;
  }
}
