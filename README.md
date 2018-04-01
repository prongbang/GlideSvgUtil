# Glide Svg Util

Load image based on [Glide](https://github.com/bumptech/glide/tree/master/samples/svg/src/main/java/com/bumptech/glide/samples/svg) and [AndroidSvg](https://github.com/BigBadaboom/androidsvg) library.

Thank you.

### Download
> build.gradle
```
 allprojects {
     repositories {
         maven { url 'https://jitpack.io' }
     }
 }
 
 ...
 apply plugin: 'kotlin-kapt'
 
 dependencies {
     implementation 'com.github.prongbang:glidesvgutil:1.0.0'
     implementation 'com.github.bumptech.glide:glide:4.6.1'
     kapt 'com.github.bumptech.glide:compiler:4.6.1'
     implementation 'com.caverock:androidsvg:1.2.1'
 }
```

### How to use
> Load svg from url
```kotlin
GlideSvgUtil(this).builder().load(ivPreviewFromUrl, "https://image.flaticon.com/icons/svg/789/789440.svg")
```

> Load svg from resources
```kotlin
GlideSvgUtil(this).builder().load(ivPreviewFromRes, R.raw.flower)
```