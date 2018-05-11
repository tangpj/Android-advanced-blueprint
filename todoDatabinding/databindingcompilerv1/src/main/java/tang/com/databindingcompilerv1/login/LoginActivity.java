package tang.com.databindingcompilerv1.login;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tang.com.databindingcompilerv1.R;
import tang.com.databindingcompilerv1.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getLoginPrompt().observe(this, observe -> {
            binding.tvPrompt.setText(observe);
        });
    }
}
