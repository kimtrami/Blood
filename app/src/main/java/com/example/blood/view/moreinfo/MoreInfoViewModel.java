package com.example.blood.view.moreinfo;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.MoreInfo;

import java.util.ArrayList;
import java.util.List;

public class MoreInfoViewModel extends ViewModel {


    public List<MoreInfo> initData() {
        List<MoreInfo> data = new ArrayList<>();data.add(new MoreInfo(R.drawable.normal_blood_pressure, "#00C57E",
                "< 120", "< 60",
                "Huyết áp bình thường", "và"));

        data.add(new MoreInfo(R.drawable.elevated_blood, "#E9D841",
                "120 - 129", "60 - 79",
                "Huyết áp tăng nhẹ", "và"));

        data.add(new MoreInfo(R.drawable.high_blood_stoge1, "#FEC415",
                "130 - 139", "80 - 89",
                "Huyết áp cao – Giai đoạn 1", "hoặc"));

        data.add(new MoreInfo(R.drawable.high_blood_stoge2, "#FA9C0F",
                "140 - 180", "90 - 120",
                "Huyết áp cao – Giai đoạn 2", "hoặc"));

        data.add(new MoreInfo(R.drawable.dangerously_high_blood, "#FB5555",
                "> 180", "> 120",
                "Huyết áp nguy hiểm", "và/hoặc"));

        return data;
    }


}

