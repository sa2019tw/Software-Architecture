package com.example.sa_hw.HW2UseCase.ReadCourse;

import android.content.Context;
import android.widget.ListView;

public class ReadCourseInputImpl implements ReadCourseInput {
    Context context;
    ListView listView;

    public ReadCourseInputImpl(Context context, ListView listView){
        setContext(context);
        setListView(listView);
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public ListView getListView() {
        return listView;
    }

    @Override
    public void setListView(ListView listView) {
        this.listView = listView;
    }
}
