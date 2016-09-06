package homework.my.homework_androiddevelopment_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView componentName;
    private TextView componentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        componentName = (TextView) findViewById(R.id.componentName);
        componentID = (TextView) findViewById(R.id.componentID);

        componentName.setText(getIntent().getStringExtra("COMPONENT_NAME"));
        componentID.setText(getIntent().getStringExtra("COMPONENT_ID"));
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
