package com.github.moinmarcell.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    public String uploadPhoto(@RequestParam("file") MultipartFile photo) throws IOException {
        return photoService.uploadPhoto(photo);
    }

}
