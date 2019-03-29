package com.concordia.cejv669.foodconsumption;

import java.util.Date;

public class Serving {
    private int recordId;
    private long recordDate;
    private String name;
    private int calories;
    private int quantity;
    private static int lastUsedId = 0;

    public static final String TABLE_NAME = "serving";
    public static final String COLUMN_ID = "serving_id";
    public static final String COLUMN_DATE= "serving_date";
    public static final String COLUMN_NAME = "serving_name";
    public static final String COLUMN_CALORIES = "serving_calories";
    public static final String COLUMN_QUANTITY = "serving_quantity";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER, " +
            COLUMN_DATE + " TXT, " +
            COLUMN_NAME + " TXT, " +
            COLUMN_CALORIES + " INTEGER, " +
            COLUMN_QUANTITY + " INTEGER )";

    public Serving(long recordDate, String name, int calories, int quantity) {
        lastUsedId++;
        this.recordId = lastUsedId;
        this.recordDate = recordDate;
        this.name = name;
        this.calories = calories;
        this.quantity = quantity;
    }

    public Serving() {
    }

    public long getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Long recordDate) {

        this.recordDate = recordDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
