package com.doubleclick.marktinhome.Database;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.doubleclick.marktinhome.Model.Chat;

/**
 * Created By Eslam Ghazy on 12/11/2021
 */
@Database(entities = Chat.class, version = 1)
public abstract class ChatDatabase extends RoomDatabase {

    private static ChatDatabase instance;

    public abstract ChatDao EntitiesDAO();

    //Singlton
    public static synchronized ChatDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    ChatDatabase.class, "Chat-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
//                     .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

}
