package org.bracket;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BracketValidator {

    private static final Map<Character, Character> BRACKET_DICTIONARY;

    static {
        BRACKET_DICTIONARY = new HashMap<>();
        BRACKET_DICTIONARY.put('{', '}');
        BRACKET_DICTIONARY.put('(', ')');
        BRACKET_DICTIONARY.put('[', ']');
    }

    public boolean isBracketClosed(String brackets) {
        LinkedList<Character> openBrackets = new LinkedList<>();

        for (char bracket : brackets.toCharArray()) {
            Character closeBracket = BRACKET_DICTIONARY.get(bracket);
            if (closeBracket != null) {
                openBrackets.add(bracket);
            } else if (!openBrackets.isEmpty()) {
                Character character = openBrackets.removeLast();
                if (!BRACKET_DICTIONARY.get(character).equals(bracket)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return openBrackets.isEmpty();
    }

}
