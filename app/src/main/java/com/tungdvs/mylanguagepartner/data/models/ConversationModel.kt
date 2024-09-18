package com.tungdvs.mylanguagepartner.data.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ConversationModel: RealmObject {
    var messages: List<MessageModel> = listOf()
    @PrimaryKey
    var timestamp: Long = 0
}