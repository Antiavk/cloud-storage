package com.cloudstorage.storage.controllers;


import com.cloudstorage.storage.models.File;
import com.cloudstorage.storage.services.StorageService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin(
        origins = "${origins.clients}",
        allowCredentials = "true"
)
@RestController
@RequestMapping("/")
public class StorageController {

    private StorageService service;

    public StorageController(StorageService service) {
        this.service = service;
    }

    @PostMapping("/file")
    public ResponseEntity<String> filePost(@RequestHeader("auth-token") String authToken,
                                           @RequestBody MultipartFile file) {
        final String response = service.saveFile(authToken, file);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/file")
    public void fileDelete(@RequestHeader("auth-token") String authToken,
                           @RequestParam("filename") String filename) {
        service.deleteFile(authToken, filename);
    }

    @GetMapping("/file")
    public ResponseEntity<byte[]> fileGet(@RequestHeader("auth-token") String authToken,
                                          @RequestParam("filename") String filename) {
        final byte[] file = service.getFile(authToken, filename);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        ResponseEntity response = new ResponseEntity(file, headers, HttpStatus.OK);
        return response;
    }


    @PutMapping("/file")
    public void filenamePut(@RequestHeader("auth-token") String authToken,
                            @RequestParam("filename") String filename,
                            @RequestBody File newFilename
    ) {

        service.updateFile(authToken, filename, newFilename.getFilename());
    }


    @GetMapping("/list")
    public ResponseEntity<List<File>> list(@RequestHeader("auth-token") String authToken,
                                           @RequestParam("limit") int limit) {
        final List<File> fileList = service.getFileList(authToken, limit);
        return ResponseEntity.ok(fileList);
    }


}
