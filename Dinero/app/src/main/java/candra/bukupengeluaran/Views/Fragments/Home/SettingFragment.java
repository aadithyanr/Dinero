package com.trinet.dinero.Views.Fragments.Home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trinet.dinero.R;
import com.trinet.dinero.Supports.Utils.FragmentAdapter;
import com.trinet.dinero.Views.Fragments.Setting.SettingGeneralFragment;
import com.trinet.dinero.Views.Fragments.Setting.SettingThemeFragment;
import com.trinet.dinero.databinding.FragmentSettingBinding;

/**
 * Created by Aadithyan Rajeshon 06/10/2017.
 */

public class SettingFragment extends Fragment {

    FragmentSettingBinding content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        content = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);
        setView();
        return content.getRoot();
    }

    void setView(){
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager(),true);
        adapter.addFragment(new SettingGeneralFragment(), "General");
        adapter.addFragment(new SettingThemeFragment(), "Theme");
        content.pager.setAdapter(adapter);
        content.tabs.post(new Runnable() {
            @Override
            public void run() {
                content.tabs.setupWithViewPager(content.pager);
            }
        });
    }
}
