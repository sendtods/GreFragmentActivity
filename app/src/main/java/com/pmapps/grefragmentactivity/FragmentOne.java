package com.pmapps.grefragmentactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tarzan on 8/18/2015.
 */
public class FragmentOne extends Fragment {
    TextView tvDisplay;
    OnTextChangedListener onTextChangedListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_layout,container,false);
        tvDisplay = (TextView)view.findViewById(R.id.TVDisplay);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onTextChangedListener = (OnTextChangedListener) activity;
        }
        catch(Exception ex)
        {
            System.out.println("" + ex.toString());
        }
    }

    public String GetTextFromDisplay() {
        return tvDisplay.getText().toString();
    }

    public void updateTVDisplay(String tVnumber) {
        tvDisplay.setText(tVnumber);
    }

    public interface OnTextChangedListener{
        String GetTextFromTVDisplay();
    }
}
