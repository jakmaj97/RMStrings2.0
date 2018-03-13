package myownrms.jakubmajchrzak.rmstrings2;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Map;

import java.util.HashMap;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Song extends AppCompatActivity {

    MediaPlayer mpToStop;
    boolean bMpSetted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song); SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bMpSetted = true;

        Map<String, MySong> mpSongsMap = new HashMap<>();
        mpSongsMap = mpFillMap(mpSongsMap);

        Button btPlay = (Button) findViewById(R.id.btPlay);
        Button btStop = (Button) findViewById(R.id.btStop);
        Button btPause = (Button) findViewById(R.id.btPause);
        ImageView ivSheet = (ImageView) findViewById(R.id.imageView3);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(ivSheet);
        photoViewAttacher.update();
        final MediaPlayer mpCell;

        String sExtra = getIntent().getExtras().getString("key");

        ivSheet.setImageResource(mpSongsMap.get(sExtra).getImage());
        mpCell = MediaPlayer.create(this, mpSongsMap.get(sExtra).getMusic());

        if(bMpSetted) {
            mpToStop = mpCell;
            btPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mpCell.start();
                }
            });
            btStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mpCell.isPlaying()) {
                        mpCell.pause();
                        mpCell.seekTo(0);
                    }
                }
            });
            btPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mpCell.isPlaying())
                        mpCell.pause();
                }
            });
        }
    }
    @Override
    public void finish() {
        mpToStop.pause();
        mpToStop.seekTo(0);
        super.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    Map mpFillMap(Map<String, MySong> mpMap) {

        mpMap.put("wierzycJakPiotr1", new MySong(R.drawable.wierzyc_jak_piotr_viol1, R.raw.wierzyc_jak_piotr_v1));
        mpMap.put("wierzycJakPiotr2", new MySong(R.drawable.wierzyc_jak_piotr_viol2, R.raw.wierzyc_jak_piotr_v2));
        mpMap.put("wierzycJakPiotr3", new MySong(R.drawable.wierzyc_jak_piotr_cello, R.raw.wierzyc_jak_piotr_c));

        mpMap.put("duszoMa1", new MySong(R.drawable.duszo_ma_v1, R.raw.duszo_ma_v1m));
        mpMap.put("duszoMa2", new MySong(R.drawable.duszo_ma_v2, R.raw.duszo_ma_v2m));
        mpMap.put("duszoMa3", new MySong(R.drawable.duzo_ma_c, R.raw.duszo_ma_cm));

        mpMap.put("genesis1", new MySong(R.drawable.genesis_v1, R.raw.genesis_v1));
        mpMap.put("genesis2", new MySong(R.drawable.genesis_v2, R.raw.genesis_v2));
        mpMap.put("genesis3", new MySong(R.drawable.genesis_c, R.raw.genesis_cm));

        mpMap.put("hej1", new MySong(R.drawable.hej_jezu_v, R.raw.hej_jezu_v));
        mpMap.put("hej2", new MySong(R.drawable.hej_jezu_v, R.raw.hej_jezu_v));
        mpMap.put("hej3", new MySong(R.drawable.hej_jezu_c, R.raw.hej_jezu_c));

        mpMap.put("jakDobrze1", new MySong(R.drawable.jak_dobrze_v1, R.raw.jak_dobrze_v1));
        mpMap.put("jakDobrze2", new MySong(R.drawable.jak_dobrze_v2, R.raw.jak_dobrze_v2));
        mpMap.put("jakDobrze3", new MySong(R.drawable.jak_dobrze_c, R.raw.jak_dobrze_cm));

        mpMap.put("jegoMilosc1", new MySong(R.drawable.jego_milosc_v1, R.raw.jego_milosc_v1));
        mpMap.put("jegoMilosc2", new MySong(R.drawable.jego_milosc_v2, R.raw.jego_milosc_v2));
        mpMap.put("jegoMilosc3", new MySong(R.drawable.jego_milosc_c, R.raw.jego_milosc_c));

        mpMap.put("kazdyWschod1", new MySong(R.drawable.kazdy_wschod_v, R.raw.kazdy_wschod_v));

        mpMap.put("panieTwaDobroc1", new MySong(R.drawable.panie_twa_dobroc_v1, R.raw.panie_twa_dobroc_v1));
        mpMap.put("panieTwaDobroc2", new MySong(R.drawable.panie_twa_dobroc_c2, R.raw.panie_twa_dobroc_v2));
        mpMap.put("panieTwaDobroc3", new MySong(R.drawable.panie_twa_dobroc_c, R.raw.panie_twa_dobroc_c));

        mpMap.put("pozwol1", new MySong(R.drawable.pozwol_v1, R.raw.pozwol_v1));
        mpMap.put("pozwol2", new MySong(R.drawable.pozwol_v2, R.raw.pozwol_v2));
        mpMap.put("pozwol3", new MySong(R.drawable.pozwol_c, R.raw.pozwol_c));

        mpMap.put("przyjdz1", new MySong(R.drawable.przyjdz_jak_v1, R.raw.przyjdz_jak_v1));
        mpMap.put("przyjdz2", new MySong(R.drawable.przyjdz_jak_v2, R.raw.przyjdz_jak_v2));
        mpMap.put("przyjdz3", new MySong(R.drawable.przyjdz_jak_c, R.raw.przyjdz_jak_c));

        mpMap.put("stoje1", new MySong(R.drawable.stoje_dzis_v1, R.raw.stoje_v1));
        mpMap.put("stoje2", new MySong(R.drawable.stoje_dzis_v2, R.raw.stoje_v2));
        mpMap.put("stoje3", new MySong(R.drawable.stoje_dzis_c, R.raw.stoje_c));

        mpMap.put("sandaly1", new MySong(R.drawable.sandaly_v1, R.raw.sandaly_v1));
        mpMap.put("sandaly2", new MySong(R.drawable.sandaly_v2, R.raw.sandaly_v2));
        mpMap.put("sandaly3", new MySong(R.drawable.sandaly_c, R.raw.sandaly_c));

        mpMap.put("toKrol1", new MySong(R.drawable.to_krol_v1, R.raw.to_krol_v));
        mpMap.put("toKrol2", new MySong(R.drawable.to_krol_v2, R.raw.to_krol_v));
        mpMap.put("toKrol3", new MySong(R.drawable.to_krol_c, R.raw.to_krol_c));

        mpMap.put("wykrz1", new MySong(R.drawable.wykrzykujcie_v1, R.raw.wykrzykujcie_v1));
        mpMap.put("wykrz2", new MySong(R.drawable.wykrzykujcie_v2, R.raw.wykrzykujcie_v2));
        mpMap.put("wykrz3", new MySong(R.drawable.wykrzykujcie_c, R.raw.wykrzykujcie_c));

        mpMap.put("ziemia1", new MySong(R.drawable.ziemia_v1, R.raw.ziemia_v1));
        mpMap.put("ziemia2", new MySong(R.drawable.ziemia_v2, R.raw.ziemia_v2));
        mpMap.put("ziemia3", new MySong(R.drawable.ziemia_c, R.raw.ziemia_c));

        return mpMap;
    }
}
