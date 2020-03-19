package com.example.navdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentConfirmationBinding
import com.example.navdemo.databinding.FragmentMainBinding
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding

    lateinit var recipientName: String
    private lateinit var amount: Money



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_confirmation,
            container,
            false
        )
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var args = ConfirmationFragmentArgs.fromBundle(arguments!!)
        binding.name = args.recipient
        binding.amount = "$${args.amount.amount}"
    }
}


