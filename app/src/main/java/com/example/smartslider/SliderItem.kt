package com.example.smartslider

import android.graphics.Bitmap

class SliderItem {
    var image: Bitmap? = null

    constructor(){}

    constructor(image: Bitmap) {
        this.image = image
    }
}