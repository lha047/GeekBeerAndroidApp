package uib.pilsogprog.microbrewit.helpers;

import java.util.List;

import uib.pilsogprog.microbrewit.model.Beer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "BeersMicrobewIt";
 
    // Contacts table name
    public static final String TABLE_BEERS = "beers";
 
    // Contacts Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_STYLE = "style";
    public static final String KEY_BREWERY = "brewery";
    public static final String KEY_MY_RATING = "myrating";
    public static final String KEY_ABV = "abv";
    
	String CREATE_BEERS_TABLE = "CREATE TABLE " + TABLE_BEERS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			"" + KEY_STYLE + " TEXT, " + KEY_BREWERY + " TEXT ," + KEY_MY_RATING + " INT, " + KEY_ABV + " REAL" + ")";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BEERS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BEERS);
 
        // Create tables again
        onCreate(db);
	}

}
