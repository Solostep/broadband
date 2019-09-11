// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class MessageAndNoticeActivity_ViewBinding<T extends MessageAndNoticeActivity> implements Unbinder {
  protected T target;

  private View view2131231061;

  private View view2131230949;

  @UiThread
  public MessageAndNoticeActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.system_message_linear, "field 'systemMessageLinear' and method 'onLinearClick'");
    target.systemMessageLinear = Utils.castView(view, R.id.system_message_linear, "field 'systemMessageLinear'", RelativeLayout.class);
    view2131231061 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.notice_message_linear, "field 'noticeMessageLinear' and method 'onLinearClick'");
    target.noticeMessageLinear = Utils.castView(view, R.id.notice_message_linear, "field 'noticeMessageLinear'", RelativeLayout.class);
    view2131230949 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLinearClick(p0);
      }
    });
    target.noticeMsgTv = Utils.findRequiredViewAsType(source, R.id.notice_msg_tv, "field 'noticeMsgTv'", TextView.class);
    target.systemMsgTv = Utils.findRequiredViewAsType(source, R.id.system_msg_tv, "field 'systemMsgTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.systemMessageLinear = null;
    target.noticeMessageLinear = null;
    target.noticeMsgTv = null;
    target.systemMsgTv = null;

    view2131231061.setOnClickListener(null);
    view2131231061 = null;
    view2131230949.setOnClickListener(null);
    view2131230949 = null;

    this.target = null;
  }
}
