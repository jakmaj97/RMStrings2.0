package myownrms.jakubmajchrzak.rmstrings2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ViolinII extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violin_ii);

        SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Intent iSong = new Intent(this, Song.class);
        final Bundle myBundle = new Bundle();

        Button btWierzycJakPiotr = (Button) findViewById(R.id.btWierzycJakPiotr);
        btWierzycJakPiotr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "wierzycJakPiotr2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btDuszoMa = (Button) findViewById(R.id.btDuszoMaPanaChwal);
        btDuszoMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "duszoMa2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btGenesis = (Button) findViewById(R.id.btGenesis);
        btGenesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "genesis2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btHejJezu = (Button) findViewById(R.id.btHejJezu);
        btHejJezu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "hej2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btJakDobrze = (Button) findViewById(R.id.btJakDobrze);
        btJakDobrze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "jakDobrze2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btJegoMilosc = (Button) findViewById(R.id.btJegoMilosc);
        btJegoMilosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "jegoMilosc2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btKazdyWschod = (Button) findViewById(R.id.btKazdyWschod);
        btKazdyWschod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "kazdyWschod1");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btPanieTwaDobroc = (Button) findViewById(R.id.btPanieTwaDobroc);
        btPanieTwaDobroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "panieTwaDobroc2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btPozwolBy = (Button) findViewById(R.id.btPozwolBy);
        btPozwolBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "pozwol2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btPrzyjdz = (Button) findViewById(R.id.btPrzyjdzJakDeszcz);
        btPrzyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "przyjdz2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btSandaly = (Button) findViewById(R.id.btSandaly);
        btSandaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "sandaly2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btStoje = (Button) findViewById(R.id.btStojeDzis);
        btStoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "stoje2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btToKrol = (Button) findViewById(R.id.btToKrol);
        btToKrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "toKrol2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btWykrzykujcie = (Button) findViewById(R.id.btWykrzykujcie);
        btWykrzykujcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "wykrz2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btZiemia = (Button) findViewById(R.id.btZiemia);
        btZiemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString("key", "ziemia2");
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
