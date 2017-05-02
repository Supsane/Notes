package com.chashurinevgeny.notes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

        return view;
    }

//    private void initView() {
//        View view = getView();
//        if (view != null) {
//            notesListBaseAdapter = new NotesListBaseAdapter(view.getContext());
//            titleNotesEditText = (EditText) view.findViewById(R.id.addNotesHead);
//            textNotesEditText = (EditText) view.findViewById(R.id.addNotesText);
//            ok = (ImageButton) view.findViewById(R.id.addNotesImageButton);
//            back = (ImageButton) view.findViewById(R.id.backImageButton);
//        }
//    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.addNotesImageButton: {
//                Log.d("AddOrEditNotesFragmeent", "onClickAddNotesImageButton");
//                imageButtonOkBehavior();
//                break;
//            }
//            case R.id.backImageButton: {
//                break;
//            }
//            default: {
//                break;
//            }
//        }
//    }

    private void imageButtonOkBehavior() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AddOrEditNotesFragment", "onClickAddNotesImageButton");
                String titleNotes = titleNotesEditText.getText().toString();
                String textNotes = textNotesEditText.getText().toString();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                if (fm != null) {
                    Fragment notesListFragment = fm.findFragmentById(R.id.fragment_list_notes);
                    if (notesListFragment != null) {
                        notesListBaseAdapter.addNotes(titleNotes, textNotes);
                    }
                }

                Toast.makeText(v.getContext(), R.string.add_notes_successfull, Toast.LENGTH_LONG).show();
                titleNotesEditText.setText("");
                textNotesEditText.setText("");
            }
        });
    }
}
