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
import android.widget.Toast;

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

        Button btPlay = (Button) findViewById(R.id.btPlay);
        Button btStop = (Button) findViewById(R.id.btStop);
        Button btPause = (Button) findViewById(R.id.btPause);
        ImageView ivSheet = (ImageView) findViewById(R.id.imageView3);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(ivSheet);
        photoViewAttacher.update();
        final MediaPlayer mpCell;

        String sExtra = getIntent().getExtras().getString("key");

        if(sExtra.equals("wierzycJakPiotr1")) {
            ivSheet.setImageResource(R.drawable.wierzyc_jak_piotr_viol1);
            mpCell = MediaPlayer.create(this, R.raw.wierzyc_jak_piotr_v1);
        }
        else if(sExtra.equals("wierzycJakPiotr2")) {
            ivSheet.setImageResource(R.drawable.wierzyc_jak_piotr_viol2);
            mpCell = MediaPlayer.create(this, R.raw.wierzyc_jak_piotr_v2);
        }
        else if(sExtra.equals("wierzycJakPiotr3")) {
            ivSheet.setImageResource(R.drawable.wierzyc_jak_piotr_cello);
            mpCell = MediaPlayer.create(this, R.raw.wierzyc_jak_piotr_c);
        }

        else if(sExtra.equals("duszoMa1")) {
            ivSheet.setImageResource(R.drawable.duszo_ma_v1);
            mpCell = MediaPlayer.create(this, R.raw.duszo_ma_v1m);
        }
        else if(sExtra.equals("duszoMa2")) {
            ivSheet.setImageResource(R.drawable.duszo_ma_v2);
            mpCell = MediaPlayer.create(this, R.raw.duszo_ma_v2m);
        }
        else if(sExtra.equals("duszoMa3")) {
            ivSheet.setImageResource(R.drawable.duzo_ma_c);
            mpCell = MediaPlayer.create(this, R.raw.duszo_ma_cm);
        }

        else if(sExtra.equals("genesis1")) {
            ivSheet.setImageResource(R.drawable.genesis_v1);
            mpCell = MediaPlayer.create(this, R.raw.genesis_v1);
        }
        else if(sExtra.equals("genesis2")) {
            ivSheet.setImageResource(R.drawable.genesis_v2);
            mpCell = MediaPlayer.create(this, R.raw.genesis_v2);
        }
        else if(sExtra.equals("genesis3")) {
            ivSheet.setImageResource(R.drawable.genesis_c);
            mpCell = MediaPlayer.create(this, R.raw.genesis_cm);
        }

        else if(sExtra.equals("hej1")) {
            ivSheet.setImageResource(R.drawable.hej_jezu_v);
            mpCell = MediaPlayer.create(this, R.raw.hej_jezu_v);
        }
        else if(sExtra.equals("hej2")) {
            ivSheet.setImageResource(R.drawable.hej_jezu_v);
            mpCell = MediaPlayer.create(this, R.raw.hej_jezu_v);
        }
        else if(sExtra.equals("hej3")) {
            ivSheet.setImageResource(R.drawable.hej_jezu_c);
            mpCell = MediaPlayer.create(this, R.raw.hej_jezu_c);
        }

        else if(sExtra.equals("jakDobrze1")) {
            ivSheet.setImageResource(R.drawable.jak_dobrze_v1);
            mpCell = MediaPlayer.create(this, R.raw.jak_dobrze_v1);
        }
        else if(sExtra.equals("jakDobrze2")) {
            ivSheet.setImageResource(R.drawable.jak_dobrze_v2);
            mpCell = MediaPlayer.create(this, R.raw.jak_dobrze_v2);
        }
        else if(sExtra.equals("jakDobrze3")) {
            ivSheet.setImageResource(R.drawable.jak_dobrze_c);
            mpCell = MediaPlayer.create(this, R.raw.jak_dobrze_cm);
        }

        else if(sExtra.equals("jegoMilosc1")) {
            ivSheet.setImageResource(R.drawable.jego_milosc_v1);
            mpCell = MediaPlayer.create(this, R.raw.jego_milosc_v1);
        }
        else if(sExtra.equals("jegoMilosc2")) {
            ivSheet.setImageResource(R.drawable.jego_milosc_v2);
            mpCell = MediaPlayer.create(this, R.raw.jego_milosc_v2);
        }
        else if(sExtra.equals("jegoMilosc3")) {
            ivSheet.setImageResource(R.drawable.jego_milosc_c);
            mpCell = MediaPlayer.create(this, R.raw.jego_milosc_c);
        }

        else if(sExtra.equals("kazdyWschod1")) {
            ivSheet.setImageResource(R.drawable.kazdy_wschod_v);
            mpCell = MediaPlayer.create(this, R.raw.kazdy_wschod_v);
        }

        else if(sExtra.equals("panieTwaDobroc1")) {
            ivSheet.setImageResource(R.drawable.panie_twa_dobroc_v1);
            mpCell = MediaPlayer.create(this, R.raw.panie_twa_dobroc_v1);
        }
        else if(sExtra.equals("panieTwaDobroc2")) {
            ivSheet.setImageResource(R.drawable.panie_twa_dobroc_c2);
            mpCell = MediaPlayer.create(this, R.raw.panie_twa_dobroc_v2);
        }
        else if(sExtra.equals("panieTwaDobroc3")) {
            ivSheet.setImageResource(R.drawable.panie_twa_dobroc_c);
            mpCell = MediaPlayer.create(this, R.raw.panie_twa_dobroc_c);
        }

        else  if(sExtra.equals("pozwol1")) {
            ivSheet.setImageResource(R.drawable.pozwol_v1);
            mpCell = MediaPlayer.create(this, R.raw.pozwol_v1);
        }
        else  if(sExtra.equals("pozwol2")) {
            ivSheet.setImageResource(R.drawable.pozwol_v2);
            mpCell = MediaPlayer.create(this, R.raw.pozwol_v2);
        }
        else  if(sExtra.equals("pozwol3")) {
            ivSheet.setImageResource(R.drawable.pozwol_c);
            mpCell = MediaPlayer.create(this, R.raw.pozwol_c);
        }

        else if(sExtra.equals("przyjdz1")) {
            ivSheet.setImageResource(R.drawable.przyjdz_jak_v1);
            mpCell = MediaPlayer.create(this, R.raw.przyjdz_jak_v1);
        }
        else if(sExtra.equals("przyjdz2")) {
            ivSheet.setImageResource(R.drawable.przyjdz_jak_v2);
            mpCell = MediaPlayer.create(this, R.raw.przyjdz_jak_v2);
        }
        else if(sExtra.equals("przyjdz3")) {
            ivSheet.setImageResource(R.drawable.przyjdz_jak_c);
            mpCell = MediaPlayer.create(this, R.raw.przyjdz_jak_c);
        }

        else if(sExtra.equals("stoje1")) {
            ivSheet.setImageResource(R.drawable.stoje_dzis_v1);
            mpCell = MediaPlayer.create(this, R.raw.stoje_v1);
        }
        else if(sExtra.equals("stoje2")) {
            ivSheet.setImageResource(R.drawable.stoje_dzis_v2);
            mpCell = MediaPlayer.create(this, R.raw.stoje_v2);
        }
        else if(sExtra.equals("stoje3")) {
            ivSheet.setImageResource(R.drawable.stoje_dzis_c);
            mpCell = MediaPlayer.create(this, R.raw.stoje_c);
        }

        else if(sExtra.equals("sandaly1")) {
            ivSheet.setImageResource(R.drawable.sandaly_v1);
            mpCell = MediaPlayer.create(this, R.raw.sandaly_v1);
        }
        else if(sExtra.equals("sandaly2")) {
            ivSheet.setImageResource(R.drawable.sandaly_v2);
            mpCell = MediaPlayer.create(this, R.raw.sandaly_v2);
        }
        else if(sExtra.equals("sandaly3")) {
            ivSheet.setImageResource(R.drawable.sandaly_c);
            mpCell = MediaPlayer.create(this, R.raw.sandaly_c);
        }

        else if(sExtra.equals("toKrol1")) {
            ivSheet.setImageResource(R.drawable.to_krol_v1);
            mpCell = MediaPlayer.create(this, R.raw.to_krol_v);
        }
        else if(sExtra.equals("toKrol2")) {
            ivSheet.setImageResource(R.drawable.to_krol_v2);
            mpCell = MediaPlayer.create(this, R.raw.to_krol_v);
        }
        else if(sExtra.equals("toKrol3")) {
            ivSheet.setImageResource(R.drawable.to_krol_c);
            mpCell = MediaPlayer.create(this, R.raw.to_krol_c);
        }

        else if(sExtra.equals("wykrz1")) {
            ivSheet.setImageResource(R.drawable.wykrzykujcie_v1);
            mpCell = MediaPlayer.create(this, R.raw.wykrzykujcie_v1);
        }
        else if(sExtra.equals("wykrz2")) {
            ivSheet.setImageResource(R.drawable.wykrzykujcie_v2);
            mpCell = MediaPlayer.create(this, R.raw.wykrzykujcie_v2);
        }
        else if(sExtra.equals("wykrz3")) {
            ivSheet.setImageResource(R.drawable.wykrzykujcie_c);
            mpCell = MediaPlayer.create(this, R.raw.wykrzykujcie_c);
        }

        else if(sExtra.equals("ziemia1")) {
            ivSheet.setImageResource(R.drawable.ziemia_v1);
            mpCell = MediaPlayer.create(this, R.raw.ziemia_v1);
        }
        else if(sExtra.equals("ziemia2")) {
            ivSheet.setImageResource(R.drawable.ziemia_v2);
            mpCell = MediaPlayer.create(this, R.raw.ziemia_v2);
        }
        else if(sExtra.equals("ziemia3")) {
            ivSheet.setImageResource(R.drawable.ziemia_c);
            mpCell = MediaPlayer.create(this, R.raw.ziemia_c);
        }
        else {
            bMpSetted = false;
            mpCell = null;
            vShowToast();
        }

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
                    mpCell.pause();
                    mpCell.seekTo(0);
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
        if(item.getItemId()== android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void vShowToast() {
        Toast toast = Toast.makeText(getApplicationContext(), "Coś poszło nie tak :/ :(", Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.color.colorPrimary);
        toast.show();
    }
}
