package com.example.kazuate;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    //準備
    private TextView result;
    private TextView rs1;
    private TextView rs2;
    private TextView rs3;
    private TextView rs4;
    private TextView rs0;
    private TextView tv;
    private EditText edit;
    private Button sent;
    private Button reset;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        //起動と同時



    }

    //idを取得して準備
    private void getId() {
        TextView result = findViewById(R.id.result);
        TextView tv = findViewById(R.id.tv);
        EditText edit = findViewById(R.id.edit);
        TextView rs0 =findViewById(R.id.rs0);
        TextView rs1 = findViewById(R.id.rs1);
        TextView rs2 = findViewById(R.id.rs2);
        TextView rs3 = findViewById(R.id.rs3);
        TextView rs4 = findViewById(R.id.rs4);
        Button sent = findViewById(R.id.sent);
        Button reset = findViewById(R.id.reset);
    }

    //そのあと


    //数当てゲームを始めるかどうかの問






}