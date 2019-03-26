package com.example.sa_hw;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.BaseColumns._ID;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;

public class updateData extends AppCompatActivity {

    private Button buttonFinishUpdate;
    private Button buttonDiscardUpdate;
    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private EditText updateCourseName;
    private EditText updateCourseIntro;
    private EditText updateCourseSuitable;
    private EditText updateCoursePrice;
    private EditText updateCourseNotice;
    private EditText updateCourseRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        dbHelper = new FeedReaderDbHelper(this);

        setData();

        buttonFinishUpdate = findViewById(R.id.buttonFinishUpdate);
        buttonFinishUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String id = intent.getStringExtra("message");
                Log.d("id from editTextId", id);
                updateData(id);
            }
        });

        buttonDiscardUpdate = findViewById(R.id.buttonDiscardUpdate);
        buttonDiscardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void updateData(String id){
        db = dbHelper.getWritableDatabase();

        updateCourseName = findViewById(R.id.updateCourseName);
        updateCourseIntro = findViewById(R.id.updateCourseIntro);
        updateCourseSuitable = findViewById(R.id.updateCourseSuitable);
        updateCoursePrice = findViewById(R.id.updateCoursePrice);
        updateCourseNotice = findViewById(R.id.updateCourseNotice);
        updateCourseRemark = findViewById(R.id.updateCourseRemark);

        String name = updateCourseName.getText().toString().trim();
        String introduction = updateCourseIntro.getText().toString().trim();
        String suitable = updateCourseSuitable.getText().toString().trim();
        String price = updateCoursePrice.getText().toString().trim();
        String notice = updateCourseNotice.getText().toString().trim();
        String remark = updateCourseRemark.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_COURSENAME, name);
        values.put(COLUMN_NAME_COURSEINTRO, introduction);
        values.put(COLUMN_NAME_COURSESUITABLE, suitable);
        values.put(COLUMN_NAME_COURSEPRICE, price);
        values.put(COLUMN_NAME_COURSENOTICE, notice);
        values.put(COLUMN_NAME_COURSEREMARK, remark);

        String selection = _ID + " = ?";
        String[] selectionArgs = { id };

        if ("".equals(name)){
            Toast.makeText(updateData.this," 課程名稱不可為空白 ! ", Toast.LENGTH_LONG).show();
        }else{
            db.update(
                    TABLE_NAME,
                    values,
                    selection,
                    selectionArgs);
            finish();
        }
    }

    public void setData(){
        Intent intent = getIntent();
        String courseName = intent.getStringExtra("courseName");
        String introduction = intent.getStringExtra("introduction");
        String suitable = intent.getStringExtra("suitable");
        String price = intent.getStringExtra("price");
        String notice = intent.getStringExtra("notice");
        String remark = intent.getStringExtra("remark");
        Log.d("Data Here!!!!",courseName + "\n" +introduction+"\n"+suitable+"\n"+price+"\n"+notice+"\n"+remark);

        updateCourseName = findViewById(R.id.updateCourseName);
        updateCourseIntro = findViewById(R.id.updateCourseIntro);
        updateCourseSuitable = findViewById(R.id.updateCourseSuitable);
        updateCoursePrice = findViewById(R.id.updateCoursePrice);
        updateCourseNotice = findViewById(R.id.updateCourseNotice);
        updateCourseRemark = findViewById(R.id.updateCourseRemark);

        updateCourseName.setText(courseName);
        updateCourseIntro.setText(introduction);
        updateCourseSuitable.setText(suitable);
        updateCoursePrice.setText(price);
        updateCourseNotice.setText(notice);
        updateCourseRemark.setText(remark);
    }
}
