package com.cesarbassani.myapplication.views;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cesarbassani.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePicker.OnTimeChangedListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        this.mViewHolder.mButtonDatePicker = findViewById(R.id.button_datepicker);
        this.mViewHolder.mButtonSetTime = findViewById(R.id.button_set_time);
        this.mViewHolder.mButtonGetTime = findViewById(R.id.button_get_time);
        this.mViewHolder.mTimePicker = findViewById(R.id.timepicker);

        this.setListener();
    }

    private void setListener() {
        this.mViewHolder.mButtonDatePicker.setOnClickListener(this);
        this.mViewHolder.mButtonGetTime.setOnClickListener(this);
        this.mViewHolder.mButtonSetTime.setOnClickListener(this);
        this.mViewHolder.mTimePicker.setOnTimeChangedListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.button_datepicker) {
            this.showDatePickerDialog();
        } else if (id == R.id.button_get_time) {

            if (Build.VERSION.SDK_INT >= 23) {

                String hour = String.valueOf(this.mViewHolder.mTimePicker.getHour());
                String minute = String.valueOf(this.mViewHolder.mTimePicker.getMinute());

                String value = String.valueOf(hour) + ":" + String.valueOf(minute);

                Toast.makeText(this, value, Toast.LENGTH_LONG).show();

            } else {
                String hour = String.valueOf(this.mViewHolder.mTimePicker.getCurrentHour());
                String minute = String.valueOf(this.mViewHolder.mTimePicker.getCurrentMinute());

                String value = String.valueOf(hour) + ":" + String.valueOf(minute);

                Toast.makeText(this, value, Toast.LENGTH_LONG).show();
            }

        } else if (id == R.id.button_set_time) {
            if (Build.VERSION.SDK_INT >= 23) {


                this.mViewHolder.mTimePicker.setHour(10);
                this.mViewHolder.mTimePicker.setMinute(45);

            } else {

                this.mViewHolder.mTimePicker.setCurrentHour(10);
                this.mViewHolder.mTimePicker.setCurrentMinute(45);
            }
        }

    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, this, year, month, day).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        String date = SIMPLE_DATE_FORMAT.format(calendar.getTime());

        this.mViewHolder.mButtonDatePicker.setText(date);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

        String value = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    private static class ViewHolder {

        private Button mButtonDatePicker;
        private TimePicker mTimePicker;
        private Button mButtonGetTime;
        private Button mButtonSetTime;
    }
}
