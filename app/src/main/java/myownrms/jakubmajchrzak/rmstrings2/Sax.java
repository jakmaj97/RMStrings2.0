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
import android.widget.Toast;

public class Sax extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax);

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
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btDuszoMa = (Button) findViewById(R.id.btDuszoMaPanaChwal);
        btDuszoMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.duszo_ma_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btGenesis = (Button) findViewById(R.id.btGenesis);
        btGenesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.genesis_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btIdz = (Button) findViewById(R.id.btIdz);
        btIdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.idz_i_glos_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btHejJezu = (Button) findViewById(R.id.btHejJezu);
        btHejJezu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.hej_jezu_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btJakDobrze = (Button) findViewById(R.id.btJakDobrze);
        btJakDobrze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.jak_dobrze_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btNadejdzie = (Button) findViewById(R.id.btNadejdzie);
        btNadejdzie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.nadejdzie_dzien_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btKazdyWschod = (Button) findViewById(R.id.btKazdyWschod);
        btKazdyWschod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.kazdy_wschod_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btPanieTwaDobroc= (Button) findViewById(R.id.btPanieTwaDobroc);
        btPanieTwaDobroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.panie_twa_dobroc_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btPrzyjdz = (Button) findViewById(R.id.btPrzyjdzJakDeszcz);
        btPrzyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.przyjdz_jak_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btSandaly = (Button) findViewById(R.id.btSandaly);
        btSandaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.sandaly_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btStoje = (Button) findViewById(R.id.btStojeDzis);
        btStoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.stoje_dzis_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btUwielbiamy = (Button) findViewById(R.id.btUWielbiamy);
        btUwielbiamy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.uwielbiamy_cie_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btToKrol = (Button) findViewById(R.id.btToKrol);
        btToKrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.to_krol_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btWykrzykujcie = (Button) findViewById(R.id.btWykrzykujcie);
        btWykrzykujcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vEmptySongToast();}
        });
        Button btZbawca = (Button) findViewById(R.id.btZbawca);
        btZbawca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.zbawca_ids)[5]);
                iSong.putExtras(myBundle);
                startActivity(iSong, myBundle);
            }
        });
        Button btZiemia = (Button) findViewById(R.id.btZiemia);
        btZiemia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBundle.putString(getResources().getString(R.string.key), getResources().getStringArray(R.array.ziemia_ids)[5]);
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
    public void vEmptySongToast() {
        Toast toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.noScoresComm), Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.color.colorPrimary);
        toast.show();
    }
}
