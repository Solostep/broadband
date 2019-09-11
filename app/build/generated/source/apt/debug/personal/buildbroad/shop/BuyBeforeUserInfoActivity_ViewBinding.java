// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.shop;

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

public class BuyBeforeUserInfoActivity_ViewBinding<T extends BuyBeforeUserInfoActivity> implements Unbinder {
  protected T target;

  private View view2131230942;

  @UiThread
  public BuyBeforeUserInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.userPhoneTv = Utils.findRequiredViewAsType(source, R.id.user_phone_tv, "field 'userPhoneTv'", TextView.class);
    target.realNameInputEt = Utils.findRequiredViewAsType(source, R.id.real_name_input_et, "field 'realNameInputEt'", EditText.class);
    target.adressInputEt = Utils.findRequiredViewAsType(source, R.id.adress_input_et, "field 'adressInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.next_step_btn, "field 'nextStepBtn' and method 'onNextStepClick'");
    target.nextStepBtn = Utils.castView(view, R.id.next_step_btn, "field 'nextStepBtn'", Button.class);
    view2131230942 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onNextStepClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.userPhoneTv = null;
    target.realNameInputEt = null;
    target.adressInputEt = null;
    target.nextStepBtn = null;

    view2131230942.setOnClickListener(null);
    view2131230942 = null;

    this.target = null;
  }
}
