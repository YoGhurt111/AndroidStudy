package com.shu.navigationbar.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shu.navigationbar.R;
import com.shu.navigationbar.fragment.HelpFragment;
import com.shu.navigationbar.fragment.MessageFragment;
import com.shu.navigationbar.fragment.MyFragment;
import com.shu.navigationbar.fragment.ServiceFragment;
import com.shu.navigationbar.fragment.TaskFragment;

import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup navigationBar;
    private ServiceFragment serviceFragment;
    private HelpFragment helpFragment;
    private MessageFragment messageFragment;
    private TaskFragment taskFragment;
    private MyFragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化Fragment并设置首页为serviceFragment
        initFragment(0);
        //主要为初始化导航栏
        initView();

    }


    public void initView(){
        navigationBar = (RadioGroup)findViewById(R.id.navigation_bar);
        navigationBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.service_rb:
                        initFragment(0);
                        break;
                    case R.id.help_rb:
                        initFragment(1);
                        break;
                    case R.id.task_rb:
                        initFragment(2);
                        break;
                    case R.id.message_rb:
                        initFragment(3);
                        break;
                    case R.id.my_rb:
                        initFragment(4);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    /** 各个fragment的index说明:
     * 0 serviceFragment
     * 1 helpFragment
     * 2 taskFragment
     * 3 messageFragment
     * 4 myFragment
     * **/
    public void initFragment(int index){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index){
            case 0:
                if (serviceFragment == null){
                    serviceFragment = new ServiceFragment();
                    fragmentTransaction.add(R.id.fl_content, serviceFragment);
                }
                else{
                    fragmentTransaction.show(serviceFragment);
                }
                break;
            case 1:
                if (helpFragment == null){
                    helpFragment = new HelpFragment();
                    fragmentTransaction.add(R.id.fl_content, helpFragment);
                }
                else{
                    fragmentTransaction.show(helpFragment);
                }
                break;
            case 2:
                if (taskFragment == null){
                    taskFragment = new TaskFragment();
                    fragmentTransaction.add(R.id.fl_content, taskFragment);
                }
                else{
                    fragmentTransaction.show(taskFragment);
                }
                break;
            case 3:
                if (messageFragment == null){
                    messageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.fl_content, messageFragment);
                }
                else{
                    fragmentTransaction.show(messageFragment);
                }
                break;
            case 4:
                if (myFragment == null){
                    myFragment = new MyFragment();
                    fragmentTransaction.add(R.id.fl_content, myFragment);
                }
                else{
                    fragmentTransaction.show(myFragment);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction){
        if (helpFragment != null){
            transaction.hide(helpFragment);
        }
        if (messageFragment != null){
            transaction.hide(messageFragment);
        }
        if (myFragment != null){
            transaction.hide(myFragment);
        }
        if (serviceFragment != null){
            transaction.hide(serviceFragment);
        }
        if (taskFragment != null){
            transaction.hide(taskFragment);
        }
    }

}
