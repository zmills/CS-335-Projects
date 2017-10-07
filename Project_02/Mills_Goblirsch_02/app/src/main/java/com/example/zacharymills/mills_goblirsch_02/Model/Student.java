package com.example.zacharymills.mills_goblirsch_02.Model;

/**
 * Created by Zachary Mills on 10/1/2017.
 */

public class Student
{

    private String studentId;
    private String studentName;
    private String studentClassification;
    private String studentRoomNumber;
    private Boolean isWorkStudent;
    private StudentAttendanceStatus attendanceStatus;

    /***************************************************************************/
    /*                               Constructor                               */
    /***************************************************************************/
    public Student(String studentId, String studentName, String studentClassification, String studentRoomNumber, Boolean isWorkStudent)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClassification = studentClassification;
        this.studentRoomNumber = studentRoomNumber;
        this.isWorkStudent = isWorkStudent;
        attendanceStatus = new StudentAttendanceStatus();
    }

    /* Getters                                                                 */
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getStudentClassification() {
        return studentClassification;
    }
    public String getStudentRoomNumber() {
        return studentRoomNumber;
    }
    public Boolean getWorkStudent() {
        return isWorkStudent;
    }
    public StudentAttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }


    /***************************************************************************/
    /*                      Students attendance status                         */
    /***************************************************************************/
    public class StudentAttendanceStatus
    {
        private boolean isPresent;
        private boolean isTardy;
        private boolean isAbsent;

        public StudentAttendanceStatus() { }

        /* Setters                                                             */
        public void setPresent(boolean present) {
            isPresent = present;
        }
        public void setTardy(boolean tardy) {
            isTardy = tardy;
        }
        public void setAbsent(boolean absent) {
            isAbsent = absent;
        }

        /* Getters                                                             */
        public boolean isPresent() {
            return isPresent;
        }
        public boolean isTardy() {
            return isTardy;
        }
        public boolean isAbsent() {
            return isAbsent;
        }
    }
}
