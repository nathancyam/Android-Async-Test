package edu.billkas.MultiscreenActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FindProduct extends ListActivity {
	//String[] articles = ServerLink.getData(1);
	Articles[] art_Array = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find);

        // This creates an array of Article classes to transfer to the intent
        art_Array = ServerLink.getData();

        // Look at the end of the line; art_Array while an array of classes can be attached to the Bundle
		setListAdapter(new ArrayAdapter<Articles>(this,android.R.layout.simple_list_item_1, android.R.id.text1, art_Array));
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			Intent i;
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // This is where we find which ListItem the users has selected
                Articles article = (Articles)getListAdapter().getItem(position);
				i = new Intent(getApplicationContext(), DisplayProduct.class);
                i.putExtra("class_ArticleArray", article);
				startActivity(i);
			}
		});
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