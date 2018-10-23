package my.edu.taruc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String BMI_RESULT = "my.edu.taruc.bmicalculator.RESULT";
    private EditText editTextMessageW;
    private EditText editTextMessageH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessageW = findViewById(R.id.editTextWeight);
        editTextMessageH = findViewById(R.id.editTextHeight);
    }

    public void calcBMI(View view){

        if(TextUtils.isEmpty(editTextMessageW.getText())){
            editTextMessageW.setError("Please enter your weight");
            return;
        }else if(TextUtils.isEmpty(editTextMessageH.getText())){
            editTextMessageH.setError("Please enter your height");
            return;
        }

        String wValue = editTextMessageW.getText().toString();
        String hValue = editTextMessageH.getText().toString();

        double weight = Double.parseDouble(wValue);
        double height = Double.parseDouble(hValue)/100;
        double total = weight / (height * height);

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(BMI_RESULT,total);
        startActivity(intent);

    }
}
