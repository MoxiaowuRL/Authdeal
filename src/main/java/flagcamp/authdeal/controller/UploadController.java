package flagcamp.authdeal.controller;

import flagcamp.authdeal.util.FileUploadUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@CrossOrigin
public class UploadController {
  @RequestMapping(value ="/upload", method = RequestMethod.POST)
  public ResponseEntity<Map> upload(@RequestParam("image") MultipartFile multipartFile) throws IOException {
    System.out.println(multipartFile.toString());
    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

    String uploadDir = "src/main/webapp/" + multipartFile.getOriginalFilename();
    //String uploadDir = "/image_upload/";
    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

    //
    System.out.println(fileName);
    Map map = new HashMap<String,String>();
    map.put("image",fileName);

    return new ResponseEntity<Map>(map, HttpStatus.OK);
  }

}
