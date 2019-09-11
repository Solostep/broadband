// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class UserProveActivity_ViewBinding<T extends UserProveActivity> implements Unbinder {
  protected T target;

  private View view2131230878;

  private View view2131231056;

  @UiThread
  public UserProveActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.phoneHintTv = Utils.findRequiredViewAsType(source, R.id.phone_hint_tv, "field 'phoneHintTv'", TextView.class);
    target.realNameInputEt = Utils.findRequiredViewAsType(source, R.id.real_name_input_et, "field 'realNameInputEt'", EditText.class);
    target.idcardInputEt = Utils.findRequiredViewAsType(source, R.id.idcard_input_et, "field 'idcardInputEt'", EditText.class);
    target.uploadHintTv = Utils.findRequiredViewAsType(source, R.id.upload_hint_tv, "field 'uploadHintTv'", TextView.class);
    target.errorHintTv = Utils.findRequiredViewAsType(source, R.id.error_hint_tv, "field 'errorHintTv'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.identity_add_img, "field 'identityAddImg' and method 'onExampleClick'");
    target.identityAddImg = Utils.castView(view, R.id.identity_add_img, "field 'identityAddImg'", ImageView.class);
    view2131230878 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onExampleClick();
      }
    });
    target.identityHintTv = Utils.findRequiredViewAsType(source, R.id.identity_hint_tv, "field 'identityHintTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.submit_btn, "field 'submitBtn' and method 'submitClick'");
    target.submitBtn = Utils.castView(view, R.id.submit_btn, "field 'submitBtn'", Button.class);
    view2131231056 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitClick();
      }
    });
    target.addIdentityLinear = Utils.findRequiredViewAsType(source, R.id.add_identity_linear, "field 'addIdentityLinear'", RelativeLayout.class);
    target.pictureImg = Utils.findRequiredViewAsType(source, R.id.picture_img, "field 'pictureImg'", ImageView.class);
    target.delImg = Utils.findRequiredViewAsType(source, R.id.del_img, "field 'delImg'", ImageView.class);
    target.showIdentityFrame = Utils.findRequiredViewAsType(source, R.id.show_identity_frame, "field 'showIdentityFrame'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.phoneHintTv = null;
    target.realNameInputEt = null;
    target.idcardInputEt = null;
    target.uploadHintTv = null;
    target.errorHintTv = null;
    target.identityAddImg = null;
    target.identityHintTv = null;
    target.submitBtn = null;
    target.addIdentityLinear = null;
    target.pictureImg = null;
    target.delImg = null;
    target.showIdentityFrame = null;

    view2131230878.setOnClickListener(null);
    view2131230878 = null;
    view2131231056.setOnClickListener(null);
    view2131231056 = null;

    this.target = null;
  }
}
