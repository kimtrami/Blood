package com.example.blood.view.resultsugar;

import androidx.lifecycle.ViewModel;

import com.example.blood.R;
import com.example.blood.model.ResultSugar;
import com.example.blood.model.Sugar;

import java.util.ArrayList;
import java.util.List;

public class ResultSugarViewModel extends ViewModel {
    private List<ResultSugar> dataResult;
    private List<Sugar> dataSugarStatus;

    public List<ResultSugar> initDataResult() {
        dataResult = new ArrayList<>();

        dataResult.add(new ResultSugar(
                "Vì sao cần kiểm tra đường huyết?",
                "Việc tự kiểm tra đường huyết đặc biệt có lợi cho người lớn tuổi và những người mắc bệnh tiểu đường (type 1 hoặc type 2) hoặc có triệu chứng tiểu đường. "
                        + "Nó giúp theo dõi mức đường huyết, ngăn ngừa biến chứng nặng, và phát hiện sớm để điều trị kịp thời. Ngoài ra, việc kiểm tra giúp bạn:\n"
                        + "- Theo dõi hiệu quả của thuốc điều trị tiểu đường.\n"
                        + "- Theo dõi tiến trình điều trị tổng thể.\n"
                        + "- Biết được các yếu tố khác như chế độ ăn, tập luyện, bệnh tật hay căng thẳng ảnh hưởng đến đường huyết ra sao.\n"
                        + "Tùy vào loại tiểu đường và phác đồ điều trị, thời điểm kiểm tra đường huyết có thể khác nhau."
        ));

        dataResult.add(new ResultSugar(
                "Tiểu đường type 1",
                "Thông thường, bác sĩ sẽ khuyên bạn kiểm tra đường huyết 4 đến 10 lần mỗi ngày. "
                        + "Các thời điểm kiểm tra được khuyến nghị:\n"
                        + "- Trước khi ăn\n"
                        + "- Trước và sau khi tập thể dục\n"
                        + "- Trước khi ngủ\n"
                        + "- Vào ban đêm\n"
                        + "- Nếu bạn bị ốm, thay đổi thói quen sinh hoạt hoặc dùng thuốc mới, bạn nên kiểm tra đường huyết thường xuyên hơn."
        ));

        dataResult.add(new ResultSugar(
                "Tiểu đường type 2",
                "Tần suất kiểm tra tùy thuộc vào phương pháp điều trị bạn đang sử dụng:\n"
                        + "Insulin:\n"
                        + "Bác sĩ có thể yêu cầu bạn kiểm tra nhiều lần trong ngày, tùy vào loại và liều lượng insulin:\n"
                        + "- Nếu bạn tiêm insulin hằng ngày, bạn nên đo đường huyết trước bữa ăn và trước khi đi ngủ.\n"
                        + "- Nếu bạn chỉ dùng insulin tác dụng trung bình hoặc kéo dài, bạn có thể chỉ cần đo 2 lần/ngày: trước bữa sáng và trước bữa tối.\n"
                        + "Thuốc không phải insulin hoặc thay đổi lối sống (ăn uống – tập luyện):\n"
                        + "Bạn có thể không cần kiểm tra đường huyết hằng ngày."
        ));

        return dataResult;
    }


    public List<Sugar> initDataSugarStatus() {
        dataSugarStatus = new ArrayList<>();

        dataSugarStatus.add(new Sugar("#41ACE9"));
        dataSugarStatus.add(new Sugar("#00C57E"));
        dataSugarStatus.add(new Sugar("#E9D841"));
        dataSugarStatus.add(new Sugar("#FB5555"));

        return dataSugarStatus;
    }

    public ResultSugar checkConcentration(float concentration) {
        String state;
        int colorState;

        if (concentration < 4.0) {
            state = "Đường huyết thấp";
            colorState = R.color.Low;
        } else if (concentration < 5.5) {
            state = "Đường huyết bình thường";
            colorState = R.color.Normal;
        } else if (concentration < 7.0) {
            state = "Tiền tiểu đường";
            colorState = R.color.bp_elevated;
        } else {
            state = "Tiểu đường";
            colorState = R.color.bp_danger;
        }


        return new ResultSugar(state, colorState);
    }


}
