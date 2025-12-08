package com.example.blood.view.infodetailpressure;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailPressureViewModel extends ViewModel {

    private List<InfoDetail> data;

    public List<InfoDetail> initData(){
        data = new ArrayList<>();

        data.add(new InfoDetail("Giới thiệu",
                "Các rối loạn huyết áp thường không có triệu chứng rõ ràng, điều này rất nguy hiểm vì huyết áp cao hoặc thấp đều có thể dẫn đến các tình trạng đe dọa tính mạng như đau tim hoặc đột quỵ."
                        + " Tuy nhiên, bạn có thể phòng ngừa hoặc điều trị sớm bằng cách theo dõi chỉ số huyết áp thường xuyên. Việc chẩn đoán sớm và duy trì lối sống lành mạnh sẽ giúp bạn giữ huyết áp ổn định và ngăn ngừa các vấn đề sức khỏe."
        ));

        data.add(new InfoDetail("Về huyết áp",
                "Huyết áp là lực mà máu tác động lên thành động mạch khi được bơm từ tim ra."
                        + " Kiểm tra huyết áp giúp đánh giá hoạt động của tim và là một phần quan trọng trong việc kiểm tra sức khỏe tổng quát. Việc dùng thuốc đúng cách và theo dõi huyết áp đều đặn đặc biệt quan trọng đối với những người bị tăng huyết áp."
        ));

        data.add(new InfoDetail("Chẩn đoán huyết áp cao như thế nào?",
                "Cách duy nhất để biết bạn có bị huyết áp cao hay không là kiểm tra huyết áp thường xuyên từ bác sĩ hoặc cơ sở y tế."
                        + " Nếu huyết áp của bạn bình thường, bác sĩ sẽ kiểm tra tại mỗi lần khám sức khỏe hằng năm. Nếu huyết áp cao, bác sĩ có thể yêu cầu bạn tự đo huyết áp tại nhà nhiều lần mỗi ngày hoặc theo tuần."
        ));

        return data;
    }

}
