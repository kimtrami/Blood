package com.example.blood.view.editbloodsugar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.example.blood.databinding.ActivityEditBloodSugarBinding;
import com.example.blood.databloodsugar.BloodSugarEntity;
import com.example.blood.model.Sugar;
import com.example.blood.popup.FunctionPopup;
import com.example.blood.view.adapter.EditBloodSugarAdapter;
import com.example.blood.view.base.BaseActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EditBloodSugarActivity extends BaseActivity<ActivityEditBloodSugarBinding> {

    private BloodSugarEntity entity;
    private EditBloodSugarAdapter adapter;
    private EditBloodSugarViewModel viewModel;
    private Calendar calendar;
    private LocalDateTime localDateTime;
    private int year, month, day;
    private long hour, minute, selectionLastDate;

    @Override
    protected ActivityEditBloodSugarBinding inflateBinding(LayoutInflater inflater) {
        return ActivityEditBloodSugarBinding.inflate(getLayoutInflater()) ;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void initializeComponent() {
        adapter = new EditBloodSugarAdapter();
        binding.lstStatusSugar.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(EditBloodSugarViewModel.class);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key1");
        Gson gson = new Gson();
        entity = gson.fromJson(key, BloodSugarEntity.class);
        viewModel.setBloodSugarEntity(entity);

        calendar = Calendar.getInstance();
        localDateTime = LocalDateTime.now();

        selectionLastDate = MaterialDatePicker.todayInUtcMilliseconds();

    }

    @Override
    public void initializeEvent() {

        binding.btnBack.setOnClickListener(v -> finish());

        binding.btnClock.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                showTimePicker();
            }
        });

        binding.btnCalendar.setOnClickListener(v -> showDatePicker());

        binding.btnMeasured.setOnClickListener(v -> selectionMenu());

        binding.btnSave.setOnClickListener(v -> {
            insertSugarConcentration();
            insertNote();
            viewModel.updateDataBloodSugar(this);
            Toast.makeText(this, "Update success", Toast.LENGTH_SHORT).show();
            finish();

        });

    }

    @Override
    public void initializeData() {
        List<Sugar> data = viewModel.initData();
        adapter.setData(data);
    }

    @Override
    public void bindView() {

        binding.edtSurgarConcentration.setText(String.valueOf(entity.getSugarConcenttration()));
        binding.btnMeasured.setText(entity.getMeasured());
        binding.edtNote.setText(entity.getNote());

        binding.txtCalendar.setText(entity.getDate());

        long timestamp = entity.getTime();
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        binding.txtTime.setText(sdf.format(date));
    }

    private void showDatePicker() {
        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.
                datePicker().setTitleText("selection date")
                .setSelection(selectionLastDate)
                .build();

        datePicker.show(getSupportFragmentManager(), "abc");

        datePicker.addOnPositiveButtonClickListener(selection -> {
            calendar.setTimeInMillis(selection);

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


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showTimePicker() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (TimePicker view, int hourOfDay, int minuteSelected) -> {

                    hour = hourOfDay;
                    minute = minuteSelected;

                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteSelected);

                    binding.txtTime.setText(selectedTime);
                    viewModel.insertTime(selectedTime);
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
