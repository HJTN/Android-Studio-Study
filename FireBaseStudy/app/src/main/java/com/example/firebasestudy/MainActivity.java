package com.example.firebasestudy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText et_user_name, et_user_email;
    Button btn_save;

    private DatabaseReference mDatabase;
    private Integer number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_user_name = findViewById(R.id.et_user_name);
        et_user_email = findViewById(R.id.et_user_email);
        btn_save = findViewById(R.id.btn_save);

        // firebase 정의
        mDatabase = FirebaseDatabase.getInstance().getReference();

        readUser();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserName = et_user_name.getText().toString();
                String getUserEmail = et_user_email.getText().toString();

                // hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("name", getUserEmail);
                result.put("email", getUserEmail);

                writeNewUser(number, getUserName, getUserEmail);
                number++;
            }
        });
    }
    
    // 파이어베이스 데이터 조회
    private void readUser() {
        mDatabase.child("users").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Get Post object and use the values to update the UI
                if(snapshot.getValue(User.class) != null) {
                    User post = snapshot.getValue(User.class);
                    Log.w("FireBaseData", "getData" + post.getData());
                } else {
                    Toast.makeText(MainActivity.this, "No Data...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData", "loading:onCancelled", error.toException());
            }
        });
    }
    
    // 파이어베이스에 데이터 추가
    private void writeNewUser(Integer userId, String name, String email) {
        User user = new User(name, email);
        
        mDatabase.child("users").child("" + userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        // Write was successful!
                        Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(MainActivity.this, "Failed to save...", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}