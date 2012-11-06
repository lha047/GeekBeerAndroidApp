package uib.pilsogprog.geekbeer;

import android.R.anim;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

@SuppressLint({ "NewApi", "NewApi" })
public class MainActivity extends FragmentActivity {

    private Fragment mTopFragment;
	private FragmentManager mFragmentManager;
	private FragmentTransaction fragmentTransaction;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        
        mFragmentManager = getSupportFragmentManager();
        mTopFragment = mFragmentManager.findFragmentById(R.id.fragment_content);
        if(mTopFragment == null) {
        	replaceFragment(R.id.fragment_content, new SearchFragment());
        }               
    }
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_beer_menu_item:
			
			return true;
		case R.id.search_menu_item:
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}



	private void replaceFragment(int fragmentContent, Fragment fragment) {
		fragmentTransaction = mFragmentManager.beginTransaction();
		fragmentTransaction.add(fragmentContent, fragment);
		fragmentTransaction.commit();
	}
    
	public void submit(View view) {
		gotToSearchResultView();
	}

	private void gotToSearchResultView() {
		FragmentManager fm = getSupportFragmentManager();
		if(fm != null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.main_content, new BasicFragment());
			ft.commit();
		}
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
}
