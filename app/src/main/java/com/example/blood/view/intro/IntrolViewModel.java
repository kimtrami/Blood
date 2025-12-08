package com.example.blood.view.intro;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.Intro;

import java.util.ArrayList;
import java.util.List;

public class IntrolViewModel extends ViewModel {

    public List<Intro> initData() {
        ArrayList<Intro> intros = new ArrayList<>();intros.add(new Intro(R.drawable.intro1, "Công cụ theo dõi huyết áp",
                "Bạn có thể theo dõi huyết áp dễ dàng và chính xác qua các báo cáo."));

        intros.add(new Intro(R.drawable.intro2, "Biểu đồ và báo cáo sức khỏe",
                "Xem sự thay đổi sức khỏe của bạn qua từng biểu đồ trực quan."));

        intros.add(new Intro(R.drawable.intro3, "Thông tin về huyết áp",
                "Cung cấp kiến thức hữu ích về huyết áp cho bạn."));

        intros.add(new Intro(R.drawable.intro4, "Theo dõi sức khỏe tổng quan",
                "Theo dõi sức khỏe tiện lợi và dễ dàng ngay trong tầm tay bạn."));

//        data.setValue(intros);
        return intros;
    }

}
