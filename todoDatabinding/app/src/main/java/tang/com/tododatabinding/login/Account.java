package tang.com.tododatabinding.login;

import android.databinding.ObservableField;
import android.text.TextWatcher;

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
