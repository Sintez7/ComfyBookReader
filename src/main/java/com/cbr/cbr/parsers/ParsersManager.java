package com.cbr.cbr.parsers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParsersManager {

    private List<Parser> parsers = new ArrayList<>();

    public void registerParser(Parser parser) {
        parsers.add(parser);
    }

    public Parser findParser(String extension) {
        for (Parser parser : parsers) {
            if (parser.canParse(extension)) {
                return parser;
            }
        }
        return null;
    }
}
