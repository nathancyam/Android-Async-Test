package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;

public class AddProduct extends Fragment implements View.OnClickListener {

//	@Override
//    public void onCreateView(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.add, container, false);
        Button addbtn = (Button)v.findViewById(R.id.btn_Add);
        addbtn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        try{
            switch(v.getId()){
                case R.id.btn_Add:
                    Log.i("onClick","Clicking this");
                    submit_Article(v);
                    break;
                default:
                    break;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

	public void submit_Article(View view){
		EditText field_Title = (EditText) getView().findViewById(R.id.txt_Title);
		EditText field_Date = (EditText) getView().findViewById(R.id.txt_Date);
	    final String str_Title = field_Title.getText().toString();
	    final String str_Date = field_Date.getText().toString();
        Runnable runBackground = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                ServerLink.postData(str_Title, str_Date);
            }
        };
        new Thread(runBackground).start();
	}
	
	// *********************************************************************
  	// Methods to bring up Menu and handle selections.
//	 @Override
//	    public boolean onCreateOptionsMenu(Menu menu){
////	    	super.onCreateOptionsMenu(menu);
////	    	MenuInflater inflater = getMenuInflater();
////	    	inflater.inflate(R.menu.addmenu, menu);
//	    	return true;
//	    }
	    
	  	// Method to handle menu selections
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item){
//	    	Intent i;
//	    	switch(item.getItemId()){
//	    	case R.id.homeMenuItem:
//	    		i = new Intent(this, MultiScreenActivityActivity.class);
//	    		startActivity(i);
//	    		return true;
//	    	case R.id.findMenuItem:
//	    		i = new Intent(this, FindProduct.class);
//	    		startActivity(i);
//	        	return true;
//	    	case R.id.delMenuItem:
//	    		i = new Intent(this, DeleteProduct.class);
//	    		startActivity(i);
//	        	return true;
//	    	case R.id.editMenuItem:
//	    		i = new Intent(this, EditProduct.class);
//	    		startActivity(i);
//	        	return true;
//	    	}
	    return false;
	    }

    // End MENU Methods
    // _______________________________________________________________________
	    
}
