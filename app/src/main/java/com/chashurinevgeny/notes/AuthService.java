package com.chashurinevgeny.notes;

/**
 * Created by Chashurin Evgeny on 30.04.2017.
 */

interface AuthService {
    void connect();

    void addNotes(String titleNotes, String textNotes);

    void deleteNotes(int idNotes);

    void editNotes (String titleNotes, String textNotes, int Notes);

    void disconnect();
}
