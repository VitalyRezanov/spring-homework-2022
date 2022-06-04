package com.netcracker.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUploadService {

    public String uploadFile(MultipartFile file, RedirectAttributes redirectAttributes, Resource resource) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get("/" + file.getOriginalFilename());
        try(BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(Files.write(path, bytes).toFile()))); BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(resource.getFile(),true)))) {
            bw.write(br.readLine());
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }
}
