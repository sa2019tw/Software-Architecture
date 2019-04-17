package com.example.sa_hw;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_page2, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView dataId = view.findViewById(R.id.dataId);
        TextView dataName = view.findViewById(R.id.dataName);
        TextView dataIntro = view.findViewById(R.id.dataIntro);
        TextView dataSuitable = view.findViewById(R.id.dataSuitable);
        TextView dataPrice = view.findViewById(R.id.dataPrice);
        TextView dataNotice = view.findViewById(R.id.dataNotice);
        TextView dataRemark = view.findViewById(R.id.dataRemark);

        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
        String suitable = cursor.getString(cursor.getColumnIndexOrThrow("suitable"));
        String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
        String notice = cursor.getString(cursor.getColumnIndexOrThrow("notice"));
        String remark = cursor.getString(cursor.getColumnIndexOrThrow("remark"));

        dataId.setText("ID : "+Integer.toString(id));
        dataName.setText("課程名稱 : " + name);
        dataIntro.setText("課程說明 : " + introduction);
        dataSuitable.setText("適合對象 : " + suitable);
        dataPrice.setText("定價 : " + price);
        dataNotice.setText("注意事項 : " + notice);
        dataRemark.setText("備註 : " + remark);
    }
}