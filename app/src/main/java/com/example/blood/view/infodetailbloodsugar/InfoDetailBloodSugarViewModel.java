package com.example.blood.view.infodetailbloodsugar;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailBloodSugarViewModel extends ViewModel {

    private List<InfoDetail> data = new ArrayList<>();

    public List<InfoDetail> initData(){

        data.add(new InfoDetail("Why test your blood sugar","Blood sugar self - testing can be particularly beneficial for the elderly and those with diabetes (Type 1 or Type 2) or diabetic symptoms as it enables monitoring of blood sugar levels, preventing severe complications, and seeking treatment at an earlies stage. Additionally, it can assist in the following ways:\n" +
                " - Monitor the effect of diabets medications.\n" +
                " - Track youe progress in overall treatment.\n" +
                " - Know how orther factors, such as diet, exercise, illness and stress, affect blood sugar levels.\n" +
                "Depending on the type of diabetes and treatment plan, the timing of blood sugar measurements may vary."));

        data.add(new InfoDetail("Type 1 diabetes", "Usually your doctor will suggest you test 4 to 10 times a day recommended testing time:\n" +
                " - Before you eat\n" +
                " - Before and after exercise\n" +
                " - Before you sleep\n" +
                " - At nighyt\n" +
                "If you are sick, changing your daily routine, or talking a new medication, it is recommended to check your blood sugar more frequently."));

        data.add(new InfoDetail("Type 2 diabetes","The frequency depend on what you take treat your diabetes:\n" +
                "Insulin\n" +
                "Your doctor may ask you to check serveral time a day, depending on the type and amount of insulin you use:\n" +
                " - If you are administering daily injections, it is recommended to test your blood sugar levels before eating and before going to bed.\n" +
                " - If you are only using intermediate or long-acting insulin, it may be sufficient to test your blood sugar levels twice a day, before breakfast and dinner.\n" +
                "Non insulin medications or lifestyle changes (diet and exercise)\n" +
                "You may not be asked to test your blood sugar on a daily basis"));


        return  data;
    }

}
