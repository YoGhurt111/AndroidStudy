package yoghurt.kh21;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import static yoghurt.kh21.ReversePolishNotation.isOperator;

public class Calculator extends AppCompatActivity {
    private TextView textView;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonBack;
    private Button buttonClear;
    private Button buttonEqual;
    private Button buttonPoint;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String bnText;
            String oldExpression;
            String newExpression;
            Button bn = (Button) v;
            switch (bn.getId()){
                case R.id.num0:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num1:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num2:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num3:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num4:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num5:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num6:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num7:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num8:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.num9:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.button_back:
                    oldExpression = textView.getText().toString();
                    newExpression = oldExpression.substring(0,oldExpression.length()-1);
                    textView.setText(newExpression);
                    break;
                case R.id.button_clear:
                    newExpression = "";
                    textView.setText(newExpression);
                    break;
                case R.id.button_plus:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.button_minus:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.button_multiply:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.button_divide:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
                case R.id.button_equal:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    double result = ReversePolishNotation.evalExp(oldExpression);
                    newExpression = Double.toString(result);
                    textView.setText(newExpression);
                    break;
                case R.id.button_point:
                    bnText = bn.getText().toString();
                    oldExpression = textView.getText().toString();
                    newExpression = "";
                    newExpression = oldExpression.concat(bnText);
                    textView.setText(newExpression);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        textView = (TextView) findViewById(R.id.text);
        button0 = (Button) findViewById(R.id.num0);
        button1 = (Button) findViewById(R.id.num1);
        button2 = (Button) findViewById(R.id.num2);
        button3 = (Button) findViewById(R.id.num3);
        button4 = (Button) findViewById(R.id.num4);
        button5 = (Button) findViewById(R.id.num5);
        button6 = (Button) findViewById(R.id.num6);
        button7 = (Button) findViewById(R.id.num7);
        button8 = (Button) findViewById(R.id.num8);
        button9 = (Button) findViewById(R.id.num9);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonMultiply = (Button) findViewById(R.id.button_multiply);
        buttonDivide = (Button) findViewById(R.id.button_divide);
        buttonBack = (Button) findViewById(R.id.button_back);
        buttonClear = (Button) findViewById(R.id.button_clear);
        buttonEqual = (Button) findViewById(R.id.button_equal);
        buttonPoint = (Button) findViewById(R.id.button_point);

        button0.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonMultiply.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonDivide.setOnClickListener(listener);
        buttonEqual.setOnClickListener(listener);
        buttonPoint.setOnClickListener(listener);
        buttonBack.setOnClickListener(listener);
        buttonClear.setOnClickListener(listener);
    }

}
