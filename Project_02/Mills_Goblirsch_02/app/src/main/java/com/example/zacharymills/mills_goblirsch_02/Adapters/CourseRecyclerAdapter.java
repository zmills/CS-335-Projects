package com.example.zacharymills.mills_goblirsch_02.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zacharymills.mills_goblirsch_02.Model.Course;
import com.example.zacharymills.mills_goblirsch_02.R;
import com.example.zacharymills.mills_goblirsch_02.StudentListActivity;

import java.util.List;

/**
 * Created by Zachary Mills on 9/30/2017.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder>
{
    private final Context mContext;
    private final List<Course> mCourses;
    private final LayoutInflater mLayoutInflater;

    /***************************************************************************/
    /*                               Constructor                               */
    /***************************************************************************/
    public CourseRecyclerAdapter(Context Context, List<Course> Courses)
    {
        mContext = Context;
        mCourses = Courses;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /***************************************************************************/
    /*                          Create the view holder                         */
    /***************************************************************************/
    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = mLayoutInflater.inflate(R.layout.item_course_list, parent, false);
        return new CourseViewHolder(itemView);
    }

    /***************************************************************************/
    /*                          Bind the view holder                           */
    /***************************************************************************/
    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position)
    {
        Course course = mCourses.get(position);
        holder.mCourseTitle.setText(course.getCourseTitle());
        holder.mCourseCode.setText(course.getCourseCode());
        holder.mCurrentPosition = position;
        holder.mCourseImage.setImageResource(course.getCourseImageResource());

    }

    /***************************************************************************/
    /*                          Get the item count                             */
    /***************************************************************************/
    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    /***************************************************************************/
    /*                          Course view holder                             */
    /***************************************************************************/
    public class CourseViewHolder extends RecyclerView.ViewHolder {

        public final TextView mCourseTitle;
        public final TextView mCourseCode;
        private final ImageView mCourseImage;
        public int mCurrentPosition;

        /* Constructor                                                         */
        public CourseViewHolder(View itemView)
        {
            super(itemView);

            /* Link the ui elements to their id's                              */

            mCourseTitle = (TextView) itemView.findViewById(R.id.course_title);
            mCourseCode = (TextView) itemView.findViewById(R.id.course_code);
            mCourseImage = (ImageView) itemView.findViewById(R.id.course_image_view);

            /* Start a new activity when the item clicked                      */
            itemView.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                {
                    Intent intent = new Intent(mContext, StudentListActivity.class);
                    intent.putExtra("CoursePosition", mCurrentPosition);
                    //intent.putExtra("CourseTitle", mCourseTitle.toString());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
