package myrms.myrmstrings.jakubmajchrzak.example;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.Map;

import java.util.HashMap;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Song extends AppCompatActivity implements APPCONSTANTS {

    Button btStop;
    MediaPlayer mpSongPlayer;
    SeekBar sbSongTime;
    Handler hSongHandler;
    Runnable rSongRunnable;
    TextView tvSecs;
    ToggleButton tbtPlay;
    boolean bStopClicked;
    boolean bSeekStop;
    boolean bFirstUsage;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song); SpannableString s = new SpannableString(getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, getTitle().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        tvSecs = (TextView) findViewById(R.id.tvSecs);
        bSeekStop = false;
        bStopClicked = false;
        bFirstUsage = true;
        tbtPlay = (ToggleButton) findViewById(R.id.tbtPlay);
        btStop = (Button) findViewById(R.id.btStop);
        sbSongTime = (SeekBar) findViewById(R.id.sbSongTime);
        hSongHandler = new Handler();
        rSongRunnable = new Runnable() {
            @Override
            public void run() {
                vSeekUpdation();
            }
        };

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Map<String, MySong> mapSongsMap = new HashMap<>();
        mapSongsMap = mpFillMap(mapSongsMap);

        ImageView ivSheet = (ImageView) findViewById(R.id.imageView3);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(ivSheet);
        photoViewAttacher.update();

        final String sExtra = getIntent().getExtras().getString(getResources().getString(R.string.key));
        ivSheet.setImageResource(mapSongsMap.get(sExtra).getImage());

        mpSongPlayer = MediaPlayer.create(this, mapSongsMap.get(sExtra).getMusic());

        sbSongTime.setMax(mpSongPlayer.getDuration());

        tbtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sbSongTime.getProgress() == sbSongTime.getMax()) {
                    tbtPlay.setChecked(false);
                }
                vSeekUpdation();
                if(!tbtPlay.isChecked() && sbSongTime.getProgress() == sbSongTime.getMax()){
                    sbSongTime.setProgress(I_START_SONG);
                    tbtPlay.setChecked(true);
                    bSeekStop = true;
                }
                if(tbtPlay.isChecked()) {
                    if(bSeekStop) {
                        mpSongPlayer.seekTo(I_START_SONG);
                        bSeekStop = false;
                    }
                    sbSongTime.setProgress(mpSongPlayer.getCurrentPosition());
                    mpSongPlayer.start();
                }
                else {
                    mpSongPlayer.pause();
                    sbSongTime.setProgress(mpSongPlayer.getCurrentPosition());
                }
            }
        });
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bStopClicked = true;
                try {
                    mpSongPlayer.stop();
                    mpSongPlayer.prepare();
                    sbSongTime.setProgress(I_START_SONG);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(tbtPlay.isChecked())
                    tbtPlay.setChecked(false);
            }
        });
        sbSongTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSecs.setText(sTimeFormat(progress/I_SECOND_DIVIDER));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(mpSongPlayer.isPlaying()) {
                    mpSongPlayer.pause();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mpSongPlayer.seekTo(seekBar.getProgress());
                sbSongTime.setProgress(mpSongPlayer.getCurrentPosition());
                hSongHandler.postDelayed(rSongRunnable, I_DELAY);
                if(!tbtPlay.isChecked() && seekBar.getProgress() != seekBar.getMax())
                    tbtPlay.setChecked(true);
                if(seekBar.getProgress() != seekBar.getMax())
                    mpSongPlayer.start();
                else  {
                    tbtPlay.setChecked(false);
                }
            }
        });
    }
    public void vSeekUpdation() {
        if(mpSongPlayer != null) {
            if(bStopClicked) {
                mpSongPlayer.seekTo(I_START_SONG);
                bStopClicked = false;
            }
            int iMPos = mpSongPlayer.getCurrentPosition();
            sbSongTime.setProgress(mpSongPlayer.getCurrentPosition());
            hSongHandler.postDelayed(rSongRunnable, I_DELAY);
            tvSecs.setText(sTimeFormat(iMPos/I_SECOND_DIVIDER));
        }
    }
    @Override
    public void finish() {
        mpSongPlayer.stop();
        super.finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    String sTimeFormat(int iSeconds) {
        int iMins = iSeconds/I_SECONDS;
        int iSecs = iSeconds%I_SECONDS;
        if(iMins < I_DIGITS) {
            if(iSecs < I_DIGITS)
                return getResources().getString(R.string.zero)+iMins+getResources().getString(R.string.colon)+getResources().getString(R.string.zero)+iSecs;
            else
                return getResources().getString(R.string.zero)+iMins+getResources().getString(R.string.colon)+iSecs;
        }
        else {
            if(iSecs < I_DIGITS)
                return iMins+getResources().getString(R.string.colon)+getResources().getString(R.string.zero)+iSecs;
            else
                return iMins+getResources().getString(R.string.colon)+iSecs;
        }
    }
    Map mpFillMap(Map<String, MySong> mpMap) {

        mpMap.put(getResources().getStringArray(R.array.czcijmy_ids)[I_VIOL1_POS], new MySong(R.drawable.czcijmy_v1, R.raw.czcijmy_v1));
        mpMap.put(getResources().getStringArray(R.array.czcijmy_ids)[I_VIOL2_POS], new MySong(R.drawable.czcijmy_v2, R.raw.czcijmy_v2));
        mpMap.put(getResources().getStringArray(R.array.czcijmy_ids)[I_CELLO_POS], new MySong(R.drawable.czcijmy_c, R.raw.czcijmy_c));
        mpMap.put(getResources().getStringArray(R.array.czcijmy_ids)[I_TRMPT1_POS], new MySong(R.drawable.czcijmy_t1, R.raw.czcijmy_t1));
        mpMap.put(getResources().getStringArray(R.array.czcijmy_ids)[I_TRMPT2_POS], new MySong(R.drawable.czcijmy_t2, R.raw.czcijmy_t2));
        mpMap.put(getResources().getStringArray(R.array.czcijmy_ids)[I_SAX_POS], new MySong(R.drawable.czcijmy_s, R.raw.czcijmy_s));

        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[I_VIOL1_POS], new MySong(R.drawable.duszo_ma_v1, R.raw.duszo_ma_v1m));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[I_VIOL2_POS], new MySong(R.drawable.duszo_ma_v2, R.raw.duszo_ma_v2m));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[I_CELLO_POS], new MySong(R.drawable.duzo_ma_c, R.raw.duszo_ma_cm));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[I_TRMPT1_POS], new MySong(R.drawable.duszo_ma_t, R.raw.duszo_ma_t1));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[I_TRMPT2_POS], new MySong(R.drawable.duszo_ma_t2, R.raw.duszo_ma_t2));
        mpMap.put(getResources().getStringArray(R.array.duszo_ma_ids)[I_SAX_POS], new MySong(R.drawable.duszo_ma_sax, R.raw.duszo_ma_s));

        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[I_VIOL1_POS], new MySong(R.drawable.genesis_v1, R.raw.genesis_v1));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[I_VIOL2_POS], new MySong(R.drawable.genesis_v2, R.raw.genesis_v2));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[I_CELLO_POS], new MySong(R.drawable.genesis_c, R.raw.genesis_cm));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[I_TRMPT1_POS], new MySong(R.drawable.genesis_t1, R.raw.genesis_t1));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[I_TRMPT2_POS], new MySong(R.drawable.genesis_t2, R.raw.genesis_t2));
        mpMap.put(getResources().getStringArray(R.array.genesis_ids)[I_SAX_POS], new MySong(R.drawable.genesic_s, R.raw.genesis_s));

        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[I_VIOL1_POS], new MySong(R.drawable.hej_jezu_v, R.raw.hej_jezu_v));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[I_VIOL2_POS], new MySong(R.drawable.hej_jezu_v, R.raw.hej_jezu_v));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[I_CELLO_POS], new MySong(R.drawable.hej_jezu_c, R.raw.hej_jezu_c));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[I_TRMPT1_POS], new MySong(R.drawable.hej_jezu_t1, R.raw.hej_jezu_tm));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[I_TRMPT2_POS], new MySong(R.drawable.hej_jezu_t2, R.raw.hej_jezu_t2m));
        mpMap.put(getResources().getStringArray(R.array.hej_jezu_ids)[I_SAX_POS], new MySong(R.drawable.hej_jezu_s, R.raw.hej_jezu_sm));

        mpMap.put(getResources().getStringArray(R.array.idz_i_glos_ids)[I_TRMPT1_POS], new MySong(R.drawable.idz_t1, R.raw.idz_t1));
        mpMap.put(getResources().getStringArray(R.array.idz_i_glos_ids)[I_TRMPT2_POS], new MySong(R.drawable.idz_t2, R.raw.idz_t2));
        mpMap.put(getResources().getStringArray(R.array.idz_i_glos_ids)[I_SAX_POS], new MySong(R.drawable.idz_s, R.raw.idz_s));

        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[I_VIOL1_POS], new MySong(R.drawable.jak_dobrze_v1, R.raw.jak_dobrze_v1));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[I_VIOL2_POS], new MySong(R.drawable.jak_dobrze_v2, R.raw.jak_dobrze_v2));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[I_CELLO_POS], new MySong(R.drawable.jak_dobrze_c, R.raw.jak_dobrze_cm));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[I_TRMPT1_POS], new MySong(R.drawable.jak_dobrze_tt, R.raw.jak_dobrze_t));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[I_TRMPT2_POS], new MySong(R.drawable.jak_dobrze_tt, R.raw.jak_dobrze_t));
        mpMap.put(getResources().getStringArray(R.array.jak_dobrze_ids)[I_SAX_POS], new MySong(R.drawable.jak_dobrze_s, R.raw.jak_dobrze_s));

        mpMap.put(getResources().getStringArray(R.array.jego_milosc_ids)[I_VIOL1_POS], new MySong(R.drawable.jego_milosc_v1, R.raw.jego_milosc_v1));
        mpMap.put(getResources().getStringArray(R.array.jego_milosc_ids)[I_VIOL2_POS], new MySong(R.drawable.jego_milosc_v2, R.raw.jego_milosc_v2));
        mpMap.put(getResources().getStringArray(R.array.jego_milosc_ids)[I_CELLO_POS], new MySong(R.drawable.jego_milosc_c, R.raw.jego_milosc_c));

        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[I_VIOL1_POS], new MySong(R.drawable.kazdy_wschod_v, R.raw.kazdy_wschod_v));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[I_VIOL2_POS], new MySong(R.drawable.kazdy_wschod_v, R.raw.kazdy_wschod_v));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[I_CELLO_POS], new MySong(R.drawable.kazdy_wschod_c, R.raw.kazdy_wschod_c));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[I_TRMPT1_POS], new MySong(R.drawable.kazdy_wschod_tt, R.raw.kazdy_wschod_t));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[I_TRMPT2_POS], new MySong(R.drawable.kazdy_wschod_tt, R.raw.kazdy_wschod_t));
        mpMap.put(getResources().getStringArray(R.array.kazdy_wschod_ids)[I_SAX_POS], new MySong(R.drawable.kazdy_wschod_s, R.raw.kazdy_wschod_s));

        mpMap.put(getResources().getStringArray(R.array.nadejdzie_dzien_ids)[I_TRMPT1_POS], new MySong(R.drawable.nadejdzie_dzien_t1, R.raw.nadejdzie_dzien_t1));
        mpMap.put(getResources().getStringArray(R.array.nadejdzie_dzien_ids)[I_TRMPT2_POS], new MySong(R.drawable.nadejdzie_dzien_t2, R.raw.nadejdzie_dzien_t2));
        mpMap.put(getResources().getStringArray(R.array.nadejdzie_dzien_ids)[I_SAX_POS], new MySong(R.drawable.nadejdzie_dzien_s, R.raw.nadejdzie_dzien_s));

        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[I_VIOL1_POS], new MySong(R.drawable.panie_twa_dobroc_v1, R.raw.panie_twa_dobroc_v1));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[I_VIOL2_POS], new MySong(R.drawable.panie_twa_dobroc_c2, R.raw.panie_twa_dobroc_v2));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[I_CELLO_POS], new MySong(R.drawable.panie_twa_dobroc_c, R.raw.panie_twa_dobroc_c));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[I_TRMPT1_POS], new MySong(R.drawable.panie_twa_dobroc_t, R.raw.panie_twa_dobroc_t1));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[I_TRMPT2_POS], new MySong(R.drawable.panie_twa_dobroc_t2, R.raw.panie_twa_dobroc_t2));
        mpMap.put(getResources().getStringArray(R.array.panie_twa_dobroc_ids)[I_SAX_POS], new MySong(R.drawable.panie_twa_dobroc_s, R.raw.panie_twa_dobroc_s));

        mpMap.put(getResources().getStringArray(R.array.pozwol_by_ids)[I_VIOL1_POS], new MySong(R.drawable.pozwol_v1, R.raw.pozwol_v1));
        mpMap.put(getResources().getStringArray(R.array.pozwol_by_ids)[I_VIOL2_POS], new MySong(R.drawable.pozwol_v2, R.raw.pozwol_v2));
        mpMap.put(getResources().getStringArray(R.array.pozwol_by_ids)[I_CELLO_POS], new MySong(R.drawable.pozwol_c, R.raw.pozwol_c));

        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[I_VIOL1_POS], new MySong(R.drawable.przyjdz_jak_v1, R.raw.przyjdz_jak_v1));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[I_VIOL2_POS], new MySong(R.drawable.przyjdz_jak_v2, R.raw.przyjdz_jak_v2));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[I_CELLO_POS], new MySong(R.drawable.przyjdz_jak_c, R.raw.przyjdz_jak_c));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[I_TRMPT1_POS], new MySong(R.drawable.przyjdz_jak_t, R.raw.przyjdz_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[I_TRMPT2_POS], new MySong(R.drawable.przyjdz_jak_t, R.raw.przyjdz_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.przyjdz_jak_ids)[I_SAX_POS], new MySong(R.drawable.przyjdz_jak_s, R.raw.przyjdz_jak_s));

        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[I_VIOL1_POS], new MySong(R.drawable.stoje_dzis_v1, R.raw.stoje_v1));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[I_VIOL2_POS], new MySong(R.drawable.stoje_dzis_v2, R.raw.stoje_v2));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[I_CELLO_POS], new MySong(R.drawable.stoje_dzis_c, R.raw.stoje_c));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[I_TRMPT1_POS], new MySong(R.drawable.stoje_tt, R.raw.stoje_dzis_tt));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[I_TRMPT2_POS], new MySong(R.drawable.stoje_tt, R.raw.stoje_dzis_tt));
        mpMap.put(getResources().getStringArray(R.array.stoje_dzis_ids)[I_SAX_POS], new MySong(R.drawable.stoje_s, R.raw.stoje_dzis_s));

        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[I_VIOL1_POS], new MySong(R.drawable.sandaly_v1, R.raw.sandaly_v1));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[I_VIOL2_POS], new MySong(R.drawable.sandaly_v2, R.raw.sandaly_v2));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[I_CELLO_POS], new MySong(R.drawable.sandaly_c, R.raw.sandaly_c));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[I_TRMPT1_POS], new MySong(R.drawable.sandaly_tt, R.raw.sandaly_tt));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[I_TRMPT2_POS], new MySong(R.drawable.sandaly_tt, R.raw.sandaly_tt));
        mpMap.put(getResources().getStringArray(R.array.sandaly_ids)[I_SAX_POS], new MySong(R.drawable.sandaly_s, R.raw.sandaly_s));

        mpMap.put(getResources().getStringArray(R.array.schowaj_ids)[I_VIOL1_POS], new MySong(R.drawable.schowaj_v1, R.raw.schowaj_v1));
        mpMap.put(getResources().getStringArray(R.array.schowaj_ids)[I_VIOL2_POS], new MySong(R.drawable.schowaj_v2, R.raw.schowaj_v2));
        mpMap.put(getResources().getStringArray(R.array.schowaj_ids)[I_CELLO_POS], new MySong(R.drawable.schowaj_c, R.raw.schowaj_c));
        mpMap.put(getResources().getStringArray(R.array.schowaj_ids)[I_TRMPT1_POS], new MySong(R.drawable.schowaj_tt, R.raw.schowaj_tts));
        mpMap.put(getResources().getStringArray(R.array.schowaj_ids)[I_TRMPT2_POS], new MySong(R.drawable.schowaj_tt, R.raw.schowaj_tts));
        mpMap.put(getResources().getStringArray(R.array.schowaj_ids)[I_SAX_POS], new MySong(R.drawable.schowaj_s, R.raw.schowaj_tts));

        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[I_VIOL1_POS], new MySong(R.drawable.to_krol_v1, R.raw.to_krol_v));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[I_VIOL2_POS], new MySong(R.drawable.to_krol_v2, R.raw.to_krol_v));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[I_CELLO_POS], new MySong(R.drawable.to_krol_c, R.raw.to_krol_c));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[I_TRMPT1_POS], new MySong(R.drawable.to_krol_t, R.raw.to_krol_t1));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[I_TRMPT2_POS], new MySong(R.drawable.to_krol_t2, R.raw.to_krol_t2));
        mpMap.put(getResources().getStringArray(R.array.to_krol_ids)[I_SAX_POS], new MySong(R.drawable.to_krol_s, R.raw.to_krol_s));

        mpMap.put(getResources().getStringArray(R.array.uwielbiamy_cie_ids)[I_TRMPT1_POS], new MySong(R.drawable.uwielbiamy_tt, R.raw.uwielbiamy_cie_tt));
        mpMap.put(getResources().getStringArray(R.array.uwielbiamy_cie_ids)[I_TRMPT2_POS], new MySong(R.drawable.uwielbiamy_tt, R.raw.uwielbiamy_cie_tt));
        mpMap.put(getResources().getStringArray(R.array.uwielbiamy_cie_ids)[I_SAX_POS], new MySong(R.drawable.uwielbiamy_s, R.raw.uwielbiamy_cie_s));

        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[I_VIOL1_POS], new MySong(R.drawable.wierzyc_jak_piotr_viol1, R.raw.wierzyc_jak_piotr_v1));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[I_VIOL2_POS], new MySong(R.drawable.wierzyc_jak_piotr_viol2, R.raw.wierzyc_jak_piotr_v2));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[I_CELLO_POS], new MySong(R.drawable.wierzyc_jak_piotr_cello, R.raw.wierzyc_jak_piotr_c));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[I_TRMPT1_POS], new MySong(R.drawable.wierzyc_jak_piotr_tt, R.raw.wierzyc_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[I_TRMPT2_POS], new MySong(R.drawable.wierzyc_jak_piotr_tt, R.raw.wierzyc_jak_tt));
        mpMap.put(getResources().getStringArray(R.array.wierzyc_jak_piotr_ids)[I_SAX_POS], new MySong(R.drawable.wierzyc_jak_piotr_s, R.raw.wierzyc_jak_s));

        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[I_VIOL1_POS], new MySong(R.drawable.wykrzykujcie_v1, R.raw.wykrzykujcie_v1));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[I_VIOL2_POS], new MySong(R.drawable.wykrzykujcie_v2, R.raw.wykrzykujcie_v2));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[I_CELLO_POS], new MySong(R.drawable.wykrzykujcie_c, R.raw.wykrzykujcie_c));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[I_TRMPT1_POS], new MySong(R.drawable.wykrz_t1, R.raw.wykrz_t1));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[I_TRMPT2_POS], new MySong(R.drawable.wykrz_t2, R.raw.wykrz_t2));
        mpMap.put(getResources().getStringArray(R.array.wykrzykujcie_ids)[I_SAX_POS], new MySong(R.drawable.wykrz_s, R.raw.wykrz_s));

        mpMap.put(getResources().getStringArray(R.array.zbawca_ids)[I_TRMPT1_POS], new MySong(R.drawable.zbawca_t1, R.raw.zbawca_t1));
        mpMap.put(getResources().getStringArray(R.array.zbawca_ids)[I_TRMPT2_POS], new MySong(R.drawable.zbawca_t2, R.raw.zbawca_t2));
        mpMap.put(getResources().getStringArray(R.array.zbawca_ids)[I_SAX_POS], new MySong(R.drawable.zbawca_s, R.raw.zbawca_s));

        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[I_VIOL1_POS], new MySong(R.drawable.ziemia_v1, R.raw.ziemia_v1));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[I_VIOL2_POS], new MySong(R.drawable.ziemia_v2, R.raw.ziemia_v2));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[I_CELLO_POS], new MySong(R.drawable.ziemia_c, R.raw.ziemia_c));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[I_TRMPT1_POS], new MySong(R.drawable.ziemia_t1, R.raw.ziemia_t1));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[I_TRMPT2_POS], new MySong(R.drawable.ziemia_t2, R.raw.ziemia_t2));
        mpMap.put(getResources().getStringArray(R.array.ziemia_ids)[I_SAX_POS], new MySong(R.drawable.ziemia_s, R.raw.ziemia_s));

        return mpMap;
    }
}
