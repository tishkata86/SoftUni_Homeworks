package homework.my.homework_androiddevelopment_01;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button firstButton;
    private Button secondButton;
    private int firstButtonClickedCounter = 0;
    private int secondButtonClickedCounter = 0;

    private Button button01;
    private Button button02;
    private Button button03;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = (Button) findViewById(R.id.firstButton);
        firstButton.setOnClickListener(this);

        secondButton = (Button) findViewById(R.id.secondButton);

        button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(this);
        button02 = (Button) findViewById(R.id.button02);
        button02.setOnClickListener(this);
        button03 = (Button) findViewById(R.id.button03);
        button03.setOnClickListener(this);

        result = (TextView) findViewById(R.id.resultText);
        result.setOnClickListener(this);

    }

    //Implicit
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.firstButton){
            firstButtonClickedCounter++;
            firstButton.setText(String.valueOf(firstButtonClickedCounter));
        }

        if (v.getId() == R.id.button01){
            if (result.getText().equals(String.valueOf(R.id.button01))){
                button01.setText(String.valueOf(R.id.button01));
            }
            result.setText(String.valueOf(R.id.button01));
        }

        if (v.getId() == R.id.button02){
            if (result.getText().equals(String.valueOf(R.id.button02))){
                button02.setText(String.valueOf(R.id.button02));
            }
            result.setText(String.valueOf(R.id.button02));
        }

        if (v.getId() == R.id.button03){
            if (result.getText().equals(String.valueOf(R.id.button03))){
                button03.setText(String.valueOf(R.id.button03));
            }
            result.setText(String.valueOf(R.id.button03));
        }

        if (v.getId() == R.id.resultText){
            if (!result.getText().equals("Result")){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("COMPONENT_ID", result.getText());
                intent.putExtra("COMPONENT_NAME", TextView.class.getSimpleName());
                startActivity(intent);
            }
        }
    }

    //Explicit
    public void rightButtonClicked(View view){
        secondButtonClickedCounter++;
        secondButton.setText(String.valueOf(secondButtonClickedCounter));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
