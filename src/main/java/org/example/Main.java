package org.example;

/*
Сделать классы

Карта с полями - номер имя фамилия cvv дата+

Для хранения этих данных ОДНОЙ СТРИНГОЙ+

для генерации ИмениФамилии итд+

для хранения всех данных+

для записи всех данных в файл+

для чтения всех данных из файла

для парсинга регулярными выражениями и там же для предоставления этих данных при помощи printF в красивом виде


Далее:
Должны быть проверки на корректные даты - формат ММ/ГГ
 */
public class Main {
    public static void main(String[] args) {
        CardToFile cardToFile = new CardToFile();
        CardFromFile cards = new CardFromFile();
        ParsCard parsCard = new ParsCard();

        CardGeneration user1 = new CardGeneration();
        CardGeneration user2 = new CardGeneration();
        CardGeneration user3 = new CardGeneration();
        CardGeneration user4 = new CardGeneration();

        cardToFile.toFile(user2.toString(), "card.txt", false);
        cardToFile.toFile(user3.toString(), "card.txt", true);
        cardToFile.toFile(user1.toString(), "card.txt", true);
        cardToFile.toFile(user4.toString(), "card.txt", true);
        cards.readFromFile("card.txt").forEach(parsCard::parse);
    }
}