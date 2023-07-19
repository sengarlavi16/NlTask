package com.community.nltask.api.views

import android.content.Context

interface IAppView {
        fun getContext(): Context
        fun enableLoadingBar(context: Context, enable: Boolean, s: String)
        fun onError(reason: String?)
}