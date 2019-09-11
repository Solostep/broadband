// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class ProductListAdapter$ViewHolder_ViewBinding<T extends ProductListAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ProductListAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.productNameTv = Utils.findRequiredViewAsType(source, R.id.product_name_tv, "field 'productNameTv'", TextView.class);
    target.oldPriceTv = Utils.findRequiredViewAsType(source, R.id.old_price_tv, "field 'oldPriceTv'", TextView.class);
    target.nowPriceTv = Utils.findRequiredViewAsType(source, R.id.now_price_tv, "field 'nowPriceTv'", TextView.class);
    target.productBuyImg = Utils.findRequiredViewAsType(source, R.id.product_buy_img, "field 'productBuyImg'", ImageView.class);
    target.nowBuyTv = Utils.findRequiredViewAsType(source, R.id.now_buy_tv, "field 'nowBuyTv'", TextView.class);
    target.buyLinear = Utils.findRequiredViewAsType(source, R.id.buy_linear, "field 'buyLinear'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.productNameTv = null;
    target.oldPriceTv = null;
    target.nowPriceTv = null;
    target.productBuyImg = null;
    target.nowBuyTv = null;
    target.buyLinear = null;

    this.target = null;
  }
}
