package com.conamobile.android_mvp_1dars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.android_mvp_1dars.adapter.PostAdapter
import com.conamobile.android_mvp_1dars.model.Post
import com.conamobile.android_mvp_1dars.presenter.MainPresenter
import com.conamobile.android_mvp_1dars.utils.Utils
import com.conamobile.android_mvp_1dars.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var recyclerView: RecyclerView
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mainPresenter = MainPresenter(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        mainPresenter.apiPostList()
    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.adapter = adapter
    }

    override fun onPostListSuccess(posts: ArrayList<Post>) {
        refreshAdapter(posts)
    }

    override fun onPostListFailure(error: String) {}

    override fun onPostDeleteSuccess(posts: Post?) {
        mainPresenter.apiPostList()
    }

    override fun onPostDeleteFailure(error: String) {}
}