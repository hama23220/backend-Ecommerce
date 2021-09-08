package com.mohamed.commerce.Services;

import java.io.InputStream;

public interface FlickrService {
    String savePhoto(InputStream photo, String title);
}
