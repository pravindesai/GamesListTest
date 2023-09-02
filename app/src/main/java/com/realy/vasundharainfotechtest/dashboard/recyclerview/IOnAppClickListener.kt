package com.realy.vasundharainfotechtest.dashboard.recyclerview

import com.realy.vasundharainfotechtest.data.model.DataItem
import com.realy.vasundharainfotechtest.data.model.SubCategoryItem

interface IOnAppClickListener {
    fun iOnItemClick(dataItem: SubCategoryItem)
    fun iOnItemDownloadClick(dataItem: SubCategoryItem)
}