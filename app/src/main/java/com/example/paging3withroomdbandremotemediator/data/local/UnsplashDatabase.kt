package com.example.paging3withroomdbandremotemediator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3withroomdbandremotemediator.data.local.dao.UnsplashImageDao
import com.example.paging3withroomdbandremotemediator.data.local.dao.UnsplashRemoteKeysDao
import com.example.paging3withroomdbandremotemediator.model.UnsplashImage
import com.example.paging3withroomdbandremotemediator.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase(){

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao


}