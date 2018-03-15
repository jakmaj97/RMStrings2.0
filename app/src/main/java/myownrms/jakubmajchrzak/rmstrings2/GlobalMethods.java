package myownrms.jakubmajchrzak.rmstrings2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class GlobalMethods {
    Context contMyContext;

    public GlobalMethods(Context contUserContext) {
        contMyContext = contUserContext;
    }
    public void vEmptySongToast() {
        Toast toast = Toast.makeText(contMyContext, contMyContext.getResources().getString(R.string.no_scores_comm), Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundResource(R.color.colorPrimary);
        toast.show();
    }
}
