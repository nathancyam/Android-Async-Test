package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class DisplayProduct extends Fragment {

//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.display);
//		TextView nameView = (TextView)findViewById(R.id.Name_View);
//        TextView dateView = (TextView)findViewById(R.id.Date_View);
//		Bundle extras = getIntent().getExtras();
//		if(extras != null) {
//            Articles printArticle = (Articles)getIntent().getExtras().get("class_ArticleArray");
//            nameView.setText(printArticle.title);
//            dateView.setText(printArticle.date);
//		}
//	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		TextView nameView = (TextView)getView().findViewById(R.id.Name_View);
        TextView dateView = (TextView)getView().findViewById(R.id.Date_View);
        return inflater.inflate(R.layout.display, container, false);
    }

    public void post_NewArticle(View view){
        TextView txt_newTitle = (EditText)getView().findViewById(R.id.Name_View);
        TextView txt_newDate = (EditText)getView().findViewById(R.id.Date_View);
        String newTitle = txt_newTitle.getText().toString();
        String newDate = txt_newDate.getText().toString();
        Log.i("DisplayProduct.java","Adding new items to database");
        ServerLink.postData(newTitle, newDate);

    }

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.display, menu);
//		return true;
//	}
}
