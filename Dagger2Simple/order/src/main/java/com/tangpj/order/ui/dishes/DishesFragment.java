package com.tangpj.order.ui.dishes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tangpj.order.R;
import com.tangpj.order.di.FragmentScoped;
import com.tangpj.order.pojo.Dish;
import com.tangpj.order.ui.addedit.AddEditDishActivity;
import com.tangpj.order.ui.addedit.AddEditDishFragment;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class DishesFragment extends DaggerFragment implements DishesContract.View{

    RecyclerView rvDishes;

    @Inject
    DishesAdapter dishesAdapter;

    @Inject
    RecyclerView.LayoutManager layoutManager;

    @Inject
    DishesContract.Presenter mPresenter;

    @Inject
    public DishesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dishes, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    public void initView(View view){
        rvDishes = view.findViewById(R.id.rv_dishes);
        rvDishes.setAdapter(dishesAdapter);
        rvDishes.setLayoutManager(layoutManager);
        registerForContextMenu(rvDishes);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.menu_dishes_item, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Dish dish = dishesAdapter.getLongClickDish();
        if (dish == null) return false;
        switch (item.getItemId()){
            case R.id.action_edit:
                Intent intent = new Intent(getActivity(), AddEditDishActivity.class);
                intent.putExtra(AddEditDishFragment.EDIT_DISH_ID, dish.getId());
                startActivity(intent);
                break;
            case R.id.action_delete:
                if (mPresenter.deleteDish(dish.getId())){
                    dishesAdapter.removedDish(dish);
                }
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void showDishes(List<Dish> dishes) {
        dishesAdapter.setDishes(dishes);
    }

    public String order(){
        return mPresenter.order(dishesAdapter.getSelectMap());
    }

}
