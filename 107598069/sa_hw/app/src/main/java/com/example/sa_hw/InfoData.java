package com.example.sa_hw;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class InfoData extends AppCompatActivity {

    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private Button buttonFinishCreate;
    private Button buttonDiscardCreate;
    private EditText courseName;
    private EditText courseIntro;
    private EditText courseSuitable;
    private EditText coursePrice;
    private EditText courseNotice;
    private EditText courseRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_data);

        dbHelper = new FeedReaderDbHelper(this);

        buttonFinishCreate = findViewById(R.id.buttonFinishCreate);
        buttonFinishCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        buttonDiscardCreate = findViewById(R.id.buttonDiscardCreate);
        buttonDiscardCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void insertData(){
        db = dbHelper.getWritableDatabase();

        courseName = findViewById(R.id.courseName);
        courseIntro = findViewById(R.id.courseIntro);
        courseSuitable = findViewById(R.id.courseSuitable);
        coursePrice = findViewById(R.id.coursePrice);
        courseNotice = findViewById(R.id.courseNotice);
        courseRemark = findViewById(R.id.courseRemark);

        String name = courseName.getText().toString().trim();
        String introduction = courseIntro.getText().toString().trim();
        String suitable = courseSuitable.getText().toString().trim();
        String price = coursePrice.getText().toString().trim();
        String notice = courseNotice.getText().toString().trim();
        String remark = courseRemark.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_COURSENAME, name);
        values.put(COLUMN_NAME_COURSEINTRO, introduction);
        values.put(COLUMN_NAME_COURSESUITABLE, suitable);
        values.put(COLUMN_NAME_COURSEPRICE, price);
        values.put(COLUMN_NAME_COURSENOTICE, notice);
        values.put(COLUMN_NAME_COURSEREMARK, remark);

        if ("".equals(name)){
            Toast.makeText(InfoData.this," 課程名稱不可為空白 ! ", Toast.LENGTH_LONG).show();
        }else{
            db.insert(TABLE_NAME, null, values);
            finish();
        }

//        long newRowId = db.insert(TABLE_NAME, null, values);
//        Log.d("ButtonCreate","here!!!");
    }
}
