package com.ogangi.dummyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ogangi.messangi.android.sdk.vo.MessageVO;

import java.util.List;

/**
 * Created by jmtt on 22/10/15.
 * This is a custom example adapter
 */
public class NotificationAdapter extends ArrayAdapter<MessageVO> {


    public NotificationAdapter(Context context, List<MessageVO> notifications) {
        super(context, 0, notifications);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MessageVO notification = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.notification_item, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView content = (TextView) convertView.findViewById(R.id.content);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        // Populate the data into the template view using the data object
        title.setText(notification.getSubject());
        content.setText(notification.getText());
        date.setText(notification.getMessageDate().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}