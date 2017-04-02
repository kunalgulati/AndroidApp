package com.SFU.G1.SFUResources;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {

    private Context mContext;
    private String Display;
    private int Total_Rows = 0;
    private int FacultyIndex = 0;
    int temp =0 ;
    // Image
    //private int[] Imageid;

    public CustomGrid(Context c,String TempName, int TempRows, int Temp_FacultyIndex /* , int[] Imageid*/ ) {
        mContext = c;

        // this.Imageid = Imageid;      For adding a custtom image
        this.Display = TempName;
        this.Total_Rows = TempRows;     // Assigning the total number of elements in the Depratment Array
        this.FacultyIndex = Temp_FacultyIndex; // Assigning the Index of the Faculty
    }

    public CustomGrid(Context c, String faculty) {
        mContext = c;
    }

    @Override
    public int getCount() {
        if (Display == "faculty")
        {
            return DepartmentList.DepartmentInfo.Faculty.length;
        }
        else
        {
            //Change
            return DepartmentList.DepartmentInfo.Department[FacultyIndex].length;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.activity_custom_grid, null);


            TextView textView = (TextView) grid.findViewById(R.id.grid_text);

            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);


            if (Display == "faculty")
            {
                textView.setText(DepartmentList.DepartmentInfo.Faculty[position]);
                imageView.setImageResource(R.drawable.event);
            }
            else
            {
                textView.setText(DepartmentList.DepartmentInfo.Department[FacultyIndex][position]);
                imageView.setImageResource(R.drawable.event);
            }

            Log.d("Not me", " baba");

        }

        else
        {


            Log.d("Me", String.valueOf(temp));
            temp ++;
            grid = (View) convertView;
        }

        return grid;

    }


    private String[] mThumbTexts = {
            "Facebook", "Flickr", "Gmail", "LinkedIn", "Picasa", "Myspace", "RSS", "Skype", "Tuenti",
            "Twitter", "WindowsLive", "Vimeo", "Yahoo", "Otros"
    };
}
