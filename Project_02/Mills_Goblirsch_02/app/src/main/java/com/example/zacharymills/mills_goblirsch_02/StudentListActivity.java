package com.example.zacharymills.mills_goblirsch_02;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.zacharymills.mills_goblirsch_02.Adapters.StudentRecyclerAdapter;
import com.example.zacharymills.mills_goblirsch_02.Model.Course;
import com.example.zacharymills.mills_goblirsch_02.Model.CourseDB;
import com.example.zacharymills.mills_goblirsch_02.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity
{
    private StudentRecyclerAdapter mStudentRecyclerAdapter;
    private CourseDB mCourseDB = CourseDB.get();
    private List<Course> mListOfCourses = mCourseDB.getAllCourses();
    private List<Student> mListOfStudents;
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list_activity_layout);

        /* Grab the course position from the incoming intent                   */
        mPosition = getIntent().getExtras().getInt("CoursePosition");
        Course course = mListOfCourses.get(mPosition);

        /* Get the list of students in the course                              */
        mListOfStudents = course.getAllStudents();

        /* Initialize the content to be displayed                              */
        initializeDisplayContent();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mStudentRecyclerAdapter.notifyDataSetChanged();
    }

    /***************************************************************************/
    /*                   Initialize the content to be displayed                */
    /***************************************************************************/
    private void initializeDisplayContent()
    {
        /* Link the ui elements to their id's                                  */
        final RecyclerView recyclerStudents = (RecyclerView) findViewById(R.id.list_students);
        final LinearLayoutManager studentLayoutManager = new LinearLayoutManager(this);
        recyclerStudents.setLayoutManager(studentLayoutManager);

        /* Create the student adapter                                          */
        mStudentRecyclerAdapter = new StudentRecyclerAdapter(this, mListOfStudents);
        recyclerStudents.setAdapter(mStudentRecyclerAdapter);
    }
}
