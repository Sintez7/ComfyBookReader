package com.cbr.cbr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class WebReaderTryOne {

    @GetMapping
    public String method1(Model model) {
        System.err.println(model);
        model.addAttribute("att1", "att1val");
        model.addAttribute("objattadd");
        System.err.println(model);
        return "testing1";
    }
}
