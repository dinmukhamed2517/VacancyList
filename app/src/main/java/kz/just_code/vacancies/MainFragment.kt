package kz.just_code.vacancies

import androidx.navigation.fragment.findNavController
import kz.just_code.vacancies.base.BaseFragment
import kz.just_code.vacancies.databinding.FragmentMainBinding

class MainFragment:BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate){

    override fun onBindView() {
        super.onBindView()

        with(binding){
            getStarted.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToVacanciesFragment())
            }
        }
    }
}