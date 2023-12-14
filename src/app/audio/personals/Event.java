package app.audio.personals;
import app.audio.LibraryEntry;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Event {
    @Getter
    private String name;
    @Getter
    private String owner;
    @Getter
    private String description;
    @Getter
    private String date; // Format dd-mm-yyyy

    public Event(String owner, String name, String description, String date) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public class DateValidator {
        public static boolean isValidDate(String dateString) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // Setează să nu fie permisive interpretările datei

            try {
                sdf.parse(dateString); // Verificăm dacă data este în formatul corect

                String[] parts = dateString.split("-");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (year < 1900 || year > 2023) {
                    return false; // Anul nu este în intervalul acceptat
                }

                if (month < 1 || month > 12) {
                    return false; // Luna nu este validă
                }

                if (day < 1 || day > 31) {
                    return false; // Ziua nu este validă
                }

                // Verifică special pentru luna februarie
                if (month == 2 && day > 28) {
                    return false; // Februarie nu poate avea mai mult de 28 de zile
                }

                // Verifică luni cu 30 de zile
                if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                    return false; // Aprilie, Iunie, Septembrie, Noiembrie nu pot avea mai mult de 30 de zile
                }

                return true; // Data este validă
            } catch (ParseException | NumberFormatException e) {
                return false; // Formatul datei este invalid sau eroare la conversia numerelor
            }
        }

    }
}