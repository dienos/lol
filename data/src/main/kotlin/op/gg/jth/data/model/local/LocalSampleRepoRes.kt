package op.gg.jth.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import op.gg.jth.domain.model.local.LocalSampleRepo

@Entity(tableName = "sample")
data class LocalSampleRepoRes(
    @PrimaryKey(autoGenerate = true)
    val _id: Long,
    val _name: String,
) : LocalSampleRepo {
    override val id: Long
        get() = _id

    override val name: String
    get() = _name
}