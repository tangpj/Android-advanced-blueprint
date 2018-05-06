package tang.com.tododatabinding.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

    private final ObservableField<Boolean> isLoading = new ObservableField<>();
    private final ObservableField<Account> account = new ObservableField<>();

    public LoginViewModel(){
        account.set(new Account("",""));
    }

    public void login(View view){
        isLoading.set(true);
            new Handler().postDelayed(() -> {
                Log.d(TAG,"正在登陆中....\n"
                        + "accountNum = " + Objects.requireNonNull(account.get()).getAccountNum().get()
                        + "\npassword = " + Objects.requireNonNull(account.get()).getPassword().get());
                isLoading.set(false);
            }, 2000);
    }

    public ObservableField<Boolean> getIsLoading(){
        return isLoading;
    }

    public Account getAccount(){
        return account.get();
    }
}
