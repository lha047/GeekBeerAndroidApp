package uib.pilsogprog.geekbeer;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListFrag extends ListFragment {

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Activity activity = getActivity();
		if(activity != null) {
			ListAdapter la = getListAdapter();
			GeekBeerModel model = (GeekBeerModel) la.getItem(position);
		}
		Toast.makeText(activity, "clicked", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Activity activity = getActivity();
		if(activity != null) {
			
			ListAdapter adapter = new ListAdapter() {
				
				public void unregisterDataSetObserver(DataSetObserver observer) {
					// TODO Auto-generated method stub
					
				}
				
				public void registerDataSetObserver(DataSetObserver observer) {
					// TODO Auto-generated method stub
					
				}
				
				public boolean isEmpty() {
					// TODO Auto-generated method stub
					return false;
				}
				
				public boolean hasStableIds() {
					// TODO Auto-generated method stub
					return false;
				}
				
				public int getViewTypeCount() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				public View getView(int position, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					return null;
				}
				
				public int getItemViewType(int position) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				public long getItemId(int position) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				public Object getItem(int position) {
					// TODO Auto-generated method stub
					return null;
				}
				
				public int getCount() {
					// TODO Auto-generated method stub
					return 0;
				}
				
				public boolean isEnabled(int position) {
					// TODO Auto-generated method stub
					return false;
				}
				
				public boolean areAllItemsEnabled() {
					// TODO Auto-generated method stub
					return false;
				}
			};
			setListAdapter(adapter );
		}
	}

	
}
