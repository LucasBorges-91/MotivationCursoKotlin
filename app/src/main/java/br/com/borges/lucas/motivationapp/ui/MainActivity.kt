package br.com.borges.lucas.motivationapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.borges.lucas.motivationapp.R
import br.com.borges.lucas.motivationapp.databinding.ActivityMainBinding
import br.com.borges.lucas.motivationapp.infra.MotivationConstants
import br.com.borges.lucas.motivationapp.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var mSecurityPreferences: SecurityPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate( layoutInflater )
    setContentView( binding.root )
    supportActionBar?.hide()
    mSecurityPreferences = SecurityPreferences( this )
    binding.tvName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
  }
}