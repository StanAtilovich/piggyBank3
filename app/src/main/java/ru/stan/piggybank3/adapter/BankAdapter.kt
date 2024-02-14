package ru.stan.piggybank3.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import ru.stan.piggybank3.data.Moneyboxe
import ru.stan.piggybank3.R
import ru.stan.piggybank3.databinding.ListMoneyboxesItemBinding


class BankAdapter : ListAdapter<Moneyboxe, BankAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListMoneyboxesItemBinding.bind(view)

        fun bind(moneyboxe: Moneyboxe) = with(binding) {
            titleView.text = moneyboxe.title
            amountView.text = moneyboxe.amount.toString()
            alreadyHaveView.text = moneyboxe.alreadyhave.toString()
            unitView.text =  moneyboxe.unit
            unitView2.text =  moneyboxe.unit
            datetoView.text = "до "+ moneyboxe.dateto

            val progressBar = progressBar
            val plannedAmount = moneyboxe.amount
            progressBar.max = plannedAmount

            val currentAmount = moneyboxe.alreadyhave
            progressBar.progress = currentAmount
            progressBar.progressTintList = ColorStateList.valueOf(Color.GREEN)
        }
    }

    class Comparator : DiffUtil.ItemCallback<Moneyboxe>() {
        override fun areItemsTheSame(oldItem: Moneyboxe, newItem: Moneyboxe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Moneyboxe, newItem: Moneyboxe): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_moneyboxes_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}