package com.example.prateek;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prateek.Miniproject.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class Changepassword extends Fragment {


    public Changepassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_changepassword, container, false);
    }

}
