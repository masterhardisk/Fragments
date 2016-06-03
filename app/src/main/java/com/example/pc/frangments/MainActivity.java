package com.example.pc.frangments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements FragmentA.Communicator {
    int counter=0;
    FragmentA f1;
    FragmentB f2;
    FragmentHuevos f3;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        f1 = (FragmentA) manager.findFragmentById(R.id.fragment1);
        f1.setCommunicator(this);
    }



    @Override
    public void respond(String data){
        counter++;
        f2 = (FragmentB) manager.findFragmentById(R.id.fragment2);
        f2.changetext(data);


    }

    @Override
    public void con(int c) {
        if(c==100) {
            addF();
            Snackbar snackbar = Snackbar
                    .make(findViewById(R.id.main),"PERO QUE ES ESTO??",Snackbar.LENGTH_INDEFINITE)
                    .setAction("ATRAS!!!", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    remF();
                                }
                    });

        View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();
            snackbar.setCallback(new Snackbar.Callback() {
                @Override
                public void onDismissed(Snackbar snackbar, int event) {
                    super.onDismissed(snackbar, event);
                    if (event != DISMISS_EVENT_ACTION) {
                        remF();
                    }
                }
            });

        }
    }


    public void addF(){
        f3 = new FragmentHuevos();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.group,f3,"Huevos");
        transaction.commit();
    }

    public void remF(){
        FragmentHuevos f3 = (FragmentHuevos) manager.findFragmentByTag("Huevos");
        FragmentTransaction transaction = manager.beginTransaction();
        if(f3!=null){
            transaction.remove(f3);
            transaction.commit();
        }
    }
}
