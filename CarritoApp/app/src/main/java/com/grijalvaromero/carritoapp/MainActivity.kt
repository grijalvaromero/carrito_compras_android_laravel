package com.grijalvaromero.carritoapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.grijalvaromero.carritoapp.vistas.ComprasFragment
import com.grijalvaromero.carritoapp.vistas.FavsFragment
import com.grijalvaromero.carritoapp.vistas.HomeFragment


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer_layout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var nav_view: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         toolbar =findViewById(R.id.toolbar)
         drawer_layout = findViewById(R.id.drawer_layout)
         nav_view = findViewById(R.id.nav_view)

         val toggle = ActionBarDrawerToggle(
             this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
         drawer_layout.addDrawerListener(toggle)
         toggle.syncState()

         nav_view.setNavigationItemSelectedListener(this)
        findViewById<TextView>(R.id.toolbarIndicator).text="20"

}

override fun onBackPressed() {
 if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
     drawer_layout.closeDrawer(GravityCompat.START)
 } else {
     super.onBackPressed()
 }
}

override fun onCreateOptionsMenu(menu: Menu): Boolean {
 // Inflate the menu; this adds items to the action bar if it is present.
 //menuInflater.inflate(R.menu.main, menu)
 return true
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
 // Handle action bar item clicks here. The action bar will
 // automatically handle clicks on the Home/Up button, so long
 // as you specify a parent activity in AndroidManifest.xml.
 when (item.itemId) {
     R.id.action_settings -> return true
     else -> return super.onOptionsItemSelected(item)
 }
}

override fun onNavigationItemSelected(item: MenuItem): Boolean {
 // Handle navigation view item clicks here.
 when (item.itemId) {
     R.id.nav_first_fragment -> {
         supportFragmentManager.beginTransaction().replace(R.id.mainContent,ComprasFragment()).commit()
         setTitle("Import")
     }
     R.id.nav_second_fragment -> {
         supportFragmentManager.beginTransaction().replace(R.id.mainContent,FavsFragment()).commit()
         setTitle("Gallery")
     }
     R.id.nav_third_fragment -> {
         supportFragmentManager.beginTransaction().replace(R.id.mainContent,HomeFragment()).commit()
         setTitle("Carrito")
     }

 }

 drawer_layout.closeDrawer(GravityCompat.START)
 return true
}
/*fun setupDrawer(): ActionBarDrawerToggle {
 return  ActionBarDrawerToggle(this, mDrawer,toolbar,"Open","Close")
}*/
/*override fun onOptionsItemSelected(item: MenuItem): Boolean {
 var fragment:Fragment

  when (item.itemId) {
     android.R.id.home -> {
         mDrawer.openDrawer(GravityCompat.START);

         true
     }
     R.id.nav_first_fragment -> {
         supportFragmentManager.beginTransaction().replace(R.id.flContent,ComprasFragment()).commit()
         true
     }
      R.id.nav_second_fragment -> {
          supportFragmentManager.beginTransaction().replace(R.id.flContent,FavsFragment()).commit()
          true
      }
      R.id.nav_third_fragment -> {
          supportFragmentManager.beginTransaction().replace(R.id.flContent,ComprasFragment()).commit()
          true
      }

     else -> super.onOptionsItemSelected(item)
 }
 item.setChecked(true)
 setTitle(item.title)
 mDrawer.closeDrawers()
 return true
}*/


}