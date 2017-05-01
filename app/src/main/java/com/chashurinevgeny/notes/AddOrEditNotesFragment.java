package com.chashurinevgeny.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddOrEditNotesFragment extends Fragment {

    private EditText titleNotesEditText, textNotesEditText;
    private ImageButton ok, back;
    DBWorkNotesService dbWorNotesService = new DBWorkNotesService();
    NotesListBaseAdapter notesListBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_or_edite_notes, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        imageViewBehavior();
    }

    private void initView() {
        View view = getView();
        if (view != null) {
            notesListBaseAdapter = new NotesListBaseAdapter(view.getContext());
            titleNotesEditText = (EditText) view.findViewById(R.id.addNotesHead);
            textNotesEditText = (EditText) view.findViewById(R.id.addNotesText);
            ok = (ImageButton) view.findViewById(R.id.addNotesImageView);
            back = (ImageButton) view.findViewById(R.id.backImageView);
        }
    }

    private void imageViewBehavior() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleNotes = titleNotesEditText.getText().toString();
                String textNotes = textNotesEditText.getText().toString();
                dbWorNotesService.addNotes(titleNotes, textNotes);
                notesListBaseAdapter.notifyDataSetChanged();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
