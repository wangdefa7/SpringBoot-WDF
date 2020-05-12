package com.wdf.test.testphoto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @RequestMapping("/openPhotoPage")
    public String openPhotoPage(){
        System.out.println("进入openPhotoPage");
        return "/testphoto/photo";
    }

    @RequestMapping("/uploadPhoto")
    @ResponseBody
    public String uploadPhoto(@RequestParam MultipartFile file){
        String name = file.getOriginalFilename();
        System.out.println(name);
        return name;
    }
}
