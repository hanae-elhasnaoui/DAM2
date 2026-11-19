package es.elorrieta.gymapp
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
fun Fragment.irA(destino: Fragment) {
    parentFragmentManager.commit {
        replace(R.id.fragmentContainer, destino)
        addToBackStack(null)
    }
}
