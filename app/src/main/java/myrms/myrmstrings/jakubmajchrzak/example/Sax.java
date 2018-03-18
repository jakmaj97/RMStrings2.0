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

public class Sax extends AppCompatActivity {

    GlobalMethods gbMyGlobals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax);

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
        Button btIdz = (Button) findViewById(R.id.btIdz);
        Button btHejJezu = (Button) findViewById(R.id.btHejJezu);
        Button btJakDobrze = (Button) findViewById(R.id.btJakDobrze);
        Button btKazdyWschod = (Button) findViewById(R.id.btKazdyWschod);
        Button btNadejdzie = (Button) findViewById(R.id.btNadejdzie);
        Button btPanieTwaDobroc= (Button) findViewById(R.id.btPanieTwaDobroc);
        Button btPrzyjdz = (Button) findViewById(R.id.btPrzyjdzJakDeszcz);
        Button btSandaly = (Button) findViewById(R.id.btSandaly);
        Button btSchowaj = (Button) findViewById(R.id.btSchowaj);
        Button btStoje = (Button) findViewById(R.id.btStojeDzis);
        Button btToKrol = (Button) findViewById(R.id.btToKrol);
        Button btUwielbiamy = (Button) findViewById(R.id.btUWielbiamy);
        Button btWierzycJakPiotr = (Button) findViewById(R.id.btWierzycJakPiotr);
        Button btWykrzykujcie = (Button) findViewById(R.id.btWykrzykujcie);
        Button btZbawca = (Button) findViewById(R.id.btZbawca);
        Button btZiemia = (Button) findViewById(R.id.btZiemia);

        btCzcijmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btDuszoMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btGenesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btIdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.idz_i_glos_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btHejJezu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btJakDobrze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btNadejdzie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.nadejdzie_dzien_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btKazdyWschod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.kazdy_wschod_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btPanieTwaDobroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btPrzyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btSandaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btSchowaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btStoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btToKrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btUwielbiamy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.uwielbiamy_cie_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btWierzycJakPiotr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btWykrzykujcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gbMyGlobals.vEmptySongToast();}
        });
        btZbawca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.zbawca_ids)[getResources().getInteger(R.integer.sax_id)]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        btZiemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[getResources().getInteger(R.integer.sax_id)]);
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
