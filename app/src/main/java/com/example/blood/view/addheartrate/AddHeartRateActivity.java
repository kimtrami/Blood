    package com.example.blood.view.addheartrate;

    import static android.view.View.*;

    import android.app.TimePickerDialog;
    import android.content.Intent;
    import android.os.Build;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.widget.TimePicker;
    import android.widget.Toast;

    import androidx.lifecycle.ViewModelProvider;

    import com.example.blood.databinding.ActivityAddHeartRateBinding;
    import com.example.blood.model.AddPressure;
    import com.example.blood.model.HeartRate;
    import com.example.blood.model.StatusHateRate;
    import com.example.blood.view.Utils;
    import com.example.blood.view.adapter.HeartRateAdapter;
    import com.example.blood.view.base.BaseActivity;
    import com.example.blood.view.resultheartrate.ResultHeartRateActivity;
    import com.google.android.material.datepicker.MaterialDatePicker;
    import com.google.android.material.timepicker.MaterialTimePicker;
    import com.google.android.material.timepicker.TimeFormat;
    import com.google.gson.Gson;
    import com.shawnlin.numberpicker.NumberPicker;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.List;

    public class AddHeartRateActivity extends BaseActivity<ActivityAddHeartRateBinding> {

        private HeartRateAdapter adapter;
        private HeartRateViewModel viewModel;
        private List<HeartRate> data = new ArrayList<>();
        private int bpm;
        private long selectionDate, hour, minute;
        private int year, month, day;

        @Override
        protected ActivityAddHeartRateBinding inflateBinding(LayoutInflater inflater) {
            return ActivityAddHeartRateBinding.inflate(getLayoutInflater());
        }

        @Override
        public void initializeComponent() {
            adapter = new HeartRateAdapter();
            binding.lstStatus.setAdapter(adapter);

            viewModel = new ViewModelProvider(this).get(HeartRateViewModel.class);

            Calendar calendar = Calendar.getInstance();

            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            day = calendar.get(Calendar.DAY_OF_MONTH);

            selectionDate = MaterialDatePicker.todayInUtcMilliseconds();

            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
        }


        @Override
        public void initializeEvent() {
            binding.numberPickerBpm.setOnValueChangedListener((picker, oldVal, newVal) -> {
                bpm = newVal;
                renderHeartRateStatus();
                viewModel.updateBpm(bpm);
            });

            binding.btnCalendar.setOnClickListener(v -> showDateTime());

            binding.btnClock.setOnClickListener(v -> showTimePicker());

            binding.btnBack.setOnClickListener(v -> finish());

            binding.btnSave.setOnClickListener(v -> {
                insertNote();
                viewModel.update(this);
            });

            viewModel.getPreMutableLiveData().observe(this, id -> {
                if (id > 0) {
                    Toast.makeText(this, "Save Success", Toast.LENGTH_SHORT).show();
                    viewModel.updateID(id);
                    Gson gson = new Gson();
                    String keySugar = gson.toJson(viewModel.getHeartRateEntity());
                    Intent intent = new Intent(this, ResultHeartRateActivity.class);
                    intent.putExtra(Utils.KEY_SAVE_HEART_RATE, keySugar);
                    startActivity(intent);
                    finish();
                }
            });


        }

        @Override
        public void initializeData() {
            data = viewModel.intiData();
            adapter.setData(data);
        }

        @Override
        public void bindView() {
            binding.txtCalendar.setText(day + "/" + month + "/" + year);
            binding.txtTime.setText(hour + ":" + minute);
        }


        private void showDateTime() {
            MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Selected Date")
                    .setSelection(selectionDate)
                    .build();

            datePicker.show(getSupportFragmentManager(), "DATE_PICKER");

            datePicker.addOnPositiveButtonClickListener(selection -> {
                selectionDate = selection;

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis((Long) selection);

                int yearSelected = calendar.get(Calendar.YEAR);
                int monthSelected = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                year = yearSelected;
                month = monthSelected + 1;
                day = dayOfMonth;

                String selectedDate = dayOfMonth + "/" + (monthSelected + 1) + "/" + yearSelected;

                binding.txtCalendar.setText(selectedDate);
                viewModel.updateDate(selectedDate);
            });

        }

        private void showTimePicker() {
            MaterialTimePicker timePicker =
                    new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_24H)
                            .setHour((int) hour)
                            .setMinute((int) minute)
                            .setTitleText("Selection hour")
                            .build();

            timePicker.show(getSupportFragmentManager(), "TIME_PICKER");

            timePicker.addOnPositiveButtonClickListener(view -> {
                hour = timePicker.getHour();
                minute = timePicker.getMinute();

                String selectedTime = String.format("%02d:%02d", hour, minute);

                binding.txtTime.setText(selectedTime);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    viewModel.updateTime(selectedTime);
                }
            });

        }

        private void insertNote() {
            String note = binding.edtNote.getText().toString();
            viewModel.updateNote(note);
        }

        private void renderHeartRateStatus() {
            StatusHateRate statusHateRate = viewModel.checkHeartRate(bpm);
            binding.imgHeart.setImageResource(statusHateRate.getImages());
            binding.txtStateHeartRate.setText(statusHateRate.getTitleState());
            binding.txtRestingHeartRate.setTextColor(statusHateRate.getTextColor());
            binding.txtRestingHeartRate.setText(statusHateRate.getStauts());
        }


    }
