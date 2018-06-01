package com.yg.a3rdseminar

import android.content.Intent
import android.graphics.Canvas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{



    private lateinit var kakaoItems : ArrayList<KaKaoItem>
    private lateinit var kaKaoAdapter: KaKaoAdapter
    lateinit var swipeController: SwipeController
    lateinit var itemTouchListener: ItemTouchHelper

    var isDisplayButtons : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //swipeController = SwipeController()



        kakaoItems = ArrayList()
        kakaoItems.add(KaKaoItem(R.drawable.pika1, "09의 바나나안드로이드", "낰낰", "오후 4:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika2, "이돌이의 차근차근기획", ":D ><", "오후 6:05"))
        kakaoItems.add(KaKaoItem(R.drawable.pika3, "트카의 트카TV", "브이로그 찍었당~~", "오후 3:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika4, "사과의 고속사과", "이상하다 혜진아,, 내심장은 너한테만 반응하나봐,,", "오후 8:24"))
        kakaoItems.add(KaKaoItem(R.drawable.pika5, "섭이의 섭섭한칼퇴", "옆모습 정승환(섭피셜)", "오후 11:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika6, "인누강의 웹마이웨이", "호에에에에에엥", "오후 12:16"))
        kakaoItems.add(KaKaoItem(R.drawable.pika7, "신선이의 힐링캠프", "얘들아 그.. 딱 5분만 말할게요^^", "오후 8:02"))
        kakaoItems.add(KaKaoItem(R.drawable.pika8, "할머니의 당찬하루", "야!", "오후 4:21"))
        kakaoItems.add(KaKaoItem(R.drawable.pika9, "이모님의 회계원리", "뒤풀이 어디가지...★", "오후 11:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika10, "대장의 생방송", "따봉따봉미 bb", "오후 10:10"))

        kaKaoAdapter = KaKaoAdapter(kakaoItems, this)
        kaKaoAdapter.setOnItemClickListener(this)


        main_rv.layoutManager = LinearLayoutManager(this)
        main_rv.adapter = kaKaoAdapter

        swipeController = SwipeController(object : SwipeControllerActions() {
            override fun onRightClicked(position: Int) {
                //kaKaoAdapter..remove(position)
                kaKaoAdapter.notifyItemRemoved(position)
                kaKaoAdapter.notifyItemRangeChanged(position, kaKaoAdapter.itemCount)
            }
        })

        itemTouchListener = ItemTouchHelper(swipeController)
        itemTouchListener.attachToRecyclerView(main_rv)

        main_rv.addItemDecoration(object : RecyclerView.ItemDecoration(){
            override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
                swipeController.onDraw(c!!)
            }
        })
        main_float_add.setOnClickListener {
            clickFloat()
        }

        main_float_c1.setOnClickListener {
            Toast.makeText(this, "1번 버튼", Toast.LENGTH_SHORT).show()
        }

        main_float_c2.setOnClickListener {
            Toast.makeText(this, "2번 버튼", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClick(v: View?) {
        val idx : Int = main_rv.getChildAdapterPosition(v)
        val name : String = kakaoItems[idx].name
        val profile : Int = kakaoItems[idx].profile

        val intent = Intent(applicationContext, ChatActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("profile", profile)
        startActivity(intent)
    }

    fun clickFloat(){
        if (!isDisplayButtons) {
            isDisplayButtons = true
            main_wrapper_layout.visibility = View.VISIBLE
            main_wrapper_layout.setOnClickListener{ clickFloat() }
            val animation = AnimationUtils.loadAnimation(this, R.anim.float_main_show)
            main_float_add.setBackgroundResource(R.drawable.monster2)
            main_float_add.startAnimation(animation)

            val layoutParams1 = main_float_c1.layoutParams as RelativeLayout.LayoutParams
            layoutParams1.bottomMargin += (main_float_c1.height * 1.2).toInt()
            val showC1 = AnimationUtils.loadAnimation(this, R.anim.float_button1_show)
            main_float_c1.layoutParams = layoutParams1
            main_float_c1.startAnimation(showC1)
            main_float_c1.isClickable = true

            val layoutParam2 = main_float_c2.layoutParams as RelativeLayout.LayoutParams
            layoutParam2.bottomMargin += (main_float_c2.height * 2.4).toInt()
            val showC2 = AnimationUtils.loadAnimation(this, R.anim.float_button2_show)
            main_float_c2.layoutParams = layoutParam2
            main_float_c2.startAnimation(showC2)
            main_float_c2.isClickable = true

        } else {
            isDisplayButtons = false
            main_wrapper_layout.visibility = View.INVISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.float_main_hide)
            main_float_add.setBackgroundResource(R.drawable.monster)
            main_float_add.startAnimation(animation)

            val layoutParams1 = main_float_c1.layoutParams as RelativeLayout.LayoutParams
            layoutParams1.bottomMargin -= (main_float_c1.height * 1.2).toInt()
            val hideC1 = AnimationUtils.loadAnimation(this, R.anim.float_button1_hide)
            main_float_c1.layoutParams = layoutParams1
            main_float_c1.startAnimation(hideC1)
            main_float_c1.isClickable = false

            val layoutParams2 = main_float_c2.layoutParams as RelativeLayout.LayoutParams
            layoutParams2.bottomMargin -= (main_float_c2.height * 2.4).toInt()
            val hideC2 = AnimationUtils.loadAnimation(this, R.anim.float_button2_hide)
            main_float_c2.layoutParams = layoutParams2
            main_float_c2.startAnimation(hideC2)
            main_float_c2.isClickable = false
        }
    }
}
