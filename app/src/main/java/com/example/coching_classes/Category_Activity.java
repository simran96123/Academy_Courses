package com.example.coching_classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category_Activity extends AppCompatActivity {

    private Button home , offered_courses , community , dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_);

        home = findViewById(R.id.home_btn);
        offered_courses = findViewById(R.id.offeredcourses_btn);
        community = findViewById(R.id.comunity_btn);
        dashboard = findViewById(R.id.dashboard_btn);

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Category_Activity.this , Dashboard_Activity.class);
                startActivity(intent);
            }
        });

        offered_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Category_Activity.this , Offered_Courses_Activity.class);
                startActivity(intent);

            }
        });
    }


}

