package com.example.j7_spinnerinchtocm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] SELECTED = {"SELECT","INCH to CENTIMETER","CENTIMETER to INCH"};
    Spinner SPIN;
    EditText INPUT;
    TextView RS;
    Button CLR;
    Double I,O;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        INPUT = (EditText)findViewById(R.id.IN);
        RS = (TextView)findViewById(R.id.RES);
        CLR = (Button)findViewById(R.id.CLR);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        SPIN = (Spinner) findViewById(R.id.SEL);
        SPIN.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the SELECTION list
        ArrayAdapter SLOT = new ArrayAdapter(this, android.R.layout.simple_spinner_item,SELECTED);
        SLOT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        SPIN.setAdapter(SLOT);

        CLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                INPUT.setText("");
                RS.setText("");
                SPIN.setAdapter(SLOT);
            }
        });
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (INPUT.getText().length()==0) {
            Toast.makeText(getApplicationContext(), "Enter Numerical Value in the box then select spinner value", Toast.LENGTH_SHORT).show();
            }
        else
            {
                String SELECTED = SPIN.getSelectedItem().toString();

                if (SELECTED.equals("INCH to CENTIMETER")) {
                    I = Double.parseDouble(INPUT.getText().toString());
                    O = I * 2.54;
                    RS.setText(Double.toString(O));
                }

                if (SELECTED.equals("CENTIMETER to INCH")) {
                    I = Double.parseDouble(INPUT.getText().toString());
                    O = I / 2.54;
                    RS.setText(Double.toString(O));
                }

                if (SELECTED.equals("SELECT")) {
                    Toast.makeText(getApplicationContext(), "Select any one item below in the spinner to perform the conversion operation", Toast.LENGTH_SHORT).show();
                }
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }
}