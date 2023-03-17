package com.android.mypet

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mypet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var position = DEFAULT_POSITION

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.root)

        initPetImage()

    }
    fun initPetImage() {
        val fragmentPet = PetFragment()
        val fragmentPet2 = PetFragment2()

        supportFragmentManager.beginTransaction().add(R.id.container_pet, fragmentPet).commit()

        binding.btnChange.setOnClickListener{
            val transaction= supportFragmentManager.beginTransaction()
            when(position) {
                DEFAULT_POSITION -> {
                    transaction.replace(R.id.container_pet, fragmentPet2)
                    position = JUMP_POSITION
                }
                JUMP_POSITION -> {
                    transaction.replace(R.id.container_pet, fragmentPet)
                    position = DEFAULT_POSITION
                }
            }
            transaction.commit()
        }
    }

    companion object {
        const val DEFAULT_POSITION = 1
        const val JUMP_POSITION = 2
    }
}