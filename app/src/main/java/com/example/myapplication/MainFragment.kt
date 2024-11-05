package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container, false)
//        listeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    private fun listeners() = with(binding){
        bViewTransaction.setOnClickListener {
//            toast
            Toast.makeText(context, "coming soon!", Toast.LENGTH_SHORT).show()
        }
        bSendMoney.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(MainFragmentDirections
                    .actionMainFragmentToChooseRecipientFragment())
        }
        bViewBalance.setOnClickListener{
            Toast.makeText(context, "coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}