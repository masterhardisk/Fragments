package com.example.pc.frangments;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data){
        FragmentManager manager=getFragmentManager();
        FragmentB f2 = (FragmentB) manager.findFragmentById(R.id.fragment2);
        f2.changetext(data);
    }
}
