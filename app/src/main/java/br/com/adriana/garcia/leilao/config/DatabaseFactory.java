package br.com.adriana.garcia.leilao.config;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseFactory {

    public DatabaseConfig getDatabase(Context context) {
        return Room
                .databaseBuilder(context, DatabaseConfig.class, "leilao")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
