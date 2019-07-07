package com.example.th_fragment_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentA extends Fragment {

    public static final String TAG_A = "FragmentA";
    public static final String FRAG_A = "frag.a";
    private FragmentListener listener;


    private EditText edtInput;
    private Button btnOk;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (FragmentListener) context;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        edtInput = v.findViewById(R.id.edt_input_a);
        btnOk = v.findViewById(R.id.btn_ok_a);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if(bundle!=null){
//            edtInput.setText(bundle.getString(MainActivity.INPUT_VALUE));
            if(bundle.getString(FragmentB.FRAG_B)!=null){
                String text = bundle.getString(FragmentB.FRAG_B);
                edtInput.setText(text);
                Log.i("edtInput from frag s b ",""+text);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle bundle = getArguments();
//        if(bundle!=null){
////            edtInput.setText(bundle.getString(MainActivity.INPUT_VALUE));
//            if(bundle.getString(FragmentB.FRAG_B)!=null){
//                edtInput.setText(bundle.getString(FragmentB.FRAG_B));
//                Log.i("edtInput from frag b ",""+bundle.getString(FragmentB.FRAG_B));
//            }
//        }
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textA = edtInput.getText().toString();
                if(!textA.isEmpty()){
                    bundle.putString(FRAG_A,textA);
                    listener.setArgs(bundle);
                    listener.replaceFragmentB();
                }


            }
        });
//        initViews();
    }

    private void initViews() {
        Bundle bundle = new Bundle();
        if(bundle!=null){
            if(bundle.getString(FragmentA.FRAG_A)!=null){
                edtInput.setText(bundle.getString(FragmentA.FRAG_A));
            }
        }
    }
}
