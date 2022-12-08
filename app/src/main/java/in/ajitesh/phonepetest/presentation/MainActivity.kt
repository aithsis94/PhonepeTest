package `in`.ajitesh.phonepetest.presentation

import `in`.ajitesh.phonepetest.R
import `in`.ajitesh.phonepetest.databinding.ActivityMainBinding
import `in`.ajitesh.phonepetest.presenter.MainViewModel
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

class MainActivity : androidx.fragment.app.FragmentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        this.viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        this.viewBinding.lifecycleOwner = this
        this.viewBinding.viewModel = viewModel!!
    }
}