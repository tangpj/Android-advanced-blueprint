package tang.com.tododatabindingv2.login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.Objects;

import tang.com.tododatabindingv2.MainActivity;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final MutableLiveData<Account> account = new MutableLiveData<>();
    private final MutableLiveData<String> loginPrompt = new MutableLiveData<>();

    public LoginViewModel(){
        account.postValue(new Account("",""));
        isLoading.postValue(false);
    }

    public void login(View view){
        String loginMsg =  "accountNum = " + Objects.requireNonNull(account.getValue()).getAccountNum().getValue()
                + "\npassword = " + Objects.requireNonNull(account.getValue()).getPassword().getValue();
        Log.d(TAG,"\n正在登陆中....\n"
               + loginMsg);
        loginPrompt.postValue("正在登陆账号：" + Objects.requireNonNull(account.getValue()).getAccountNum().getValue());
        isLoading.postValue(true);
            new Handler().postDelayed(() -> {
                Log.d(TAG,"登陆成功....\n");
                isLoading.postValue(false);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("hello", loginMsg);
                view.getContext().startActivity(intent);
                loginPrompt.postValue("");
            }, 2000);

    }

    public MutableLiveData<Boolean> getIsLoading(){
        return isLoading;
    }

    public Account getAccount(){
        return account.getValue();
    }

    public MutableLiveData<String> getLoginPrompt() {
        return loginPrompt;
    }
}
