package com.cbr.cbr;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleReader {

//    @PostConstruct
    private void init() {
        File sample = new File("src/main/resources/static/sample.fb2");
        System.out.println("Sample can read?: " + sample.canRead());
        System.out.println("path: " + sample.getAbsolutePath());

        List<String> sampleStrings = new ArrayList<>();

        if (sample.canRead()) {
            try {
                sampleStrings = Files.readAllLines(Path.of(sample.getPath()), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String sampleString : sampleStrings) {
            System.out.println(sampleString);
        }
    }
}
