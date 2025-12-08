package com.example.blood.view.resultpressure;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.ResultPressure;

import java.util.ArrayList;
import java.util.List;

public class ResultPressureViewModel extends ViewModel {


    public List<ResultPressure> intiData() {
        List<ResultPressure> data = new ArrayList<>();

        data.add(new ResultPressure(
                "Giới thiệu",
                "Các rối loạn huyết áp thường không có triệu chứng rõ ràng, điều này rất nguy hiểm vì huyết áp cao hoặc thấp đều có thể dẫn đến các tình trạng đe dọa tính mạng như đau tim hoặc đột quỵ. Tuy nhiên, bạn có thể phòng ngừa hoặc điều trị sớm thông qua việc theo dõi huyết áp thường xuyên. "
                        + "Việc chẩn đoán sớm và thay đổi lối sống lành mạnh sẽ giúp bạn duy trì huyết áp ổn định và ngăn ngừa các vấn đề sức khỏe."
        ));

        data.add(new ResultPressure(
                "Huyết áp là gì?",
                "Huyết áp là lực mà máu tác động lên thành động mạch khi được bơm ra từ tim. Kiểm tra huyết áp giúp đánh giá hoạt động của tim và là một phần quan trọng trong việc kiểm tra sức khỏe tổng quát. "
                        + "Quản lý thuốc đúng cách và theo dõi huyết áp là điều rất cần thiết đối với những người bị huyết áp cao."
        ));

        data.add(new ResultPressure(
                "Chẩn đoán huyết áp cao như thế nào?",
                "Cách duy nhất để biết bạn có bị huyết áp cao hay không là kiểm tra huyết áp thường xuyên tại cơ sở y tế. "
                        + "Nếu huyết áp của bạn bình thường, bác sĩ sẽ kiểm tra trong mỗi lần khám sức khỏe định kỳ hằng năm. "
                        + "Nếu chỉ số huyết áp cao, bác sĩ có thể yêu cầu bạn tự theo dõi tại nhà nhiều lần mỗi ngày hoặc mỗi tuần."
        ));

        return data;
    }


    public ResultPressure checkBloodPressure(int sys, int dia) {
        String status;
        int img;
        int colorState;

        if (sys < 120 && dia < 60) {
            status = "Huyết áp bình thường";
            img = R.drawable.normal_blood_pressure;
            colorState = R.color.Normal;
        } else if ((sys >= 120 && sys <= 129) && (dia >= 60 && dia <= 79)) {
            status = "Huyết áp tăng nhẹ";
            img = R.drawable.elevated_blood;
            colorState = R.color.bp_elevated;
        } else if ((sys >= 130 && sys <= 139) || (dia >= 80 && dia <= 89)) {
            status = "Huyết áp cao – Giai đoạn 1";
            img = R.drawable.high_blood_stoge1;
            colorState = R.color.bp_stage1;
        } else if ((sys >= 140 && sys <= 180) || (dia >= 90 && dia <= 120)) {
            status = "Huyết áp cao – Giai đoạn 2";
            img = R.drawable.high_blood_stoge2;
            colorState = R.color.bp_stage2;
        } else if (sys > 180 || dia > 120) {
            status = "Huyết áp nguy hiểm";
            img = R.drawable.high_blood_stoge2;
            colorState = R.color.bp_danger;
        } else {
            status = "Huyết áp bình thường";
            img = R.drawable.normal_blood_pressure;
            colorState = R.color.Normal;
        }

        return new ResultPressure(status, img, colorState);
    }

}
