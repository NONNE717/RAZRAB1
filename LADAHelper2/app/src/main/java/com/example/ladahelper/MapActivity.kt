package com.example.ladahelper

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MapActivity : AppCompatActivity() {
    lateinit var mapView: MapView
    lateinit var trafficbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("8fd1287f-b688-42e7-9417-6e3964be6211")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_map)
        mapView=findViewById(R.id.map)
        mapView.map.move(CameraPosition(Point(55.798226, 49.101554), 11.0f,0.0f,0.0f),
            Animation(Animation.Type.SMOOTH,10f),null
        )
        var mapKit:MapKit=MapKitFactory.getInstance()
        var probki=mapKit.createTrafficLayer(mapView.mapWindow)
        var probkiison=false
        requiestlocationPermission()
        probki.isTrafficVisible=true
        var locationmapkit=mapKit.createUserLocationLayer(mapView.mapWindow)
        locationmapkit.isVisible=true


    }
    private fun requiestlocationPermission(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),0)
            return
        }


    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
}