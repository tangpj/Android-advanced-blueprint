package tang.com.tododatabindingv2.login;

import android.arch.lifecycle.MutableLiveData;

public class Account {
    private MutableLiveData<String> accountNum = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();

    Account(String accountNum, String password){
        this.accountNum.setValue(accountNum);
        this.password.setValue(password);
    }

    public MutableLiveData<String> getAccountNum(){
        return accountNum;
    }

    public MutableLiveData<String> getPassword(){
        return password;
    }

}
