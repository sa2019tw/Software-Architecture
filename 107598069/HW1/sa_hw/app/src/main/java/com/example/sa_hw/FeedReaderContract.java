package com.example.sa_hw;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_COURSENAME = "name";
        public static final String COLUMN_NAME_COURSEINTRO = "introduction";
        public static final String COLUMN_NAME_COURSESUITABLE = "suitable";
        public static final String COLUMN_NAME_COURSEPRICE = "price";
        public static final String COLUMN_NAME_COURSENOTICE = "notice";
        public static final String COLUMN_NAME_COURSEREMARK = "remark";
    }
}
