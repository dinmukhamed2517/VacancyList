package kz.just_code.vacancies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.vacancies.databinding.FragmentVacanciesBinding
import kz.just_code.vacancies.decoration.HeaderDecoration
import kz.just_code.vacancies.decoration.OffsetDecoration

class VacanciesFragment:Fragment(){
    private lateinit var binding: FragmentVacanciesBinding

    private var vacancyAdapter:VacancyAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVacanciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacancyAdapter = VacancyAdapter()
        with(binding){
            vacancyList.adapter = vacancyAdapter
            vacancyList.layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false)
            vacancyAdapter!!.submitList(getItemsList())
            vacancyList.addItemDecoration(OffsetDecoration(10,10, 5,5))
            vacancyList.addItemDecoration(HeaderDecoration())
            vacancyList.swipeToLike(
                R.drawable.like_icon,
                onLiked = { position ->
                    val item = (vacancyList.adapter as? VacancyAdapter)?.currentList?.get(position)
                    if(item is RecyclerViewItem.Vacancy){
                        item.vacancyDto.isLiked = true
                        vacancyList.adapter?.notifyItemChanged(position)
                    }

                }
            )
        }
    }
}
private fun getItemsList():List<RecyclerViewItem> {
    val mainList = mutableListOf<RecyclerViewItem>()

    val vacancyList = mutableListOf<VacancyDto>()
    vacancyList.add(VacancyDto(1, "Junior UX Designer", Type.VACANCY_VIEW, 15000.0, "Canva","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))

    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(2, "Junior Product Designer", Type.VACANCY_VIEW, 12000.0, "Canva, Figma","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))





    vacancyList.add(VacancyDto(3, "Middle Motion Designer", Type.VACANCY_VIEW, 15000.0, "Figma, VGX","Designer" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(4, "Junior Android developer", Type.VACANCY_VIEW, 20000.0, "Android Studio, Kotlin","Android" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(5, "Middle Android developer", Type.VACANCY_VIEW, 50000.0, "Android Studio, Kotlin","Android" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(6, "Middle Frontend developer", Type.VACANCY_VIEW, 50000.0, "React, JS","Frontend" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(7, "Senior Frontend developer", Type.VACANCY_VIEW, 75000.0, "Angular, TS","Frontend" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(8, "Senior Backend developer", Type.VACANCY_VIEW, 75000.0, "Django, Python","Backend" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(9, "Junior Backend developer", Type.VACANCY_VIEW, 10000.0, "Spring, Java","Backend" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(10, "Junior IOS developer", Type.VACANCY_VIEW, 11500.0, "IOS, Swift","IOS" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(11, "Senior IOS developer", Type.VACANCY_VIEW, 111500.0, "IOS, Swift","IOS" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
    vacancyList.add(VacancyDto(12, "Senior Android developer", Type.VACANCY_VIEW, 150000.0, "Android, Kotlin","Android" ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))

    mainList.add(RecyclerViewItem.Header("Designer"))
    mainList.addAll(vacancyList.filter { it.professionType == "Designer" }.map {RecyclerViewItem.Vacancy(it)})

    mainList.add(RecyclerViewItem.Header("IOS"))
    mainList.addAll(vacancyList.filter { it.professionType == "IOS" }.map {RecyclerViewItem.Vacancy(it)})

    mainList.add(RecyclerViewItem.Header("Frontend"))
    mainList.addAll(vacancyList.filter { it.professionType == "Frontend" }.map {RecyclerViewItem.Vacancy(it)})

    mainList.add(RecyclerViewItem.Header("Backend"))
    mainList.addAll(vacancyList.filter { it.professionType == "Backend" }.map {RecyclerViewItem.Vacancy(it)})

    mainList.add(RecyclerViewItem.Header("Android"))
    mainList.addAll(vacancyList.filter { it.professionType == "Android" }.map {RecyclerViewItem.Vacancy(it)})

    return mainList
}
sealed class RecyclerViewItem{
    data class Header(val title:String): RecyclerViewItem()
    data class Vacancy(val vacancyDto: VacancyDto):RecyclerViewItem()
}