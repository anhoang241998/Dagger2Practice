package com.annguyenhoang.dagger2practice.notification.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.annguyenhoang.dagger2practice.App
import com.annguyenhoang.dagger2practice.R
import com.annguyenhoang.dagger2practice.databinding.ActivityMainBinding
import com.annguyenhoang.dagger2practice.di.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var vmFactory: ViewModelFactory

    private lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        (application as App)
            .rootFactory
            .activityFactory()
            .inject(this@MainActivity)

        viewModel = ViewModelProvider(this, vmFactory)[TestViewModel::class]
        viewModel.printString { str ->
            binding.tvText.text = str
        }
    }
}