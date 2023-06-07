package com.latextoword.dictionary;

import com.latextoword.atom.AtomRegex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum AtomChar {

    BACKSLASH("\\", Arrays.asList(new AtomRegex(1, "", "^\\\\([a-zA-Z]+|\\\\| |;|,|!|%|#|\\$|\\^|_|~|:)", "", 0, 0, 1), new AtomRegex("{", "^\\\\\\{.*?\\\\\\}", "}", 1, 1, 1), new AtomRegex("[", "^\\\\\\[.*?\\\\\\]", "]", 1, 1, 1), new AtomRegex("", "\\\\(\\{|\\}|\\[|\\]|\\(|\\))", "", 0, 0, 1)), 0),
    AMP("&", Arrays.asList(new AtomRegex("", "^&[a-zA-z]{1,10}[1-5]?;", "", 0, 0, 1), new AtomRegex("", "^&#[0-9]{1,5};", "", 0, 0, 2), new AtomRegex("", "^&", "", 0, 0, 1)), 0),
    SUP("^", new ArrayList<>(), 0),
    SUB("_", new ArrayList<>(), 0),
    BRACE("{", Collections.singletonList(new AtomRegex("{", "^\\{.*?\\}", "}", 0, 0, 1)), 1),
    BRACKET("(", Collections.singletonList(new AtomRegex("(", "^\\(.*?\\)", ")", 1, 0, 1)), 1),
    BRACKETZH("（", Collections.singletonList(new AtomRegex("（", "^\\（.*?\\）", "）", 1, 0, 1)), 1),
    SQARE_BRACKET("[", Collections.singletonList(new AtomRegex("[", "^\\[.*?\\]", "]", 1, 0, 1)), 1),
    GT(">", new ArrayList<>(), 0),
    LT("<", new ArrayList<>(), 0),
    LONGEQUAL("═", new ArrayList<>(), 0),
    WAVE("~", new ArrayList<>(), 0),
    ;

    private final String atomChar;
    private final List<AtomRegex> regex;
    //0:atomName;1:atomBEs
    private final Integer type;

    AtomChar(String atomChar, List<AtomRegex> regex, Integer type) {
        this.atomChar = atomChar;
        this.regex = regex;
        this.type = type;
    }

    public String getAtomChar() {
        return atomChar;
    }

    public List<AtomRegex> getRegex() {
        return regex;
    }

    public Integer getType() {
        return type;
    }


}
