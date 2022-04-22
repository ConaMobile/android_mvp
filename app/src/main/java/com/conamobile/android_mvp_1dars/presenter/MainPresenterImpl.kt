package com.conamobile.android_mvp_1dars.presenter

import com.conamobile.android_mvp_1dars.model.Post

interface MainPresenterImpl {
    fun apiPostList()
    fun apiPostDelete(post: Post)
}