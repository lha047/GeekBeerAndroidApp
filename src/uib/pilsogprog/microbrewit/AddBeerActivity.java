package uib.pilsogprog.microbrewit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;


import uib.pilsogprog.microbrewit.fragments.TextInputFragment;
import uib.pilsogprog.microbrewit.helpers.BeerDataSource;
import uib.pilsogprog.microbrewit.model.Beer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddBeerActivity extends FragmentActivity {

	private static final int NAME = 0;
	private static final int STYLE = 1;
	private static final int BREWERY = 2;
	private static final int MY_RATING = 3;
	private static final int COMMENT = 4;
	private static final int ABV = 5;
	private static final int FRAGMENT_COUNT = ABV +1;
	private static final String BEER_PREFIX = "BEER";

	private Fragment[] fragments = new Fragment[FRAGMENT_COUNT];
	private boolean restoredFragment = false;
	
	private BeerDataSource db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_beer);
		db = new BeerDataSource(getApplicationContext());
		db.open();
	}
	
	public void submit(View v) {
		EditText name =  (EditText) v.findViewById(R.id.name_text);
		EditText brewery = (EditText) v.findViewById(R.id.brewery_text);
		EditText myRating = (EditText) v.findViewById(R.id.my_rating_text);
		EditText style = (EditText) v.findViewById(R.id.style_text);
		EditText abv = (EditText) v.findViewById(R.id.abv_text);
		
		Beer beer = new Beer(name.getText().toString());
		beer.setStyle(style.getText().toString());
		beer.setBrewery(brewery.getText().toString());
		beer.setMyRating(Integer.valueOf(myRating.getText().toString()));
		beer.setABV(Double.valueOf(abv.getText().toString()));
		
		db.addBeer(beer);
		
	}
	
	/**Responsible for posting to the server.
	 * @author Lisa
	 *
	 */
	private class PostToMicrobrewit extends AsyncTask<JSONObject, Void, String> {

		private String microbrewitServer; //hjemme
		//		private String semanticTouristServer = "http://10.102.58.37:8080/server/"; //skole

		public PostToMicrobrewit(String graphPath) {
			microbrewitServer = "http://www.microbrew.it/ontology/beer/add";
			Log.i("POST", microbrewitServer);
		}

		@Override
		protected String doInBackground(JSONObject... params) {
			String response = post(params[0].toString(), microbrewitServer);
			return response;
		}

		private String post(String entity, String uri) {
			String response = "";
			try {
				HttpPost post = new HttpPost(uri);
				post.setEntity(new StringEntity(entity));
				setHeader(post);
				HttpClient client = new DefaultHttpClient();
				try{
					HttpResponse httpResponse = client.execute(post);
					response = getResponseMessage(httpResponse);
				} catch (HttpHostConnectException e) {
					Log.i("ServerConnection", e.getMessage());
				}
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
		}



		private String getResponseMessage(HttpResponse httpResponse) throws IOException {
			String responseMessage = "";
			InputStream is = httpResponse.getEntity().getContent();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
			String s = "";
			while((s = buffer.readLine()) != null) {
				responseMessage += s;
			}
			return responseMessage;
		}

		private void setHeader(HttpPost post) {
			post.setHeader("Content-Type", "application/json");
			post.setHeader("Accept", "application/json");
		}

		@Override
		protected void onPostExecute(String result) {
			Log.i("postExecute", "somthing with view result");
//			TextView text = (TextView) findViewById(R.id.text_view);
//			text.setText(result);
		}		

	}

	private void insertFragment(int fragmentIndex) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentByTag(tag(fragmentIndex));
		
		if(fragment == null) {
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//			String tag  = tag(fragmentIndex);
//			Log.i("tag", tag);
//			int id = fragmentManager.findFragmentByTag(tag).getId();
			
			fragmentTransaction.add(fragments[fragmentIndex].getId(), placeFragment(fragmentIndex));
			fragmentTransaction.commit();
		}
		
		
//		Fragment fragment = null;
//		if(savedInstanceState != null) {
//			FragmentManager fragmentManager = getSupportFragmentManager();
//			fragment = fragmentManager.getFragment(savedInstanceState, getBundleKey(fragmentIndex));
//		}
//		if (fragment != null) {
//			fragments[fragmentIndex] = fragment;
//			restoredFragment  = true;
//		} else {

//		}
	}

	private Fragment placeFragment(int fragmentIndex) {
		switch (fragmentIndex) {
		case NAME:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		case STYLE:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		case BREWERY:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		case MY_RATING:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		case COMMENT:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		case ABV:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		default:
			fragments[fragmentIndex] = new TextInputFragment();
			break;
		}
		return fragments[fragmentIndex];
	}

	private String tag(int fragmentIndex) {
		return BEER_PREFIX + Integer.toString(fragmentIndex);
	}




}
