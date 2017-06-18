package com.mmeh.peal;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.icu.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.N)
public class WeekCalendar extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent intent = new Intent();
            int itemId = item.getItemId();
            switch (item.getItemId()) {
                case R.id.navigation_calendar:
                    intent = new Intent(findViewById(itemId).getContext(), MonthCalendar.class);
                    break;
                case R.id.navigation_recipes:
                    intent = new Intent(findViewById(itemId).getContext(), RecipeBook.class);
                    break;
                case R.id.navigation_shoppingList:
                    intent = new Intent(findViewById(itemId).getContext(), ShoppingList.class);
                    break;
            }
            startActivity(intent);
            return true;

        }

    };

    public int getWeek(){
        Calendar calendar = Calendar.getInstance();
        int week = calendar.WEEK_OF_YEAR;
        return week;
    }

    public void setWeekDays(int week){

        DateFormat format = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        //calendar.set(Calendar.WEEK_OF_YEAR, week);
        final String[] days = new String[7];
        for(int i = 0; i < 7; i++)
        {
            days[i] = format.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        final String month_name = month_date.format(calendar.getTime());


        Button month = (Button)findViewById(R.id.nextWeek);
        month.setText(month_name);
        Button day_0 = (Button)findViewById(R.id.day0);
        day_0.setText(days[0]);
        Button day_1 = (Button)findViewById(R.id.day1);
        day_1.setText(days[1]);
        Button day_2 = (Button)findViewById(R.id.day2);
        day_2.setText(days[2]);
        Button day_3 = (Button)findViewById(R.id.day3);
        day_3.setText(days[3]);
        Button day_4 = (Button)findViewById(R.id.day4);
        day_4.setText(days[4]);
        Button day_5 = (Button)findViewById(R.id.day5);
        day_5.setText(days[5]);
        Button day_6 = (Button)findViewById(R.id.day6);
        day_6.setText(days[6]);

        day_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[0], month_name);
            }
        });
        day_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[1], month_name);
            }
        });
        day_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[2], month_name);
            }
        });
        day_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[3], month_name);
            }
        });
        day_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[4], month_name);
            }
        });
        day_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[5], month_name);
            }
        });
        day_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDay(days[6], month_name);
            }
        });

    }

    public int nextWeek(int currentWeek){
        return currentWeek++;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_calendar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        int currentWeek = getWeek();
        setWeekDays(currentWeek);

    }

    public void goToTestScreen(View view) {
        Intent intent;
        intent = new Intent(this, MealView.class);
        startActivity(intent);
    }

    public void goToDay(String day, String month){
        Intent intent;
        intent = new Intent(this, DayView.class);
        intent.putExtra("Month", month);
        intent.putExtra("Day", day);
        startActivity(intent);
    }


}
