package edu.fullerton.ecs.reversepolishnotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CalculatorActivity";
    private CalculatorStack stack;
    private Button[] numberButtons;
    private Button addButton;
    private Button subButton;
    private Button multButton;
    private Button divButton;
    private Button delButton;
    private Button dropButton;
    private Button evalButton;
    private TextView inputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        stack = new CalculatorStack();
        numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = (Button) findViewById(getResources().getIdentifier("button" + i, "id",this.getPackageName()));
            Log.d(TAG, "onCreate: " + numberButtons[i].toString());
            numberButtons[i].setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View view) {
        int digit = 0;
        switch (view.getId()) {
            case R.id.button0:
                digit = 0;
                break;
            case R.id.button1:
                digit = 1;
                break;
            case R.id.button2:
                digit = 2;
                break;
            case R.id.button3:
                digit = 3;
                break;
            case R.id.button4:
                digit = 4;
                break;
            case R.id.button5:
                digit = 5;
                break;
            case R.id.button6:
                digit = 6;
                break;
            case R.id.button7:
                digit = 7;
                break;
            case R.id.button8:
                digit = 8;
                break;
            case R.id.button9:
                digit = 9;
                break;
            default: break;
        }
        Toast.makeText(this, Integer.toString(digit) ,Toast.LENGTH_SHORT).show();
    }
}
