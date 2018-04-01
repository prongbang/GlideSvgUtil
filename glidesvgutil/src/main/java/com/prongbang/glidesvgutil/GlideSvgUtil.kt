package com.prongbang.glidesvgutil

import android.content.ContentResolver
import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * Created by prongbang on 3/12/2018 AD.
 */
class GlideSvgUtil(private val context: Context) {

    private var progressBar: ProgressBar? = null
    private var placeholderRes: Int? = null
    private var imageErrorRes: Int? = null

    fun builder(): Builder {
        val glideRequest = GlideApp.with(context).`as`(PictureDrawable::class.java)

        if (placeholderRes != null) glideRequest.placeholder(placeholderRes!!)
        if (imageErrorRes != null) glideRequest.error(imageErrorRes!!)

        val requestBuilder = glideRequest.transition(DrawableTransitionOptions.withCrossFade()).listener(SvgSoftwareLayerSetter())

        return Builder(requestBuilder)
    }

    fun placeholder(placeholder: Int): GlideSvgUtil {
        placeholderRes = placeholder
        return this
    }

    fun error(imageError: Int): GlideSvgUtil {
        imageErrorRes = imageError
        return this
    }

    fun progressBar(progressBar: ProgressBar): GlideSvgUtil {
        this.progressBar = progressBar
        return this
    }

    inner class Builder(private var requestBuilder: RequestBuilder<PictureDrawable>) {

        fun load(imageView: ImageView, rawImage: Int) {
            val uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.packageName + "/" + rawImage)
            requestBuilder.load(uri).listener(object : RequestListener<PictureDrawable> {

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<PictureDrawable>?, isFirstResource: Boolean): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(resource: PictureDrawable?, model: Any?, target: Target<PictureDrawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }

            }).into(imageView)
        }

        fun load(imageView: ImageView, url: String) {
            val uri = Uri.parse(url)
            requestBuilder.load(uri).listener(object : RequestListener<PictureDrawable> {

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<PictureDrawable>?, isFirstResource: Boolean): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(resource: PictureDrawable?, model: Any?, target: Target<PictureDrawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }

            }).into(imageView)
        }
    }

}