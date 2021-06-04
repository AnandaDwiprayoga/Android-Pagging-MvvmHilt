package com.pasukanlangit.id.paggingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pasukanlangit.id.paggingmvvm.adapter.RickAdapter
import com.pasukanlangit.id.paggingmvvm.databinding.ActivityMainBinding
import com.pasukanlangit.id.paggingmvvm.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: RickMortyViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    private lateinit var mAdapter : RickAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRv()
        loadingData()
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }

    private fun setUpRv() {
        mAdapter = RickAdapter()
        binding.rvRick.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }
}