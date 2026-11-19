package es.elorrieta.gymapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.DatosIniciales
import es.elorrieta.gymapp.bd.GymDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        val pref=getSharedPreferences("ajustes",MODE_PRIVATE)
        AppCompatDelegate.setDefaultNightMode(
            if(pref.getBoolean("oscuro",false)) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
        AppCompatDelegate.setApplicationLocales(
            androidx.core.os.LocaleListCompat.forLanguageTags(pref.getString("idioma","es") ?: "es")
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null) supportFragmentManager.commit {
            replace(R.id.fragmentContainer,FragmentLogo())
        }
        lifecycleScope.launch(Dispatchers.IO) {
            DatosIniciales.cargarSiVacia(GymDatabase(this@MainActivity))
        }
    }
}
