// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

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

public class EditUserInfoActivity_ViewBinding<T extends EditUserInfoActivity> implements Unbinder {
  protected T target;

  private View view2131231016;

  @UiThread
  public EditUserInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.phoneHintTv = Utils.findRequiredViewAsType(source, R.id.phone_hint_tv, "field 'phoneHintTv'", TextView.class);
    target.nameInputEt = Utils.findRequiredViewAsType(source, R.id.name_input_et, "field 'nameInputEt'", EditText.class);
    target.adressInputEt = Utils.findRequiredViewAsType(source, R.id.adress_input_et, "field 'adressInputEt'", EditText.class);
    target.emailInputEt = Utils.findRequiredViewAsType(source, R.id.email_input_et, "field 'emailInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.save_btn, "field 'saveBtn' and method 'updateUserInfo'");
    target.saveBtn = Utils.castView(view, R.id.save_btn, "field 'saveBtn'", Button.class);
    view2131231016 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.updateUserInfo();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.phoneHintTv = null;
    target.nameInputEt = null;
    target.adressInputEt = null;
    target.emailInputEt = null;
    target.saveBtn = null;

    view2131231016.setOnClickListener(null);
    view2131231016 = null;

    this.target = null;
  }
}
