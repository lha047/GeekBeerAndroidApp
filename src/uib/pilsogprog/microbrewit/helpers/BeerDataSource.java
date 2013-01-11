package uib.pilsogprog.microbrewit.helpers;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import uib.pilsogprog.microbrewit.model.Beer;

public class BeerDataSource {

	private SQLiteDatabase database;
	private DBHelper dbHelper;
	private String[] allColumns = {DBHelper.KEY_ID, DBHelper.KEY_NAME, 
			DBHelper.KEY_STYLE, DBHelper.KEY_BREWERY, DBHelper.KEY_MY_RATING, DBHelper.KEY_ABV};

	public BeerDataSource(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void open() {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Beer addBeer(Beer beer) {
		ContentValues values = new ContentValues();
		values.put(DBHelper.KEY_NAME, beer.getName());
		values.put(DBHelper.KEY_STYLE, beer.getStyle());
		values.put(DBHelper.KEY_BREWERY, beer.getBrewery());
		values.put(DBHelper.KEY_MY_RATING, beer.getMyRating());
		values.put(DBHelper.KEY_ABV, beer.getABV());
		long insertId = database.insert(DBHelper.TABLE_BEERS, null, values);
		Cursor cursor = database.query(DBHelper.TABLE_BEERS,
				allColumns, DBHelper.KEY_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Beer newBeer = cursorToBeer(cursor);
		cursor.close();
		return newBeer;
	}

//	public Beer getBeer(int id) {}

	public Beer getBeer(String name) {
		Cursor cursor = database.query(DBHelper.TABLE_BEERS, allColumns, DBHelper.KEY_NAME + "=?", new String[] {name}, null, null, null);
		Beer beer = new Beer(cursor.getString(1));
		beer.setStyle(cursor.getString(2));
		beer.setBrewery(cursor.getString(3));
		beer.setMyRating(cursor.getInt(4));
		beer.setABV(cursor.getDouble(5));
		return beer;
	}

//	public List<Beer> getAllBeers() {}
//
//	public int getBeersCount() {}
//
//	public int updateBeer(Beer beer) {}
//
//	public void deleteContact(Beer beer) {}

	private Beer cursorToBeer(Cursor cursor) {

		return new Beer(cursor.getInt(0), cursor.getString(1), 
				cursor.getString(2), cursor.getString(3),
				cursor.getInt(4), cursor.getDouble(5));

	}

}
