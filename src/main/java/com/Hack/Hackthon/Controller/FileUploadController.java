package com.Hack.Hackthon.Controller;

import com.Hack.Hackthon.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {


    @Autowired
    private FileUploadHelper fileUploadHelper;

   @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) {

       try {
           if (file.isEmpty()) {


               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select valid file");
           } else if (!file.getContentType().equals("image/png")) {

               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg Content type are allowed");

           }

                            boolean f =    fileUploadHelper.uploadFile(file);
                                if(f){
                                    return ResponseEntity.ok("File uploaded Succesfully");
                                }



       }catch(Exception e){

           e.printStackTrace();

                          }

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrog! Try again");

   }


}
