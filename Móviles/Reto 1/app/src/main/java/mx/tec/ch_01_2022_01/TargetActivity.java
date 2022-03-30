package mx.tec.ch_01_2022_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {

    TextView targetTVOM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        targetTVOM = findViewById(R.id.textView2);
        Intent currentIntent = getIntent();

        Boolean chkST;
        Boolean chkWK;
        Boolean chkTR;
        String edtxNM;

        chkST = currentIntent.getBooleanExtra("chkbxST", false);
        chkWK = currentIntent.getBooleanExtra("chkbxWK", false);
        chkTR = currentIntent.getBooleanExtra("chkbxTR", false);
        edtxNM = currentIntent.getStringExtra("edtxNM");

        targetTVOM.setText("User name: " + edtxNM  + "; " +
                           "User studies: " + chkST.toString() + "; " +
                           "User works: " + chkWK.toString() + "; " +
                           "User is in training: " + chkTR.toString());

    }
}