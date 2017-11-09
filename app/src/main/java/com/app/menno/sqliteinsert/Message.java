package com.app.menno.sqliteinsert;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Menno on 5-11-2017.
 */

public class Message {
    // Laat de message zien aan de user
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}

