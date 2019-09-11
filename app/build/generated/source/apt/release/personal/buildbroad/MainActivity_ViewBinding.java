// Generated code from Butter Knife. Do not modify!
package personal.buildbroad;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131230808;

  private View view2131230779;

  private View view2131230918;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.exit_login_btn, "method 'onLinearClick'");
    view2131230808 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.commit_btn, "method 'onLinearClick'");
    view2131230779 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.refresh_apmac_btn, "method 'onLinearClick'");
    view2131230918 = view;
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
    if (this.target == null) throw new IllegalStateException("Bindings already cleared.");

    view2131230808.setOnClickListener(null);
    view2131230808 = null;
    view2131230779.setOnClickListener(null);
    view2131230779 = null;
    view2131230918.setOnClickListener(null);
    view2131230918 = null;

    this.target = null;
  }
}
