package com.yg.a3rdseminar

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class KaKaoAdapter(var kakaoItems : ArrayList<KaKaoItem>) : RecyclerView.Adapter<KaKaoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KaKaoViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.kakao_item, parent, false)
        //mainView.setOnClickListener(onItemClick)
        return KaKaoViewHolder(mainView)
    }

    override fun getItemCount(): Int = kakaoItems.size

    override fun onBindViewHolder(holder: KaKaoViewHolder, position: Int) {
        holder.kakaoProfile.setImageResource(kakaoItems[position].profile);
        holder.kakaoName.text = kakaoItems[position].name
        holder.kakaoPreView.text = kakaoItems[position].preView
        holder.kakaoDate.text = kakaoItems[position].date
    }

}
