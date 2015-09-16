package com.pmapps.grefragmentactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tarzan on 9/15/2015.
 */
public class FragmentSerialNumber extends Fragment{
    TextView tvSerialNumber;
    OnSerialNumberChangedListener onSerialNumberChangedListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_serial_number_layout,container,false);
        tvSerialNumber = (TextView)view.findViewById(R.id.TVSerialNumber);
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onSerialNumberChangedListener = (OnSerialNumberChangedListener) activity;
        }
        catch(Exception ex)
        {
            System.out.println("" + ex.toString());
        }
    }

    public String GetTextFromSerialNumber() {
        return tvSerialNumber.getText().toString();
    }

    public void updateTVSerialNumber(String tVnumber) {
        tvSerialNumber.setText(tVnumber);
    }

    public interface OnSerialNumberChangedListener{
        String GetTextFromTVSerialNumber();
    }
}
