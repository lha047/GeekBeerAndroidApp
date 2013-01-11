package uib.pilsogprog.microbrewit;

import uib.pilsogprog.microbrewit.fragments.BasicFragment;
import uib.pilsogprog.microbrewit.fragments.SearchFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment searchFragment = fragmentManager.findFragmentById(R.id.fragment_content);
        if(searchFragment == null) {
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        	fragmentTransaction.add(R.id.fragment_content, new SearchFragment());
        	fragmentTransaction.commit();
        }
        
    }
    
	public void submit(View view) {
		gotToSearchResultView();
	}

	private void gotToSearchResultView() {
		FragmentManager fm = getSupportFragmentManager();
		if(fm != null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.fragment_content, new BasicFragment());
			ft.commit();
		}
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
