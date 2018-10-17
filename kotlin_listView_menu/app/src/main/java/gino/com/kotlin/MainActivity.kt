package gino.com.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem


import android.view.Menu
import android.widget.*

class MainActivity : AppCompatActivity() {
    private val data = arrayOf("關於Android Tutorial的事情",
            "一隻非常可愛的小狗狗!", "一首非常好聽的音樂！")
    private val adapter : ArrayAdapter<String> by lazy { ArrayAdapter (this,android.R.layout.simple_list_item_1,data) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item_list : ListView  = findViewById(R.id.item_list)
        item_list.adapter = adapter

        val item_event = AdapterView.OnItemClickListener() {
            // parent: 使用者操作的ListView物件
            // view: 使用者選擇的項目
            // position: 使用者選擇的項目編號，第一個是0
            // id: 在這裡沒有用途
            parent, view , position, id ->
            Toast.makeText(this@MainActivity,data[position],Toast.LENGTH_LONG).show()
        }
        item_list.onItemClickListener = item_event
    }

    // 載入選單資源
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun clickMenuItem (item: MenuItem) {
        val itemId = item.itemId
        when (itemId)
        {
            R.id.search_item -> {
                Toast.makeText(this,"search_item",Toast.LENGTH_LONG).show()
            }
            R.id.add_item -> {
                Toast.makeText(this,"add_item",Toast.LENGTH_LONG).show()
            }
            R.id.revert_item -> {
                Toast.makeText(this,"revert_item",Toast.LENGTH_LONG).show()
            }
            R.id.delete_item -> {
                Toast.makeText(this,"delete_item",Toast.LENGTH_LONG).show()
            }
        }

    }
}
