package com.example.blood.view.resultheartrate;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.HeartRateStatus;
import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class ResultHeartRateViewModel extends ViewModel {

    public List<HeartRateStatus> initDataStatus(){

        List<HeartRateStatus> data = new ArrayList<>();
        data.add(new HeartRateStatus(0, "#41ACE9"));
        data.add(new HeartRateStatus(1, "#00C57E"));
        data.add(new HeartRateStatus(2, "#FB5555"));
        return data;
    }

    public HeartRateStatus checkTitleStateHeartRate(int bpm){
        String title;
        int titleColor;
        int imgState;

        if(bpm <= 60 ){
            title = "Nhịp tim thấp";
            titleColor = R.color.Low;
            imgState = R.drawable.low_heart_rate;
        } else if (bpm <= 100) {
            title = "Nhịp tim bình thường";
            titleColor = R.color.Normal;
            imgState = R.drawable.heart_normal;
        } else {
            title = "Nhịp tim cao";
            titleColor = R.color.bp_danger;
            imgState = R.drawable.diabetes_heart_rate;
        }

        return new HeartRateStatus(title, titleColor, imgState);
    }


    public List<InfoDetail> initDataDetail(){

        List<InfoDetail> data = new ArrayList<>();

        data.add(new InfoDetail(
                "Bạn cần biết gì về\nnhịp tim của mình?",
                "Ngay cả khi bạn không phải là vận động viên, hiểu rõ về nhịp tim cũng giúp bạn theo dõi mức độ thể chất — và thậm chí có thể giúp bạn phát hiện sớm các vấn đề sức khỏe.\n" +
                        "Nhịp tim (pulse) là số lần tim đập trong một phút. Nhịp tim bình thường thay đổi tùy từng người. Việc biết được nhịp tim của bản thân là một thước đo quan trọng để đánh giá sức khỏe tim mạch.\n" +
                        "Khi bạn già đi, nhịp tim và độ đều đặn có thể thay đổi — và những thay đổi này đôi khi cho thấy các bệnh lý về tim hoặc những vấn đề sức khỏe khác cần được kiểm tra."
        ));

        data.add(new InfoDetail(
                "Các yếu tố khác ảnh hưởng đến nhịp tim",
                " - Nhiệt độ không khí: Khi thời tiết nóng hoặc độ ẩm cao, tim cần bơm nhiều máu hơn, nên nhịp tim có thể tăng nhẹ (khoảng 5–10 nhịp mỗi phút).\n" +
                        " - Tư thế cơ thể: Khi nghỉ ngơi, ngồi hoặc đứng, nhịp tim thường không thay đổi nhiều. Khi bạn vừa đứng lên, nhịp tim có thể tăng nhẹ trong 15–20 giây đầu, sau đó sẽ ổn định lại.\n" +
                        " - Cảm xúc: Căng thẳng, lo lắng, buồn hoặc quá vui đều có thể làm tăng nhịp tim.\n" +
                        " - Cân nặng: Cân nặng thường không làm thay đổi nhịp tim. Tuy nhiên, nếu bạn bị béo phì, nhịp tim lúc nghỉ có thể cao hơn bình thường nhưng hiếm khi vượt quá 100.\n" +
                        " - Thuốc đang sử dụng: Thuốc chẹn beta (beta blockers) giúp làm chậm nhịp tim, trong khi dùng quá nhiều thuốc tuyến giáp có thể làm tăng nhịp tim."
        ));

        return data;
    }


}
