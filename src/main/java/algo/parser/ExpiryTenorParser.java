package algo.parser;

import java.util.Map;

public class ExpiryTenorParser {

    public ExpiryTenorParser(Map<String, Integer> cache) {
        this.cache = cache;
    }

    private final Map<String, Integer> cache;

    String parse(String input) {
        input = input.toUpperCase().trim();

        StringBuilder prevString = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            var current = input.charAt(i);

            if(current == ' ') {
                continue;
            }

            if((current >= '0' && current <= '9') || current == 'Y' || current == 'M' || current == '.') {
                prevString.append(current);
            } else {
                stringBuilder.append(getValue(prevString)).append(current);
                prevString = new StringBuilder();
            }
        }

        return stringBuilder.append(getValue(prevString)).toString();
    }

    private String getValue(StringBuilder prevString) {
        String result;
        if(cache.containsKey(prevString.toString())) {
            result = String.valueOf(cache.get(prevString.toString()));
        }else {
            if (prevString.toString().isEmpty() || isNumber(prevString)) {
                result = prevString.toString();
            } else  {
                throw new IllegalArgumentException("cant parse input!");
            }
        }
        return result;
    }

    private boolean isNumber(StringBuilder stringBuilder) {
        try {
            Double.parseDouble(stringBuilder.toString());
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
