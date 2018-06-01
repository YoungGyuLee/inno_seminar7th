package com.yg.a3rdseminar

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText

class KaKaoHead(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var kakaoPreView : EditText = itemView!!.findViewById(R.id.head_search_edit) as EditText

}