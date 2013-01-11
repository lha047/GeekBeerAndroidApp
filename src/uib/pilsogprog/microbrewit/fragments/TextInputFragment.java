package uib.pilsogprog.microbrewit.fragments;

import uib.pilsogprog.microbrewit.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TextInputFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.text_input_fragment, container, false);
		return view;
	}
}
