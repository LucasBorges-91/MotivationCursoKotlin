package br.com.borges.lucas.motivationapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.borges.lucas.motivationapp.databinding.ActivityMainBinding
import br.com.borges.lucas.motivationapp.databinding.ActivitySplashBinding
import br.com.borges.lucas.motivationapp.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {

  private lateinit var binding: ActivitySplashBinding
  private lateinit var mSecurityPreferences: SecurityPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySplashBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()
    mSecurityPreferences = SecurityPreferences( this )

    binding.btSave.setOnClickListener{
      handleSave()
    }


  }

  private fun handleSave() {
    val name = binding.etName.text.toString()
    if ( name != "" ) {
      mSecurityPreferences.storeString( "name", name )
      startActivity( Intent( this, MainActivity::class.java ) )
    } else {
      Toast.makeText( this, "Informe o nome para seguir em frente", Toast.LENGTH_SHORT)
        .show()
    }
  }
}