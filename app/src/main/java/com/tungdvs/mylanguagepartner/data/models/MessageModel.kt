package com.tungdvs.mylanguagepartner.data.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class MessageModel: RealmObject {
    var content: String = ""
    var role: Int = 0
    @PrimaryKey
    var timestamp: Long = 0
}