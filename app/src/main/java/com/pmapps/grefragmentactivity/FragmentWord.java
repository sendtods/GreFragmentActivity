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
public class FragmentWord extends Fragment {
    TextView tvWord;
    OnWordChangedListener onWordChangedListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_layout,container,false);
        tvWord = (TextView)view.findViewById(R.id.TVWord);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onWordChangedListener = (OnWordChangedListener) activity;
        }
        catch(Exception ex)
        {
            System.out.println("" + ex.toString());
        }
    }

    public String GetTextFromWord() {
        return tvWord.getText().toString();
    }

    public void updateTVWord(String tVnumber) {
        tvWord.setText(tVnumber);
    }

    public interface OnWordChangedListener{
        String GetTextFromTVWord();
    }
}
