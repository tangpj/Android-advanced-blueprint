package tang.com.tododatabindingv2.login;

import android.databinding.ObservableField;

public class Account {
    private ObservableField<String> accountNum = new ObservableField<>();
    private ObservableField<String> password = new ObservableField<>();

    Account(String accountNum, String password){
        this.accountNum.set(accountNum);
        this.password.set(password);
    }

    public ObservableField<String> getAccountNum(){
        return accountNum;
    }

    public ObservableField<String> getPassword(){
        return password;
    }

}
