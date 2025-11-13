package com.example.blood.popup;

import androidx.room.Database;


@Database(entities = {UserEntity.class, NameDao.class}, version = 1)
public abstract class AppDatabase {

    public abstract UserDao userDao();


}
