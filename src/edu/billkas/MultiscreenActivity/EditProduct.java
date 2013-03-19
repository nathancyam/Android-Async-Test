package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class EditProduct extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
    }
	
	//*********************************************************************
		// Methods to bring up Menu and handle selections.
		 @Override
		    public boolean onCreateOptionsMenu(Menu menu){
		    	super.onCreateOptionsMenu(menu);
		    	MenuInflater inflater = getMenuInflater();
		    	inflater.inflate(R.menu.editmenu, menu);
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
		    	case R.id.addMenuItem:
		    		i = new Intent(this, AddProduct.class);
		    		startActivity(i);	
		        	return true;
		    	case R.id.delMenuItem:
		    		i = new Intent(this, DeleteProduct.class);
		    		startActivity(i);		
		        	return true;
		    	case R.id.findMenuItem:
		    		i = new Intent(this, FindProduct.class);
		    		startActivity(i);		
		        	return true;
		    	}
		    return false;
		    }
		    // End MENU Methods
		    // _______________________________________________________________________
		    
}  // end ACTIVITY EditProduct
