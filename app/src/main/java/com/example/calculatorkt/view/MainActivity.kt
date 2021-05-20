package com.example.calculatorkt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.calculatorkt.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navigationView: NavigationView

    private lateinit var listeneer: NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        navController = findNavController(R.id.container)
//        drawerLayout = findViewById(R.id.drawerLayout)
//        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
//
//        navigationView = findViewById(R.id.calc_navigation)
//        navigationView.setupWithNavController(navController)
//        setupActionBarWithNavController(navController, appBarConfiguration)

       binding.open.setOnClickListener {
           binding.drawerLayout.openDrawer(binding.calcNavigation)
       }
    }



//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.container)
//        return navController.navigateUp(appBarConfiguration)
//                ||super.onSupportNavigateUp()
//    }
}