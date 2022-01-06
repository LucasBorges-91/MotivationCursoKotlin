package br.com.borges.lucas.motivationapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
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

    binding.ivAll.setOnClickListener{
      handleFilter( 1 )
    }

    binding.ivHappy.setOnClickListener{
      handleFilter( 2 )
    }

    binding.ivMorning.setOnClickListener{
      handleFilter( 3 )
    }

    binding.btNewPhrase.setOnClickListener{

    }
  }

  private fun handleNewPhrase() {

  }

  private fun handleFilter( id: Int ) {
    binding.ivAll.setColorFilter( ContextCompat.getColor( this, R.color.white ) )
    binding.ivHappy.setColorFilter( ContextCompat.getColor( this, R.color.white ) )
    binding.ivMorning.setColorFilter( ContextCompat.getColor( this, R.color.white ) )

    when ( id ) {
      1 -> {
        binding.ivAll.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )
      }
      2 -> {
        binding.ivHappy.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )
      }
      3 -> {
        binding.ivMorning.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )
      }
    }
  }
}