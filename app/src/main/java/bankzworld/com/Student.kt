package bankzworld.com

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null
    @ColumnInfo(name = "first_name")
    var firstName: String? = null
    @ColumnInfo(name = "last_name")
    var lastName: String? = null
}