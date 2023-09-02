package com.realy.vasundharainfotechtest.dashboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.realy.vasundharainfotechtest.data.model.SubCategoryItem
import com.realy.vasundharainfotechtest.databinding.AppItemBinding

class AppsRecyclerViewAdapter(val apps:List<SubCategoryItem>, val iOnAppClickListener:IOnAppClickListener) : RecyclerView.Adapter<AppsRecyclerViewAdapter.AppViewHolder>() {

    inner class AppViewHolder(val binding:AppItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(SubCategoryItem: SubCategoryItem){
            binding.app = SubCategoryItem
            binding.container.setOnClickListener {
                iOnAppClickListener.iOnItemClick(SubCategoryItem)
            }

            binding.downloaddBtn.setOnClickListener {
                iOnAppClickListener.iOnItemDownloadClick(SubCategoryItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = AppItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = apps.get(position)
        holder.bindData(app)
    }

    override fun getItemCount(): Int = apps.size

}