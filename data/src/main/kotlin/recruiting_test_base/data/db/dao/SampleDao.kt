package recruiting_test_base.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import recruiting_test_base.data.model.LocalSampleRepoRes

@Dao
interface SampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: LocalSampleRepoRes)

    @Query("SELECT * FROM sample")
    suspend fun getSamples(): List<LocalSampleRepoRes>
}