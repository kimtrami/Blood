package com.example.blood.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import com.example.blood.databinding.PopupSelectionBloodSugraBinding;
import com.example.blood.view.adapter.OnItemFunctionPopup;
import com.example.blood.view.adapter.PopupBloodSugarAdapter;

import java.util.ArrayList;
import java.util.List;

public class FunctionPopup extends PopupWindow implements OnItemFunctionPopup {

    private PopupSelectionBloodSugraBinding binding;
    private Context mContext;
    private PopupBloodSugarAdapter adapter;
    private List<String> data ;
    private OnItemFunctionPopup listener;

    public FunctionPopup(Context context) {
        mContext = context;
    }

    public void setListener(OnItemFunctionPopup listener) {
        this.listener = listener;
    }


    public void onCreate(View anchor){
        binding = PopupSelectionBloodSugraBinding.inflate(LayoutInflater.from(mContext));
        setContentView(binding.getRoot());


        adapter = new PopupBloodSugarAdapter();
        adapter.setItemFunctionPopup(this);
        binding.lstMeals.setAdapter(adapter);
        initData();
        adapter.setData(data);

        setWidth(anchor.getWidth());
        setHeight(android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

        setFocusable(true);

    }


    public void showPopup(View view){
        showAsDropDown(view, 0, -50);
    }

    private void initData(){
        data = new ArrayList<>();
        data.add("Before Breakfast");
        data.add("After Breakfast");

        data.add("Before Lunch");
        data.add("After Lunch");

        data.add("Before Dinner");
        data.add("After Dinner");
    }


    @Override
    public void position( String selected) {
        if (listener != null) {
            listener.position(selected);
        }

        dismiss();
    }
}
