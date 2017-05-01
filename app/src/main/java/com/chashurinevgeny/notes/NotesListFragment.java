package com.chashurinevgeny.notes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NotesListFragment extends Fragment {

    ListView listNotes;
    NotesListBaseAdapter notesListBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_view_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
           listNotes = (ListView) view.findViewById(R.id.list_view);
            notesListBaseAdapter = new NotesListBaseAdapter(view.getContext());
            listNotes.setAdapter(notesListBaseAdapter);
        }
    }
}
