package com.example.admin;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        ajouterborne.OnFragmentInteractionListener, ajouterevenement.OnFragmentInteractionListener,
        modifierborne.OnFragmentInteractionListener, modifierevenement.OnFragmentInteractionListener,
        supprimerborne.OnFragmentInteractionListener, supprimerevenement.OnFragmentInteractionListener,
        profil.OnFragmentInteractionListener, sedeconnecter.OnFragmentInteractionListener{

    DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        // Ouverture de la vue de connexion
        profil p = new profil();
        ;
        this.startTransactionFragment(p.newInstance());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Fragment ajouterborne;
    private Fragment ajouterevenement;
    private Fragment modifierborne;
    private Fragment modifierevenement;
    private Fragment profil;
    private Fragment sedeconnecter;
    private Fragment supprimerborne;
    private Fragment supprimerevenement;

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        ajouterborne ab = new ajouterborne();
        ajouterevenement ae = new ajouterevenement();
        modifierborne mb = new modifierborne();
        modifierevenement me = new modifierevenement();
        profil p = new profil();
        sedeconnecter sd = new sedeconnecter();
        supprimerborne sb = new supprimerborne();
        supprimerevenement se = new supprimerevenement();

        // 6 - Show fragment after user clicked on a menu item
        switch (id){
            case R.id.nav_ajouterborne :
                if (ajouterborne == null) ajouterborne = ab.newInstance();
                this.startTransactionFragment(ajouterborne);
                break;
            case R.id.nav_ajouterevenement:
                if (ajouterevenement == null) ajouterevenement = ae.newInstance();
                this.startTransactionFragment(ajouterevenement);
                break;
            case R.id.nav_modifierborne:
                if (modifierborne == null) modifierborne = mb.newInstance();
                this.startTransactionFragment(modifierborne);
                break;
            case R.id.nav_modifierevenement:
                if (modifierevenement == null) modifierevenement = me.newInstance();
                this.startTransactionFragment(modifierevenement);
                break;
            case R.id.nav_profil:
                if (profil == null) profil = p.newInstance();
                this.startTransactionFragment(profil);
                break;
            case R.id.nav_sedeconnecter:
                if (sedeconnecter == null) sedeconnecter = sd.newInstance();
                this.startTransactionFragment(sedeconnecter);
                break;
            case R.id.nav_supprimerborne:
                if (supprimerborne == null) supprimerborne = sb.newInstance();
                this.startTransactionFragment(supprimerborne);
                break;
            case R.id.nav_supprimerevenement:
                if (supprimerevenement == null) supprimerevenement = se.newInstance();
                this.startTransactionFragment(supprimerevenement);
                break;
            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void startTransactionFragment(Fragment fragment){
        if (!fragment.isVisible()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_holder, fragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
