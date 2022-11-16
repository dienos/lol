package op.gg.jth.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import op.gg.jth.data.db.dao.SampleDao
import op.gg.jth.data.model.local.LocalSampleRepoRes

@Database(
    entities = [LocalSampleRepoRes::class],
    version = 1,
    exportSchema = false
)
abstract class SampleDataBae : RoomDatabase() {
   abstract fun SampleDao() : SampleDao
}