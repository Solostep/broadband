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

public class MyBroadActivity_ViewBinding<T extends MyBroadActivity> implements Unbinder {
  protected T target;

  private View view2131230775;

  @UiThread
  public MyBroadActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.broadNameTv = Utils.findRequiredViewAsType(source, R.id.broad_name_tv, "field 'broadNameTv'", TextView.class);
    target.accountTv = Utils.findRequiredViewAsType(source, R.id.account_tv, "field 'accountTv'", TextView.class);
    target.priceTv = Utils.findRequiredViewAsType(source, R.id.price_tv, "field 'priceTv'", TextView.class);
    target.broadDateTv = Utils.findRequiredViewAsType(source, R.id.broad_date_tv, "field 'broadDateTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.broad_list_btn, "field 'broadListBtn' and method 'onBroadListClick'");
    target.broadListBtn = Utils.castView(view, R.id.broad_list_btn, "field 'broadListBtn'", Button.class);
    view2131230775 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBroadListClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.broadNameTv = null;
    target.accountTv = null;
    target.priceTv = null;
    target.broadDateTv = null;
    target.broadListBtn = null;

    view2131230775.setOnClickListener(null);
    view2131230775 = null;

    this.target = null;
  }
}
