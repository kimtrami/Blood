package com.example.blood.view.infodetailbloodsugar;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailBloodSugarViewModel extends ViewModel {

    private List<InfoDetail> data = new ArrayList<>();

    public List<InfoDetail> initData(){

        data.add(new InfoDetail("Vì sao cần kiểm tra đường huyết?",
                "Việc tự kiểm tra đường huyết đặc biệt hữu ích cho người lớn tuổi và những người mắc bệnh tiểu đường (Type 1 hoặc Type 2) hoặc có triệu chứng tiểu đường, vì nó giúp theo dõi mức đường huyết, ngăn ngừa biến chứng nặng và điều trị kịp thời ở giai đoạn sớm. Ngoài ra, việc kiểm tra còn giúp:\n" +
                        " - Theo dõi hiệu quả của thuốc điều trị tiểu đường.\n" +
                        " - Theo dõi tiến trình điều trị tổng thể.\n" +
                        " - Biết được các yếu tố khác như chế độ ăn, tập luyện, bệnh tật hoặc căng thẳng ảnh hưởng đến đường huyết như thế nào.\n" +
                        "Tùy vào loại tiểu đường và phác đồ điều trị, thời điểm đo đường huyết có thể khác nhau."));

        data.add(new InfoDetail("Tiểu đường Type 1",
                "Thông thường, bác sĩ sẽ khuyên bạn kiểm tra đường huyết 4 đến 10 lần mỗi ngày. Thời điểm khuyến nghị:\n" +
                        " - Trước khi ăn\n" +
                        " - Trước và sau khi tập luyện\n" +
                        " - Trước khi đi ngủ\n" +
                        " - Vào ban đêm\n" +
                        "Nếu bạn bị ốm, thay đổi thói quen sinh hoạt hoặc dùng thuốc mới, bạn nên kiểm tra đường huyết thường xuyên hơn."));

        data.add(new InfoDetail("Tiểu đường Type 2",
                "Tần suất kiểm tra phụ thuộc vào phương pháp điều trị:\n" +
                        "Insulin\n" +
                        "Bác sĩ có thể yêu cầu bạn kiểm tra nhiều lần mỗi ngày, tùy vào loại và liều insulin bạn sử dụng:\n" +
                        " - Nếu bạn tiêm insulin hằng ngày, nên đo đường huyết trước khi ăn và trước khi ngủ.\n" +
                        " - Nếu bạn chỉ dùng insulin tác dụng trung bình hoặc dài, bạn có thể chỉ cần đo 2 lần mỗi ngày: trước bữa sáng và trước bữa tối.\n" +
                        "Thuốc không chứa insulin hoặc thay đổi lối sống (ăn uống, tập luyện)\n" +
                        "Bạn có thể không cần kiểm tra đường huyết mỗi ngày."));

        return data;
    }


}
