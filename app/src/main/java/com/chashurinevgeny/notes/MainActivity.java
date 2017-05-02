package com.chashurinevgeny.notes;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        NotesListFragment notesListFragment = new NotesListFragment();
        fragmentTransaction.add(R.id.fragment_list_notes, notesListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add: {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                AddOrEditNotesFragment addOrEditNotesFragment = new AddOrEditNotesFragment();
                fragmentTransaction.replace(R.id.fragment_list_notes, addOrEditNotesFragment);
                fragmentTransaction.commit();
                return true;
            }
            case R.id.action_delete_all: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
