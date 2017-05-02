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

    List<String> getTitleNotesList() {
        return titleNotesList;
    }

    List<String> getTextNotesList() {
        return textNotesList;
    }

    void addNotesTitleInList (String titleNotes) {
        titleNotesList.add(titleNotes);
    }

    void addNotesTextInList (String textNotes) {
        textNotesList.add(textNotes);
    }

    @Override
    public void connect() {

    }

    @Override
    public void deleteNotes(int idNotes) {

    }

    @Override
    public void editNotes(String titleNotes, String textNotes, int Notes) {

    }

    @Override
    public void disconnect() {

    }
}
