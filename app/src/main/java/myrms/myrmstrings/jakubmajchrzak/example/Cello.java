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

public class Cello extends AppCompatActivity implements View.OnClickListener {

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

        btCzcijmy.setOnClickListener(this);
        btDuszoMa.setOnClickListener(this);
        btGenesis.setOnClickListener(this);
        btHejJezu.setOnClickListener(this);
        btJakDobrze.setOnClickListener(this);
        btJegoMilosc.setOnClickListener(this);
        btKazdyWschod.setOnClickListener(this);
        btPanieTwaDobroc.setOnClickListener(this);
        btPozwolBy.setOnClickListener(this);
        btPrzyjdz.setOnClickListener(this);
        btSandaly.setOnClickListener(this);
        btSchowaj.setOnClickListener(this);
        btStoje.setOnClickListener(this);
        btToKrol.setOnClickListener(this);
        btWierzycJakPiotr.setOnClickListener(this);
        btWykrzykujcie.setOnClickListener(this);
        btZiemia.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        final Bundle myBundle = new Bundle();
        final Intent iSong = new Intent(this, Song.class);
        boolean bScoreExits = true;

        switch (v.getId()) {
            case R.id.btCzcijmy: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btDuszoMaPanaChwal: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btGenesis: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btHejJezu: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btJakDobrze: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btJegoMilosc: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jego_milosc_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btKazdyWschod: gbMyGlobals.vEmptySongToast(); bScoreExits = false; break;
            case R.id.btPanieTwaDobroc: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btPozwolBy: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.pozwol_by_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btPrzyjdzJakDeszcz: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btSandaly: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btSchowaj: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btStojeDzis: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btToKrol: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btWierzycJakPiotr: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btWykrzykujcie: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wykrzykujcie_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case R.id.btZiemia: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            default: break;
        }
        if(bScoreExits) {
            iSong.putExtras(myBundle);
            startActivity(iSong, myBundle);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}