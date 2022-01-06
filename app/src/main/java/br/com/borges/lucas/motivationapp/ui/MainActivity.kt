package br.com.borges.lucas.motivationapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import br.com.borges.lucas.motivationapp.R
import br.com.borges.lucas.motivationapp.databinding.ActivityMainBinding
import br.com.borges.lucas.motivationapp.infra.MotivationConstants
import br.com.borges.lucas.motivationapp.infra.SecurityPreferences
import br.com.borges.lucas.motivationapp.repository.Mock

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var mSecurityPreferences: SecurityPreferences
  private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate( layoutInflater )
    setContentView( binding.root )
    supportActionBar?.hide()
    mSecurityPreferences = SecurityPreferences( this )
    binding.tvName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

    val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    binding.tvName.text = "Olá, ${name}"

    //Logica inicial de seleção
    binding.ivAll.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )

    binding.ivAll.setOnClickListener{
      handleFilter( MotivationConstants.PHRASEFILTER.ALL )
    }

    binding.ivHappy.setOnClickListener{
      handleFilter( MotivationConstants.PHRASEFILTER.HAPPY )
    }

    binding.ivMorning.setOnClickListener{
      handleFilter( MotivationConstants.PHRASEFILTER.MORNING )
    }

    binding.btNewPhrase.setOnClickListener{
      handleNewPhrase()
    }
  }

  private fun handleNewPhrase() {
    val phrase = Mock().getPhrase( mPhraseFilter )
    binding.tvPhrase.text = phrase
  }

  private fun handleFilter( id: Int ) {
    binding.ivAll.setColorFilter( ContextCompat.getColor( this, R.color.white ) )
    binding.ivHappy.setColorFilter( ContextCompat.getColor( this, R.color.white ) )
    binding.ivMorning.setColorFilter( ContextCompat.getColor( this, R.color.white ) )

    when ( id ) {
      1 -> {
        binding.ivAll.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )
        mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
      }
      2 -> {
        binding.ivHappy.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )
        mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
      }
      3 -> {
        binding.ivMorning.setColorFilter( ContextCompat.getColor( this, R.color.colorAccent ) )
        mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
      }
    }
  }
}