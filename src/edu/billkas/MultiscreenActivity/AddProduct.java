package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddProduct extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
    }
	
	public void submit_Article(View view){
		EditText field_Title = (EditText) findViewById(R.id.txt_Title);
		EditText field_Date = (EditText) findViewById(R.id.txt_Date);
	    String str_Title = field_Title.getText().toString();
	    String str_Date = field_Date.getText().toString();
	    try {
			ServerLink.postData(str_Title, str_Date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// *********************************************************************
  	// Methods to bring up Menu and handle selections.
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu){
	    	super.onCreateOptionsMenu(menu);
	    	MenuInflater inflater = getMenuInflater();
	    	inflater.inflate(R.menu.addmenu, menu);
	    	return true;
	    }
	    
	  	// Method to handle menu selections
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item){
	    	Intent i;
	    	switch(item.getItemId()){
	    	case R.id.homeMenuItem:
	    		i = new Intent(this, MultiScreenActivityActivity.class);
	    		startActivity(i);	
	    		return true;
	    	case R.id.findMenuItem:
	    		i = new Intent(this, FindProduct.class);
	    		startActivity(i);	
	        	return true;
	    	case R.id.delMenuItem:
	    		i = new Intent(this, DeleteProduct.class);
	    		startActivity(i);		
	        	return true;
	    	case R.id.editMenuItem:
	    		i = new Intent(this, EditProduct.class);
	    		startActivity(i);		
	        	return true;
	    	}
	    return false;
	    }
    // End MENU Methods
    // _______________________________________________________________________
	    
}
