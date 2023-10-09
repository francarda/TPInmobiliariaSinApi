package com.example.tpinmobiliariasinapi.ui.inicio;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<MapaActual> mMapa;
    private static final LatLng MERLO= new LatLng(-32.320094, -65.0157063);
    private static final LatLng SANLUIS=new LatLng(-33.280576,-66.332482);
    private static final LatLng ULP=new LatLng(-33.150720,-66.306864);
    public HomeViewModel() {

    }

    public LiveData<MapaActual> getMMapa() {
        if(mMapa==null){
            mMapa= new MutableLiveData<>();
        }
        return mMapa;
    }

    public class MapaActual implements OnMapReadyCallback {

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            //Marcadores
            //googleMap.addMarker(new MarkerOptions().position(SANLUIS).title("San Luis"));
            //googleMap.addMarker(new MarkerOptions().position(ULP).title("ULP"));
            googleMap.addMarker(new MarkerOptions().position(MERLO).title("Merlo"));
            //efecto de camara
            CameraPosition camPos = new CameraPosition.Builder()
                    .target(MERLO)
                    .zoom(19)
                    .bearing(45)//inclinacion
                    .tilt(70)
                    .build();
            CameraUpdate update = CameraUpdateFactory.newCameraPosition(camPos);
            googleMap.animateCamera(update);
        }
    }


}