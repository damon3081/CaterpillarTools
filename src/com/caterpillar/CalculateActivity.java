package com.caterpillar;

import com.caterpillar.util.SystemUiHider;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class CalculateActivity extends Activity {
	
	private double a_value;
	private TextView textView;
	private EditText x1eEditText;
	private EditText x2eEditText;
	private EditText y1eEditText;
	private EditText y2eEditText;
	private EditText resultEditText;
	private Button button;
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private double result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_calculate);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		a_value = bundle.getDouble("a_value");
		textView = (TextView) findViewById(R.id.a);
		x1eEditText = (EditText) findViewById(R.id.x1);
		x2eEditText = (EditText) findViewById(R.id.x2);
		y1eEditText = (EditText) findViewById(R.id.y1);
		y2eEditText = (EditText) findViewById(R.id.y2);
		resultEditText = (EditText) findViewById(R.id.result);
		button = (Button) findViewById(R.id.button1);
		textView.setText(a_value+"");
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 String x1sString = x1eEditText.getText().toString();
                 String x2sString = x2eEditText.getText().toString();
                 String y1sString = y1eEditText.getText().toString();
                 String y2sString = y2eEditText.getText().toString();
                 if(x1sString.equals("")||x2sString.equals("")||y1sString.equals("")||y2sString.equals("")){
                 	resultEditText.setText("0");
                 	Toast.makeText(getApplicationContext(), "请输入数据", 2000).show();
                 }else {
						x1 = Double.parseDouble(x1sString);
						x2 = Double.parseDouble(x2sString);
						y1 = Double.parseDouble(y1sString);
						y2 = Double.parseDouble(y2sString);
						result = (x2-a_value)*(y1-y2)/(x2-x1)+y2;
						resultEditText.setText(result+"");
						x1eEditText.setText("");
						x2eEditText.setText("");
						y1eEditText.setText("");
						y2eEditText.setText("");
					}
			}
		});
		
	    y2eEditText.setOnKeyListener(new View.OnKeyListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (KeyEvent.KEYCODE_ENTER == keyCode && event.getAction() == KeyEvent.ACTION_DOWN) {  
                    String x1sString = x1eEditText.getText().toString();
                    String x2sString = x2eEditText.getText().toString();
                    String y1sString = y1eEditText.getText().toString();
                    String y2sString = y2eEditText.getText().toString();
                    if(x1sString.equals("")||x2sString.equals("")||y1sString.equals("")||y2sString.equals("")){
                    	resultEditText.setText("0");
                    	Toast.makeText(getApplicationContext(), "请输入数据", 2000).show();
                    }else {
						x1 = Double.parseDouble(x1sString);
						x2 = Double.parseDouble(x2sString);
						y1 = Double.parseDouble(y1sString);
						y2 = Double.parseDouble(y2sString);
						result = (x2-a_value)*(y1-y2)/(x2-x1)+y2;
						resultEditText.setText(result+"");
						x1eEditText.setText("");
						x2eEditText.setText("");
						y1eEditText.setText("");
						y2eEditText.setText("");
					}
                    return true;  
                }  
                return false;  
			}
		});
		
		
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

}
