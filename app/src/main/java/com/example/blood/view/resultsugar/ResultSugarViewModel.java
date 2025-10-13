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
        dataResult.add(new ResultSugar("Why test your blood sugar", "Blood sugar self - testing can be particularly beneficial for the elderly and those with diabetes (Type 1 or Type 2) or diabetic symptoms as it enables monitoring of blood sugar levels, preventing severe complications, and seeking treatment at an earlies stage. Additionally, it can assist in the following ways:\n" +
                "- Monitor the effect of diabets medications.\n" +
                "- Track youe progress in overall treatment.\n" +
                "- Know how orther factors, such as diet, exercise, illness and stress, affect blood sugar levels.\n" +
                "Depending on the type of diabetes and treatment plan, the timing of blood sugar measurements may vary."));

        dataResult.add(new ResultSugar("Type 1 diabetes", "Usually your doctor will suggest you test 4 to 10 times a day recommended testing time:\n" +
                "- Before you eat\n" +
                "- Before and after exercise\n" +
                "- Before you sleep\n" +
                "- At nighyt\n" +
                "- If you are sick, changing your daily routine, or talking a new medication, it is recommended to check your blood sugar more frequently."));

        dataResult.add(new ResultSugar("Type 2 diabetes", "The frequency depend on what you take treat your diabetes:\n" +
                "Insulin\n" +
                "Your doctor may ask you to check serveral time a day, depending on the type and amount of insulin you use:\n" +
                "- If you are administering daily injections, it is recommended to test your blood sugar levels before eating and before going to bed.\n" +
                "- If you are only using intermediate or long-acting insulin, it may be sufficient to test your blood sugar levels twice a day, before breakfast and dinner.\n" +
                "Non insulin medications or lifestyle changes (diet and exercise)\n" +
                "You may not be asked to test your blood sugar on a daily basis"));

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
            state = "Low";
            colorState = R.color.Low;
        } else if (concentration < 5.5) {
            state = "Normal";
            colorState = R.color.Normal;
        } else if (concentration < 7.0) {
            state = "Pre-diabetes";
            colorState = R.color.bp_elevated;
        } else {
            state = "Diabetes";
            colorState = R.color.bp_danger;
        }

        return new ResultSugar(state, colorState);
    }


}
