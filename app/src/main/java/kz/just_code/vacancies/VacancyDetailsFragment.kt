package kz.just_code.vacancies

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.just_code.vacancies.base.BaseFragment
import kz.just_code.vacancies.databinding.FragmentVacancyDetailsBinding

class VacancyDetailsFragment:BaseFragment<FragmentVacancyDetailsBinding>(FragmentVacancyDetailsBinding::inflate) {

    private val args: VacancyDetailsFragmentArgs by navArgs()


    override fun onBindView() {
        super.onBindView()
        with(binding){
            val item = args.vacancyItem.vacancyDto
            title.text = item.title
            description.text = item.description
            salary.text = "Salary :${item.salary}$"

            if(item.isLiked){
                favorite.setImageResource(R.drawable.baseline_favorite_red)
            }
            backBtn.setOnClickListener {
                findNavController().navigate(VacancyDetailsFragmentDirections.actionVacancyDetailsFragmentToVacanciesFragment())
            }
        }
    }
}