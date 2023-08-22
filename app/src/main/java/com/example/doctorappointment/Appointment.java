package com.example.doctorappointment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Appointment extends AppCompatActivity  implements View.OnClickListener {
    public Button button1;
   String[] areas = {"Meru", "Tharaka Nithi", "Embu", "Kirinyaga", "Nyeri", "Murang'a", "Kiambu", "Nairobi"};
    String[] doctors = {"Isaiah Mungai", "Sammy Mwambezi", "Isaac Okeyo", "Anthony Taylor", "Dr. No", "James Bond", "Dr.Kamau"};

    EditText selectDate,selectTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    //ListView listView;
   // ArrayAdapter<String> adapter
    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
//    ?

    //SearchView searchView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        button1= (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Appointment.this, Confirmation.class);
                startActivity(intent);
            }
        });

                //   listView=(ListView) findViewById(R.id.listview);
                //  adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
                //  listView.setAdapter(adapter);
                //  new Connection().execute();

                selectDate = (EditText) findViewById(R.id.date);
                selectTime = (EditText) findViewById(R.id.time);

                selectDate.setOnClickListener(this);
                selectTime.setOnClickListener(this);


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, areas);
                AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.areas);
                acTextView.setThreshold(1);
                acTextView.setAdapter(adapter);

                adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, doctors);
                acTextView = (AutoCompleteTextView) findViewById(R.id.doctors);
                acTextView.setThreshold(1);
                acTextView.setAdapter(adapter);


            }

            @Override
            public void onClick(View view) {

                if (view == selectDate) {
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
                if (view == selectTime) {

                    // Get Current Time
                    final Calendar c = Calendar.getInstance();
                    mHour = c.get(Calendar.HOUR_OF_DAY);
                    mMinute = c.get(Calendar.MINUTE);

                    // Launch Time Picker Dialog
                    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                            new TimePickerDialog.OnTimeSetListener() {

                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay,
                                                      int minute) {

                                    selectTime.setText(hourOfDay + ":" + minute);
                                }
                            }, mHour, mMinute, false);
                    timePickerDialog.show();
                }
            }

        }

