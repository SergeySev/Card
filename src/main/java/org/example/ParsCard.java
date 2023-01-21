package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsCard {
    public void parse(String data) {
        if (data.isEmpty()) return;
        String regex = "^(Name|Card number|CVV|Year|Month):(.+)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(data);

        String name = "";
        String cardNumber = "";
        String cvv = "";
        String year = "";
        String month = "";

        while (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            switch (group1) {
                case ("Name") -> name = replaceFirstSpace(group2);
                case ("Card number") -> cardNumber = replaceFirstSpace(group2);
                case ("CVV")-> cvv = replaceFirstSpace(group2);
                case ("Year")-> year = replaceFirstSpace(group2);
                case ("Month")-> month = replaceFirstSpace(group2);
            }
        }
        System.out.printf("Name: %-30s\t Card number: %-16s\t CVV: %-3s\t Year: %-3s\t Month: %-3s\n",
                name, cardNumber, cvv, year, month);
    }
    private String replaceFirstSpace(String str) {
        return (str.startsWith(" ")) ? str.replaceFirst(" ", "") : str;
    }
}
