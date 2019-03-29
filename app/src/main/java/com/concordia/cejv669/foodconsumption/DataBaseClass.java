package com.concordia.cejv669.foodconsumption;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.concordia.cejv669.foodconsumption.Serving.TABLE_NAME;

public class DataBaseClass extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;

    public DataBaseClass(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)  {
        db.execSQL(Serving.CREATE_TABLE);
    }

    public Serving addServing(Serving s) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Serving.COLUMN_ID, s.getRecordId());
        values.put(Serving.COLUMN_DATE, s.getRecordDate()+"");
        values.put(Serving.COLUMN_NAME, s.getName());
        values.put(Serving.COLUMN_CALORIES, s.getCalories());
        values.put(Serving.COLUMN_QUANTITY, s.getQuantity());
        db.insert(Serving.TABLE_NAME, null, values);
        return s;
    }

//    public Serving getServing(long date) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.query(Serving.TABLE_NAME,
//                new String[]{Serving.COLUMN_ID, EmployeeDAO.COLUMN_FIRSTNAME, EmployeeDAO.COLUMN_LASTNAME, EmployeeDAO.COLUMN_INSURED},
//                EmployeeDAO.COLUMN_ID + "=?",
//                new String[]{String.valueOf(empId)}, null, null, null, null
//        );
//        if (c != null)
//            c.moveToFirst();
//        Employee employee = new Employee();
//        employee.setId(c.getInt(c.getColumnIndex(EmployeeDAO.COLUMN_ID)));
//        employee.setFirstName(c.getString(c.getColumnIndex(EmployeeDAO.COLUMN_FIRSTNAME)));
//        employee.setLastName(c.getString(c.getColumnIndex(EmployeeDAO.COLUMN_LASTNAME)));
//        employee.setInsured(c.getInt(c.getColumnIndex(EmployeeDAO.COLUMN_INSURED)) != 0);
//        return employee;
//    }
    public List<Serving> getSrvings(){
        List <Serving> servings =new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String slecteQuery="select * from " + Serving.TABLE_NAME;
        Cursor c= db.rawQuery(slecteQuery,null);
        if( c.moveToFirst())
        {
            do{
                Serving serving = new Serving();
                serving.setRecordId(c.getInt(c.getColumnIndex(Serving.COLUMN_ID)));
                serving.setName(c.getString(c.getColumnIndex(Serving.COLUMN_NAME)));
                serving.setRecordDate(Long.parseLong(c.getInt(c.getColumnIndex(Serving.COLUMN_DATE))+""));
                serving.setCalories(c.getInt(c.getColumnIndex(Serving.COLUMN_CALORIES)));
                serving.setQuantity(c.getInt(c.getColumnIndex(Serving.COLUMN_QUANTITY)));
                servings.add(serving);

            }while (c.moveToNext());

        }
        if (c != null)
            c.moveToFirst();
        db.close();
        return servings;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
