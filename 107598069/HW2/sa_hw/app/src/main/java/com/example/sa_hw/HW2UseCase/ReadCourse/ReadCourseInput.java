package com.example.sa_hw.HW2UseCase.ReadCourse;

import android.content.Context;
import android.widget.ListView;

public interface ReadCourseInput {
    Context getContext();

    void setContext(Context context);

    ListView getListView();

    void setListView(ListView listView);
}
