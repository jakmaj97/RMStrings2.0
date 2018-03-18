package myrms.myrmstrings.jakubmajchrzak.example;

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

import myrms.myrmstrings.jakubmajchrzak.example.R;

public class Cello extends AppCompatActivity {

    GlobalMethods gbMyGlobals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cello);

        gbMyGlobals = new GlobalMethods(getApplicationContext());

        SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Intent iSong = new Intent(this, Song.class);
        final Bundle myBundle = new Bundle();

        Button btCzcijmy = (Button) findViewById(R.id.btCzcijmy);
        Button btDuszoMa = (Button) findViewById(R.id.btDuszoMaPanaChwal);
        Button btGenesis = (Button) findViewById(R.id.btGenesis);
        Button btHejJezu = (Button) findViewById(R.id.btHejJezu);
        Button btJakDobrze = (Button) findViewById(R.id.btJakDobrze);
        Button btJegoMilosc = (Button) findViewById(R.id.btJegoMilosc);
        Button btKazdyWschod = (Button) findViewById(R.id.btKazdyWschod);
        Button btPanieTwaDobroc= (Button) findViewById(R.id.btPanieTwaDobroc);
        Button btPozwolBy = (Button) findViewById(R.id.btPozwolBy);
        Button btPrzyjdz = (Button) findViewById(R.id.btPrzyjdzJakDeszcz);
        Button btSandaly = (Button) findViewById(R.id.btSandaly);
        Button btSchowaj = (Button) findViewById(R.id.btSchowaj);
        Button btStoje = (Button) findViewById(R.id.btStojeDzis);
        Button btToKrol = (Button) findViewById(R.id.btToKrol);
        Button btWierzycJakPiotr = (Button) findViewById(R.id.btWierzycJakPiotr);
        Button btWykrzykujcie = (Button) findViewById(R.id.btWykrzykujcie);
        Button btZiemia = (Button) findViewById(R.id.btZiemia);

        btCzcijmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btDuszoMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btGenesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btHejJezu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btJakDobrze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btJegoMilosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jego_milosc_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btKazdyWschod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gbMyGlobals.vEmptySongToast();
            }
        });
        btPanieTwaDobroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btPozwolBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.pozwol_by_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btPrzyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btSandaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btSchowaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btStoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btToKrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btWierzycJakPiotr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btWykrzykujcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wykrzykujcie_ids)[getResources().getInteger(R.integer.cello_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btZiemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[getResources().getInteger(R.integer.cello_id)]);
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
