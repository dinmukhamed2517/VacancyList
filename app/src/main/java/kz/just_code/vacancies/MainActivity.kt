package kz.just_code.vacancies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.vacancies.databinding.ActivityMainBinding
import kz.just_code.vacancies.decoration.OffsetDecoration
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val vacancyAdapter = VacancyAdapter()

        with(binding) {
            listView.adapter = vacancyAdapter
            listView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            listView.addItemDecoration(OffsetDecoration(8, 8, 4, 4))
        }
        vacancyAdapter.submitList(getTransformedList())
    }
    private fun getTransformedList():List<VacancyDto>{
        val vacancyList = getVacancyList()
        val list: MutableList<VacancyDto> = mutableListOf()
        
        vacancyList.forEachIndexed { index, item ->
            val previousItem =if(index>0) vacancyList[index-1] else null
            if(previousItem?.professionType!= item.professionType){
                list.add(VacancyDto(id = UniqueIdGenerator.generateId(),
                    "${item.professionType}", VacancyType.PROFESSION_VIEW, professionType = item.professionType))
            }
            list.add(item)
        }
        return list
    }
    private fun getVacancyList():List<VacancyDto>{
        return listOf(
            VacancyDto(id = UniqueIdGenerator.generateId(), "Junior Android Developer ", VacancyType.VACANCY_VIEW, "Android"),
            VacancyDto(id = UniqueIdGenerator.generateId(), "Senior Android Developer", VacancyType.VACANCY_VIEW,"Android"),
            VacancyDto(id = UniqueIdGenerator.generateId(),"Django backend developer", VacancyType.VACANCY_VIEW, "Backend"),
            VacancyDto(id = UniqueIdGenerator.generateId(),"Spring backend developer", VacancyType.VACANCY_VIEW, "Backend"),
            VacancyDto(id = UniqueIdGenerator.generateId(), "React Frontend developer", VacancyType.VACANCY_VIEW, "Frontend"),
            VacancyDto(id = UniqueIdGenerator.generateId(), "Angular Frontend developer", VacancyType.VACANCY_VIEW, "Frontend"),
            VacancyDto(id = UniqueIdGenerator.generateId(), "UI/UX designer", VacancyType.VACANCY_VIEW, "Designer"),
            VacancyDto(id = UniqueIdGenerator.generateId(),"Middle UI/UX designer", VacancyType.VACANCY_VIEW, "Designer"),
            VacancyDto(id = UniqueIdGenerator.generateId(), "Junior IOS Developer", VacancyType.VACANCY_VIEW, "IOS"),
            VacancyDto(id = UniqueIdGenerator.generateId(),"Middle IOS Developer", VacancyType.VACANCY_VIEW,"IOS"),
        )
    }
}
