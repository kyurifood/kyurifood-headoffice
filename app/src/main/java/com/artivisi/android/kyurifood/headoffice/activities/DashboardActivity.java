package com.artivisi.android.kyurifood.headoffice.activities;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.artivisi.android.kyurifood.headoffice.R;
import com.artivisi.android.kyurifood.headoffice.fragments.ApprovalFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.DashboardFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.DistributorFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.LaporanFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.MarketerFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.PengaturanFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.PesananFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.ProdukFragment;
import com.artivisi.android.kyurifood.headoffice.fragments.RegionalFragment;

public class DashboardActivity extends AppCompatActivity
        implements
        DashboardFragment.OnFragmentInteractionListener,
        ProdukFragment.OnFragmentInteractionListener,
        RegionalFragment.OnFragmentInteractionListener,
        DistributorFragment.OnFragmentInteractionListener,
        MarketerFragment.OnFragmentInteractionListener,
        PesananFragment.OnFragmentInteractionListener,
        LaporanFragment.OnFragmentInteractionListener,
        ApprovalFragment.OnFragmentInteractionListener,
        PengaturanFragment.OnFragmentInteractionListener{

    DashboardFragment dashboardFragment = new DashboardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containter, dashboardFragment);
        transaction.commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
