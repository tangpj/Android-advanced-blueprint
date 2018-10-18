package com.tangpj.order.ui.addedit;

import com.tangpj.order.BasePresenter;
import com.tangpj.order.BaseView;
import com.tangpj.order.pojo.Dish;

public interface AddEditDishContract {

    interface View extends BaseView<Presenter>{
        void showDish(Dish dish);
        void showEmptyDishError();
        void saveSucceed(Dish dish);
    }

    interface Presenter extends BasePresenter<View>{
        void saveDish(String name, String description);
        void loadDish();
    }

}
