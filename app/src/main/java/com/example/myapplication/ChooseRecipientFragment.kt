package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment() {

    lateinit var binding : FragmentChooseRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    private fun listeners(){
        binding.apply {
            bCancel.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(ChooseRecipientFragmentDirections
                        .actionChooseRecipientFragmentToMainFragment())
            }
            bNext.setOnClickListener {
                val name = etName.text.toString()
                Navigation.findNavController(it)
                    .navigate(ChooseRecipientFragmentDirections
                        .actionChooseRecipientFragmentToConfirmationFragment(name))
            }
        }
    }
}