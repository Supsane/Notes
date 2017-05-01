package com.chashurinevgeny.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chashurin Evgeny on 01.05.2017.
 */

class DBWorkNotesService implements WorkNotesService {

    private List <String> titleNotes = new ArrayList<>();
    private List <String> textNotes = new ArrayList<>();

    DBWorkNotesService () {
        titleNotes.add(0, "Title 1");
        textNotes.add(0, "Text 1");
        titleNotes.add(0, "Title 2");
        textNotes.add(0, "Text 2");
        titleNotes.add(0, "Title 3");
        textNotes.add(0, "Text 3");
    }

    @Override
    public void connect() {

    }

    @Override
    public void addNotes(String titleNotes, String textNotes) {

    }

    @Override
    public void deleteNotes(int idNotes) {

    }

    @Override
    public void editNotes(String titleNotes, String textNotes, int Notes) {

    }

    @Override
    public String[] returnTitleNotes() {

        String[] titleNotesArray = titleNotes.toArray(new String[titleNotes.size()]);

        return titleNotesArray;
    }

    @Override
    public void disconnect() {

    }
}
