// Generated code from Butter Knife. Do not modify!
package personal.buildbroad.usercenter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import personal.buildbroad.R;

public class SuggestionActivity_ViewBinding<T extends SuggestionActivity> implements Unbinder {
  protected T target;

  private View view2131231016;

  @UiThread
  public SuggestionActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.suggestionEt = Utils.findRequiredViewAsType(source, R.id.suggestion_et, "field 'suggestionEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.save_btn, "field 'saveBtn' and method 'saveSuggestion'");
    target.saveBtn = Utils.castView(view, R.id.save_btn, "field 'saveBtn'", Button.class);
    view2131231016 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.saveSuggestion();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.suggestionEt = null;
    target.saveBtn = null;

    view2131231016.setOnClickListener(null);
    view2131231016 = null;

    this.target = null;
  }
}
