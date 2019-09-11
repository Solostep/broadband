// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.repairs;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class RepairsUserInfoActivity_ViewBinding<T extends RepairsUserInfoActivity> implements Unbinder {
  protected T target;

  private View view2131230942;

  @UiThread
  public RepairsUserInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.nameInputEt = Utils.findRequiredViewAsType(source, R.id.name_input_et, "field 'nameInputEt'", EditText.class);
    target.phoneInputEt = Utils.findRequiredViewAsType(source, R.id.phone_input_et, "field 'phoneInputEt'", EditText.class);
    target.addressInputEt = Utils.findRequiredViewAsType(source, R.id.address_input_et, "field 'addressInputEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.next_step_btn, "field 'nextStepBtn' and method 'onNextStepClick'");
    target.nextStepBtn = Utils.castView(view, R.id.next_step_btn, "field 'nextStepBtn'", Button.class);
    view2131230942 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onNextStepClick();
      }
    });
    target.topImage = Utils.findRequiredViewAsType(source, R.id.top_image, "field 'topImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.nameInputEt = null;
    target.phoneInputEt = null;
    target.addressInputEt = null;
    target.nextStepBtn = null;
    target.topImage = null;

    view2131230942.setOnClickListener(null);
    view2131230942 = null;

    this.target = null;
  }
}
