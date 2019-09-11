// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.repairs;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class RepairsResultActivity_ViewBinding<T extends RepairsResultActivity> implements Unbinder {
  protected T target;

  @UiThread
  public RepairsResultActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.nameTv = Utils.findRequiredViewAsType(source, R.id.name_tv, "field 'nameTv'", TextView.class);
    target.phoneTv = Utils.findRequiredViewAsType(source, R.id.phone_tv, "field 'phoneTv'", TextView.class);
    target.adressTv = Utils.findRequiredViewAsType(source, R.id.adress_tv, "field 'adressTv'", TextView.class);
    target.questionTv = Utils.findRequiredViewAsType(source, R.id.question_tv, "field 'questionTv'", TextView.class);
    target.remarkTv = Utils.findRequiredViewAsType(source, R.id.remark_tv, "field 'remarkTv'", TextView.class);
    target.dateTv = Utils.findRequiredViewAsType(source, R.id.date_tv, "field 'dateTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.nameTv = null;
    target.phoneTv = null;
    target.adressTv = null;
    target.questionTv = null;
    target.remarkTv = null;
    target.dateTv = null;

    this.target = null;
  }
}
