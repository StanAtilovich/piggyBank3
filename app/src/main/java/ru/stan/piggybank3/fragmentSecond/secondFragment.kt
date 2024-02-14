package ru.stan.piggybank3.fragmentSecond

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.stan.piggybank3.R
import ru.stan.piggybank3.databinding.FragmentBlankBinding
import ru.stan.piggybank3.databinding.FragmentSecondBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class secondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondViewModel





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonList.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        binding.imageView.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = context?.let { it1 ->
                DatePickerDialog(
                    it1,
                    DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                        // Обработка выбранной даты
                        val calendar = Calendar.getInstance()
                        calendar.set(selectedYear, selectedMonth, selectedDay)
                        val dateFormatted = SimpleDateFormat(
                            "d MMMM yyyy",
                            Locale.getDefault()
                        ).format(calendar.time)
                        binding.textView2.text =
                            dateFormatted // Отображение выбранной даты в textView2
                    },
                    year,
                    month,
                    day
                )
            }

            datePickerDialog?.show()
        }
        val nameSum2 = binding.NameSum2
        val sumContainer2 = binding.SumContainer2
        binding.myCheckbox.setOnClickListener {
            // Проверяем состояние чекбокса
            if (binding.myCheckbox.isChecked) {
                // Скрываем элементы
                nameSum2.visibility = View.GONE
                sumContainer2.visibility = View.GONE
            } else {
                // Показываем элементы
                nameSum2.visibility = View.VISIBLE
                sumContainer2.visibility = View.VISIBLE
            }
        }

    }
}