package com.chashurinevgeny.notes;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Chashurin Evgeny on 30.04.2017.
 */

public class DBNotes extends BaseAdapter {

    private String titleNotes;
    private String textNotes;
    

    public DBNotes(String titleNotes, String textNotes) {
        this.titleNotes = titleNotes;
        this.textNotes = textNotes;
    }

    public String getTitleNotes() {
        return titleNotes;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public static final DBNotes[] notes = {
            new DBNotes("Title 1", "Text 1"),
            new DBNotes("Title 2", "Text 2"),
            new DBNotes("Title 3", "Text 3"),
            new DBNotes("Title 4", "Text 4"),
            new DBNotes("Title 5", "Text 5"),
            new DBNotes("Title 6", "Text 6"),
    };

    @Override
    public String toString() {
        return this.titleNotes;
    }
}
