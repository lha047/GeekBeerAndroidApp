package uib.pilsogprog.microbrewit;

import java.util.List;

import uib.pilsogprog.microbrewit.helpers.BeerDataSource;
import uib.pilsogprog.microbrewit.model.Beer;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;

public class ShowMyBeersActivity extends ListActivity {

	private BeerDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.list_fragment);

	    datasource = new BeerDataSource(this);
	    datasource.open();

	    List<Beer> values = datasource.getAllBeers();

	    // Use the SimpleCursorAdapter to show the
	    // elements in a ListView
	    ArrayAdapter<Beer> adapter = new ArrayAdapter<Beer>(this,
	        android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	}

	
}
