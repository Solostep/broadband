// Generated code from Butter Knife. Do not modify!
package personal.buildbroad;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  private View view2131230777;

  private View view2131230780;

  private View view2131230782;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.buyProductTv = Utils.findRequiredViewAsType(source, R.id.buy_product_tv, "field 'buyProductTv'", TextView.class);
    target.userGoodTv = Utils.findRequiredViewAsType(source, R.id.user_good_tv, "field 'userGoodTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.broad_manage_linear, "field 'broadManageLinear' and method 'onDeviceClick'");
    target.broadManageLinear = Utils.castView(view, R.id.broad_manage_linear, "field 'broadManageLinear'", LinearLayout.class);
    view2131230777 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onDeviceClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.broad_network_trouble_linear, "field 'broadNetworkTroubleLinear' and method 'onTroubleClick'");
    target.broadNetworkTroubleLinear = Utils.castView(view, R.id.broad_network_trouble_linear, "field 'broadNetworkTroubleLinear'", LinearLayout.class);
    view2131230780 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTroubleClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.broad_order_linear, "field 'broadOrderLinear' and method 'onBuyClick'");
    target.broadOrderLinear = Utils.castView(view, R.id.broad_order_linear, "field 'broadOrderLinear'", LinearLayout.class);
    view2131230782 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBuyClick(p0);
      }
    });
    target.broadOrderImg = Utils.findRequiredViewAsType(source, R.id.broad_order_img, "field 'broadOrderImg'", ImageView.class);
    target.broadOrderTv = Utils.findRequiredViewAsType(source, R.id.broad_order_tv, "field 'broadOrderTv'", TextView.class);
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.buyProductTv = null;
    target.userGoodTv = null;
    target.broadManageLinear = null;
    target.broadNetworkTroubleLinear = null;
    target.broadOrderLinear = null;
    target.broadOrderImg = null;
    target.broadOrderTv = null;
    target.banner = null;

    view2131230777.setOnClickListener(null);
    view2131230777 = null;
    view2131230780.setOnClickListener(null);
    view2131230780 = null;
    view2131230782.setOnClickListener(null);
    view2131230782 = null;

    this.target = null;
  }
}
