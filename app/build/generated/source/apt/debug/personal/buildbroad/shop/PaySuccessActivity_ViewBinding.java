// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.shop;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class PaySuccessActivity_ViewBinding<T extends PaySuccessActivity> implements Unbinder {
  protected T target;

  private View view2131230967;

  @UiThread
  public PaySuccessActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.complateHintTv = Utils.findRequiredViewAsType(source, R.id.complate_hint_tv, "field 'complateHintTv'", TextView.class);
    target.priceTv = Utils.findRequiredViewAsType(source, R.id.price_tv, "field 'priceTv'", TextView.class);
    target.broadNameTv = Utils.findRequiredViewAsType(source, R.id.broad_name_tv, "field 'broadNameTv'", TextView.class);
    target.broadDateTv = Utils.findRequiredViewAsType(source, R.id.broad_date_tv, "field 'broadDateTv'", TextView.class);
    target.addressTv = Utils.findRequiredViewAsType(source, R.id.address_tv, "field 'addressTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.order_completes_btn, "field 'orderCompletesBtn' and method 'OnCompltetClick'");
    target.orderCompletesBtn = Utils.castView(view, R.id.order_completes_btn, "field 'orderCompletesBtn'", Button.class);
    view2131230967 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnCompltetClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.complateHintTv = null;
    target.priceTv = null;
    target.broadNameTv = null;
    target.broadDateTv = null;
    target.addressTv = null;
    target.orderCompletesBtn = null;

    view2131230967.setOnClickListener(null);
    view2131230967 = null;

    this.target = null;
  }
}
