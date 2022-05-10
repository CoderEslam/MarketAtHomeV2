package com.doubleclick

import com.doubleclick.marktinhome.Model.Chat

/**
 * Created By Eslam Ghazy on 5/10/2022
 */
interface OnMessageClick {

    fun onMessageClickListner(chat: Chat, pos: Int);

}