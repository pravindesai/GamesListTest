package com.realy.vasundharainfotechtest.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.realy.vasundharainfotechtest.dashboard.recyclerview.AppsRecyclerViewAdapter
import com.realy.vasundharainfotechtest.dashboard.recyclerview.IOnAppClickListener
import com.realy.vasundharainfotechtest.data.model.SubCategoryItem
import com.realy.vasundharainfotechtest.databinding.FragmentFirstBinding


class DashboardFragment : Fragment(), IOnAppClickListener {
    val TAG = "***APP_DATA"
    var binding: FragmentFirstBinding? = null
    var dashboardViewModel:DashboardViewModel? = null
    var appsRecyclerViewAdapter: AppsRecyclerViewAdapter?=null
    var apps:MutableList<SubCategoryItem> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        appsRecyclerViewAdapter = AppsRecyclerViewAdapter(apps, this)
        binding?.recyclerViewAdapter = appsRecyclerViewAdapter

        attachDataObserver()

        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        dashboardViewModel?.getAllApps()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun attachDataObserver(){
            lifecycleScope.launchWhenStarted {
                dashboardViewModel?._appsStateFlow?.collect{ dataStae ->
                    when(dataStae){
                        AppState.Empty -> {
                            Log.i(TAG,"EMPTY")
                        }
                        is AppState.Error -> {
                            Log.i(TAG,"Error")
                        }
                        is AppState.Failure -> {
                            Log.i(TAG,"Failure ${dataStae.msg}")
                        }
                        AppState.Loading -> {
                            Log.i(TAG,"Loading")
                        }
                        is AppState.Sucess -> {
                            Log.i(TAG,"Success")
                            apps.clear()
//                            apps.addAll(dataStae.response.appCenter?.flatMap { it?.subCategory?: emptyList() }?.filterNotNull()?: emptyList())

                            apps.addAll(
                                dataStae.response.appCenter?.find { it?.name.equals("POPULAR GAMES") }?.subCategory?.filterNotNull() ?: emptyList()
                            )


                            appsRecyclerViewAdapter?.notifyDataSetChanged()
                        }
                    }
                }
            }
    }

    override fun iOnItemClick(dataItem: SubCategoryItem) {

    }

    override fun iOnItemDownloadClick(dataItem: SubCategoryItem) {
        val appStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${dataItem.appLink}"))
        appStoreIntent.setPackage("com.android.vending")
        startActivity(appStoreIntent)
    }
}