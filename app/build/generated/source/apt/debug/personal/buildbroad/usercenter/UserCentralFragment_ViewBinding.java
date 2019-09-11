// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class UserCentralFragment_ViewBinding<T extends UserCentralFragment> implements Unbinder {
  protected T target;

  private View view2131230947;

  private View view2131231112;

  private View view2131231010;

  private View view2131230812;

  private View view2131231059;

  private View view2131230726;

  private View view2131230853;

  private View view2131231109;

  @UiThread
  public UserCentralFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.unreadMsgTv = Utils.findRequiredViewAsType(source, R.id.unread_msg_tv, "field 'unreadMsgTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.notice_linear, "field 'noticeLinear' and method 'onLinearClick'");
    target.noticeLinear = Utils.castView(view, R.id.notice_linear, "field 'noticeLinear'", RelativeLayout.class);
    view2131230947 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_info_linear, "field 'userInfoLinear' and method 'onLinearClick'");
    target.userInfoLinear = Utils.castView(view, R.id.user_info_linear, "field 'userInfoLinear'", RelativeLayout.class);
    view2131231112 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.reset_pwds_linear, "field 'resetPwdsLinear' and method 'onLinearClick'");
    target.resetPwdsLinear = Utils.castView(view, R.id.reset_pwds_linear, "field 'resetPwdsLinear'", RelativeLayout.class);
    view2131231010 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.compation_linear, "field 'compationLinear' and method 'onLinearClick'");
    target.compationLinear = Utils.castView(view, R.id.compation_linear, "field 'compationLinear'", RelativeLayout.class);
    view2131230812 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.suggestion_linear, "field 'suggestionLinear' and method 'onLinearClick'");
    target.suggestionLinear = Utils.castView(view, R.id.suggestion_linear, "field 'suggestionLinear'", RelativeLayout.class);
    view2131231059 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.about_us_linear, "field 'aboutUsLinear' and method 'onLinearClick'");
    target.aboutUsLinear = Utils.castView(view, R.id.about_us_linear, "field 'aboutUsLinear'", RelativeLayout.class);
    view2131230726 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.exit_login_btn, "field 'exitLoginBtn' and method 'onLinearClick'");
    target.exitLoginBtn = Utils.castView(view, R.id.exit_login_btn, "field 'exitLoginBtn'", Button.class);
    view2131230853 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.user_info_edit_img, "field 'userInfoEditImg' and method 'onLinearClick'");
    target.userInfoEditImg = Utils.castView(view, R.id.user_info_edit_img, "field 'userInfoEditImg'", ImageView.class);
    view2131231109 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    target.userNameTv = Utils.findRequiredViewAsType(source, R.id.user_name_tv, "field 'userNameTv'", TextView.class);
    target.addressTv = Utils.findRequiredViewAsType(source, R.id.address_tv, "field 'addressTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.unreadMsgTv = null;
    target.noticeLinear = null;
    target.userInfoLinear = null;
    target.resetPwdsLinear = null;
    target.compationLinear = null;
    target.suggestionLinear = null;
    target.aboutUsLinear = null;
    target.exitLoginBtn = null;
    target.userInfoEditImg = null;
    target.userNameTv = null;
    target.addressTv = null;

    view2131230947.setOnClickListener(null);
    view2131230947 = null;
    view2131231112.setOnClickListener(null);
    view2131231112 = null;
    view2131231010.setOnClickListener(null);
    view2131231010 = null;
    view2131230812.setOnClickListener(null);
    view2131230812 = null;
    view2131231059.setOnClickListener(null);
    view2131231059 = null;
    view2131230726.setOnClickListener(null);
    view2131230726 = null;
    view2131230853.setOnClickListener(null);
    view2131230853 = null;
    view2131231109.setOnClickListener(null);
    view2131231109 = null;

    this.target = null;
  }
}
