package com.cbr.cbr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class WebReaderTryOne {

    @GetMapping
    public String method1(Model model) {
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

        model.addAttribute("sampleLines", sampleStrings);

        return "testing2";
    }
}
