package com.example.coching_classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard_Activity extends AppCompatActivity {

    private Button student_btnn , teacher_btnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_);


        student_btnn = findViewById(R.id.student_btn);
        teacher_btnn = findViewById(R.id.teacher_btn);

        student_btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent stu_intent  = new Intent(Dashboard_Activity.this , Student_Activity.class);
                startActivity(stu_intent);
            }
        });

        teacher_btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent teach_intent = new Intent(Dashboard_Activity.this , Teacher_Activity.class);
                startActivity(teach_intent);
            }
        });
    }
}