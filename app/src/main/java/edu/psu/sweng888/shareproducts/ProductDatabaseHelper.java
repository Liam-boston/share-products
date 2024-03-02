package edu.psu.sweng888.shareproducts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "products_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PRODUCTS = "products";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_SELLER = "seller";
    private static final String KEY_PRICE = "price";

    public ProductDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME + " TEXT," +
                KEY_DESCRIPTION + " TEXT," +
                KEY_SELLER + " TEXT," +
                KEY_PRICE + " INTEGER" + ")";
        db.execSQL(QUERY_CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void populateProductsDatabase() {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        // insert product values into db
        // apple
        values = new ContentValues();
        values.put(KEY_NAME, "Apple");
        values.put(KEY_DESCRIPTION, "Honey-crisp Apple");
        values.put(KEY_SELLER, "Lehman Orchard");
        values.put(KEY_PRICE, 1);
        db.insert(TABLE_PRODUCTS, null, values);

        // doritos
        values = new ContentValues();
        values.put(KEY_NAME, "Doritos");
        values.put(KEY_DESCRIPTION, "Nacho Cheese");
        values.put(KEY_SELLER, "Sheetz");
        values.put(KEY_PRICE, 4);
        db.insert(TABLE_PRODUCTS, null, values);

        // chicken
        values = new ContentValues();
        values.put(KEY_NAME, "Chicken");
        values.put(KEY_DESCRIPTION, "Chicken Breasts");
        values.put(KEY_SELLER, "Perdue");
        values.put(KEY_PRICE, 7);
        db.insert(TABLE_PRODUCTS, null, values);

        // steak
        values = new ContentValues();
        values.put(KEY_NAME, "Steak");
        values.put(KEY_DESCRIPTION, "NY Strip Steaks");
        values.put(KEY_SELLER, "Target");
        values.put(KEY_PRICE, 18);
        db.insert(TABLE_PRODUCTS, null, values);

        // potatoes
        values = new ContentValues();
        values.put(KEY_NAME, "Potatoes");
        values.put(KEY_DESCRIPTION, "5lbs Bag of Russet Potatoes");
        values.put(KEY_SELLER, "Giant");
        values.put(KEY_PRICE, 9);
        db.insert(TABLE_PRODUCTS, null, values);

        // broccoli
        values = new ContentValues();
        values.put(KEY_NAME, "Broccoli");
        values.put(KEY_DESCRIPTION, "Head of Broccoli");
        values.put(KEY_SELLER, "Giant");
        values.put(KEY_PRICE, 3);
        db.insert(TABLE_PRODUCTS, null, values);

        // ice cream
        values = new ContentValues();
        values.put(KEY_NAME, "Ice Cream");
        values.put(KEY_DESCRIPTION, "Mint Chocolate Chip");
        values.put(KEY_SELLER, "Weis");
        values.put(KEY_PRICE, 4);
        db.insert(TABLE_PRODUCTS, null, values);

        // sweet tea
        values = new ContentValues();
        values.put(KEY_NAME, "Sweet Tea");
        values.put(KEY_DESCRIPTION, "Turkey Hill Sweet Tea");
        values.put(KEY_SELLER, "Rutters");
        values.put(KEY_PRICE, 11);
        db.insert(TABLE_PRODUCTS, null, values);

        // snickers
        values = new ContentValues();
        values.put(KEY_NAME, "Snickers");
        values.put(KEY_DESCRIPTION, "King-size Snickers Bar");
        values.put(KEY_SELLER, "Walmart");
        values.put(KEY_PRICE, 2);
        db.insert(TABLE_PRODUCTS, null, values);

        // muffin
        values = new ContentValues();
        values.put(KEY_NAME, "Muffin");
        values.put(KEY_DESCRIPTION, "4-pack Blueberry Muffins");
        values.put(KEY_SELLER, "Weis");
        values.put(KEY_PRICE, 6);
        db.insert(TABLE_PRODUCTS, null, values);

        db.close();
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product (
                        cursor.getString(1), // NAME
                        cursor.getString(2), // DESCRIPTION
                        cursor.getString(3), // SELLER
                        cursor.getInt(4) // PRICE
                );
                products.add(product);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return products;
    }
}