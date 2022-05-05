package com.kumarrittik99.daggerwithmvvm.features.main.activities


import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kumarrittik99.daggerwithmvvm.R
import com.kumarrittik99.daggerwithmvvm.base.BaseActivity
import com.kumarrittik99.daggerwithmvvm.base.BaseApplication
import com.kumarrittik99.daggerwithmvvm.features.main.viewmodelfactories.MainViewModelFactory
import com.kumarrittik99.daggerwithmvvm.features.main.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {


    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val productTextView: TextView
    get() = findViewById(R.id.tv_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).applicationComponent.injectDependencies(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.productsLiveData.observe(this, Observer {
            productTextView.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }
}