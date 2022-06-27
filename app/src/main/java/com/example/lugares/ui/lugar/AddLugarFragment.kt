package com.example.lugares.ui.lugar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lugares.R
import com.example.lugares.databinding.FragmentAddLugarBinding
import com.example.lugares.databinding.FragmentLugarBinding
import com.example.lugares.model.Lugar
import com.example.lugares.viewmodel.LugarViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddLugarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddLugarFragment : Fragment() {

    private var _binding: FragmentAddLugarBinding? = null
    private val binding get() = _binding!!

    private lateinit var lugarViewModel: LugarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddLugarBinding.inflate(inflater, container, false)
        lugarViewModel = ViewModelProvider(this).get(LugarViewModel::class.java)
        binding.btAgregar.setOnClickListener {
            addLugar()
        }
          return binding.root
    }

    private fun addLugar() {
        var nombre = binding.etNombre.text.toString()
        if (nombre.isNotEmpty()) { //Podemos insertar el lugar
            var correo = binding.etCorreo.text.toString()
            var telefono = binding.etTelefono.text.toString()
            var web = binding.etWeb.text.toString()
            var lugar = Lugar(0, nombre,correo,telefono,web,0.0,0.0,0.0,"","")
            lugarViewModel.addLugar(lugar)
            Toast.makeText(requireContext(),"Lugar Agregado",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(),"Faltan Datos", Toast.LENGTH_LONG).show()
        }
        findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddLugarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddLugarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}