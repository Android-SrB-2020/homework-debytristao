package com.example.navdemo


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navdemo.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {


    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        binding.apply{
            sendMoneyBtn.setOnClickListener {
                navController.navigate(MainFragmentDirections.actionMainFragmentToChooseRecipientFragment())

            }
            viewTransactionsBtn.setOnClickListener {
                navController.navigate(MainFragmentDirections.actionMainFragmentToViewTransactionFragment())
            }
            viewBalanceBtn.setOnClickListener {
                navController.navigate(MainFragmentDirections.actionMainFragmentToViewBalanceFragment2())
            }
        }
    }
    //override fun onClick...


}
