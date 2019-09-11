// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class SubmitIdentityActivity_ViewBinding<T extends SubmitIdentityActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SubmitIdentityActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.realNameInputEt = Utils.findRequiredViewAsType(source, R.id.real_name_input_et, "field 'realNameInputEt'", EditText.class);
    target.idcardInputEt = Utils.findRequiredViewAsType(source, R.id.idcard_input_et, "field 'idcardInputEt'", EditText.class);
    target.photoExampleTv = Utils.findRequiredViewAsType(source, R.id.photo_example_tv, "field 'photoExampleTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.realNameInputEt = null;
    target.idcardInputEt = null;
    target.photoExampleTv = null;

    this.target = null;
  }
}
