package com.example.pruebasproyecto.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pruebasproyecto.R

class PruebaFragment : Fragment() {

    companion object {
        fun newInstance() : PruebaFragment{
            return PruebaFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prueba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.fragmentCerrar).setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.setCustomAnimations(
                R.anim.slide_in,
                R.anim.slide_out
            )?.remove(this)?.commit()
        }
    }
}