// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.shop;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class OrderAndPayActivity_ViewBinding<T extends OrderAndPayActivity> implements Unbinder {
  protected T target;

  private View view2131231122;

  private View view2131230760;

  private View view2131231121;

  private View view2131230759;

  private View view2131230974;

  @UiThread
  public OrderAndPayActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.wechat_rb, "field 'wechatRb' and method 'onCheckClick'");
    target.wechatRb = Utils.castView(view, R.id.wechat_rb, "field 'wechatRb'", RadioButton.class);
    view2131231122 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCheckClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.alipay_rb, "field 'alipayRb' and method 'onCheckClick'");
    target.alipayRb = Utils.castView(view, R.id.alipay_rb, "field 'alipayRb'", RadioButton.class);
    view2131230760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCheckClick(p0);
      }
    });
    target.payRadioGroup = Utils.findRequiredViewAsType(source, R.id.pay_radio_group, "field 'payRadioGroup'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.wechat_linear, "field 'wechatLinear' and method 'onCheckClick'");
    target.wechatLinear = Utils.castView(view, R.id.wechat_linear, "field 'wechatLinear'", LinearLayout.class);
    view2131231121 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCheckClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.alipay_linear, "field 'alipayLinear' and method 'onCheckClick'");
    target.alipayLinear = Utils.castView(view, R.id.alipay_linear, "field 'alipayLinear'", LinearLayout.class);
    view2131230759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCheckClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.pay_btn, "field 'payButton' and method 'onPayClick'");
    target.payButton = Utils.castView(view, R.id.pay_btn, "field 'payButton'", Button.class);
    view2131230974 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPayClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.wechatRb = null;
    target.alipayRb = null;
    target.payRadioGroup = null;
    target.wechatLinear = null;
    target.alipayLinear = null;
    target.payButton = null;

    view2131231122.setOnClickListener(null);
    view2131231122 = null;
    view2131230760.setOnClickListener(null);
    view2131230760 = null;
    view2131231121.setOnClickListener(null);
    view2131231121 = null;
    view2131230759.setOnClickListener(null);
    view2131230759 = null;
    view2131230974.setOnClickListener(null);
    view2131230974 = null;

    this.target = null;
  }
}
