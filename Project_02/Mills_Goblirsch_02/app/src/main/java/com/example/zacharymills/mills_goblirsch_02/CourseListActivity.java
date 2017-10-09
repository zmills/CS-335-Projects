package com.example.zacharymills.mills_goblirsch_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zacharymills.mills_goblirsch_02.Adapters.CourseRecyclerAdapter;
import com.example.zacharymills.mills_goblirsch_02.Model.Course;
import com.example.zacharymills.mills_goblirsch_02.Model.CourseDB;

import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends AppCompatActivity
{
    private CourseRecyclerAdapter mCourseRecyclerAdapter;
    private CourseDB mCourseDB = CourseDB.get();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list_activity_layout);

        /* Initialize the content to be displayed                              */
        initializeDisplayContent();
    }

    /***************************************************************************/
    /*                   Initialize the content to be displayed                */
    /***************************************************************************/
    private void initializeDisplayContent()
    {
        /* Link the ui elements to their id's                                  */
        final RecyclerView recyclerCourses = (RecyclerView) findViewById(R.id.list_courses);
        final LinearLayoutManager coursesLayoutManager = new LinearLayoutManager(this);
        recyclerCourses.setLayoutManager(coursesLayoutManager);
        recyclerCourses.setNestedScrollingEnabled(false);

        /* Create the course adapter                                           */
        mCourseRecyclerAdapter = new CourseRecyclerAdapter(this, mCourseDB.getAllCourses());
        recyclerCourses.setAdapter(mCourseRecyclerAdapter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mCourseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mCourseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }
}
