package gino.com.kotlin_viewpager

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gino.com.kotlin_viewpager.R.id.pager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_slider.view.*

class MainActivity : AppCompatActivity() {

    val images: IntArray = intArrayOf(R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {

        val adapter: PagerAdapter = SliderPagerAdapter(this, images)
        val pager : ViewPager = findViewById(R.id.pager)
        pager.adapter = adapter


        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                println("on page scroll state changed $state")
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val currentPosition = position + 1
                pageCountTextView.text = "$currentPosition / ${images.size}"
            }

            override fun onPageSelected(position: Int) {
                println("on page selected $position")
            }

        })

    }


    private class SliderPagerAdapter : PagerAdapter {

        val context: Context
        val images: IntArray
        lateinit var inflator: LayoutInflater

        constructor(context: Context, images: IntArray) : super(){
            this.context = context
            this.images = images

        }

        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
            return view == `object` as ConstraintLayout

        }

        override fun getCount(): Int {
            return images.size
        }

        override fun instantiateItem(container: ViewGroup?, position: Int): Any {

            inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val rv: View = inflator.inflate(R.layout.fragment_slider, container,false)
            rv.imageView.setImageResource(images[position])
            container!!.addView(rv)
            return rv
        }

        override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
            container!!.removeView(`object` as ConstraintLayout)
        }

    }

}
