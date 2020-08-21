package com.example.coching_classes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Student_Activity extends AppCompatActivity {

    ListView listView;
    //  DatabaseReference ref;
    //  FirebaseDatabase database;
    //  FirebaseDatabase mRef;

    //  String[] studentNames = {"simran", "sony", "neha", "kashak", "punam", "munna", "simi", "nisha", "manshi", "sona"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_);

        //  mRef = new FirebaseDatabase("https://our-acedemy.firebaseio.com/");

//        HashMap<String , Object> map = new HashMap<>();
//        map.put("Name" , "Simran");
//        map.put("Email" , "simikri98@gmail.com");
//        map.put("Courses Enrolled" , "JAVA");


        // FirebaseDatabase.getInstance().getReference().child("our_acedemy").child("multipleValues").updateChildren(map);


        listView = findViewById(R.id.stu_listview);


        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row_data, list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Data data = snapshot.getValue(Data.class);
                    String txt = data.getName() + " :" + data.getCourses();
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}



//        CustomerAdapter customerAdapter = new CustomerAdapter();
//        listView.setAdapter(customerAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent = new Intent(getApplicationContext() ,ListdataActivity.class);
//                intent.putExtra("name" , studentNames[i]);
//                startActivity(intent);
//
//            }
//        });
//
//
//
//    }
//
//
//    private class CustomerAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return studentNames.length;
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//
//            View view1 = getLayoutInflater().inflate(R.layout.row_data , null);
//            TextView name = view1.findViewById(R.id.students);
//
//            name.setText(studentNames[i]);
//
//            return view1;
//        }
   // }
//}

