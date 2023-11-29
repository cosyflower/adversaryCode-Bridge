package bridge.parser;

import java.util.regex.Pattern;

public class PatternRegex {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final Pattern WORD_PATTERN = Pattern.compile("^\\w+$");
}
