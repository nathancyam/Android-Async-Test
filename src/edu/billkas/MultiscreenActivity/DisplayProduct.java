package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayProduct extends Activity{

    public static int articleID;
    public static String orig_title, orig_date;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		final TextView nameView = (TextView)findViewById(R.id.Name_View);
        final TextView dateView = (TextView)findViewById(R.id.Date_View);
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
            Articles printArticle = (Articles)getIntent().getExtras().get("class_ArticleArray");
            // Set original here
            orig_title = printArticle.title;
            orig_date = printArticle.date;
            // Set originals in the textviews
            nameView.setText(orig_title);
            dateView.setText(orig_date);
            articleID = printArticle.id;
		}
        // Add buttons here
        Button btn_Update = (Button)findViewById(R.id.btn_update);
        btn_Update.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    String txt_newTitle = nameView.getText().toString();
                    String txt_newDate = dateView.getText().toString();
                    if ((txt_newTitle.equals(orig_title)) && (txt_newDate.equals(orig_date))){
                        Log.i("DisplayProduct.java","No changes");
                        // do nothing
                    }
                    else{
                        // HTTP PUT
                        Log.i("DisplayProduct.java","Changes found");
                        ServerLink.putData(articleID, txt_newTitle, txt_newDate);
                    }
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            }
        );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

//    @Override
//    public void onClick(View v) {
//        TextView nameView = (TextView)findViewById(R.id.Name_View);
//        TextView dateView = (TextView)findViewById(R.id.Date_View);
//        String new_title = nameView.getText();
//        switch (v.getId()){
//            case R.id.btn_Add:
//                ServerLink.putData(articleID, );
//                break;
//            default:
//                break;
//        }
//    }
}
