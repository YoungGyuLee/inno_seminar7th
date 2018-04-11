package com.yg.a3rdseminar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var kakaoItems : ArrayList<KaKaoItem>
    lateinit var kaKaoAdapter: KaKaoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        kakaoItems = ArrayList()
        kakaoItems.add(KaKaoItem(R.drawable.pika1, "09의 바나나안드로이드", "낰낰", "오후 4:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika2, "이돌이의 차근차근기획", ":D ><", "오후 6:05"))
        kakaoItems.add(KaKaoItem(R.drawable.pika3, "트카의 텔미텔미딪", "아니 내가(손 휘적)", "오후 3:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika4, "사과의 고속사과", "이상하다 혜진아,, 내심장은 너한테만 반응하나봐,,", "오후 8:24"))
        kakaoItems.add(KaKaoItem(R.drawable.pika5, "섭이의 섭섭한칼퇴", "옆모습 정승환(섭피셜)", "오후 11:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika6, "인누강의 웹마이웨이", "호에에에에에엥", "오후 12:16"))
        kakaoItems.add(KaKaoItem(R.drawable.pika7, "신선이의 힐링캠프", "얘들아 그.. 딱 5분만 말할게요^^", "오후 8:02"))
        kakaoItems.add(KaKaoItem(R.drawable.pika8, "할머니의 당찬하루", "야!", "오후 4:21"))
        kakaoItems.add(KaKaoItem(R.drawable.pika9, "이모님의 회계원리", "뒤풀이 어디가지...★", "오후 11:07"))
        kakaoItems.add(KaKaoItem(R.drawable.pika10, "대장의 생방송", "따봉따봉미 bb", "오후 10:10"))

        kaKaoAdapter = KaKaoAdapter(kakaoItems)
        main_rv.layoutManager = LinearLayoutManager(this)
        main_rv.adapter = kaKaoAdapter

    }
}
