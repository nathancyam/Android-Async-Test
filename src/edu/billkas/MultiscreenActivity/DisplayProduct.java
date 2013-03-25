package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DisplayProduct extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		TextView nameView = (TextView)findViewById(R.id.Name_View);
        TextView dateView = (TextView)findViewById(R.id.Date_View);
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
            Articles printArticle = (Articles)getIntent().getExtras().get("class_ArticleArray");
            nameView.setText(printArticle.title);
            dateView.setText(printArticle.date);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}
}
