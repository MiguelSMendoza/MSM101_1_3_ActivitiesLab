package es.netrunners.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityForResult extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forresult);

		final EditText txtResult = (EditText) findViewById(R.id.editTextSetResult);

		Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
		btnConfirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("RESULT", txtResult.getText().toString());
				if (getParent() == null) {
					setResult(Activity.RESULT_OK, data);
				} else {
					getParent().setResult(Activity.RESULT_OK, data);
					
				}
				finish();

			}
		});
	}

}
