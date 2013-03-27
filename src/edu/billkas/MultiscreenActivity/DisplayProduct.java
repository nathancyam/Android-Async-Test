package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
            setTitle(printArticle.title);
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
                        finish();
                    }
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            }
        );
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent i;
        switch(item.getItemId()){
            case R.id.homeMenuItem:
                i = new Intent(this, MultiScreenActivityActivity.class);
                startActivity(i);
                return true;
            case R.id.updateMenuItem:
                // Update shit
                return true;
            case R.id.deleteMenuItem:
                // Delete shit
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete this article?");
                // Setting Positive "Yes" Button

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        ServerLink.deleteData(articleID);
                        finish();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
                return true;
            }
        return false;
    }
}
