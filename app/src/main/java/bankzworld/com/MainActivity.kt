package bankzworld.com

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create instance for AppDatabase class
        appDatabase = AppDatabase.getInstance(this)

        // object of student class
        val student = Student()

        // setting names to be added to the list
        student.firstName = "Anonymous"
        student.lastName = "Jbankz"

        // thread for saving students name
        Thread {
            appDatabase!!.studentDao().saveStudent(student)
        }.start()

        // thread for retrieving students name
        Thread {
            appDatabase!!.studentDao().loadAll().forEach {
                runOnUiThread {
                    // appends retrieved names from database to the textView
                    show.append("${it.firstName} \n ${it.lastName}")
                }
            }
        }.start()
    }
}
