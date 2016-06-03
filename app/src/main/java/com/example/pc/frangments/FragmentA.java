package com.example.pc.frangments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by pc on 02/06/2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button= (Button) getActivity().findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {

    }
}
