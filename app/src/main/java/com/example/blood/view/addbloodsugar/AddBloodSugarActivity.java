package com.example.blood.view.addbloodsugar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityAddBloodSugarBinding;
import com.example.blood.databinding.ActivityResultBloodSugarBinding;
import com.example.blood.popup.FunctionPopup;
import com.example.blood.view.Utils;
import com.example.blood.view.adapter.SugarAdapter;
import com.example.blood.view.base.BaseActivity;
import com.example.blood.view.resultsugar.ResultSugarActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Calendar;

public class AddBloodSugarActivity extends BaseActivity<ActivityAddBloodSugarBinding> {

    private SugarAdapter adapter;
    private AddBloodSugarViewModel viewModel;
    private Calendar calendar;
    private LocalDateTime localDateTime;
    private int year, month, day;
    private long hour, minute, selectionLastDate;

    @Override
    protected ActivityAddBloodSugarBinding inflateBinding(LayoutInflater inflater) {
        return ActivityAddBloodSugarBinding.inflate(getLayoutInflater());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void initializeComponent() {
        adapter = new SugarAdapter();
        binding.lstStatusSugar.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(AddBloodSugarViewModel.class);

        calendar = Calendar.getInstance();
        localDateTime = LocalDateTime.now();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        day = localDateTime.getDayOfMonth();
        month = localDateTime.getMonthValue();
        year = localDateTime.getYear();

        selectionLastDate = MaterialDatePicker.todayInUtcMilliseconds();

    }


    @Override
    public void initializeEvent() {
        binding.btnCalendar.setOnClickListener(v -> {
            showDatePicker();
        });

        binding.btnClock.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                showTimePicker();
            }
        });

        binding.btnMeasured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionMenu();
            }
        });

        binding.btnSave.setOnClickListener(v -> {
            insertSugarConcentration();
            insertNote();
            viewModel.insertDataBloodSugar(this);

        });

        viewModel.getPreMutableLiveData().observe(this, id -> {
            if (id > 0) {
                Toast.makeText(this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
                viewModel.insertId(id);
                Gson gson = new Gson();
                String keySugar = gson.toJson(viewModel.getBloodSugarEntity());
                Intent intent = new Intent(this, ResultSugarActivity.class);
                intent.putExtra(Utils.KEY_SAVE_SUGAR, keySugar);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Lưu thông tin thất bại", Toast.LENGTH_SHORT).show();
            }

        });

        binding.btnBack.setOnClickListener(v -> finish());

    }

    @Override
    public void initializeData() {
        adapter.setData(viewModel.initData());
    }

    @Override
    public void bindView() {
        String date = day + "/" + month + "/" + year;
        binding.txtCalendar.setText(date);

        String time = hour + ":" + minute;
        binding.txtTime.setText(time);
    }


    private void showDatePicker() {
        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selected Date")
                .setSelection(selectionLastDate)
                .build();

        datePicker.show(getSupportFragmentManager(), "DATE_PICKER");

        datePicker.addOnPositiveButtonClickListener(selection -> {
            selectionLastDate = selection;

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
            viewModel.insertDate(selectedDate);
        });
    }

    private void showTimePicker() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (TimePicker view, int hourOfDay, int minuteSelected) -> {

                    hour = hourOfDay;
                    minute = minuteSelected;

                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteSelected);

                    binding.txtTime.setText(selectedTime);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        viewModel.insertTime(selectedTime);
                    }
                },
                (int) hour, (int) minute, true
        );

        timePickerDialog.show();
    }

    private void selectionMenu() {
        FunctionPopup functionPopup = new FunctionPopup(this);
        functionPopup.onCreate(binding.btnMeasured);
        functionPopup.showPopup(binding.btnMeasured);
        functionPopup.setListener(selected -> {
            binding.btnMeasured.setText(selected);
            viewModel.insertMeasured(selected);
        });

    }

    private void insertNote() {
        String note = binding.edtNote.getText().toString();
        viewModel.insertNote(note);
    }

    private void insertSugarConcentration() {
        String getSugarConcentration = binding.edtSurgarConcentration.getText().toString();
        float result = Float.parseFloat(getSugarConcentration);
        viewModel.insertSugarConcenttration(result);
    }


}
