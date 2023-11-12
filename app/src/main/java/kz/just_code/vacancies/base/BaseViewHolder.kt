package kz.just_code.vacancies.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.just_code.vacancies.RecyclerViewItem

abstract class BaseViewHolder<VB: ViewBinding, T>(protected open val binding:VB):
    RecyclerView.ViewHolder(binding.root){
    abstract fun bindView(item:T)
}


abstract class BaseVacancyViewHolder<VB:ViewBinding>(override val binding: VB):
        BaseViewHolder<VB, RecyclerViewItem>(binding)