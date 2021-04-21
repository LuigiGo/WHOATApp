package com.androidsystems.whoatapp.ui.reports

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.androidsystems.whoatapp.R
import com.androidsystems.whoatapp.databinding.ActivityReportsBinding
import com.androidsystems.whoatapp.ui.base.BaseActivity
import com.androidsystems.whoatapp.ui.categorybrandlist.CategoryBrandListActivity
import com.androidsystems.whoatapp.ui.reports.epoxy.FeatureController
import com.androidsystems.whoatapp.utilities.helpers.Conversions
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_reports.img_logo
import kotlinx.android.synthetic.main.activity_reports.toolbar
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class ReportsActivity : BaseActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: ReportsViewModelFactory by instance()
    private val conversions: Conversions by instance()

    private lateinit var viewModel: ReportsViewModel
    private lateinit var viewBinding: ActivityReportsBinding

    private lateinit var featureController: FeatureController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReportsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ReportsViewModel::class.java)
        initializeViews()
        setupObservers()

    }

    override fun onStart() {
        super.onStart()
        loadReports()

        viewBinding.imgLogo.setOnClickListener {
            startActivity(Intent(this, CategoryBrandListActivity::class.java))
        }
    }

    private fun initializeViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.toolbar_title)

        featureController = FeatureController(conversions)

//        viewBinding.rvReports.layoutManager =
//            LinearLayoutManager(this@ReportsActivity, HORIZONTAL, false)
//        viewBinding.rvReports.setHasFixedSize(true)
//        viewBinding.rvReports.adapter = featureController.adapter

        viewBinding.rvReports.setController(featureController)
        viewBinding.rvReports.addItemDecoration(DividerItemDecoration(this, VERTICAL))

//
//        val pagerSnapHelper = PagerSnapHelper()
//        pagerSnapHelper.attachToRecyclerView(rv_reports)
//
//        val indicator: CircleIndicator2 = findViewById(R.id.indicator)
//        indicator.attachToRecyclerView(rv_reports, pagerSnapHelper)
//        mAdapter.registerAdapterDataObserver(indicator.adapterDataObserver)

        Glide.with(this).load(R.drawable.img_logo).into(img_logo)
    }

    fun loadReports() {
        viewModel.loadReports("ISO_2_CODE+%3D+%27pt%27+")
    }

    private fun setupObservers() = launch {
        val reports = viewModel.reports.await()
        reports.observe(this@ReportsActivity, { data ->
            Log.e(">>>Test: ", "setupObservers: $data")
            featureController.allFeatures = data.features
        })
    }
}