package com.example.slwat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.slwat.model.Salah
import java.util.concurrent.Executors


@Database(
entities = [Salah::class],
    version = 2
)
abstract class SalahDatabase: RoomDatabase() {




    abstract fun getSalahDao():SalahDao

    companion object {
        private val fajr: Salah = Salah(1,1,"ElFajr",0)
        private val dohr: Salah = Salah(2,2,"ElDohr",0)
        private val asr: Salah = Salah(3,3,"ElAsr",0)
        private val maghrib: Salah = Salah(4,4,"ElMaghrib",0)
        private val isha: Salah = Salah(5,5,"ElIsha",0)

        val list = mutableListOf<Salah>(fajr,dohr,asr,maghrib,isha)
        @Volatile
        private var instance: SalahDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it}
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SalahDatabase::class.java,
                "Salah_db.db"
            ).addCallback(object : Callback(){
                override fun onCreate(db:SupportSQLiteDatabase){
                    super.onCreate(db)
                    Executors.newSingleThreadExecutor().execute(Runnable {
                        instance!!.getSalahDao().upsert(list)
                    })
                }
            })
                .fallbackToDestructiveMigration()
             .build()
    }
}

/*private fun buildDatabase(context: Context): AppDatabase? {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "my-database"
    )
        .addCallback(object : Callback() {
            fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Executors.newSingleThreadScheduledExecutor().execute(Runnable {
                    getInstance(context).dataDao().insertAll(DataEntity.populateData())
                })
            }
        })
        .build()
}*/