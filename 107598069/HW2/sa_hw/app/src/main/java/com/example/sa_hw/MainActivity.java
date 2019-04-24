package com.example.sa_hw;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sa_hw.HW2UseCase.CourseRepository;
import com.example.sa_hw.HW2UseCase.CourseRepositoryImpl;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourse;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseImpl;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseInput;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseInputImpl;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseOutput;
import com.example.sa_hw.HW2UseCase.DeleteCourse.DeleteCourseOutputImpl;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourse;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseImpl;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseInput;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseInputImpl;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseOutput;
import com.example.sa_hw.HW2UseCase.ReadCourse.ReadCourseOutputImpl;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Button buttonRead;
    private Button buttonDelete;
    private Button buttonUpdate;
    private Button buttonCreate;
    public ListView list_view_id_data;
    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private EditText editTextId;
    private Cursor saveCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new FeedReaderDbHelper(this);
        editTextId = findViewById(R.id.editTextId);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
            }
        });

        buttonRead = findViewById(R.id.buttonRead);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });

        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString().trim();
                if("".equals(id)){
                    Toast.makeText(MainActivity.this," 請選擇要刪除的課程 ID ! ", Toast.LENGTH_LONG).show();
                }else {
                    deleteData(id);
                }
                readData();
            }
        });

        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString().trim();
                if("".equals(id)){
                    Toast.makeText(MainActivity.this," 請選擇要修改的課程 ID ! ", Toast.LENGTH_LONG).show();
                }else{
                    Intent updateData = new Intent(getApplicationContext(), FillDataActivity.class);
                    setData(updateData);
                    startActivity(updateData);
                }
            }
        });

        list_view_id_data = findViewById(R.id.list_view_id_data);
        list_view_id_data.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> list_view_id_data, View view, int position, long id) {
        saveCursor = (Cursor) list_view_id_data.getItemAtPosition(position);
        Log.d("click",saveCursor.getString(0));
        Toast.makeText(MainActivity.this,"你選擇 " + " ID : " + saveCursor.getString(0) + " , "+ saveCursor.getString(1), Toast.LENGTH_LONG).show();
        editTextId.setText(saveCursor.getString(0));
    }

    public void setData(Intent intent) {
        String id = saveCursor.getString(saveCursor.getColumnIndexOrThrow("_id"));
        String courseName = saveCursor.getString(saveCursor.getColumnIndexOrThrow("name"));
        String introduction = saveCursor.getString(saveCursor.getColumnIndexOrThrow("introduction"));
        String suitable = saveCursor.getString(saveCursor.getColumnIndexOrThrow("suitable"));
        String price = saveCursor.getString(saveCursor.getColumnIndexOrThrow("price"));
        String notice = saveCursor.getString(saveCursor.getColumnIndexOrThrow("notice"));
        String remark = saveCursor.getString(saveCursor.getColumnIndexOrThrow("remark"));

        intent.putExtra("_id", id);
        intent.putExtra("courseName",courseName);
        intent.putExtra("introduction",introduction);
        intent.putExtra("suitable",suitable);
        intent.putExtra("price",price);
        intent.putExtra("notice",notice);
        intent.putExtra("remark",remark);
    }

    public void readData(){

        CourseRepository courseRepository = new CourseRepositoryImpl(this);
        ReadCourse readCourseUC = new ReadCourseImpl(courseRepository);

        ReadCourseInput input = new ReadCourseInputImpl(this,list_view_id_data);
        ReadCourseOutput output = new ReadCourseOutputImpl();

        readCourseUC.execute(input,output);
    }

    public void createData(){
        Intent createData = new Intent(getApplicationContext(), FillDataActivity.class);
        startActivity(createData);
    }

    public void deleteData(String id){
        CourseRepository courseRepository = new CourseRepositoryImpl(this);
        DeleteCourse deleteCourseUC = new DeleteCourseImpl(courseRepository);

        DeleteCourseInput input = new DeleteCourseInputImpl(id);
        DeleteCourseOutput output = new DeleteCourseOutputImpl();

        deleteCourseUC.execute(input,output);
    }
}