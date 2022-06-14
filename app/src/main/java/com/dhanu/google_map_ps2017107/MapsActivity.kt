package com.dhanu.google_map_ps2017107

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.dhanu.google_map_ps2017107.databinding.ActivityMapsBinding
import com.dhanu.google_map_ps2017107.models.UserMaps
import com.google.android.gms.maps.model.LatLngBounds

private const val TAG= "MapsActivity"
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var userMaps: UserMaps
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMapsBinding.inflate(layoutInflater)
            setContentView(binding.root)

            userMaps=intent.getSerializableExtra(EXTRA_USER_MAP) as UserMaps
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        Log.i(TAG,"user map to render:${userMaps.title}")

        val boundsBuilder= LatLngBounds.Builder()
        for (place in userMaps.places) {
            val latlng=LatLng(place.latitude,place.longitude)
            googleMap.setMinZoomPreference(17.0f)
            googleMap.mapType=GoogleMap.MAP_TYPE_HYBRID
            boundsBuilder.include(latlng)
            mMap.addMarker(MarkerOptions().position(latlng).title(place.title).snippet(place.description))
        }
        // Add a marker in Sydney and move the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(),1000,3000,0))
    }
}