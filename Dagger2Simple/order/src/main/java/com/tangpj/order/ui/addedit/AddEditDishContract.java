package com.tangpj.order.ui.addedit;

import com.tangpj.order.BasePresenter;
import com.tangpj.order.BaseView;
import com.tangpj.order.pojo.Dish;

public interface AddEditDishContract {

    interface View extends BaseView<Presenter>{
        void showDish(Dish dish);
        void showEmptyDishError();
    }

    interface Presenter extends BasePresenter{
        void saveDish(String name, String description);
        void loadDish();
    }

}
