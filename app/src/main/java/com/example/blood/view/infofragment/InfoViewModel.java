package com.example.blood.view.infofragment;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.Infomation;

import java.util.ArrayList;
import java.util.List;

public class InfoViewModel extends ViewModel {
    //MutableLiveData

    public List<Infomation> initData() {
        ArrayList<Infomation> theInfomation = new ArrayList<>();
        theInfomation.add(new Infomation("Về huyết áp", R.drawable.img_blood_pressure, "#0AB678"));
        theInfomation.add(new Infomation("Về đường huyết", R.drawable.sugar_info, "#8296FF"));
        theInfomation.add(new Infomation("Về nhịp tim", R.drawable.heart_info, "#FDE400"));
        theInfomation.add(new Infomation("Về cân nặng & BMI", R.drawable.img_bmi, "#F7B11E"));
        // dong bo, postValue: bat dong bo
        return theInfomation;
    }
}
