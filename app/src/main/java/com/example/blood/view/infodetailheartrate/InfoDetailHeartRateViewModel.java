package com.example.blood.view.infodetailheartrate;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailHeartRateViewModel extends ViewModel {

    private List<InfoDetail> data;

    public List<InfoDetail> initData(){
        data = new ArrayList<>();
        data.add(new InfoDetail("Bạn cần biết gì về nhịp tim (Pulse)?",
                "Ngay cả khi bạn không phải là vận động viên, việc hiểu rõ nhịp tim của mình có thể giúp bạn theo dõi mức độ thể chất và thậm chí phát hiện sớm các vấn đề sức khỏe.\n" +
                        "Nhịp tim, hay còn gọi là pulse, là số lần tim bạn đập trong một phút. Nhịp tim bình thường khác nhau tùy từng người. Việc biết nhịp tim của bản thân là một chỉ số quan trọng để đánh giá sức khỏe tim mạch.\n" +
                        "Khi bạn già đi, sự thay đổi về tốc độ và tính đều đặn của nhịp tim có thể báo hiệu các bệnh lý về tim hoặc những vấn đề sức khỏe khác cần được chú ý."));

        data.add(new InfoDetail("Các yếu tố ảnh hưởng đến nhịp tim",
                " - Nhiệt độ môi trường: Khi thời tiết nóng ẩm, tim sẽ bơm máu nhiều hơn, khiến nhịp tim tăng nhẹ, nhưng thường chỉ tăng khoảng 5–10 nhịp/phút.\n" +
                        " - Tư thế cơ thể: Khi nghỉ ngơi, ngồi hoặc đứng, nhịp tim thường tương tự nhau. Khi bạn đứng dậy trong 15–20 giây đầu, nhịp tim có thể tăng nhẹ nhưng sẽ ổn định lại sau vài phút.\n" +
                        " - Cảm xúc: Căng thẳng, lo lắng, vui mừng hoặc buồn bã đều có thể làm tăng nhịp tim.\n" +
                        " - Kích thước cơ thể: Thông thường, kích thước cơ thể không ảnh hưởng nhiều đến nhịp tim. Người béo phì có thể có nhịp tim khi nghỉ cao hơn bình thường nhưng hiếm khi vượt quá 100.\n" +
                        " - Thuốc: Thuốc chẹn beta (beta blockers) có thể làm chậm nhịp tim, trong khi dùng quá nhiều thuốc tuyến giáp lại có thể làm tăng nhịp tim."));

        return data;
    }

}
