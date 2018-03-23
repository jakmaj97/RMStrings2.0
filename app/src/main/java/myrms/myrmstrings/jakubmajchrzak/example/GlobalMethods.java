package myrms.myrmstrings.jakubmajchrzak.example;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import myrms.myrmstrings.jakubmajchrzak.example.R;

public class GlobalMethods {

    Context contMyContext;
    boolean bScoresExist;

    public GlobalMethods(Context contUserContext) {
        contMyContext = contUserContext;
        bScoresExist = true;
    }
    public void vEmptySongToast() {
        bScoresExist = false;
        Toast toast = Toast.makeText(contMyContext, contMyContext.getResources().getString(R.string.no_scores_comm), Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.color.colorPrimary);
        toast.show();
    }
}
