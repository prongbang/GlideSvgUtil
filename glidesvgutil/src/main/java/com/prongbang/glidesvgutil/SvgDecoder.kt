package com.prongbang.glidesvgutil

import android.support.annotation.NonNull
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import java.io.IOException
import java.io.InputStream


/**
 * Created by prongbang on 3/12/2018 AD.
 *
 * Decodes an SVG internal representation from an {@link InputStream}.
 *
 * @author com.bumptech.glide.samples.svg
*/
class SvgDecoder : ResourceDecoder<InputStream, SVG> {

    override fun handles(@NonNull source: InputStream, @NonNull options: Options): Boolean {
        // TODO: Can we tell?
        return true
    }

    @Throws(IOException::class)
    override fun decode(@NonNull source: InputStream, width: Int, height: Int,
                        @NonNull options: Options): Resource<SVG> {
        try {
            val svg = SVG.getFromInputStream(source)
            return SimpleResource(svg)
        } catch (ex: SVGParseException) {
            throw IOException("Cannot load SVG from stream", ex)
        }

    }
}