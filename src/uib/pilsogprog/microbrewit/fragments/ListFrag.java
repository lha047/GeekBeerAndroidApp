package uib.pilsogprog.microbrewit.fragments;

import uib.pilsogprog.microbrewit.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFrag extends ListFragment {


	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		BeerDetailFragment detailView = BeerDetailFragment.getInstance("");
	}

	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.beers, uib.pilsogprog.microbrewit.R.layout.list_fragment));
	}
	
}
