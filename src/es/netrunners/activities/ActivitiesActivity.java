package es.netrunners.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivitiesActivity extends Activity {

	static final int REQUEST_CODE = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btnFirst = (Button) findViewById(R.id.btnFirst);
		btnFirst.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),
						FirstActivity.class));
//				Intent intent = new Intent(getApplicationContext(),
//						ActivityForResult.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				startActivity(intent);
			}
		});

		Button btnGetResult = (Button) findViewById(R.id.btnGetResult);
		btnGetResult.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(getApplicationContext(),
						ActivityForResult.class), REQUEST_CODE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE) {
			Log.e("COsas", resultCode+" "+Activity.RESULT_OK);
			if (resultCode == Activity.RESULT_OK) {
				TextView txtResult = (TextView) findViewById(R.id.textResult);
				txtResult.setText(data.getExtras().getString("RESULT"));
			}
		}
	}
}