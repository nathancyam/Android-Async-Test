package edu.billkas.MultiscreenActivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class DisplayProduct extends Fragment {

    public static int id;
    public static String title = null;
    public static String date = null;
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.display);
//		TextView nameView = (TextView)findViewById(R.id.Name_View);
//      TextView dateView = (TextView)findViewById(R.id.Date_View);
//		Bundle extras = getIntent().getExtras();
//		if(extras != null) {
//            Articles printArticle = (Articles)getIntent().getExtras().get("class_ArticleArray");
//            nameView.setText(printArticle.title);
//            dateView.setText(printArticle.date);
//		}
//	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        title = bundle.getString("title");
        date = bundle.getString("date");
        Log.i("DisplayProduct",id + title + date);
        View viewFrag =  inflater.inflate(R.layout.display, container, false);
        TextView nameView = (TextView)viewFrag.findViewById(R.id.Name_View);
        TextView dateView = (TextView)viewFrag.findViewById(R.id.Date_View);
        nameView.setText(title);
        dateView.setText(date);
        return viewFrag;
    }

    public void post_NewArticle(View view){
        TextView txt_newTitle = (EditText)getView().findViewById(R.id.Name_View);
        TextView txt_newDate = (EditText)getView().findViewById(R.id.Date_View);
        String newTitle = txt_newTitle.getText().toString();
        String newDate = txt_newDate.getText().toString();
        Log.i("DisplayProduct.java","Adding new items to database");
        ServerLink.postData(newTitle, newDate);
    }
}
