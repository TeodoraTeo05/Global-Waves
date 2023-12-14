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
                Date date = sdf.parse(dateString);
                // Verifică alte condiții specifice, cum ar fi anul și luna
                return true; // Data este validă
            } catch (ParseException e) {
                return false; // Data este invalidă
            }
        }

    }
}