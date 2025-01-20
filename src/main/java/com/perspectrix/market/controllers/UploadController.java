package com.perspectrix.market.controllers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.perspectrix.market.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.perspectrix.market.domain.Person;

import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/write")
public class UploadController {
    /**
     * this will handle the uploading and parsing of a csv. We denote the header
     * then we build a person for each row and upload to MongoDB.
     */

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public String uploadCSV(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){return "Please select a CSV file to upload";}

        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] nextLine;
            String csvHeader = null;
            while ((nextLine = reader.readNext()) != null) {
                if (csvHeader == null) {
                    csvHeader = String.join(",", nextLine);
                } else {
                    try {
                        Person person = new Person(csvHeader, nextLine);
                        uploadService.saveOrUpdatePerson(person);
                    }catch (IndexOutOfBoundsException e){
                        return "Please provide a CSV with all the required fields.";
                    }
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return "CSV file uploaded and processed successfully!";
    }
}
