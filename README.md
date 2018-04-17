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
     implementation 'com.github.prongbang:glidesvgutil:1.0.3'
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

> Circle Image View
- Dependencies
```
implementation "com.android.support:cardview-v7:27.1.1"
```
- Layout
```xml
<android.support.v7.widget.CardView
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:shape="ring"
    app:cardCornerRadius="100dp">

    <android.support.v7.widget.AppCompatImageView
        android:id="@+id/ivPreviewFromUrl"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/colorAccent" />
</android.support.v7.widget.CardView>
```
- 