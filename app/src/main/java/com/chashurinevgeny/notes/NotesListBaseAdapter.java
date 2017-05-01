package com.chashurinevgeny.notes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chashurin Evgeny on 30.04.2017.
 */

public class NotesListBaseAdapter extends BaseAdapter {

    private DBWorkNotesService dbWorkNotesService = new DBWorkNotesService();
    private LayoutInflater layoutInflater;
    private Context context;

    private String[] titleNotes = dbWorkNotesService.returnTitleNotes();


    public NotesListBaseAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return titleNotes.length;
    }

    @Override
    public Object getItem(int position) {
        return titleNotes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_view, parent, false);
        }

        TextView textTitleNotes = (TextView) convertView.findViewById(R.id.element_list_notes);
        textTitleNotes.setText(titleNotes[position]);

        return convertView;
    }
}
