package myrms.myrmstrings.jakubmajchrzak.example;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;

import myrms.myrmstrings.jakubmajchrzak.example.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        final Intent iTurnOnViolin = new Intent(this, Violin.class);
        final Intent iTurnOnViolinII = new Intent(this, ViolinII.class);
        final Intent iTurnOnCello = new Intent(this, Cello.class);
        final Intent iTurnOnTrumpet = new Intent(this, Trumpet.class);
        final Intent iTurnOnTrumpetII = new Intent(this, TrumpetII.class);
        final Intent iTurnOnSax = new Intent(this, Sax.class);

        Button btTurnOnViolinII = (Button) findViewById(R.id.btViol2);
        Button btTurnOnViolin = (Button) findViewById(R.id.btViol1);
        Button btTurnOnCello = (Button) findViewById(R.id.btCello);
        Button btTurnOnTrumpet = (Button) findViewById(R.id.btTrmpt1);
        Button btTurnOnTrumpetII = (Button) findViewById(R.id.btTrmpt2);
        Button btTurnOnSax = (Button) findViewById(R.id.btSax);

        btTurnOnViolin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnViolin);
            }
        });
        btTurnOnViolinII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnViolinII);
            }
        });
        btTurnOnCello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnCello);
            }
        });
        btTurnOnTrumpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnTrumpet);
            }
        });
        btTurnOnTrumpetII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnTrumpetII);
            }
        });
        btTurnOnSax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnSax);

            }
        });
    }
}
