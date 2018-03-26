package com.example.prateek.Miniproject;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Frag1 extends Fragment {
    EditText editText1;
    EditText editText2;
    Button button1;
    TextView txt;
    Spinner sp;
    EditText un;
    String[] select;
    int sp_position;
    String selected;
    FirebaseAuth mAuth;
    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_frag1, container, false);
        txt = (TextView)v.findViewById(R.id.forget);
        editText1 =(EditText)v.findViewById(R.id.username);
        editText2= (EditText)v.findViewById(R.id.password);
        button1 = v.findViewById(R.id.loginButton);
        sp = (Spinner)v.findViewById(R.id.sp);
        un= (EditText)v.findViewById(R.id.username);
       // String myString = "Country";
        select = getResources().getStringArray(R.array.name);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(),android. R.layout.simple_spinner_dropdown_item,select);
       // sp_position =ad.getPosition(myString);

        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0)
                {
                    un.setHint("First select your field");
                }
                else
                    {
                    String str = (String) sp.getItemAtPosition(i);
                    un.setHint(str+"name");
                        Toast.makeText(getContext(),str+"name", Toast.LENGTH_LONG);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(),Otp.class);
                startActivity(intent);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(editText1.getText().toString(),editText2.getText().toString());
            }

            private void login(String abc, String Pass) {
                if (abc.equals("admin")&&Pass.equals("12345"))
                {
                    Intent intent = new Intent(getActivity(),ownerActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getActivity(),"Not a valid user",Toast.LENGTH_SHORT).show();
                }
            }
        });
        // code here
        return v;
    }


}
