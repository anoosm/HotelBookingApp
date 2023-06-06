package com.example.hotelbookingapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.hotelbookingapp.databinding.ActivityBookingBinding
import com.example.hotelbookingapp.dbUrl
import com.example.hotelbookingapp.model.BookingDetails
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hotelImage = intent.getStringExtra("image")
        val hotelName = intent.getStringExtra("name")
        val checkinDate = intent.getStringExtra("checkinDate")
        val checkoutDate = intent.getStringExtra("checkoutDate")
        val address = intent.getStringExtra("address")
        val price = intent.getStringExtra("price")

        Glide.with(this@BookingActivity)
            .load(hotelImage)
            .into(binding.bookingHotelImage)

        binding.bookingHotelName.text = hotelName
        binding.bookingCheckInDate.text = checkinDate
        binding.bookingCheckoutDate.text = checkoutDate
        binding.bookingHotelAddress.text = address
        binding.bookingHotelPrice.text = price

        database = Firebase.database(dbUrl)

        val databaseRef = database.getReference("Bookings")

        binding.btnBookNow.setOnClickListener {
            val bookingDetails = BookingDetails(
                hotelImage.toString(),
                hotelName.toString(),
                checkinDate.toString(),
                checkoutDate.toString(),
                address.toString(),
                price.toString()
                )
            databaseRef.child(hotelName.toString()).setValue(bookingDetails)
                .addOnSuccessListener {
                Toast.makeText(this@BookingActivity, "Booking Successful", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                Toast.makeText(this@BookingActivity, "Booking Failed!!!", Toast.LENGTH_SHORT).show()
            }

        }

    }


}