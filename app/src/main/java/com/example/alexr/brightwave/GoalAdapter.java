package com.example.alexr.brightwave;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GoalAdapter extends ArrayAdapter<Goal> {
    public GoalAdapter(Activity context, ArrayList<Goal> goals) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, goals);
    }

    /**
     * The getView method gets called when the ListView is trying to display a list of items at a given position
     * The ListView will pass in a POTENTIAL view that we could reuse.
     *
     * The parameter convertView is an existing View that we can reuse.
     * When convertView == null, that means there is no View that we can reuse.
     * This situation is common when you first open up an Activity, and you're creating items in the list for the first time to fill up the screen.
     *
     * The parameter known as parent refers to the parent ViewGroup for the all items, which is the ListView itself.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.single_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Goal currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.goal_text_view);
        miwokTextView.setText(currentWord.getMainGoal());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.subgoal_text_view);
        defaultTextView.setText(currentWord.getSubGoal());

        return listItemView;
    }
}
