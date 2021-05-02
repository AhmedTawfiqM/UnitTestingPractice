package com.atdev.unittestingpractice

import android.content.Context

class ResourceComparison {

    fun isEqual(context: Context, resID: Int, res: String) = context.getString(resID) == res
}