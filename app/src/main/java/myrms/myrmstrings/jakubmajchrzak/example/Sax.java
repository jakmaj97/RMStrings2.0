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

public class Sax extends AppCompatActivity implements  View.OnClickListener {

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

        btCzcijmy.setOnClickListener(this);
        btDuszoMa.setOnClickListener(this);
        btGenesis.setOnClickListener(this);
        btHejJezu.setOnClickListener(this);
        btIdz.setOnClickListener(this);
        btJakDobrze.setOnClickListener(this);
        btKazdyWschod.setOnClickListener(this);
        btNadejdzie.setOnClickListener(this);
        btPanieTwaDobroc.setOnClickListener(this);
        btPrzyjdz.setOnClickListener(this);
        btSandaly.setOnClickListener(this);
        btSchowaj.setOnClickListener(this);
        btStoje.setOnClickListener(this);
        btToKrol.setOnClickListener(this);
        btUwielbiamy.setOnClickListener(this);
        btWierzycJakPiotr.setOnClickListener(this);
        btWykrzykujcie.setOnClickListener(this);
        btZiemia.setOnClickListener(this);
        btZbawca.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        final Bundle myBundle = new Bundle();
        final Intent iSong = new Intent(this, Song.class);
        boolean bScoreExits = true;

        switch (v.getId()) {
            case R.id.btCzcijmy: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btDuszoMaPanaChwal: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btGenesis: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btHejJezu: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btIdz: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.idz_i_glos_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btJakDobrze: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btKazdyWschod: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.kazdy_wschod_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btNadejdzie: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.nadejdzie_dzien_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btPanieTwaDobroc: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btPrzyjdzJakDeszcz: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btSandaly: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btSchowaj: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btStojeDzis: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btToKrol: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btUWielbiamy: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.uwielbiamy_cie_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btWierzycJakPiotr: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btWykrzykujcie: gbMyGlobals.vEmptySongToast(); bScoreExits = false; break;
            case R.id.btZbawca:myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.zbawca_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            case R.id.btZiemia: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[getResources().getInteger(R.integer.sax_id)]); break;
            default: break;
        }
        if(bScoreExits) {
            iSong.putExtras(myBundle);
            startActivity(iSong, myBundle);
            bScoreExits = true;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}