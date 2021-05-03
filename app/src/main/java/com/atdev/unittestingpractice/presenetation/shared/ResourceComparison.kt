package com.atdev.unittestingpractice.presenetation.shared

import android.content.Context

class ResourceComparison {

    fun isEqual(context: Context, resID: Int, res: String) =
        context.getString(resID) == res
}