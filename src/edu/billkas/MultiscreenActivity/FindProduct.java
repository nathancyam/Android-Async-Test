package edu.billkas.MultiscreenActivity;

import android.*;
import android.R;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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

import java.nio.channels.AsynchronousCloseException;

public class FindProduct extends ListFragment {
    OnProductSelectedListener mCallback;

    public interface OnProductSelectedListener{
        public void onProductSelected(Articles article);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            mCallback = (OnProductSelectedListener) activity;
        }
        catch(Exception ex){
            throw new ClassCastException(activity.toString()
                    + " must implement OnProductSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the event to the host activity
        Log.i("FindProduct.java","Clicked on Object: " + position);
        Articles article = (Articles)getListAdapter().getItem(position);
        mCallback.onProductSelected(article);
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        getActivity().invalidateOptionsMenu();
        new getArticles().execute();
        setHasOptionsMenu(true);
    }

    private class getArticles extends AsyncTask<Void, Void, Articles[]>{

        @Override
        protected Articles[] doInBackground(Void... params) {
            Articles[] articlesA;
            articlesA = ServerLink.getData();
            return articlesA;
        }

        protected void onPostExecute(Articles[] articlesA){
            try{
                setListAdapter(new ArrayAdapter<Articles>(getActivity(), R.layout.simple_list_item_1, articlesA));
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

//*********************************************************************
//	Methods to bring up Menu and handle selections.
//*********************************************************************

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        Log.i("FindProduct.java","Creating Options Menu");
    }
	    
    // Method to handle menu selections
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
       return false;
   }
}