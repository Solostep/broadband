// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

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

public class UserInfoActivity_ViewBinding<T extends UserInfoActivity> implements Unbinder {
  protected T target;

  private View view2131230838;

  private View view2131231103;

  @UiThread
  public UserInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.userNameTv = Utils.findRequiredViewAsType(source, R.id.user_name_tv, "field 'userNameTv'", TextView.class);
    target.userPhoneTv = Utils.findRequiredViewAsType(source, R.id.user_phone_tv, "field 'userPhoneTv'", TextView.class);
    target.userAddressTv = Utils.findRequiredViewAsType(source, R.id.user_address_tv, "field 'userAddressTv'", TextView.class);
    target.userEmailTv = Utils.findRequiredViewAsType(source, R.id.user_email_tv, "field 'userEmailTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.edit_user_info_tv, "field 'editUserInfoTv' and method 'onEditClick'");
    target.editUserInfoTv = Utils.castView(view, R.id.edit_user_info_tv, "field 'editUserInfoTv'", TextView.class);
    view2131230838 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onEditClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.upload_again_btn, "field 'uploadAgainBtn' and method 'onProveClick'");
    target.uploadAgainBtn = Utils.castView(view, R.id.upload_again_btn, "field 'uploadAgainBtn'", Button.class);
    view2131231103 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onProveClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.userNameTv = null;
    target.userPhoneTv = null;
    target.userAddressTv = null;
    target.userEmailTv = null;
    target.editUserInfoTv = null;
    target.uploadAgainBtn = null;

    view2131230838.setOnClickListener(null);
    view2131230838 = null;
    view2131231103.setOnClickListener(null);
    view2131231103 = null;

    this.target = null;
  }
}
