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

    private static class ViewHolder{
        private TextView tx_id;
        private TextView tx_name;
        private TextView tx_intorduction;
        private TextView tx_suitable;
        private TextView tx_price;
        private TextView tx_notice;
        private TextView tx_remark;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_list_view,parent,false);

//viewholder跑的

        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tx_id = view.findViewById(R.id.dataId);
        viewHolder.tx_name = view.findViewById(R.id.dataName);
        viewHolder.tx_intorduction = view.findViewById(R.id.dataIntro);
        viewHolder.tx_suitable = view.findViewById(R.id.dataSuitable);
        viewHolder.tx_price = view.findViewById(R.id.dataPrice);
        viewHolder.tx_notice = view.findViewById(R.id.dataNotice);
        viewHolder.tx_remark = view.findViewById(R.id.dataRemark);

        view.setTag(viewHolder);
        return view;


/*
**without usecase
//        Course txCourse = new Course();
//        txCourse.setTxId((TextView)view.findViewById(R.id.dataId));
//        txCourse.setTxName((TextView)view.findViewById(R.id.dataName));
//        txCourse.setTxIntroduction((TextView)view.findViewById(R.id.dataIntro));
//        txCourse.setTxSuitable((TextView)view.findViewById(R.id.dataSuitable));
//        txCourse.setTxPrice((TextView)view.findViewById(R.id.dataPrice));
//        txCourse.setTxNotice((TextView)view.findViewById(R.id.dataNotice));
//        txCourse.setTxRemark((TextView)view.findViewById(R.id.dataRemark));
//
//        view.setTag(txCourse);
//        Log. i("cursor" ,"newView=" +view);
//        return view;
*/

// original
//       return LayoutInflater.from(context).inflate(R.layout.activity_list_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Log. i("cursor" ,"bindView=" +view);

//viewholder跑的

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
        String suitable = cursor.getString(cursor.getColumnIndexOrThrow("suitable"));
        String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
        String notice = cursor.getString(cursor.getColumnIndexOrThrow("notice"));
        String remark = cursor.getString(cursor.getColumnIndexOrThrow("remark"));

        viewHolder.tx_id.setText("ID : "+Integer.toString(id));
        viewHolder.tx_name.setText("課程名稱 : " + name);
        viewHolder.tx_intorduction.setText("課程說明 : " + introduction);
        viewHolder.tx_suitable.setText("適合對象 : " + suitable);
        viewHolder.tx_price.setText("定價 : " + price);
        viewHolder.tx_notice.setText("注意事項 : " + notice);
        viewHolder.tx_remark.setText("備註 : " + remark);

/*
original
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
 */
    }
}