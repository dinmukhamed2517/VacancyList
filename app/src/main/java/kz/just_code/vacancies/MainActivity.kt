package kz.just_code.vacancies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import kz.just_code.vacancies.databinding.ActivityMainBinding
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            getStarted.setOnClickListener {
               supportFragmentManager.commit{
                   replace(R.id.container, VacanciesFragment())
               }
            }
        }
    }
}
