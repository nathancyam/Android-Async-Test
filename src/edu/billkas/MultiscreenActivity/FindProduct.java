package edu.billkas.MultiscreenActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FindProduct extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find);

        // This creates an array of Article classes to transfer to the intent
        new ServerLink().getData(this);

    }

//*********************************************************************
	// Methods to bring up Menu and handle selections.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.findmenu, menu);
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
           case R.id.editMenuItem:
               i = new Intent(this, EditProduct.class);
               startActivity(i);
               return true;
           }
       return false;
   }
// End MENU Methods
// _______________________________________________________________________
	    
} // End ACTIVITY - FindProduct