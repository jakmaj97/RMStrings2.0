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
        ArrayAdapter<String> aaViolinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.instruments));
        lvInstruments.setAdapter(aaViolinAdapter);
    }
    public void onItemClick(AdapterView<?> parent, View view, int iPosition, long lId) {

        final Intent iTurnOnViolin = new Intent(this, Violin.class);
        final Intent iTurnOnViolinII = new Intent(this, ViolinII.class);
        final Intent iTurnOnCello = new Intent(this, Cello.class);
        final Intent iTurnOnTrumpet = new Intent(this, Trumpet.class);
        final Intent iTurnOnTrumpetII = new Intent(this, TrumpetII.class);
        final Intent iTurnOnSax = new Intent(this, Sax.class);

        switch (iPosition) {
            case I_VIOL1_POS: startActivity(iTurnOnViolin); break;
            case I_VIOL2_POS: startActivity(iTurnOnViolinII); break;
            case I_CELLO_POS: startActivity(iTurnOnCello); break;
            case I_TRMPT1_POS: startActivity(iTurnOnTrumpet); break;
            case I_TRMPT2_POS: startActivity(iTurnOnTrumpetII); break;
            case I_SAX_POS: startActivity(iTurnOnSax); break;
            default: break;
        }
    }
}
