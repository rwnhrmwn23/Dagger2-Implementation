package com.onedev.dicoding.dagger2implementation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.onedev.dicoding.dagger2implementation.di.IRetroService
import com.onedev.dicoding.dagger2implementation.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mService: IRetroService

    private var liveDataList: MutableLiveData<RecyclerList> = MutableLiveData()

    init {
        (application as MyApplication).getRetroComponent().inject(this)
    }

    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

    fun makeAPiCall() {
        mService.getDataFromApi("atl")
            .enqueue(object : Callback<RecyclerList> {
                override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                    if (response.isSuccessful)
                        liveDataList.postValue(response.body())
                    else
                        liveDataList.postValue(null)
                }

                override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                    liveDataList.postValue(null)
                }
            })
    }
}