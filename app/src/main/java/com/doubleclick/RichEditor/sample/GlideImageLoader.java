package com.doubleclick.RichEditor.sample;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lzy.imagepicker.loader.ImageLoader;

import java.io.File;



public class GlideImageLoader implements ImageLoader {

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int i, int i1) {
        Glide.with(activity).load(Uri.fromFile(new File(path))).into(imageView);
    }

    @Override public void clearMemoryCache() {

    }
}
