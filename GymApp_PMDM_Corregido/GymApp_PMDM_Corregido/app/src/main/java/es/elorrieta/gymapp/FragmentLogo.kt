package es.elorrieta.gymapp

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentLogo: Fragment() {
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,state:Bundle?):View =
        inflater.inflate(R.layout.fragment_logo,container,false)
    override fun onViewCreated(v:View,state:Bundle?) {
        val logo=v.findViewById<ImageView>(R.id.logoAnimado)
        logo.alpha=0f
        logo.animate().alpha(1f).setDuration(1400).withEndAction {
            if(isAdded) parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,FragmentLogin()).commit()
        }.start()
    }
}
