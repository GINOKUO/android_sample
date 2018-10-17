package gino.com.kotlin_tap_counter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var counter:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewddddd()
    }

    private fun setupViewddddd() {
        button.setOnClickListener{
            counter +=1
            tv.text = counter.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean{
        this.menuInflater.inflate(R.menu.menu_main,menu)
        return super .onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.resetButton -> {
                this.counter = 0
                this.tv.text = "0"
            } else -> println("item not found onOptionsItemSelected")
        }


        return super.onOptionsItemSelected(item)
    }
}
