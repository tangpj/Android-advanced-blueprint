package com.tangpj.order.ui.addedit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.tangpj.order.R;
import com.tangpj.order.pojo.Dish;

import java.util.Map;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

import static com.tangpj.order.di.CookModules.SP_COOK;

public class AddEditDishFragment extends DaggerFragment implements  AddEditDishContract.View{

    public static final String EDIT_DISH_ID = "edit_dish_id";

    private EditText etDish;
    private EditText etDescription;
    private Button btSummit;

    @Inject
    SharedPreferences sp;

    @Inject
    Map<String, Boolean> menus;

    @Inject
    Gson gson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_dish, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        etDish = view.findViewById(R.id.et_dish);
        etDescription = view.findViewById(R.id.et_dish_description);
        btSummit = view.findViewById(R.id.bt_summit);
        btSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                summit(v);
            }
        });
    }

    public void summit(View view){
        menus.put(etDish.getText().toString(), false);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SP_COOK, gson.toJson(menus)).apply();
    }

    @Override
    public void showDish(Dish dish) {
        etDish.setText(dish.getName());
        etDescription.setText(dish.getDescription());
    }

    @Override
    public void showEmptyDishError() {
        Snackbar.make(etDish, R.string.empty_dish_message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(AddEditDishContract.Presenter presenter) {

    }
}
