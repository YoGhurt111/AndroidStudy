package yoghurt.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    //使用接口的方式来注册监听器
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        button.setOnClickListener(this);
        /*使用匿名类的方法来注册Button Listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //在此添加逻辑
            }
        });*/

    }
}
