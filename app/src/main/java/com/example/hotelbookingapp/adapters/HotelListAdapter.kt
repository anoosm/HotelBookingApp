package com.example.hotelbookingapp.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelbookingapp.activities.BookingActivity
import com.example.hotelbookingapp.databinding.LayoutHotelsBinding
import com.example.hotelbookingapp.model.Result

class HotelListAdapter(val context: Context, val hotelList: List<Result>): RecyclerView.Adapter<HotelListAdapter.HotelListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelListViewHolder {
        val view = LayoutHotelsBinding.inflate(LayoutInflater.from(context), parent, false)
        return HotelListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelListViewHolder, position: Int) {
        val currentHotel = hotelList[position]
        holder.binding.hotelName.text = currentHotel.name
        holder.binding.hotelRating.text = "reviewText"
        holder.binding.ratingNumber.text = "rating"
        holder.binding.hotelLocation.text = "${currentHotel.address.streetAddress}, ${currentHotel.address.extendedAddress}, ${currentHotel.address.locality}"
        holder.binding.hotelPrice.text = currentHotel.ratePlan.price.current

        //Parsing image url using Glide
        Glide.with(context)
            .load(currentHotel.optimizedThumbUrls.srpDesktop)
            .into(holder.binding.hotelImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, BookingActivity::class.java)
            intent.putExtra("image",currentHotel.optimizedThumbUrls.srpDesktop)
            intent.putExtra("name", currentHotel.name)
            intent.putExtra("checkinDate", "2022-10-25")
            intent.putExtra("checkoutDate", "2022-10-27")
            intent.putExtra("address", "${currentHotel.address.streetAddress}, ${currentHotel.address.extendedAddress}, ${currentHotel.address.locality}")
            intent.putExtra("price", currentHotel.ratePlan.price.current)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        Log.d("hotelListSize", "${hotelList.size}")
        return hotelList.size
    }

    class HotelListViewHolder(val binding: LayoutHotelsBinding): RecyclerView.ViewHolder(binding.root)
}
