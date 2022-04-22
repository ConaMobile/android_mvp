package com.conamobile.android_mvp_1dars.view

import com.conamobile.android_mvp_1dars.model.Post
import java.util.ArrayList

interface MainView {

    fun onPostListSuccess(posts: ArrayList<Post>)
    fun onPostListFailure(error: String)

    fun onPostDeleteSuccess(posts: Post?)
    fun onPostDeleteFailure(error: String)
}