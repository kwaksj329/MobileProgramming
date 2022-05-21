package kr.co.company.dictionary_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import kr.co.company.dictionary_hw.R;

public class MainActivity extends AppCompatActivity implements WordsFragment.OnWordSelectedListner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null) {
            WordsFragment wordsFragment = new WordsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.fragment_container, wordsFragment).commit();
        }
    }

    public void onWordSelected(int position) {
        if (findViewById(R.id.fragment_container) == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DefinitionFragment definitionFragment = (DefinitionFragment) fragmentManager.findFragmentById(R.id.definition_fragment);
            definitionFragment.updateDefinitionView(position);
        } else {
            DefinitionFragment newFragment = new DefinitionFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}