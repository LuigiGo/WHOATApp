package com.androidsystems.whoatapp.ui.reports

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.androidsystems.whoatapp.R
import com.androidsystems.whoatapp.R.layout
import com.androidsystems.whoatapp.data.entity.Feature
import com.androidsystems.whoatapp.ui.base.BaseActivity
import com.androidsystems.whoatapp.utilities.helpers.Conversions
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_reports.img_logo
import kotlinx.android.synthetic.main.activity_reports.rv_reports
import kotlinx.android.synthetic.main.activity_reports.toolbar
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator2
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class ReportsActivity : BaseActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: ReportsViewModelFactory by instance()
    private val conversions: Conversions by instance()

    private lateinit var viewModel: ReportsViewModel
    private lateinit var adapter: ReportsAdapter
    private var mReportsData: ArrayList<Feature> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_reports)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ReportsViewModel::class.java)
        adapter = ReportsAdapter(this, conversions)
    }

    override fun onStart() {
        super.onStart()
        initializeViews()
        loadReports()
    }

    private fun initializeViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.toolbar_title)

        rv_reports.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        rv_reports.adapter = adapter
        rv_reports.setHasFixedSize(true)
        adapter.setData(mReportsData)

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(rv_reports)

        val indicator: CircleIndicator2 = findViewById(R.id.indicator)
        indicator.attachToRecyclerView(rv_reports, pagerSnapHelper)
        adapter.registerAdapterDataObserver(indicator.adapterDataObserver)


        Glide.with(this).load(R.drawable.img_logo).into(img_logo)
    }

    private fun loadReports() = launch {
        viewModel.location = "ISO_2_CODE+%3D+%27pt%27+"
        val reports = viewModel.reports.await()
        reports.observe(this@ReportsActivity, Observer { data ->
            mReportsData.addAll(data.features)
            adapter.notifyDataSetChanged()
        })
    }
}