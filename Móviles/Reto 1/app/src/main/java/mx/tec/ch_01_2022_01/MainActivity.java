/// First challenge
// Sprint 1 Create a form like the one in the main activity
// Sprint 2 Create object managers to obtain the values in the form
// validate the form that it only goes to the next activity if privacy settings are OK
// Sprint 3 Send values as extras and display them in the target activity
// Optional, validate the form so that at least one option is checked

package mx.tec.ch_01_2022_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonSendOM;
    private EditText editTextNOM;
    private Switch switchOKOM;
    private CheckBox checkboxSTOM;
    private CheckBox checkboxWKOM;
    private CheckBox checkboxTROM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSendOM = findViewById(R.id.buttonSend);
        editTextNOM = findViewById(R.id.editTextName);
        switchOKOM = findViewById(R.id.switchAgree);
        checkboxSTOM = findViewById(R.id.checkBoxST);
        checkboxWKOM = findViewById(R.id.checkBoxWK);
        checkboxTROM = findViewById(R.id.checkBoxTR);

        buttonSendOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switchOKOM.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                    intent.putExtra("edtxNM", editTextNOM.getText().toString());
                    intent.putExtra("chkbxST", checkboxSTOM.isChecked());
                    intent.putExtra("chkbxWK", checkboxWKOM.isChecked());
                    intent.putExtra("chkbxTR", checkboxTROM.isChecked());
                    startActivity(intent);
                } else {
                    switchOKOM.setTextColor(0xffff0000);
                }
            }
        });

    }
}