package com.appbrainmob.bubblesoft.homeworkguru.externals;

import android.graphics.Bitmap;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;

/**
 * Created by Win 8 on 3/26/2017.
 */
public class TessOCR {

    private TessBaseAPI mTess;

    public TessOCR() {
        // TODO Auto-generated constructor stub
        try {
            mTess = new TessBaseAPI();
            String datapath = Environment.getExternalStorageDirectory() + "/tesseract/";
            String language = "eng";
            File dir = new File(datapath + "tessdata/");
            if (!dir.exists() || !dir.isDirectory())
                dir.mkdirs();
            mTess.init(datapath, language);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOCRResult(Bitmap bitmap) {

        mTess.setImage(bitmap);
        String result = mTess.getUTF8Text();

        return result;
    }

    public void onDestroy() {
        if (mTess != null)
            mTess.end();
    }
}
