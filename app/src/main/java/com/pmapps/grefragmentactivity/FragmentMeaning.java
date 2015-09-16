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
 * Created by Tarzan on 9/15/2015.
 */
public class FragmentMeaning extends Fragment {
    TextView tvMeaning;
    OnMeaningChangedListener onMeaningChangedListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meaning_layout,container,false);
        tvMeaning = (TextView)view.findViewById(R.id.TVMeaning);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onMeaningChangedListener = (OnMeaningChangedListener) activity;
        }
        catch(Exception ex)
        {
            System.out.println("" + ex.toString());
        }
    }

    public String GetTextFromMeaning() {
        return tvMeaning.getText().toString();
    }

    public void updateTVMeaning(String tVnumber) {
        tvMeaning.setText(tVnumber);
    }

    public interface OnMeaningChangedListener{
        String GetTextFromTVMeaning();
    }
}
