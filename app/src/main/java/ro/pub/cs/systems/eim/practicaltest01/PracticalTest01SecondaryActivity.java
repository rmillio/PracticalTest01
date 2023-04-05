package ro.pub.cs.systems.eim.practicaltest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    TextView textView;

    Button okBtn;
    Button cancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        textView = findViewById(R.id.text_view);

        okBtn = findViewById(R.id.ok_btn);
        cancelBtn = findViewById(R.id.cancel_btn);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.LEFT_TEXT) && intent.getExtras().containsKey(Constants.RIGHT_TEXT)) {
            int left = Integer.parseInt(intent.getStringExtra(Constants.LEFT_TEXT));
            int right = Integer.parseInt(intent.getStringExtra(Constants.RIGHT_TEXT));

            textView.setText(String.valueOf(left + right));
        }

        okBtn.setOnClickListener(view -> {
            setResult(RESULT_OK, null);
            finish();
        });

        cancelBtn.setOnClickListener(view -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });
    }


}