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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import myrms.myrmstrings.jakubmajchrzak.example.R;

public class Cello extends AppCompatActivity implements AdapterView.OnItemClickListener, APPCONSTANTS {

    GlobalMethods gbMyGlobals;
    ListView lvSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cello);

        gbMyGlobals = new GlobalMethods(getApplicationContext());
        lvSongs = (ListView) findViewById(R.id.lvSongs);

        SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        lvSongs.setOnItemClickListener(this);
        ArrayAdapter<String> aaViolinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.symp_song_names));
        lvSongs.setAdapter(aaViolinAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    public void onItemClick(AdapterView<?> parent, View view, int iPosition, long lId) {
        final Bundle myBundle = new Bundle();
        final Intent iSong = new Intent(this, Song.class);
        boolean bScoreExits = true;

        switch (iPosition) {
            case I_CZCIJMY_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_DUSZO_MA_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_GENESIS_S_PPOS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_HEJ_JEZU_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_JAK_DOBRZE_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_JEGO_MILOSC_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jego_milosc_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_KAZDY_WSCHOD_S_POS: gbMyGlobals.vEmptySongToast(); bScoreExits = false; break;
            case I_PANIE_TWA_DOBROC_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_POZWOL_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.pozwol_by_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_PRZYJDZ_JAK_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_SANDALY_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_SCHOWAJ_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_STOJE_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_TO_KROL_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_WIERZYC_JAK_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_WYKRZ_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wykrzykujcie_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            case I_ZIEMIA_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[getResources().getInteger(R.integer.cello_id)]); break;
            default: break;
        }
        if (bScoreExits) {
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