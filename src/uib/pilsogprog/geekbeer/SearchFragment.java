package uib.pilsogprog.geekbeer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SearchFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.search_fragment, container, false);
		Button submit = (Button) view.findViewById(R.id.button1);
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				gotToSearchResultView(v);				
			}
		});
		return view;
	}

	private void gotToSearchResultView(View v) {
		FragmentManager fm = getFragmentManager();
		
		if(fm != null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.main_content, new DetailsFragment());
			ft.commit();
		}
		
	}
	

}
