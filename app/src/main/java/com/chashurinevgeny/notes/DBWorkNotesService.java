package com.chashurinevgeny.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 01.05.2017.
 */

class DBWorkNotesService implements WorkNotesService {

    private List<String> titleNotesList = new ArrayList<>();
    private List<String> textNotesList = new ArrayList<>();

    DBWorkNotesService() {
        titleNotesList.add("Title 1");
        textNotesList.add("Text 1");
        titleNotesList.add("Title 2");
        textNotesList.add("Text 2");
        titleNotesList.add("Title 3");
        textNotesList.add("Text 3");
    }

    @Override
    public void connect() {

    }

    @Override
    public void addNotes(String titleNotes, String textNotes) {
        titleNotesList.add(titleNotes);
        textNotesList.add(textNotes);
    }

    @Override
    public void deleteNotes(int idNotes) {

    }

    @Override
    public void editNotes(String titleNotes, String textNotes, int Notes) {

    }

    @Override
    public String[] returnTitleNotes() {

        String[] titleNotesArray = titleNotesList.toArray(new String[titleNotesList.size()]);

        return titleNotesArray;
    }

    @Override
    public void disconnect() {

    }
}
