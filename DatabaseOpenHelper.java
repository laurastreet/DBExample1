package edu.gmu.cs477.dbexampleartists;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    final private static String CREATE_CMD =
            "CREATE TABLE artists (" + MainActivity._ID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + MainActivity.ARTIST_NAME + " TEXT NOT NULL)";

    final private static String NAME = "artist_db";
    final private static Integer VERSION = 2;
    final private Context context;

    public DatabaseOpenHelper(Context context) {
        super(context, NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS artists");
        onCreate(db);


    }

    void deleteDatabase ( ) {
        context.deleteDatabase(NAME);
    }
}
