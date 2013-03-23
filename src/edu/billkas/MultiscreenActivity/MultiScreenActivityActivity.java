package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class MultiScreenActivityActivity extends Activity implements FindProduct.OnProductSelectedListener{
    
	
	// **************************************************
	// Method: onCreate
	// Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            FindProduct firstFragment = new FindProduct();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }

        // Here we create the SpinnerAdapter
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.action_list,
                android.R.layout.simple_spinner_dropdown_item);
    }

    // If the product is selected, then we show it on the DisplayProduct.java fragment
    public void onProductSelected(Articles article){
//        Log.i("Main","article details from class: " + product.id + product.title + product.date);
        DisplayProduct newFragment = new DisplayProduct();
        Bundle bundle = new Bundle();
        // Add items to the bundle to be transferred to the new fragment (DisplayProduct fragment)
        bundle.putInt("id", article.id);
        bundle.putString("title", article.title);
        bundle.putString("date", article.date);
        newFragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

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