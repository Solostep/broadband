// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.devicemanage;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.ui.layout.LoadingLayout;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class DeviceNewListActivity_ViewBinding<T extends DeviceNewListActivity> implements Unbinder {
  protected T target;

  @UiThread
  public DeviceNewListActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.listView, "field 'listView'", ListView.class);
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", LoadingLayout.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'refreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.listView = null;
    target.loading = null;
    target.refreshLayout = null;

    this.target = null;
  }
}
