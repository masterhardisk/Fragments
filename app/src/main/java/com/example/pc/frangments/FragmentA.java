package com.example.pc.frangments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pc on 02/06/2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    Button button;
    int counter=0;
    Communicator comm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm= (Communicator) getActivity();
        button= (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        if(counter==1) {
            comm.respond("has pulsado " + counter + " vez");
        }
        else{
            comm.respond("has pulsado " + counter + " veces");
        }
        if(counter ==10){
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(R.id.main),"YA LLEVAS 10 !!!",Snackbar.LENGTH_SHORT);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();
        }
        if(counter ==50){
            Snackbar snackbar = Snackbar
                    .make(getActivity().findViewById(R.id.main),"NO TIIENES VIDA, VERDAD?",Snackbar.LENGTH_INDEFINITE)
                    .setAction("NO :(", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();
        }
    }

public interface Communicator{
    public void respond(String data);
}

    public void setCommunicator (Communicator c){
        comm=c;
    }

}
