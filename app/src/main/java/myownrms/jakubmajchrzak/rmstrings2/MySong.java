package myownrms.jakubmajchrzak.rmstrings2;

import android.view.View;

public class MySong {
    int iImage;
    int iMusic;

    MySong(int iImage, int iMusic) {
        this.iImage = iImage;
        this.iMusic = iMusic;
    }

    public int getImage() {
        return iImage;
    }
    public int getMusic() {
        return  iMusic;
    }
}
