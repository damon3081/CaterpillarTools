package com.caterpillar;

import com.caterpillar.util.SystemUiHider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainActivity extends Activity {
	
	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		editText = (EditText) findViewById(R.id.a_value);
		
		button = (Button) findViewById(R.id.loginButton);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String value = editText.getText().toString();
				if(value.equals("")||value == null){
					Toast.makeText(getApplicationContext(), "«Î ‰»Î ˝æ›£°", 500).show();
					return;
				}
				Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
				Bundle bundle = new Bundle();
				bundle.putDouble("a_value", Double.parseDouble(value));
				intent.putExtras(bundle);
				startActivity(intent);
				
			}
		});
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	
}
