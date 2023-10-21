package kz.just_code.vacancies

import SpacingViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.just_code.vacancies.base.BaseVacancyViewHolder
import kz.just_code.vacancies.databinding.ItemProfessionBinding
import kz.just_code.vacancies.databinding.ItemSpacingBinding
import kz.just_code.vacancies.databinding.ItemVacancyBinding

class VacancyAdapter:ListAdapter<VacancyDto, BaseVacancyViewHolder<*>>(VacancyDiffUtils()) {
    class VacancyDiffUtils: DiffUtil.ItemCallback<VacancyDto>(){
        override fun areItemsTheSame(oldItem: VacancyDto, newItem: VacancyDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: VacancyDto, newItem: VacancyDto): Boolean {
            return oldItem == newItem
        }

    }

    class VacancyViewHolder(binding:ItemVacancyBinding):BaseVacancyViewHolder<ItemVacancyBinding>(binding){
        override fun bindView(item: VacancyDto) {
            with(binding){
                title.text =item.name
            }
        }
    }
    class ProfessionViewHolder(binding:ItemProfessionBinding):BaseVacancyViewHolder<ItemProfessionBinding>(binding){
        override fun bindView(item: VacancyDto) {
            with(binding){
                root.text = item.name
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVacancyViewHolder<*> {
        return when(viewType){
            VacancyType.PROFESSION_VIEW.ordinal -> ProfessionViewHolder(
                ItemProfessionBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            )
            VacancyType.VACANCY_VIEW.ordinal -> VacancyViewHolder(
                ItemVacancyBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else -> SpacingViewHolder(
                ItemSpacingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: BaseVacancyViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
}

data class VacancyDto(
    val id: Int,
    val name:String,
    val type:VacancyType,
    val professionType:String
)


enum class VacancyType{
    PROFESSION_VIEW, VACANCY_VIEW, SPACING_VIEW
}

object UniqueIdGenerator{
    private var currentId = 0
    fun generateId():Int{
        return currentId++
    }
}

enum class ProfessionType{
    ANDROID, IOS, FRONTEND, BACKEND, DESIGNER
}