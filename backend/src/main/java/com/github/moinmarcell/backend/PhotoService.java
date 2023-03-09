package com.github.moinmarcell.backend;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhotoService {

    private final Cloudinary cloudinary;

    public PhotoService() {
        Map config = new HashMap<>();
        config.put("cloud_name", "YOUR_CLOUD_NAME");
        config.put("api_key", "YOUR_API_KEY");
        config.put("api_secret", "YOUR_API_SECRET");
        cloudinary = new Cloudinary(config);
    }

    public String uploadPhoto(MultipartFile photo) throws IOException {
        Map result = cloudinary.uploader().upload(photo.getBytes(), ObjectUtils.emptyMap());
        return result.get("url").toString();
    }
}
