package kz.just_code.vacancies

import SpacingViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.just_code.vacancies.base.BaseVacancyViewHolder
import kz.just_code.vacancies.databinding.HeaderBinding
import kz.just_code.vacancies.databinding.ItemSpacingBinding
import kz.just_code.vacancies.databinding.ItemVacancyBinding

class VacancyAdapter:ListAdapter<RecyclerViewItem, BaseVacancyViewHolder<*>>(VacancyDiffUtils()) {

    var itemClick: ((RecyclerViewItem)-> Unit)? = null
    class VacancyDiffUtils: DiffUtil.ItemCallback<RecyclerViewItem>(){
        override fun areItemsTheSame(
            oldItem: RecyclerViewItem,
            newItem: RecyclerViewItem
        ): Boolean {
            if(oldItem.javaClass != newItem.javaClass){
                return false
            }
            return when(oldItem){
                is RecyclerViewItem.Header -> oldItem.title == (newItem as RecyclerViewItem.Header).title
                is RecyclerViewItem.Vacancy -> oldItem.vacancyDto.id ==(newItem as RecyclerViewItem.Vacancy).vacancyDto.id
            }
        }
        override fun areContentsTheSame(
            oldItem: RecyclerViewItem,
            newItem: RecyclerViewItem
        ): Boolean {
            return when(oldItem){
                is RecyclerViewItem.Vacancy -> oldItem.vacancyDto == (newItem as RecyclerViewItem.Vacancy).vacancyDto
                else -> true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVacancyViewHolder<*> {
        return when (viewType){
            Type.HEADER_VIEW.ordinal -> {
                HeaderViewHolder(
                    HeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            Type.VACANCY_VIEW.ordinal ->{
                VacancyViewHolder(
                    ItemVacancyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> SpacingViewHolder(
                ItemSpacingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }


}

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)){
            is RecyclerViewItem.Vacancy -> Type.VACANCY_VIEW.ordinal
            is RecyclerViewItem.Header -> Type.HEADER_VIEW.ordinal
        }
    }

    override fun onBindViewHolder(holder: BaseVacancyViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class VacancyViewHolder(binding:ItemVacancyBinding):BaseVacancyViewHolder<ItemVacancyBinding>(binding){
        override fun bindView(item: RecyclerViewItem) {
            val vacancy = (item as RecyclerViewItem.Vacancy).vacancyDto
            with(binding){
                title.text = vacancy.title
                salary.text = vacancy.salary.toString()
                req.text = vacancy.requirement
            }
            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }
    }
    class HeaderViewHolder(binding:HeaderBinding):BaseVacancyViewHolder<HeaderBinding>(binding){
        override fun bindView(item: RecyclerViewItem) {
            with(binding){
                root.text = (item as RecyclerViewItem.Header).title
            }
        }

    }

}



enum class Type{
    HEADER_VIEW, VACANCY_VIEW, SPACING_VIEW
}
