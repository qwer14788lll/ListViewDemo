package com.example.listviewdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.CHINA
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    //数据源
    private val data = listOf(
        "苹果",
        "香蕉",
        "哈密瓜",
        "月饼",
        "荔枝",
        "桂圆",
        "毛桃",
        "腊肠",
        "肠粉",
        "猕猴桃",
        "蜜桃",
        "橘子",
        "芒果",
        "西瓜",
        "熊猫",
        "猫咪",
        "二哈"
    )
    private val fruitList = ArrayList<Fruit>()

    private fun initFruits() {
        repeat(2)
        {
            fruitList.add(Fruit("鼠", R.drawable.animal_0))
            fruitList.add(Fruit("牛", R.drawable.animal_1))
            fruitList.add(Fruit("虎", R.drawable.animal_2))
            fruitList.add(Fruit("兔", R.drawable.animal_3))
            fruitList.add(Fruit("龙", R.drawable.animal_4))
            fruitList.add(Fruit("蛇", R.drawable.animal_5))
            fruitList.add(Fruit("马", R.drawable.animal_6))
            fruitList.add(Fruit("羊", R.drawable.animal_7))
            fruitList.add(Fruit("猴", R.drawable.animal_8))
            fruitList.add(Fruit("鸡", R.drawable.animal_9))
            fruitList.add(Fruit("狗", R.drawable.animal_10))
            fruitList.add(Fruit("猪", R.drawable.animal_11))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFruits()

        //上下文，列表子视图，数据源
        //val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data)
        val fruitAdapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        //绑定到控件
        //listViewTest.adapter = adapter;
        listViewTest.adapter = fruitAdapter;

        listViewTest.setOnItemClickListener { _, _, i, _ ->
            val fruit = fruitList[i]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }
}