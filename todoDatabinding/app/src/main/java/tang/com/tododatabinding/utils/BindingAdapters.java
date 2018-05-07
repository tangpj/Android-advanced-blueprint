package tang.com.tododatabinding.utils;

import android.databinding.BindingAdapter;
import android.view.View;

public class BindingAdapters {

    @BindingAdapter("isVisible")
    public static void showHide(View view,boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
