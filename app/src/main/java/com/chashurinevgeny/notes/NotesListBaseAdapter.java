package com.chashurinevgeny.notes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 30.04.2017.
 */

public class NotesListBaseAdapter extends BaseAdapter {

    private DBWorkNotesService dbWorkNotesService = new DBWorkNotesService();
    private Context context;

    private List<String> titleNotesList = dbWorkNotesService.getTitleNotesList();
    private List<String> textNotesList = dbWorkNotesService.getTextNotesList();


    NotesListBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return titleNotesList.size();
    }

    @Override
    public Object getItem(int position) {
        return titleNotesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_view, parent, false);
        }

        TextView textTitleNotes = (TextView) convertView.findViewById(R.id.element_list_notes);
        textTitleNotes.setText(titleNotesList.get(position));

        return convertView;
    }

    void addNotes(String titleNotes, String textNotes) {
        Log.d("NotesListBaseAdapter", "addNotes");
        dbWorkNotesService.addNotesTitleInList(titleNotes);
        dbWorkNotesService.addNotesTextInList(textNotes);
        notifyDataSetChanged();
    }
}
