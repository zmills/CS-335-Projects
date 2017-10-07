package com.example.zacharymills.mills_goblirsch_02.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.zacharymills.mills_goblirsch_02.Model.Student;
import com.example.zacharymills.mills_goblirsch_02.R;

import java.util.List;

/**
 * Created by 124488 on 10/4/2017.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>
{

    private final Context mContext;
    private final List<Student> mStudents;
    private final LayoutInflater mLayoutInflater;
    private Student mStudent;

    /***************************************************************************/
    /*                               Constructor                               */
    /***************************************************************************/
    public StudentRecyclerAdapter(Context Context, List<Student> Students)
    {
        mContext = Context;
        mStudents = Students;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /***************************************************************************/
    /*                          Create the view holder                         */
    /***************************************************************************/
    @Override
    public StudentRecyclerAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = mLayoutInflater.inflate(R.layout.item_student_list, parent, false);
        return new StudentRecyclerAdapter.StudentViewHolder(itemView);
    }

    /***************************************************************************/
    /*                          Bind the view holder                           */
    /***************************************************************************/
    @Override
    public void onBindViewHolder(StudentRecyclerAdapter.StudentViewHolder holder, int position)
    {
        mStudent = mStudents.get(position);
        holder.mStudentName.setText(mStudent.getStudentName() + " - ");
        holder.mStudentId.setText(mStudent.getStudentId());
        holder.mStudentClassification.setText("Class: " + mStudent.getStudentClassification());
        holder.mStudentDormRoomNumber.setText("Dorm Room #: " + mStudent.getStudentRoomNumber());
        holder.mStudentIsWorkStudent.setText("Work Student: " + mStudent.getWorkStudent().toString());
        holder.mIsPresent.setText("Present");
        holder.mIsTardy.setText("Tardy");
        holder.mIsAbsent.setText("Absent");
        holder.mIsPresent.setChecked(mStudent.getAttendanceStatus().isPresent());
        holder.mIsTardy.setChecked(mStudent.getAttendanceStatus().isTardy());
        holder.mIsAbsent.setChecked(mStudent.getAttendanceStatus().isAbsent());
    }

    /***************************************************************************/
    /*                          Get the item count                             */
    /***************************************************************************/
    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    /***************************************************************************/
    /*                          Student view holder                            */
    /***************************************************************************/
    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public final TextView mStudentName;
        public final TextView mStudentId;
        public final TextView mStudentClassification;
        public final TextView mStudentDormRoomNumber;
        private final TextView mStudentIsWorkStudent;
        private final RadioButton mIsPresent;
        private final RadioButton mIsTardy;
        private final RadioButton mIsAbsent;


        public StudentViewHolder(View itemView) {
            super(itemView);

            /* Link the ui elements to their id's                              */
            mStudentName = (TextView) itemView.findViewById(R.id.student_name);
            mStudentId = (TextView) itemView.findViewById(R.id.student_id);
            mStudentClassification = (TextView) itemView.findViewById(R.id.student_classification);
            mStudentDormRoomNumber = (TextView) itemView.findViewById(R.id.student_dorm_room_number);
            mStudentIsWorkStudent = (TextView)  itemView.findViewById(R.id.student_is_work_student);
            mIsPresent = (RadioButton) itemView.findViewById(R.id.student_is_present);
            mIsTardy = (RadioButton) itemView.findViewById(R.id.student_is_tardy);
            mIsAbsent = (RadioButton) itemView.findViewById(R.id.student_is_absent);

            mIsPresent.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                {
                    mStudent = mStudents.get(getLayoutPosition());
                    mStudent.getAttendanceStatus().setPresent(true);
                    mStudent.getAttendanceStatus().setTardy(false);
                    mStudent.getAttendanceStatus().setAbsent(false);

                    mIsPresent.setChecked(mStudent.getAttendanceStatus().isPresent());
                    mIsTardy.setChecked(mStudent.getAttendanceStatus().isTardy());
                    mIsAbsent.setChecked(mStudent.getAttendanceStatus().isAbsent());
                }
            });

            mIsTardy.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                {
                    mStudent = mStudents.get(getLayoutPosition());
                    mStudent.getAttendanceStatus().setPresent(false);
                    mStudent.getAttendanceStatus().setTardy(true);
                    mStudent.getAttendanceStatus().setAbsent(false);

                    mIsPresent.setChecked(mStudent.getAttendanceStatus().isPresent());
                    mIsTardy.setChecked(mStudent.getAttendanceStatus().isTardy());
                    mIsAbsent.setChecked(mStudent.getAttendanceStatus().isAbsent());
                }
            });

            mIsAbsent.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                {
                    mStudent = mStudents.get(getLayoutPosition());
                    mStudent.getAttendanceStatus().setPresent(false);
                    mStudent.getAttendanceStatus().setTardy(false);
                    mStudent.getAttendanceStatus().setAbsent(true);

                    mIsPresent.setChecked(mStudent.getAttendanceStatus().isPresent());
                    mIsTardy.setChecked(mStudent.getAttendanceStatus().isTardy());
                    mIsAbsent.setChecked(mStudent.getAttendanceStatus().isAbsent());
                }
            });
        }
    }
}
