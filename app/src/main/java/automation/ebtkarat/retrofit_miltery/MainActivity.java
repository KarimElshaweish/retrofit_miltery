package automation.ebtkarat.retrofit_miltery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import automation.ebtkarat.retrofit_miltery.Controller.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main.main();
    }
}
