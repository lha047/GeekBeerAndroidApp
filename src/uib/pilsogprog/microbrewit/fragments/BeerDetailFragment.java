package uib.pilsogprog.microbrewit.fragments;

import uib.pilsogprog.microbrewit.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BeerDetailFragment extends Fragment{

	public static BeerDetailFragment getInstance(String beer) {
		BeerDetailFragment frag = new BeerDetailFragment();
		Bundle bundle = new Bundle();
		bundle.putString("beer", beer);
		frag.setArguments(bundle);
		return frag;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
//		Intent intent = getActivity().getIntent();
		View view  = inflater.inflate(R.layout.detail_fragment, container, false);
		
		return view;
	}

	
}
