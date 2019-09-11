// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class UserCentralFragmentTest_ViewBinding<T extends UserCentralFragmentTest> implements Unbinder {
  protected T target;

  private View view2131230853;

  @UiThread
  public UserCentralFragmentTest_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.userNameTv = Utils.findRequiredViewAsType(source, R.id.user_name_tv, "field 'userNameTv'", TextView.class);
    target.addressTv = Utils.findRequiredViewAsType(source, R.id.address_tv, "field 'addressTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.exit_login_btn, "method 'onLinearClick'");
    view2131230853 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.userNameTv = null;
    target.addressTv = null;

    view2131230853.setOnClickListener(null);
    view2131230853 = null;

    this.target = null;
  }
}
