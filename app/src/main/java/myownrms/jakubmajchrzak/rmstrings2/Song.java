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

        String sExtra = getIntent().getExtras().getString(getResources().getString(R.string.key));

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

        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[0], new MySong(R.drawable.wierzyc_jak_piotr_viol1, R.raw.wierzyc_jak_piotr_v1));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[1], new MySong(R.drawable.wierzyc_jak_piotr_viol2, R.raw.wierzyc_jak_piotr_v2));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[2], new MySong(R.drawable.wierzyc_jak_piotr_cello, R.raw.wierzyc_jak_piotr_c));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[3], new MySong(R.drawable.wierzyc_jak_piotr_tt, R.raw.wierzyc_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[4], new MySong(R.drawable.wierzyc_jak_piotr_tt, R.raw.wierzyc_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[5], new MySong(R.drawable.wierzyc_jak_piotr_s, R.raw.wierzyc_jak_s));

        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[0], new MySong(R.drawable.duszo_ma_v1, R.raw.duszo_ma_v1m));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[1], new MySong(R.drawable.duszo_ma_v2, R.raw.duszo_ma_v2m));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[2], new MySong(R.drawable.duzo_ma_c, R.raw.duszo_ma_cm));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[3], new MySong(R.drawable.duszo_ma_t, R.raw.duszo_ma_t1));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[4], new MySong(R.drawable.duszo_ma_t2, R.raw.duszo_ma_t2));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[5], new MySong(R.drawable.duszo_ma_sax, R.raw.duszo_ma_s));

        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[0], new MySong(R.drawable.genesis_v1, R.raw.genesis_v1));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[1], new MySong(R.drawable.genesis_v2, R.raw.genesis_v2));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[2], new MySong(R.drawable.genesis_c, R.raw.genesis_cm));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[3], new MySong(R.drawable.genesis_t1, R.raw.genesis_t1));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[4], new MySong(R.drawable.genesis_t2, R.raw.genesis_t2));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[5], new MySong(R.drawable.genesic_s, R.raw.genesis_s));

        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[0], new MySong(R.drawable.hej_jezu_v, R.raw.hej_jezu_v));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[1], new MySong(R.drawable.hej_jezu_v, R.raw.hej_jezu_v));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[2], new MySong(R.drawable.hej_jezu_c, R.raw.hej_jezu_c));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[3], new MySong(R.drawable.hej_jezu_t1, R.raw.hej_jezu_tm));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[4], new MySong(R.drawable.hej_jezu_t2, R.raw.hej_jezu_t2m));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[5], new MySong(R.drawable.hej_jezu_s, R.raw.hej_jezu_sm));

        mpMap.put(getResources().getStringArray(R.array.idz_i_glos_ids)[3], new MySong(R.drawable.idz_t1, R.raw.idz_t1));
        mpMap.put(getResources().getStringArray(R.array.idz_i_glos_ids)[4], new MySong(R.drawable.idz_t2, R.raw.idz_t2));
        mpMap.put(getResources().getStringArray(R.array.idz_i_glos_ids)[5], new MySong(R.drawable.idz_s, R.raw.idz_s));

        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[0], new MySong(R.drawable.jak_dobrze_v1, R.raw.jak_dobrze_v1));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[1], new MySong(R.drawable.jak_dobrze_v2, R.raw.jak_dobrze_v2));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[2], new MySong(R.drawable.jak_dobrze_c, R.raw.jak_dobrze_cm));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[3], new MySong(R.drawable.jak_dobrze_tt, R.raw.jak_dobrze_t));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[4], new MySong(R.drawable.jak_dobrze_tt, R.raw.jak_dobrze_t));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[5], new MySong(R.drawable.jak_dobrze_s, R.raw.jak_dobrze_s));

        mpMap.put(getResources().getStringArray(R.array.jego_milosc_ids)[0], new MySong(R.drawable.jego_milosc_v1, R.raw.jego_milosc_v1));
        mpMap.put(getResources().getStringArray(R.array.jego_milosc_ids)[1], new MySong(R.drawable.jego_milosc_v2, R.raw.jego_milosc_v2));
        mpMap.put(getResources().getStringArray(R.array.jego_milosc_ids)[2], new MySong(R.drawable.jego_milosc_c, R.raw.jego_milosc_c));

        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[0], new MySong(R.drawable.kazdy_wschod_v, R.raw.kazdy_wschod_v));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[3], new MySong(R.drawable.kazdy_wschod_tt, R.raw.kazdy_wschod_t));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[4], new MySong(R.drawable.kazdy_wschod_tt, R.raw.kazdy_wschod_t));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[5], new MySong(R.drawable.kazdy_wschod_s, R.raw.kazdy_wschod_s));

        mpMap.put(getResources().getStringArray(R.array.nadejdzie_dzien_ids)[3], new MySong(R.drawable.nadejdzie_dzien_t1, R.raw.nadejdzie_dzien_t1));
        mpMap.put(getResources().getStringArray(R.array.nadejdzie_dzien_ids)[4], new MySong(R.drawable.nadejdzie_dzien_t2, R.raw.nadejdzie_dzien_t2));
        mpMap.put(getResources().getStringArray(R.array.nadejdzie_dzien_ids)[5], new MySong(R.drawable.nadejdzie_dzien_s, R.raw.nadejdzie_dzien_s));

        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[0], new MySong(R.drawable.panie_twa_dobroc_v1, R.raw.panie_twa_dobroc_v1));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[1], new MySong(R.drawable.panie_twa_dobroc_c2, R.raw.panie_twa_dobroc_v2));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[2], new MySong(R.drawable.panie_twa_dobroc_c, R.raw.panie_twa_dobroc_c));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[3], new MySong(R.drawable.panie_twa_dobroc_t, R.raw.panie_twa_dobroc_t1));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[4], new MySong(R.drawable.panie_twa_dobroc_t2, R.raw.panie_twa_dobroc_t2));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[5], new MySong(R.drawable.panie_twa_dobroc_s, R.raw.panie_twa_dobroc_s));

        mpMap.put(getResources().getStringArray(R.array.pozwol_by_ids)[0], new MySong(R.drawable.pozwol_v1, R.raw.pozwol_v1));
        mpMap.put(getResources().getStringArray(R.array.pozwol_by_ids)[1], new MySong(R.drawable.pozwol_v2, R.raw.pozwol_v2));
        mpMap.put(getResources().getStringArray(R.array.pozwol_by_ids)[2], new MySong(R.drawable.pozwol_c, R.raw.pozwol_c));

        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[0], new MySong(R.drawable.przyjdz_jak_v1, R.raw.przyjdz_jak_v1));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[1], new MySong(R.drawable.przyjdz_jak_v2, R.raw.przyjdz_jak_v2));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[2], new MySong(R.drawable.przyjdz_jak_c, R.raw.przyjdz_jak_c));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[3], new MySong(R.drawable.przyjdz_jak_t, R.raw.przyjdz_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[4], new MySong(R.drawable.przyjdz_jak_t, R.raw.przyjdz_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[5], new MySong(R.drawable.przyjdz_jak_s, R.raw.przyjdz_jak_s));

        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[0], new MySong(R.drawable.stoje_dzis_v1, R.raw.stoje_v1));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[1], new MySong(R.drawable.stoje_dzis_v2, R.raw.stoje_v2));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[2], new MySong(R.drawable.stoje_dzis_c, R.raw.stoje_c));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[3], new MySong(R.drawable.stoje_tt, R.raw.stoje_dzis_tt));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[4], new MySong(R.drawable.stoje_tt, R.raw.stoje_dzis_tt));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[5], new MySong(R.drawable.stoje_s, R.raw.stoje_dzis_s));

        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[0], new MySong(R.drawable.sandaly_v1, R.raw.sandaly_v1));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[1], new MySong(R.drawable.sandaly_v2, R.raw.sandaly_v2));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[2], new MySong(R.drawable.sandaly_c, R.raw.sandaly_c));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[3], new MySong(R.drawable.sandaly_tt, R.raw.sandaly_tt));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[4], new MySong(R.drawable.sandaly_tt, R.raw.sandaly_tt));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[5], new MySong(R.drawable.sandaly_s, R.raw.sandaly_s));

        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[0], new MySong(R.drawable.to_krol_v1, R.raw.to_krol_v));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[1], new MySong(R.drawable.to_krol_v2, R.raw.to_krol_v));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[2], new MySong(R.drawable.to_krol_c, R.raw.to_krol_c));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[3], new MySong(R.drawable.to_krol_t, R.raw.to_krol_t1));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[4], new MySong(R.drawable.to_krol_t2, R.raw.to_krol_t2));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[5], new MySong(R.drawable.to_krol_s, R.raw.to_krol_s));

        mpMap.put(getResources().getStringArray(R.array.uwielbiamy_cie_ids)[3], new MySong(R.drawable.uwielbiamy_tt, R.raw.uwielbiamy_cie_tt));
        mpMap.put(getResources().getStringArray(R.array.uwielbiamy_cie_ids)[4], new MySong(R.drawable.uwielbiamy_tt, R.raw.uwielbiamy_cie_tt));
        mpMap.put(getResources().getStringArray(R.array.uwielbiamy_cie_ids)[5], new MySong(R.drawable.uwielbiamy_s, R.raw.uwielbiamy_cie_s));

        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[0], new MySong(R.drawable.wykrzykujcie_v1, R.raw.wykrzykujcie_v1));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[1], new MySong(R.drawable.wykrzykujcie_v2, R.raw.wykrzykujcie_v2));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[2], new MySong(R.drawable.wykrzykujcie_c, R.raw.wykrzykujcie_c));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[3], new MySong(R.drawable.wykrz_t1, R.raw.wykrz_t1));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[4], new MySong(R.drawable.wykrz_t2, R.raw.wykrz_t2));

        mpMap.put(getResources().getStringArray(R.array.zbawca_ids)[3], new MySong(R.drawable.zbawca_t1, R.raw.zbawca_t1));
        mpMap.put(getResources().getStringArray(R.array.zbawca_ids)[4], new MySong(R.drawable.zbawca_t2, R.raw.zbawca_t2));
        mpMap.put(getResources().getStringArray(R.array.zbawca_ids)[5], new MySong(R.drawable.zbawca_s, R.raw.zbawca_s));

        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[0], new MySong(R.drawable.ziemia_v1, R.raw.ziemia_v1));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[1], new MySong(R.drawable.ziemia_v2, R.raw.ziemia_v2));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[2], new MySong(R.drawable.ziemia_c, R.raw.ziemia_c));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[3], new MySong(R.drawable.ziemia_t1, R.raw.ziemia_t1));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[4], new MySong(R.drawable.ziemia_t2, R.raw.ziemia_t2));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[5], new MySong(R.drawable.ziemia_s, R.raw.ziemia_s));

        return mpMap;
    }
}
