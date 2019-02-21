package com.ducdm.nmvvm.extensions;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.ducdm.nmvvm.agents.models.INMvxBundle;
import com.ducdm.nmvvm.viewmodels.NMvxViewModel;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function2;

/**
 * Created by LapTop on 1/12/2017.
 */

public class NMvxTabLayoutBinding {

    @BindingAdapter(value = {"app:tab_selected", "app:tab_unselected", "app:tab_reselected"}, requireAll = false)
    public static void setAdapter(TabLayout tabLayout,
                                  Consumer<Integer> tabSelectedCommand,
                                  Consumer<Integer> tabUnselectedClickCommand,
                                  Consumer<Integer> tabReselectedCommand){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private boolean isFirstSelected = true;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                try {
                    if(isFirstSelected){
                        isFirstSelected = false;
                    } else {
                        tabSelectedCommand.accept(tab.getPosition());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                try {
                    tabUnselectedClickCommand.accept(tab.getPosition());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                try {
                    tabReselectedCommand.accept(tab.getPosition());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();
    }

}
