package com.example.sa_hw;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class CreateDB {
    public static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + TABLE_NAME + " (" +
                FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_COURSENAME + " TEXT," +
                COLUMN_NAME_COURSEINTRO + " TEXT," +
                COLUMN_NAME_COURSESUITABLE + " TEXT," +
                COLUMN_NAME_COURSEPRICE + " TEXT," +
                COLUMN_NAME_COURSENOTICE + " TEXT," +
                COLUMN_NAME_COURSEREMARK + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
