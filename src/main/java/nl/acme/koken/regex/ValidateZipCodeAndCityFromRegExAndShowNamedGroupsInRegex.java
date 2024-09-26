package nl.acme.koken.regex;

import nl.acme.koken.assertion.Assertion;

public class ValidateZipCodeAndCityFromRegExAndShowNamedGroupsInRegex {
    public static void main(String[] args) {
        Assertion.ensure("7611 AB  Den Haag".matches("^(?<numbers>[1-9][0-9]{3})\\s?(?<letters>[A-Za-z]{2})\\s{1,2}(?<city>[A-Z][a-z]+\\s*[A-Za-z]+)$"));
    }
}
