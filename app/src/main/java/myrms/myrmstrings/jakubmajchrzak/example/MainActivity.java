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
        Button btTurnOnViolin = (Button) findViewById(R.id.btViol1);
        btTurnOnViolin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnViolin);
            }
        });
        final Intent iTurnOnViolinII = new Intent(this, ViolinII.class);
        Button btTurnOnViolinII = (Button) findViewById(R.id.btViol2);
        btTurnOnViolinII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnViolinII);
            }
        });
        final Intent iTurnOnCello = new Intent(this, Cello.class);
        Button btTurnOnCello = (Button) findViewById(R.id.btCello);
        btTurnOnCello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnCello);
            }
        });
        final Intent iTurnOnTrumpet = new Intent(this, Trumpet.class);
        Button btTurnOnTrumpet = (Button) findViewById(R.id.btTrmpt1);
        btTurnOnTrumpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnTrumpet);
            }
        });
        final Intent iTurnOnTrumpetII = new Intent(this, TrumpetII.class);
        Button btTurnOnTrumpetII = (Button) findViewById(R.id.btTrmpt2);
        btTurnOnTrumpetII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnTrumpetII);
            }
        });
        final Intent iTurnOnSax = new Intent(this, Sax.class);
        Button btTurnOnSax = (Button) findViewById(R.id.btSax);
        btTurnOnSax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iTurnOnSax);
            }
        });
    }
}
