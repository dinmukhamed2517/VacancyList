package kz.just_code.vacancies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kz.just_code.vacancies.Type



@Parcelize
data class VacancyDto(
    val id: Int,
    val title:String,
    val type: Type,
    val salary:Double,
    val requirement:String,
    val professionType:String,
    val description:String,
    var isLiked:Boolean = false,
):Parcelable
