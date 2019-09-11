// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class IdentityExampleActivity_ViewBinding<T extends IdentityExampleActivity> implements Unbinder {
  protected T target;

  private View view2131231065;

  private View view2131230982;

  private View view2131230766;

  @UiThread
  public IdentityExampleActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.take_picuter_linear, "field 'takePicuterLinear' and method 'onPicuterClick'");
    target.takePicuterLinear = Utils.castView(view, R.id.take_picuter_linear, "field 'takePicuterLinear'", LinearLayout.class);
    view2131231065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPicuterClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.picuter_linear, "field 'picuterLinear' and method 'onPicuterClick'");
    target.picuterLinear = Utils.castView(view, R.id.picuter_linear, "field 'picuterLinear'", LinearLayout.class);
    view2131230982 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPicuterClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.back_btn, "field 'backBtn' and method 'onBackClick'");
    target.backBtn = Utils.castView(view, R.id.back_btn, "field 'backBtn'", Button.class);
    view2131230766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBackClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.takePicuterLinear = null;
    target.picuterLinear = null;
    target.backBtn = null;

    view2131231065.setOnClickListener(null);
    view2131231065 = null;
    view2131230982.setOnClickListener(null);
    view2131230982 = null;
    view2131230766.setOnClickListener(null);
    view2131230766 = null;

    this.target = null;
  }
}
