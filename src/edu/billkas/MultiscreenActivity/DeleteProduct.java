package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DeleteProduct extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.deletemenu, menu);
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
            case R.id.findMenuItem:
                i = new Intent(this, FindProduct.class);
                startActivity(i);
                return true;
            case R.id.addMenuItem:
                i = new Intent(this, AddProduct.class);
                startActivity(i);
                return true;
            case R.id.editMenuItem:
                i = new Intent(this, EditProduct.class);
                startActivity(i);
                return true;
        }
        return false;
    }
}