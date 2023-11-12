import android.view.View
import android.view.ViewGroup
import kz.just_code.vacancies.RecyclerViewItem
import kz.just_code.vacancies.base.BaseVacancyViewHolder
import kz.just_code.vacancies.databinding.ItemSpacingBinding
import kz.just_code.vacancies.decoration.dp

class SpacingViewHolder(override val binding: ItemSpacingBinding):BaseVacancyViewHolder<ItemSpacingBinding>(binding){
    override fun bindView(item: RecyclerViewItem) {
        binding.root.setHeight(16.dp)
    }
}

fun View.setHeight(height:Int){
    val layoutParams = this.layoutParams as ViewGroup.LayoutParams
    layoutParams.height = height
    this.layoutParams = layoutParams
}