package com.example.navdemo


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentChooseRecipientBinding
import com.example.navdemo.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment() {

    private lateinit var binding: FragmentChooseRecipientBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_choose_recipient,
            container,
            false
        )
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        binding.apply{
            nextBtn.setOnClickListener {
                if(!TextUtils.isEmpty(inputRecipient.text.toString())){


                navController.navigate(ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment(inputRecipient.text.toString()))
                }else{
                    Toast.makeText(activity, "You must enter a recipient",
                        Toast.LENGTH_SHORT).show()
                }
            }
            cancelBtn.setOnClickListener {
                activity!!.onBackPressed()
            }

        }
    }

}
