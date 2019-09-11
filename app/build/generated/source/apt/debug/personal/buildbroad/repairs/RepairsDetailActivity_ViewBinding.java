// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.repairs;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class RepairsDetailActivity_ViewBinding<T extends RepairsDetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public RepairsDetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.repairsRadioGroup = Utils.findRequiredViewAsType(source, R.id.repairs_radio_group, "field 'repairsRadioGroup'", RadioGroup.class);
    target.repairsContentEt = Utils.findRequiredViewAsType(source, R.id.repairs_content_et, "field 'repairsContentEt'", EditText.class);
    target.remarkLinear = Utils.findRequiredViewAsType(source, R.id.remark_linear, "field 'remarkLinear'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.repairsRadioGroup = null;
    target.repairsContentEt = null;
    target.remarkLinear = null;

    this.target = null;
  }
}
