// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.shop;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.lucode.hackware.magicindicator.MagicIndicator;
import personal.buildbroad.R;

public class BroadListActivity_ViewBinding<T extends BroadListActivity> implements Unbinder {
  protected T target;

  @UiThread
  public BroadListActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.magicIndicator = Utils.findRequiredViewAsType(source, R.id.magic_indicator, "field 'magicIndicator'", MagicIndicator.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.magicIndicator = null;
    target.viewPager = null;

    this.target = null;
  }
}
