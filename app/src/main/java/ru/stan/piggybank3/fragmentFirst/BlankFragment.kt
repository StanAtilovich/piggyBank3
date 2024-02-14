package ru.stan.piggybank3.fragmentFirst

import android.graphics.Typeface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.stan.piggybank3.R
import ru.stan.piggybank3.adapter.BankAdapter
import ru.stan.piggybank3.api.PiggyBankApi
import ru.stan.piggybank3.databinding.FragmentBlankBinding
import ru.stan.piggybank3.fragmentSecond.secondFragment

class BlankFragment : Fragment() {
    private lateinit var adapter: BankAdapter
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BankAdapter()
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = adapter

        binding.archiveView.setOnClickListener {
            binding.activeView.setTypeface(null, Typeface.NORMAL)
            binding.archiveView.setTypeface(null, Typeface.BOLD)
            binding.rcView.visibility = View.GONE
            binding.emptyList.visibility = View.VISIBLE
        }

        binding.activeView.setOnClickListener {
            binding.archiveView.setTypeface(null, Typeface.NORMAL)
            binding.activeView.setTypeface(null, Typeface.BOLD)
            binding.rcView.visibility = View.VISIBLE
            binding.emptyList.visibility = View.GONE
        }
        binding.addBank.setOnClickListener {
            val fragmentTransaction = (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            val secondFragment = secondFragment()
            fragmentTransaction.replace(R.id.fragment_container, secondFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val piggyBankApi = retrofit.create(PiggyBankApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val bank = piggyBankApi.getPiggyBankById()

            requireActivity().runOnUiThread {
                adapter.submitList(bank.moneyboxes)
            }
        }
    }
}
