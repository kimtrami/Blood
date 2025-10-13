package com.example.blood.view.infodetailheartrate;

import androidx.lifecycle.ViewModel;

import com.example.blood.model.InfoDetail;

import java.util.ArrayList;
import java.util.List;

public class InfoDetailHeartRateViewModel extends ViewModel {

    private List<InfoDetail> data;

    public List<InfoDetail> initData(){
        data = new ArrayList<>();
        data.add(new InfoDetail("What should you know about your Pulse rate?","Even if you’re not an athlete, knowledge about your heart rate can help you monitor your fitness level — and it might even help you spot developing health problems.\n" +
                "Your heart rate, or pulse, is the number of times your heart beats per minute. Normal heart rate varies from person to person. Knowing yours can be an important heart-health gauge.\n" +
                "As you age, changes in the rate and regularity of your pulse can change and may signify a heart conditions or other condition that needs to be addressed." ));

        data.add(new InfoDetail("How other factors affect Pulse rate ", "Air temperature: When temperatures and the humidity soar, the heart pumps a little more blood, so your pulse rate may increase, but usually no more than five to 10 beats a minute.\n" +
                " - Body position: Resting, sitting or standing, your pulse is usually the same. Sometimes as you stand for the first 15 to 20 seconds, your pulse may go up a little bit, but after a couple of minutes it should settle down.\n" +
                " - Emotions: If you’re stressed, anxious or extraordinarily happy or sad your emotions can raise your pulse.\n" +
                " - Body size: Body size usually doesn’t change pulse. If you’re very obese, you might see a higher resting pulse than normal, but usually not more than 100.\n" +
                " - Medication use: Meds that block your adrenaline (beta blockers) tend to slow your pulse, while too much thyroid medication or too high of a dosage will raise it."));

        return data;
    }
}
