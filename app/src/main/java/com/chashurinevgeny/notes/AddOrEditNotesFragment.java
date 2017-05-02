package com.chashurinevgeny.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddOrEditNotesFragment extends Fragment {

    private EditText titleNotesEditText, textNotesEditText;
    private ImageButton ok, back;
    NotesListBaseAdapter notesListBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_or_edite_notes, container, false);
        notesListBaseAdapter = new NotesListBaseAdapter(view.getContext());
        titleNotesEditText = (EditText) view.findViewById(R.id.addNotesHead);
        textNotesEditText = (EditText) view.findViewById(R.id.addNotesText);
        ok = (ImageButton) view.findViewById(R.id.addNotesImageButton);
        back = (ImageButton) view.findViewById(R.id.backImageButton);

        imageButtonOkBehavior();
        imageButtonBackBehavior();

        return view;
    }

    private void imageButtonOkBehavior() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AddOrEditNotesFragment", "onClickAddNotesImageButton");
                String titleNotes = titleNotesEditText.getText().toString();
                String textNotes = textNotesEditText.getText().toString();
                if (titleNotes.equals("") && textNotes.equals("")) {
                    Toast.makeText(v.getContext(), R.string.name_text_empty, Toast.LENGTH_LONG).show();
                } else {
                    notesListBaseAdapter.addNotes(titleNotes, textNotes);
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    NotesListFragment notesListFragment = new NotesListFragment();
                    fragmentTransaction.replace(R.id.fragment_list_notes, notesListFragment);
                    fragmentTransaction.commit();
                    Toast.makeText(v.getContext(), R.string.add_notes_successfull, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void imageButtonBackBehavior() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                NotesListFragment notesListFragment = new NotesListFragment();
                fragmentTransaction.replace(R.id.fragment_list_notes, notesListFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
