package bankzworld.com

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveStudent(student: Student)

    @Query("SELECT * FROM student")
    fun loadAll(): List<Student>

}