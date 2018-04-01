package com.prongbang.glidesvgutil

import android.graphics.drawable.PictureDrawable
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder
import com.caverock.androidsvg.SVG


/**
 * Created by prongbang on 3/12/2018 AD.
 *
 * Convert the {@link SVG}'s internal representation to an Android-compatible one ({@link Picture}).
 * @author com.bumptech.glide.samples.svg
 */
class SvgDrawableTranscoder : ResourceTranscoder<SVG, PictureDrawable> {

    @Nullable
    override fun transcode(@NonNull toTranscode: Resource<SVG>, @NonNull options: Options): Resource<PictureDrawable> {
        val svg = toTranscode.get()
        val picture = svg.renderToPicture()
        val drawable = PictureDrawable(picture)
        return SimpleResource(drawable)
    }
}