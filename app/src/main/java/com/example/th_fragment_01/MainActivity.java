package com.example.th_fragment_01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    public static final String INPUT_VALUE = "input.value";
    FragmentA fragmentA = new FragmentA();
    FragmentB fragmentB = new FragmentB();
    TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tvMain = findViewById(R.id.tv_main);

        Bundle bundle = new Bundle();
        bundle.putString(INPUT_VALUE,"Please input text");
        fragmentA.setArguments(bundle);
        fragmentB.setArguments(bundle);




        findViewById(R.id.btn_add_fragment_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(fragmentA);
            }
        });

        findViewById(R.id.btn_add_fragment_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(fragmentB);
            }
        });

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.ln_main,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void replaceFragmentA() {
        replaceFragment(fragmentA);
    }

    @Override
    public void replaceFragmentB() {
        replaceFragment(fragmentB);
    }

    @Override
    public void setArgs(Bundle bundle) {
        fragmentA.setArguments(bundle);
        fragmentB.setArguments(bundle);
    }

//    @Override
//    public void toDataFromB(Bundle bundle) {
//        fragmentB.setArguments(bundle);
//    }


}
