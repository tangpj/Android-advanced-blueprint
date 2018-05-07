package tang.com.tododatabindingv2.utils;

import android.databinding.BindingAdapter;
import android.view.View;

public class BindingAdapters {

    @BindingAdapter("isVisible")
    public static void showHide(View view,boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
