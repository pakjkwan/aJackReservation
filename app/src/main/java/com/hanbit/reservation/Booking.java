package com.hanbit.reservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking extends AppCompatActivity {
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);
        final CalendarView calendar= (CalendarView) findViewById(R.id.calendar);
        final TimePicker timePicker= (TimePicker) findViewById(R.id.timePicker);
        timePicker.setVisibility(View.INVISIBLE);
        TextView today= (TextView) findViewById(R.id.today);
        today.setText("TODAY: "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        final TextView year= (TextView) findViewById(R.id.year);
        final TextView month= (TextView) findViewById(R.id.month);
        final TextView date= (TextView) findViewById(R.id.date);
        final TextView hour= (TextView) findViewById(R.id.hour);
        final TextView minute= (TextView) findViewById(R.id.minute);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                temp=year+"-"+(month+1)+"-"+dayOfMonth;
            }
        });

        findViewById(R.id.rdDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                calendar.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.rdTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calendar.setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("선택한 연도:",temp);
                String[] arr=temp.split("-");
                year.setText(arr[0]);
                month.setText(arr[1]);
                date.setText(arr[2]);
                hour.setText(String.valueOf(timePicker.getHour()));
                minute.setText(String.valueOf(timePicker.getMinute()));
            }
        });
    }
}
