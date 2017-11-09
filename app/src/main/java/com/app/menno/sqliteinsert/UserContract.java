package com.app.menno.sqliteinsert;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Menno on 5-11-2017.
 */

public class UserContract {
    public final static String DATABASE_NAME = "employee";
    public final static int DATABASE_VERSION = 5;

    // Instance van een user
    public final static class UserEntity {
        public final static String TABLE_NAME = "UserInfo";
        public final static String UID = BaseColumns._ID;
        public final static String USER_NAME = "UserName";
        public final static String USER_PWD = "Password";
    }
}
