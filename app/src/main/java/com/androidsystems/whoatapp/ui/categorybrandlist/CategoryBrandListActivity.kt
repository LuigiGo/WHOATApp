package com.androidsystems.whoatapp.ui.categorybrandlist

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.androidsystems.whoatapp.R
import com.androidsystems.whoatapp.databinding.ActivityCategoryBrandListBinding
import com.androidsystems.whoatapp.ui.base.BaseActivity
import com.androidsystems.whoatapp.ui.categorybrandlist.entity.CategoryBrand

class CategoryBrandListActivity : BaseActivity() {

    private lateinit var binding: ActivityCategoryBrandListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_brand_list)

        val categoryBrand = CategoryBrand("Shoes", "Nike")
        binding.categorybrand = categoryBrand



    }

}