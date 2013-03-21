package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

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

    public void post_NewArticle(View view){
        TextView txt_newTitle = (EditText)findViewById(R.id.Name_View);
        TextView txt_newDate = (EditText)findViewById(R.id.Date_View);
        String newTitle = txt_newTitle.getText().toString();
        String newDate = txt_newDate.getText().toString();
        Log.i("DisplayProduct.java","Adding new items to database");
        ServerLink.postData(newTitle, newDate);

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}
}
