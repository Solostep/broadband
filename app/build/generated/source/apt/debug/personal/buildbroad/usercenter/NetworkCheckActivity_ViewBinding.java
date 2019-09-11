// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class NetworkCheckActivity_ViewBinding<T extends NetworkCheckActivity> implements Unbinder {
  protected T target;

  private View view2131230802;

  @UiThread
  public NetworkCheckActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.check_btn, "field 'checkBtn' and method 'beginCheck'");
    target.checkBtn = Utils.castView(view, R.id.check_btn, "field 'checkBtn'", Button.class);
    view2131230802 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.beginCheck();
      }
    });
    target.checkHintTv = Utils.findRequiredViewAsType(source, R.id.check_hint_tv, "field 'checkHintTv'", TextView.class);
    target.callLinear = Utils.findRequiredViewAsType(source, R.id.call_linear, "field 'callLinear'", LinearLayout.class);
    target.topImage = Utils.findRequiredViewAsType(source, R.id.top_image, "field 'topImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.checkBtn = null;
    target.checkHintTv = null;
    target.callLinear = null;
    target.topImage = null;

    view2131230802.setOnClickListener(null);
    view2131230802 = null;

    this.target = null;
  }
}
