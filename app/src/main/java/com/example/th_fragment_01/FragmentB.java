package com.example.th_fragment_01;

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

import static com.example.th_fragment_01.FragmentA.FRAG_A;


public class FragmentB extends Fragment {

    public static final String TAG_B = "FragmentB";
    public static final String FRAG_B = "frag.b";
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
        View v = inflater.inflate(R.layout.fragment_b,container,false);
        edtInput = v.findViewById(R.id.edt_input_b);
        btnOk = v.findViewById(R.id.btn_ok_b);




        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();

        if(bundle!=null){
//            edtInput.setText(bundle.getString(MainActivity.INPUT_VALUE));
            if(bundle.getString(FragmentA.FRAG_A)!=null){
                int m = 10;
                String text = bundle.getString(FragmentA.FRAG_A);
                edtInput.setText(text);
                Log.i("edtInput from frag s a ",""+text);
            }

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle bundle = getArguments();
//        if(bundle!=null){
////            edtInput.setText(bundle.getString(MainActivity.INPUT_VALUE));
//            if(bundle.getString(FragmentA.FRAG_A)!=null){
//                edtInput.setText(bundle.getString(FragmentA.FRAG_A));
//                Log.i("edtInput from frag a ",""+bundle.getString(FragmentA.FRAG_A));
//            }
//
//        }
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textB = edtInput.getText().toString();
                if(!textB.isEmpty()){
                    bundle.putString(FRAG_B,textB);
                    listener.setArgs(bundle);
                    listener.replaceFragmentA();
                }



            }
        });
//        initViews();
    }

    private void initViews() {
        Bundle bundle = new Bundle();
        if(bundle!=null){
            if(bundle.getString(FragmentB.FRAG_B)!=null){
                edtInput.setText(bundle.getString(FragmentB.FRAG_B));
            }
        }

    }
}
