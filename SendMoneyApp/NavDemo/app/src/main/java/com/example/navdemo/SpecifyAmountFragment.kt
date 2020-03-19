package com.example.navdemo


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentMainBinding
import com.example.navdemo.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {

    private lateinit var binding: FragmentSpecifyAmountBinding
    private lateinit var navController: NavController
    lateinit var recipientName: String



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_specify_amount,
            container,
            false
        )
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var args = SpecifyAmountFragmentArgs.fromBundle((arguments!!))
        navController = view.findNavController()
        binding.message = args.recipient
        binding.apply {
            sendBtn.setOnClickListener {
                if(!TextUtils.isEmpty(inputAmount.text)){
                    val amount = Money(BigDecimal(inputAmount.text.toString()))

                    navController.navigate(SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(args.recipient, amount))

                }
            }
            cancelBtn.setOnClickListener {
                activity!!.onBackPressed()
            }
        }
    }

}
