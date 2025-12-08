package com.example.blood.view.infodetailweightbmi;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailWeightBmiViewModel extends ViewModel {

    private List<InfoDetail> data ;

    public List<InfoDetail> initData(){
        data = new ArrayList<>();
        data.add(new InfoDetail("Giới thiệu",
                "BMI là chỉ số đo mức độ gầy hay béo của một người dựa trên chiều cao và cân nặng, được sử dụng để ước lượng tổng lượng mô trong cơ thể. Đây là chỉ số phổ biến nhằm đánh giá một người có đang ở mức cân nặng khỏe mạnh so với chiều cao của họ hay không."
                        + " Cụ thể, giá trị BMI thu được sẽ được dùng để phân loại một người thuộc nhóm gầy, bình thường, thừa cân hay béo phì tùy theo khoảng giá trị tương ứng. Các ngưỡng phân loại BMI có thể thay đổi tùy theo khu vực và độ tuổi, và đôi khi được chia nhỏ hơn thành các mức như ‘gầy nghiêm trọng’ hoặc ‘béo phì rất nặng’."
                        + " Việc thừa cân hoặc thiếu cân đều có thể ảnh hưởng đáng kể đến sức khỏe, vì vậy dù BMI không phải là thước đo hoàn hảo, nó vẫn là chỉ số hữu ích để xác định xem bạn có cần kiểm tra sức khỏe thêm hoặc có hành động điều chỉnh hay không."
                        + " Bạn có thể tham khảo bảng phân loại BMI bên dưới để biết rõ các mức được sử dụng trong công cụ tính này."));

        return data;
    }


}
