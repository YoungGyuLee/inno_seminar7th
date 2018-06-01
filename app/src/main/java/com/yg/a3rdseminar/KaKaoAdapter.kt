package com.yg.a3rdseminar

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class KaKaoAdapter(private var kakaoItems : ArrayList<KaKaoItem>, private var context : Context) : RecyclerView.Adapter<KaKaoViewHolder>() {


    private var onItemClick : View.OnClickListener? = null

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClick = l
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KaKaoViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.kakao_item, parent, false)
        mainView.setOnClickListener(onItemClick)
        return KaKaoViewHolder(mainView)
    }

    override fun getItemCount(): Int = kakaoItems.size

    override fun onBindViewHolder(holder: KaKaoViewHolder, position: Int) {
        holder.kakaoProfile.setImageResource(kakaoItems[position].profile)
        holder.kakaoName.text = kakaoItems[position].name
        holder.kakaoPreView.text = kakaoItems[position].preView
        holder.kakaoDate.text = kakaoItems[position].date
        holder.kakaoProfile.setOnClickListener {
            Log.v("이미지 클릭", "이미지 클릭")
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("profile", kakaoItems[position].profile)
            intent.putExtra("name", kakaoItems[position].name)
            context.startActivity(intent)

        }
    }
}
