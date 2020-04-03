package com.example.mylistviewexample

import android.content.Context
import android.database.DataSetObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.listView)
        listview.adapter = MyAdapter(this)
    }

    private class MyAdapter(context: Context) : ListAdapter {

        private val mcontext: Context

        val countries = arrayListOf<String>(
            "Brazil","India","America","England","Australia"
        )

        init {
            mcontext = context
        }

        override fun isEmpty(): Boolean {
            return false
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mcontext)
            val row = layoutInflater.inflate(R.layout.row_main,parent,false)

            val nameText = row.findViewById<TextView>(R.id.name)
            nameText.text = countries.get(position)

           val rowLocation =  row.findViewById<TextView>(R.id.count)
            rowLocation.text = "Row number: $position"

            return row
//            val textView = TextView(mcontext)
//            textView.text = "Hello World"
//            return textView
        }

        override fun registerDataSetObserver(observer: DataSetObserver?) {

        }

        override fun getItemViewType(position: Int): Int {
            return position
        }

        override fun getItem(position: Int): Any {
            return "Test"
        }

        override fun getViewTypeCount(): Int {
            return countries.size
        }

        override fun isEnabled(position: Int): Boolean {
            return true
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun areAllItemsEnabled(): Boolean {
            return true
        }

        override fun unregisterDataSetObserver(observer: DataSetObserver?) {

        }

        override fun getCount(): Int {
            return viewTypeCount
        }


    }
}
