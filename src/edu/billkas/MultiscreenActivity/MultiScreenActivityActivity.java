package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class MultiScreenActivityActivity extends Activity {
    
	
	// **************************************************
	// Method: onCreate
	// Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Here we create the SpinnerAdapter
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.action_list,
                android.R.layout.simple_spinner_dropdown_item);
    }
    // End Method onCreate
    // _____________________________________________________
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
 // *********************************************************************
  	// Method 
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	Intent i;
    	switch(item.getItemId()){
            case R.id.findMenuItem:
                i = new Intent(this, FindProduct.class);
                startActivity(i);
                return true;
            case R.id.addMenuItem:
                i = new Intent(this, AddProduct.class);
                startActivity(i);
                return true;
    	}
        return false;
    }
    
    
}// End Activity