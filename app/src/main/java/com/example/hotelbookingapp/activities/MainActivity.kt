package com.example.hotelbookingapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelbookingapp.adapters.HotelListAdapter
import com.example.hotelbookingapp.databinding.ActivityMainBinding
import com.example.hotelbookingapp.model.Hotels
import com.example.hotelbookingapp.network.HotelService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var api: HotelService
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var myAdapter: HotelListAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager


        callApi()



    }
    fun callApi() {
        api = HotelService()
        val retrofitData = api.retrofit.getListOfHotels(
            "2022-10-25",
            "2022-10-27",
            "STAR_RATING_HIGHEST_FIRST",
            1644742,
            1,
            "INR",
            "en_IN")

        retrofitData.enqueue(object : Callback<Hotels?> {
            override fun onResponse(call: Call<Hotels?>, response: Response<Hotels?>) {
                val hotelsList = response.body()!!.searchResults.results
                myAdapter = HotelListAdapter(this@MainActivity, hotelsList)
                binding.recyclerView.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Hotels?>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.toString(), Toast.LENGTH_SHORT).show()
                Log.d("apiReadFromJsonError", t.toString())
            }
        })


            /** The piece block of code below has error in parsing detailis from JSON file while using Call<List<Result>> */
//        retrofitData.enqueue(object : Callback<List<Result>?> {
//            override fun onResponse(call: Call<List<Result>?>, response: Response<List<Result>?>) {
//                if(response.isSuccessful){
//                    val hotelsList = response.body()!!
//                    myAdapter = HotelListAdapter(this@MainActivity, hotelsList)
//                    binding.recyclerView.adapter = myAdapter
//                    myAdapter.notifyDataSetChanged()
//                }
//            }
//
//            override fun onFailure(call: Call<List<Result>?>, t: Throwable) {
//                Toast.makeText(this@MainActivity,t.toString(), Toast.LENGTH_SHORT).show()
//                Log.d("apiReadFromJsonError", t.toString())
//            }
//        })
    }
//aslam@mail.com
}