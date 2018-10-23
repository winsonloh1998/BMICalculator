package my.edu.taruc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewMsg;
        textViewMsg = findViewById(R.id.textViewResult);

        ImageView imgView;
        imgView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.BMI_RESULT)){
            double getString = intent.getDoubleExtra(MainActivity.BMI_RESULT,0);

            if(getString <18.5){
                textViewMsg.setText("BMI: "+ String.valueOf(getString));
                imgView.setImageResource(R.drawable.under);
            }else if(getString >= 18.5 && getString <= 25){
                textViewMsg.setText("BMI: "+ String.valueOf(getString));
                imgView.setImageResource(R.drawable.normal);
            }else if(getString >25){
                textViewMsg.setText("BMI: "+ String.valueOf(getString));
                imgView.setImageResource(R.drawable.over);
            }else{
                imgView.setImageResource(R.drawable.empty);
            }

        }
    }
}
