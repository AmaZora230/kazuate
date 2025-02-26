package com.example.kazuate;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

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

    private Random random = new Random();
    private int randomNum;

    private int i;


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
        TextView result = findViewById(R.id.result);
        TextView tv = findViewById(R.id.tv);
        EditText edit = findViewById(R.id.edit);
        Button sent = findViewById(R.id.sent);
        Button reset = findViewById(R.id.reset);

        //数当てゲームを始めるかどうかの問 →　レイアウトで初期設定したため不要
        //初期ランダムの数字を作成
        int randomNum = random.nextInt(21);

        //iの初期設定は不要。（最初の値は0の為）

        //ボタンの設定
        sent.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //空欄だったらトーストで知らせる
                String inputText = edit.getText().toString();
                if (inputText.isEmpty()){
                    Toast.makeText(MainActivity.this,R.string.editText,Toast.LENGTH_LONG).show();
                    return;
                }

                //空欄じゃなければ実行する
                 try {
                    //入力した数字を受け取る
                    int ans = Integer.parseInt(edit.getText().toString());

                    i++; //入力回数
                    edit.setText("");

                    if ( ans == randomNum){
                        result.setText(R.string.correct);
                        tv.setText(R.string.reset);
                        sent.setEnabled(false);

                    } else if ( ans > randomNum ) {
                        result.setText(R.string.big);

                    } else if ( ans < randomNum ){
                        result.setText(R.string.small);
                    }
                    if ( i >= 5 ) {
                        result.setText(getResources().getString(R.string.incorrect,randomNum));
                        tv.setText(R.string.reset);
                        sent.setEnabled(false);
                    }
                } catch (NumberFormatException e) {
                     Toast.makeText(MainActivity.this, R.string.editText, Toast.LENGTH_LONG).show();
                }


           }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNum = random.nextInt(21);
                result.setText(R.string.ResultStart);
                tv.setText(R.string.TvStart);
                sent.setEnabled(true);
                i = 0;
            }
        });

    }
}



