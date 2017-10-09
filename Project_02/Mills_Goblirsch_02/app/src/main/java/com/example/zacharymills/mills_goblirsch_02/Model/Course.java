package com.example.zacharymills.mills_goblirsch_02.Model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zachary Mills on 9/30/2017.
 */

public class Course {

    private int courseId;
    private String courseTitle;
    private String courseCode;
    private List<Student> ListOfStudents = new ArrayList<>();
    private int courseImageResource;

    /***************************************************************************/
    /*                               Constructor                               */
    /***************************************************************************/
    public Course(int courseId, String courseTitle, String courseCode, int courseImageResource)
    {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.courseImageResource = courseImageResource;

        /* Generate a list of students for the course                          */
        GenerateStudents();
    }

    /***************************************************************************/
    /*              Generate a list of students for the course                 */
    /***************************************************************************/
    private void GenerateStudents() {

        ListOfStudents.add(new Student("124488", "Zach Mills", "Senior", "6421", false));
        ListOfStudents.add(new Student("124411", "Peter Parker", "Freshman", "6421", true));
        ListOfStudents.add(new Student("124788", "Fabrice Francois", "Senior", "6421", false));
        ListOfStudents.add(new Student("124688", "Marcelino Augello", "Junior", "6821", false));
        ListOfStudents.add(new Student("127321", "Nick Goblirsch", "Junior", "2452", true));
        Collections.shuffle(ListOfStudents);
    }

    /* Getters                                                                 */
    public int getCourseId() { return courseId; }
    public String getCourseTitle() {
        return courseTitle;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public int getCourseImageResource() {return courseImageResource; }
    public List<Student> getAllStudents()
    {
        return ListOfStudents;
    }
}
