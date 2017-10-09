package com.example.zacharymills.mills_goblirsch_02;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
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
    private TextView mCourseTitleHeader;
    private TextView mCourseCodeHeader;
    private RadioButton mAllIsPresent;
    private RadioButton mAllIsTardy;
    private RadioButton mAllIsAbsent;
    private RecyclerView mRecyclerStudents;
    private LinearLayoutManager mStudentLayoutManager;

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

        mCourseTitleHeader = (TextView) findViewById(R.id.course_title_header);
        mCourseCodeHeader = (TextView) findViewById(R.id.course_code_header);
        mAllIsPresent = (RadioButton) findViewById(R.id.all_is_present);
        mAllIsTardy = (RadioButton) findViewById(R.id.all_is_tardy);
        mAllIsAbsent = (RadioButton) findViewById(R.id.all_is_absent);

        /* Set label and header texts                                          */
        mCourseTitleHeader.setText(course.getCourseTitle() + " - ");
        mCourseCodeHeader.setText(course.getCourseCode());
        mAllIsPresent.setText("Present");
        mAllIsTardy.setText("Tardy");
        mAllIsAbsent.setText("Absent");

        /* Set all student's attendance status to present                      */
        mAllIsPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               for (int index = 0; index < mListOfStudents.size(); index++ )
               {
                   mListOfStudents.get(index).getAttendanceStatus().setPresent(true);
                   mListOfStudents.get(index).getAttendanceStatus().setTardy(false);
                   mListOfStudents.get(index).getAttendanceStatus().setAbsent(false);
               }

               mAllIsPresent.setChecked(true);
               mAllIsTardy.setChecked(false);
               mAllIsAbsent.setChecked(false);
               mStudentRecyclerAdapter.notifyDataSetChanged();
            }
        });

        /* Set all student's attendance status to Tardy                        */
        mAllIsTardy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for (int index = 0; index < mListOfStudents.size(); index++ )
                {
                    mListOfStudents.get(index).getAttendanceStatus().setPresent(false);
                    mListOfStudents.get(index).getAttendanceStatus().setTardy(true);
                    mListOfStudents.get(index).getAttendanceStatus().setAbsent(false);
                }

                mAllIsPresent.setChecked(false);
                mAllIsTardy.setChecked(true);
                mAllIsAbsent.setChecked(false);
                mStudentRecyclerAdapter.notifyDataSetChanged();
            }
        });

        /* Set all student's attendance status to Absent                       */
        mAllIsAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for (int index = 0; index < mListOfStudents.size(); index++ )
                {
                    mListOfStudents.get(index).getAttendanceStatus().setPresent(false);
                    mListOfStudents.get(index).getAttendanceStatus().setTardy(false);
                    mListOfStudents.get(index).getAttendanceStatus().setAbsent(true);
                }

                mAllIsPresent.setChecked(false);
                mAllIsTardy.setChecked(false);
                mAllIsAbsent.setChecked(true);
                mStudentRecyclerAdapter.notifyDataSetChanged();
            }
        });

        /* Initialize the content to be displayed                              */
        initializeDisplayContent();
    }

    /***************************************************************************/
    /*                   Initialize the content to be displayed                */
    /***************************************************************************/
    private void initializeDisplayContent()
    {
        /* Link the ui elements to their id's                                  */
        mRecyclerStudents = (RecyclerView) findViewById(R.id.list_students);
        mStudentLayoutManager = new LinearLayoutManager(this);
        mRecyclerStudents.setLayoutManager(mStudentLayoutManager);
        mRecyclerStudents.setNestedScrollingEnabled(false);

        /* Create the student adapter                                          */
        mStudentRecyclerAdapter = new StudentRecyclerAdapter(this, mListOfStudents);
        mRecyclerStudents.setAdapter(mStudentRecyclerAdapter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mStudentRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mStudentRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
