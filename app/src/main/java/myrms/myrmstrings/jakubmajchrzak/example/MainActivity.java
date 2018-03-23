package myrms.myrmstrings.jakubmajchrzak.example;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import myrms.myrmstrings.jakubmajchrzak.example.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, APPCONSTANTS {

    ListView lvInstruments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvInstruments = findViewById(R.id.lvInstruments);

        SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        lvInstruments.setOnItemClickListener(this);
        ArrayAdapter<String> aaViolinAdapter = new ArrayAdapter<>(this, R.layout.center_row, R.id.lvMyListView, getResources().getStringArray(R.array.instruments));
        lvInstruments.setAdapter(aaViolinAdapter);
    }
    public void onItemClick(AdapterView<?> parent, View view, int iPosition, long lId) {

        final Bundle bundInstrumentChoice = new Bundle();
        final Intent inInstrument = new Intent(this, Instrument.class);

        switch (iPosition) {
            case I_VIOL1_POS: bundInstrumentChoice.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.instruments)[I_VIOL1_POS]); break;
            case I_VIOL2_POS: bundInstrumentChoice.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.instruments)[I_VIOL2_POS]); break;
            case I_CELLO_POS: bundInstrumentChoice.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.instruments)[I_CELLO_POS]); break;
            case I_TRMPT1_POS: bundInstrumentChoice.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.instruments)[I_TRMPT1_POS]); break;
            case I_TRMPT2_POS: bundInstrumentChoice.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.instruments)[I_TRMPT2_POS]); break;
            case I_SAX_POS: bundInstrumentChoice.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.instruments)[I_SAX_POS]); break;
            default: break;
        }
        inInstrument.putExtras(bundInstrumentChoice);
        startActivity(inInstrument, bundInstrumentChoice);
    }
}
