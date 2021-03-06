package com.example.zacharymills.mills_goblirsch_02.Model;

import com.example.zacharymills.mills_goblirsch_02.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Zachary Mills on 10/6/2017.
 */

public class CourseDB
{

    private static CourseDB sCourseDB; /* Create single instance of courseDB   */

    private List<Course> mListOfCourses;

    /***************************************************************************/
    /*                               Constructor                               */
    /***************************************************************************/
    private CourseDB()
    {
        /* Add courses to list                                                 */
        mListOfCourses = new ArrayList<>();
        mListOfCourses.add(new Course("New Testament Survey 1", "BI-101", R.drawable.bi_course_icon));
        mListOfCourses.add(new Course("English Grammar", "EN-123", R.drawable.en_course_icon));
        mListOfCourses.add(new Course("Database 1", "CS-303", R.drawable.cs_course_icon));
        mListOfCourses.add(new Course("Mobile Application Programming", "CS-335", R.drawable.cs_course_icon));
        mListOfCourses.add(new Course("Graphics Programming", "CS-441", R.drawable.cs_course_icon));
    }

    /* Return all the courses in the list                                      */
    public List<Course> getAllCourses()
    {
        return mListOfCourses;
    }

    public Course getCourse(UUID id)
    {
        for(Course courseItem : mListOfCourses)
        {
            if(courseItem.getCourseId().equals(id))
            {
                return courseItem;
            }
        }
        return null;
    }

    /* Return the single instance of courseDb                                  */
    public static  CourseDB get()
    {
        /* If no courseDb exist, create one and return it                      */
        if(sCourseDB == null)
        {
            sCourseDB = new CourseDB();
        }
        return  sCourseDB;
    }
}