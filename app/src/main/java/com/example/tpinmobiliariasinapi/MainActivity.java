package com.example.tpinmobiliariasinapi;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tpinmobiliariasinapi.model.Propietario;
import com.example.tpinmobiliariasinapi.request.ApiClient;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tpinmobiliariasinapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public static Propietario prop;
    private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prop= new Propietario();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        vm.getMPropietario().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                prop= propietario;
                Log.d("nom", propietario.getApellido());
                View headerView= binding.navView.getHeaderView(0);
                ImageView iUsu=headerView.findViewById(R.id.imagenUsuario);
               TextView usuario = headerView.findViewById(R.id.headerNombre);
                TextView mail = headerView.findViewById(R.id.headerMail);
                usuario.setText(prop.getNombre());
                mail.setText(prop.getEmail());

            }
        });
        vm.getFoto().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                View headerView= binding.navView.getHeaderView(0);
                ImageView iUsu=headerView.findViewById(R.id.imagenUsuario);
                iUsu.setImageResource(integer);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Bundle bundle=(Bundle) this.getIntent().getExtras();
        vm.obtenerSerializalble(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}