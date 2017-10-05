package edu.fullerton.ecs.reversepolishnotation;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    private ImageButton delButton;
    private Button dropButton;
    private Button decButton;
    private TextView inputTextView;
    private Button enterButton;
    private TextView[] stackTextView;

    String[] topFour = new String[4];
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
        //Get widget references
        enterButton = (Button) findViewById(R.id.buttonEnter);
        addButton = (Button) findViewById(R.id.buttonAdd);
        multButton = (Button) findViewById(R.id.buttonMult);
        divButton = (Button) findViewById(R.id.buttonDiv);
        subButton = (Button) findViewById(R.id.buttonSub);
        delButton = (ImageButton) findViewById(R.id.buttonDelete);
        decButton = (Button) findViewById(R.id.buttonDecimal);
        dropButton = (Button) findViewById(R.id.buttonDrop);

        inputTextView = (TextView) findViewById(R.id.inputNumberTextView);
        stackTextView = new TextView[4];
        for (int i = 0; i < 4; i++) {
            stackTextView[i] = (TextView) findViewById(getResources().getIdentifier("stack" + i + "TextView", "id",this.getPackageName()));
        }

        //Set event handlers
        addButton.setOnClickListener(this);
        enterButton.setOnClickListener(this);
        multButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        delButton.setOnClickListener(this);
        decButton.setOnClickListener(this);
        dropButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        char digit;
        String text;
        switch (view.getId()) {
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                String viewId = view.getResources().getResourceName(view.getId());
                digit = viewId.charAt(viewId.length() - 1);
                String currentNum = inputTextView.getText().toString();
                currentNum  = currentNum + digit;
                inputTextView.setText(currentNum);
                break;
            case R.id.buttonAdd:
                stack.evaluateOperation("+");
                refreshStackDisplay();
                break;
            case R.id.buttonMult:
                stack.evaluateOperation("*");
                refreshStackDisplay();
                break;
            case R.id.buttonSub:
                stack.evaluateOperation("-");
                refreshStackDisplay();
                break;
            case R.id.buttonDiv:
                stack.evaluateOperation("/");
                refreshStackDisplay();
                break;
            case R.id.buttonEnter:
                //TODO: Fix big: Crash if nothing entered
                stack.input(Float.parseFloat(inputTextView.getText().toString()));
                inputTextView.setText("");
                refreshStackDisplay();
                break;
            case R.id.buttonDecimal:
                //TODO: Fix bug: More than one decimal point can be entered
                text = inputTextView.getText().toString();
                inputTextView.setText(text + '.');
                break;
            case R.id.buttonDelete:
                //TODO: Fix bug: Deleting from empty text causes crash
                text = inputTextView.getText().toString();
                inputTextView.setText(text.substring(0,text.length()-1));
                break;
            case R.id.buttonDrop:
                inputTextView.setText("");
                break;
            default: break;
        }
    }

    private void refreshStackDisplay() {
        String [] topFour = stack.getTopFour();
        //SetDisplay for stack
        for(int i = 0 ; i < topFour.length; i++) {
            stackTextView[3-i].setText(topFour[i]);
            Log.d(TAG, "displayStack: " + topFour[i].toString());
        }
    }
}
