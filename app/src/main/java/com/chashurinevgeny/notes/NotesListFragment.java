package com.chashurinevgeny.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

public class NotesListFragment extends Fragment {

    ListView listNotes;
    NotesListBaseAdapter notesListBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view_fragment, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("NotesListFragment", "onStart");
        View view = getView();
        if (view != null) {
            listNotes = (ListView) view.findViewById(R.id.list_view);
            notesListBaseAdapter = new NotesListBaseAdapter(view.getContext());
            listNotes.setAdapter(notesListBaseAdapter);
            listNotesBehavior();
        }
    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d("NotesListFragment", "onResume");
//        updateListNotes();
//    }

    private void listNotesBehavior() {
        listNotes.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listNotes.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {


                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    private void updateListNotes() {
        notesListBaseAdapter.notifyDataSetChanged();
    }
}
