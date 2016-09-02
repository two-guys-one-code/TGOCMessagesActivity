package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.view.View;

/**
 * Created by rodrigocavalcante on 9/2/16.
 */
public interface TGOCMessageMediaInterface {
    View getView(Context context);
    <T> T getData();
}
