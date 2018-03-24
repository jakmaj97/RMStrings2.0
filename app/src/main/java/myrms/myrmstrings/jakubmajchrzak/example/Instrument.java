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
import android.widget.ListView;
import android.widget.TextView;

public class Instrument extends AppCompatActivity implements AdapterView.OnItemClickListener, APPCONSTANTS{

    ListView lvSongs;
    TextView tvInstrument;
    ArrayAdapter<String> aaInstrumentAdapter;
    String sExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument);

        lvSongs = (ListView) findViewById(R.id.lvSongs);
        tvInstrument = (TextView) findViewById(R.id.tvInstrument);
        sExtra = getIntent().getExtras().getString(getResources().getString(R.string.key));

        SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        lvSongs.setOnItemClickListener(this);

        if(bIsSymph(sExtra)) {
            if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_VIOL1_POS]))
                tvInstrument.setText(getResources().getStringArray(R.array.instruments)[I_VIOL1_POS]);
            else if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_VIOL2_POS]))
                tvInstrument.setText(getResources().getStringArray(R.array.instruments)[I_VIOL2_POS]);
            else if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_CELLO_POS]))
                tvInstrument.setText(getResources().getStringArray(R.array.instruments)[I_CELLO_POS]);

            aaInstrumentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.symp_song_names));
        }
        else if(bIsBrass(sExtra)) {
            if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_TRMPT1_POS]))
                tvInstrument.setText(getResources().getStringArray(R.array.instruments)[I_TRMPT1_POS]);
            else if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_TRMPT2_POS]))
                tvInstrument.setText(getResources().getStringArray(R.array.instruments)[I_TRMPT2_POS]);
            else if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_SAX_POS]))
                tvInstrument.setText(getResources().getStringArray(R.array.instruments)[I_SAX_POS]);

            aaInstrumentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.brass_song_names));
        }

        lvSongs.setAdapter(aaInstrumentAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void onItemClick(AdapterView<?> parent, View view, int iPosition, long lId) {
        final Bundle myBundle = new Bundle();
        final Intent iSong = new Intent(this, Song.class);
        boolean bScoreExits = true;

        if(bIsSymph(sExtra)) {
            if (sExtra.equals(getResources().getStringArray(R.array.instruments)[I_VIOL1_POS]))
               bScoreExits = bTurnOnSymph(myBundle, I_VIOL1_POS, iPosition, bScoreExits);
            else if (sExtra.equals(getResources().getStringArray(R.array.instruments)[I_VIOL2_POS]))
                bScoreExits = bTurnOnSymph(myBundle, I_VIOL2_POS, iPosition, bScoreExits);
            else if (sExtra.equals(getResources().getStringArray(R.array.instruments)[I_CELLO_POS]))
                bScoreExits = bTurnOnSymph(myBundle, I_CELLO_POS, iPosition, bScoreExits);
        }
        else if(bIsBrass(sExtra)) {

            if (sExtra.equals(getResources().getStringArray(R.array.instruments)[I_TRMPT1_POS]))
                bScoreExits = bTurnOnBrass(myBundle, I_TRMPT1_POS, iPosition, bScoreExits);
            else if (sExtra.equals(getResources().getStringArray(R.array.instruments)[I_TRMPT2_POS]))
                bScoreExits = bTurnOnBrass(myBundle, I_TRMPT2_POS, iPosition, bScoreExits);
            else if (sExtra.equals(getResources().getStringArray(R.array.instruments)[I_SAX_POS]))
                bScoreExits = bTurnOnBrass(myBundle, I_SAX_POS, iPosition, bScoreExits);
        }
        if (bScoreExits) {
            iSong.putExtras(myBundle);
            startActivity(iSong, myBundle);
        }
    }
    public boolean bIsSymph(String sExtra) {
        if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_VIOL1_POS]) || sExtra.equals(getResources().getStringArray(R.array.instruments)[I_VIOL2_POS]) || sExtra.equals(getResources().getStringArray(R.array.instruments)[I_CELLO_POS]))
            return true;
        return false;
    }
    public boolean bIsBrass(String sExtra) {
        if(sExtra.equals(getResources().getStringArray(R.array.instruments)[I_TRMPT1_POS]) || sExtra.equals(getResources().getStringArray(R.array.instruments)[I_TRMPT2_POS]) || sExtra.equals(getResources().getStringArray(R.array.instruments)[I_SAX_POS]))
            return true;
        return false;
    }
    public boolean bTurnOnSymph(Bundle myBundle, int iInstrumentIndex, int iPosition, boolean bScoreExist) {

        switch (iPosition) {
            case I_CZCIJMY_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[iInstrumentIndex]); break;
            case I_DUSZO_MA_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[iInstrumentIndex]); break;
            case I_GENESIS_S_PPOS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[iInstrumentIndex]); break;
            case I_HEJ_JEZU_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[iInstrumentIndex]); break;
            case I_JAK_DOBRZE_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[iInstrumentIndex]); break;
            case I_JEGO_MILOSC_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jego_milosc_ids)[iInstrumentIndex]); break;
            case I_KAZDY_WSCHOD_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.kazdy_wschod_ids)[iInstrumentIndex]); break;
            case I_PANIE_TWA_DOBROC_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[iInstrumentIndex]); break;
            case I_POZWOL_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.pozwol_by_ids)[iInstrumentIndex]); break;
            case I_PRZYJDZ_JAK_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[iInstrumentIndex]); break;
            case I_SANDALY_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[iInstrumentIndex]); break;
            case I_SCHOWAJ_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[iInstrumentIndex]); break;
            case I_STOJE_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[iInstrumentIndex]); break;
            case I_TO_KROL_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[iInstrumentIndex]); break;
            case I_WIERZYC_JAK_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[iInstrumentIndex]); break;
            case I_WYKRZ_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wykrzykujcie_ids)[iInstrumentIndex]); break;
            case I_ZIEMIA_S_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[iInstrumentIndex]); break;
            default: break;
        }
        return bScoreExist;
    }
    public boolean bTurnOnBrass(Bundle myBundle, int iInstrumentIndex, int iPosition, boolean bScoreExist) {

        switch (iPosition) {
            case I_CZCIJMY_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.czcijmy_ids)[iInstrumentIndex]); break;
            case I_DUSZO_MA_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[iInstrumentIndex]); break;
            case I_GENESIS_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[iInstrumentIndex]); break;
            case I_HEJ_JEZU_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[iInstrumentIndex]); break;
            case I_IDZ_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.idz_i_glos_ids)[iInstrumentIndex]); break;
            case I_JAK_DOBRZE_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[iInstrumentIndex]); break;
            case I_KAZDY_WSCHOD_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.kazdy_wschod_ids)[iInstrumentIndex]); break;
            case I_NADEJDZIE_DZIEN_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.nadejdzie_dzien_ids)[iInstrumentIndex]); break;
            case I_PANIE_TWA_DOBROC_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[iInstrumentIndex]); break;
            case I_PRZYJDZ_JAK_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[iInstrumentIndex]); break;
            case I_SANDALY_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[iInstrumentIndex]); break;
            case I_SCHOWAJ_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.schowaj_ids)[iInstrumentIndex]); break;
            case I_STOJE_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[iInstrumentIndex]); break;
            case I_TO_KROL_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[iInstrumentIndex]); break;
            case I_UWIELBIAMY: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.uwielbiamy_cie_ids)[iInstrumentIndex]); break;
            case I_WIERZYC_JAK_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[iInstrumentIndex]); break;
            case I_WYKRZ_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wykrzykujcie_ids)[iInstrumentIndex]); break;
            case I_ZBAWCA_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.zbawca_ids)[iInstrumentIndex]); break;
            case I_ZIEMIA_B_POS: myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[iInstrumentIndex]); break;
            default: break;
        }
        return bScoreExist;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}