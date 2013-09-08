package fabio.converter.baseconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = (TextView) findViewById(R.id.textViewResult);
        final TextView data = (TextView) findViewById(R.id.editTextValue);
        final RadioGroup baseFrom = (RadioGroup) findViewById(R.id.radioGroup1);
        final RadioGroup baseTo = (RadioGroup) findViewById(R.id.radioGroup2);

        final Button button = (Button) findViewById(R.id.buttonConvert);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result.setText(conversionCaller(data.getText().toString(),baseFrom.getCheckedRadioButtonId(),baseTo.getCheckedRadioButtonId()));
            }
        });

    }

    public String conversionCaller(String value,int from, int to){
        String printResult ="";
        Converter convert = new Converter();
        switch (to){
            case R.id.radioToBase2:
                switch (from){
                    case R.id.radioFromBase2:
                        printResult = value;
                        break;
                    case R.id.radioFromBase8:
                        printResult = convert.decimalToBinary(convert.octalToDecimal(Long.parseLong(value)));
                        break;
                    case R.id.radioFromBase10:
                        printResult = convert.decimalToBinary(Long.parseLong(value));
                        break;
                    case R.id.radioFromBase16:
                        printResult = convert.decimalToBinary(convert.hexToDecimal(value));
                        break;
                }
                break;
            case R.id.radioToBase8:
                switch (from){
                    case R.id.radioFromBase2:
                        printResult = convert.decimalToOctal(convert.binaryToDecimal(Long.parseLong(value)));
                        break;
                    case R.id.radioFromBase8:
                        printResult = value;
                        break;
                    case R.id.radioFromBase10:
                        printResult = convert.decimalToOctal(Long.parseLong(value));
                        break;
                    case R.id.radioFromBase16:
                        printResult = convert.decimalToOctal(convert.hexToDecimal(value));
                        break;
                }
                break;
            case R.id.radioToBase10:
                switch (from){
                    case R.id.radioFromBase2:
                        printResult = String.valueOf(convert.binaryToDecimal(Long.parseLong(value)));
                        break;
                    case R.id.radioFromBase8:
                        printResult = String.valueOf(convert.octalToDecimal(Long.parseLong(value)));
                        break;
                    case R.id.radioFromBase10:
                        printResult = value;
                        break;
                    case R.id.radioFromBase16:
                        printResult = String.valueOf(convert.hexToDecimal(value));
                        break;
                }
                break;
            case R.id.radioToBase16:
                switch (from){
                    case R.id.radioFromBase2:
                        printResult = convert.decimalToHex(convert.binaryToDecimal(Long.parseLong(value)));
                        break;
                    case R.id.radioFromBase8:
                        printResult = convert.decimalToHex(convert.octalToDecimal(Long.parseLong(value)));
                        break;
                    case R.id.radioFromBase10:
                        printResult = convert.decimalToHex(Long.parseLong(value));
                        break;
                    case R.id.radioFromBase16:
                        printResult = value;
                        break;
                }
                break;
        }
        return printResult;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}