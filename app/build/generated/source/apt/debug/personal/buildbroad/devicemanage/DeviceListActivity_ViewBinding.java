// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.devicemanage;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.ui.layout.LoadingLayout;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class DeviceListActivity_ViewBinding<T extends DeviceListActivity> implements Unbinder {
  protected T target;

  private View view2131230943;

  @UiThread
  public DeviceListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.no_handle_linear, "field 'noHandleLinear' and method 'onHandleClick'");
    target.noHandleLinear = Utils.castView(view, R.id.no_handle_linear, "field 'noHandleLinear'", LinearLayout.class);
    view2131230943 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onHandleClick();
      }
    });
    target.connectTv = Utils.findRequiredViewAsType(source, R.id.connect_tv, "field 'connectTv'", TextView.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.listView, "field 'listView'", ListView.class);
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", LoadingLayout.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'refreshLayout'", SmartRefreshLayout.class);
    target.topImage = Utils.findRequiredViewAsType(source, R.id.top_image, "field 'topImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.noHandleLinear = null;
    target.connectTv = null;
    target.listView = null;
    target.loading = null;
    target.refreshLayout = null;
    target.topImage = null;

    view2131230943.setOnClickListener(null);
    view2131230943 = null;

    this.target = null;
  }
}
