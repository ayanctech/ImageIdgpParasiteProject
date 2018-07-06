package com.actech.protozoan_parasite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flipboard.bottomsheet.commons.BottomSheetFragment;

/**
 * Created by ACTECH on 6/27/2018.
 */

public class MyFragment extends BottomSheetFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_sheet_layout, container, false);
    }
}