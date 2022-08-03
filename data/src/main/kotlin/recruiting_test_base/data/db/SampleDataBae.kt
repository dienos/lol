package recruiting_test_base.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import recruiting_test_base.data.db.dao.SampleDao
import recruiting_test_base.data.model.LocalSampleRepoRes

@Database(
    entities = [LocalSampleRepoRes::class],
    version = 1,
    exportSchema = false
)
abstract class SampleDataBae : RoomDatabase() {
   abstract fun SampleDao() : SampleDao
}