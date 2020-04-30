package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MapsEventos extends AppCompatActivity implements GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker marketPrueba, infoWindows, marcacdor;
    double lat = 0.0, lon = 0.0;
   // dialogoPrueba fragmentDialog= new dialogoPrueba();
    private ArrayList<Marker> guardarMarcadorUno = new ArrayList<>();
    private ArrayList<Marker> guardarMarcadorDos = new ArrayList<>();

    DatabaseReference basedatos;

    private FusedLocationProviderClient fusedLocationClient; // ubicacion

    private int MY_PERMISSIONS_REQUEST_READ_CONTRACTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_eventos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
      //  mapFragment.getMapAsync(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        basedatos =  FirebaseDatabase.getInstance().getReference();// referencia al nodo principal
    //   ubicacion();     // funcion para saber la ubicacion

    }

    public void ubicacion(){

        // validar permisos de ubicacion
  /*      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions (this, new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_READ_CONTRACTS );

            return;
        }*/
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                            Map<String, Object> ubicacion = new HashMap<>();

                            ubicacion.put("latitud", location.getLongitude());
                            ubicacion.put("longitud", location.getLongitude());

                            basedatos.child("ubicacion").push().setValue(ubicacion);

                        }else{
                            Toast.makeText(MapsEventos.this, "no se guardo la ubicacion", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;           //miUbicacion(); // funcion para saber la ubicacion

        LatLng upc = new LatLng(10.4483192,  -73.2620876);       // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(upc).title("upc valledupar").snippet("Universidad popular del cesar prueba"));//.icon(BitmapDescriptorFactory.fromResource(R.drawable.rio)));

        mMap.getUiSettings().setZoomControlsEnabled(true);//habilitar zoom

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upc, 14));// personalizar zoom


        /*
        basedatos.child("ubicacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    ubicacionPrueba ubicacionPruebita = snapshot.getValue(ubicacionPrueba.class);
                    double latitud = ubicacionPruebita.getLatitud();
                    double longitud = ubicacionPruebita.getLongitud();

                    MarkerOptions markerOpccion = new MarkerOptions();
                    markerOpccion.position(new LatLng(latitud, longitud) );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/



    //    mMap.setMyLocationEnabled(true);

     //   LatLng rio = new LatLng(10.4483192,  -73.2620876);
      //  mMap.addMarker(new MarkerOptions().position(rio).title("Balneario hurtado").snippet("Rio guatapuri").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

 /*       LatLng riky = new LatLng(10.4650361,  -73.2528426);
        marketPrueba = googleMap.addMarker(new MarkerOptions().position(riky).title("Arroz riky").draggable(true));

        LatLng Terminal = new LatLng(10.445184, -73.243064);
        infoWindows = googleMap.addMarker(new MarkerOptions().position(Terminal).title("Terminal de transporte").draggable(true));

        // click en el marcador
        googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);

        //Arrastrar el marcador
        googleMap.setOnMarkerDragListener((GoogleMap.OnMarkerDragListener) this);

        //Dialogo
        googleMap.setOnInfoWindowClickListener(this);
 */   }



 // para el movimiento del marcador mio  ------------------------------
    @Override
    public void onMarkerDragStart(Marker marker) {
        if ( marker.equals(marketPrueba) ){
            Toast.makeText(this, "Iniciamos a trabajar con el market", Toast.LENGTH_SHORT).show();
        }
    }

    @Override// arrastrar el marcador y te la posicion
    public void onMarkerDrag(Marker marker) {
        if ( marker.equals(marketPrueba )){
            String newTitle = String.format(String.valueOf(Locale.getDefault()),getString(R.string.marker_detail_latlng),
                        marker.getPosition().latitude,
                        marker.getPosition().longitude);

            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if ( marker.equals(marketPrueba) ){
            Toast.makeText(this, "Terminaste la actividad con el marcador", Toast.LENGTH_SHORT).show();
            setTitle(R.string.app_name);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return true;
    }
    // para el movimiento del marcador mio  ------------------------------


    // evento de mostrar info
 /*   @Override
    public void onInfoWindowClick(Marker marker) {
        if ( marker.equals(infoWindows) ){
            fragmentDialog.newInstance(marker.getTitle(), getString(R.string.terminal)).show(getSupportFragmentManager(), null);
        }
    }
*/

/*
    private void agregarMarcador(double lat, double lon){
        LatLng coordenadas = new LatLng(lat, lon);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 12);
        Toast.makeText(this, "131 marcador", Toast.LENGTH_LONG).show();
        if ( marcacdor != null ) marcacdor.remove();{
            marcacdor = mMap.addMarker(new MarkerOptions().position(coordenadas).title("usted se encuentra aqui"));
            mMap.animateCamera(miUbicacion);
        }
    }

    private void actualUbicacion(Location location){
        Toast.makeText(this, "140 si", Toast.LENGTH_LONG).show();
        if ( location != null ){
            lat = location.getLatitude();
            lon = location.getLongitude();
            agregarMarcador(lat, lon);
        }
    }

    private void miUbicacion(){
        LocationManager localizacionManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 10000);
       }
        Toast.makeText(this, "mi ubicacion", Toast.LENGTH_LONG).show();

        Location localizacionx = localizacionManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Toast.makeText(this, "156" + localizacionx ,Toast.LENGTH_LONG).show();
        actualUbicacion(localizacionx);
        //localizacionManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locListener);
    }
*/

}
