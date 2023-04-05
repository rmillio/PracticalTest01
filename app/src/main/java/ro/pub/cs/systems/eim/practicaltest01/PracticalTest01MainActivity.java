package ro.pub.cs.systems.eim.practicaltest01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    Button leftBtn;
    Button rightBtn;
    Button navigateBtn;

    TextView leftTextView;
    TextView rightTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        leftBtn = findViewById(R.id.press_me_btn);
        rightBtn = findViewById(R.id.press_me_too_btn);
        navigateBtn = findViewById(R.id.navigate_btn);

        leftTextView = findViewById(R.id.left_text_view);
        rightTextView = findViewById(R.id.right_text_view);

        leftBtn.setOnClickListener(view -> {
            leftTextView.setText(String.valueOf(Integer.parseInt(leftTextView.getText().toString()) + 1));
        });

        rightBtn.setOnClickListener(view -> {
            rightTextView.setText(String.valueOf(Integer.parseInt(rightTextView.getText().toString()) + 1));
        });

        navigateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
            intent.putExtra(Constants.LEFT_TEXT, leftTextView.getText().toString());
            intent.putExtra(Constants.RIGHT_TEXT, rightTextView.getText().toString());
            startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.LEFT_TEXT, leftTextView.getText().toString());
        savedInstanceState.putString(Constants.RIGHT_TEXT, rightTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.LEFT_TEXT)) {
            leftTextView.setText(savedInstanceState.getString(Constants.LEFT_TEXT));
        } else {
            leftTextView.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.RIGHT_TEXT)) {
            rightTextView.setText(savedInstanceState.getString(Constants.RIGHT_TEXT));
        } else {
            rightTextView.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case Constants.SECONDARY_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "Result ok", Toast.LENGTH_SHORT).show();
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "Result canceled", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}