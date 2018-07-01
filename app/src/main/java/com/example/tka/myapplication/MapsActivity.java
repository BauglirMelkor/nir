package com.example.tka.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
      //  LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        PolylineOptions po = new PolylineOptions();
        List<LatLng> decoded = PolyUtil.decode("whwxF_s~pDb@?`@NlBn@rBzAPHFEdEoFKs@Dk@Q_i@sJc@oIq@kKAcBDm@Ty@XaADg@GwAUw@m@}@gAwAIq@BaFVgFg@mNOoCQq@aB{Cs@mBg@eBqCoNg@uCIiA@sAl@kFf@mDLqAI}AaA{Dc@qBCkCA_CDwAJsDPwC`@sCR[v@{C\\cBDCHQRk@Pk@D?HBFHR`@P`@PZFP|ArAfB~AnAdAlA~@lCbAnDQ`B?`BBfCXPNDZ@L~BfF`@p@bAbA`D`BjBzA|@rAd@~@n@bBf@xBfAxI^vCRz@x@nCBT\\d@LGHGFIDUAI`@mAxAaC|A}Ad@w@Te@VQdAm@hBiANEbAJJBf@GZ_@DkAAO?EvAAlACbBY^Cr@DpD~@pCx@zFfB|IvCl@b@GPJJpA{@|@i@lBq@dE_CbBe@`@CnABf@H\\b@@ZFRPHNBl@z@^b@lBrDv@|A~AbBh@b@fCnApFvBhEfApD`A`Bb@jBj@LDQt@SpARqAv@cDj@oBFaBEgCA{BNk@Hw@FqAKu@Qe@cAaC]eAe@aCOsBS}MDEBO@EnAsApAyADCt@j@d@b@z@b@bA{DZs@tAn@PVf@xAqBxLE~@DfAHt@R|@Tj@tB|ClAvBbAnCh@dBTnAHzAGjCa@|IOnB[lB_@`Bc@lA{@jBiAfBm@t@kPbNeFuGmCfB]kA@KR]FS@KvAaA^_@jA{@|BuA}BtAkAz@WDeBhAkFhDuBxAwBlBoBtBgFdGqKzMuOjRmEtFkG|HwAhB{@k@aBs@gCyAyBgB[_@uAq@uDcBg@e@k@q@m@OOGeAmBc@y@OoAg@sBc@iAKQQs@{AgEq@_AwA}@o@i@QUm@o@MMgDsA}BgAg@QOC?IKqDOiBg@_CGc@M_DDS@SHMb@{An@_CsAzEILCYC{@@u@JcAxBsKz@wCfBaFz@_C`@y@jBcCZUJKJFLGDCFGHWCSO[SGa@m@c@gA]iBeAoJa@cCq@{BkAkCgAsAmCcByAu@y@k@YW}@_BgBcEIMa@]p@iJNy@r@}Bj@wDo@QP{ANyA?]WmCOmAp@QRMBSe@sFUqCx@Qv@Y~@g@V`@XSt@GdAm@^a@xBmDh@b@z@`@vD|@j@HyAjH}BbKmCbM{@jEs@hDO`@}DtReA~EuL|j@gBbI_@xBGfC_@pB_BpH_DbOw@pDgCrLg@`CG@IHKRSPQGIWr@eFHQNEN?LBVZ`@b@`@f@Z|@D~@ATMp@e@zAKv@\\lGv@|MXlBp@hLFfAEj@Hd@i@n@uBnCg@n@GBMGo@g@c@]y@e@q@Wk@Ik@?O?");
        po.visible(true);
        mMap.addPolyline(po);

        for(LatLng ll:decoded) {
            MarkerOptions mo = new MarkerOptions();
            mo.position(ll);
            mo.anchor(0.5f,0.5f);
            mMap.addMarker(mo);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(decoded.get(0)));
        mMap.setMaxZoomPreference(100f);
    }
}
