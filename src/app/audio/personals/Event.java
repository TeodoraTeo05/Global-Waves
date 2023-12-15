package app.audio.personals;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public final class Event {
    @Getter
    private String name;
    @Getter
    private String owner;
    @Getter
    private String description;
    @Getter
    private String date;
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2023;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int FEBRUARY = 2;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int MAX_DAY_FEBRUARY = 28;
    private static final int MAX_DAY_SHORT_MONTH = 30;
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    public Event(final String owner, final String name, final String description,
                 final String date) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    /**
     * Checks if the date is valid.
     *
     * @param dateString the date string
     * @return true if the date is valid, false otherwise
     */
    public static boolean isValidDate(final String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);

        try {
            sdf.parse(dateString);

            String[] parts = dateString.split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (year < MIN_YEAR || year > MAX_YEAR) {
                return false;
            }

            if (month < MIN_MONTH || month > MAX_MONTH) {
                return false;
            }

            if (day < MIN_DAY || day > MAX_DAY) {
                return false;
            }

            if (month == FEBRUARY && day > MAX_DAY_FEBRUARY) {
                return false;
            }

            if ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
                    && day > MAX_DAY_SHORT_MONTH) {
                return false;
            }

            return true;
        } catch (ParseException | NumberFormatException e) {
            return false;
        }
    }
}
