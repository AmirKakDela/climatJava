package com.climat.demo;


enum TimeOfDay {
    Утро,
    День,
    Вечер,
    Ночь
}

enum TimeOfYear {
    Зима,
    Весна,
    Лето,
    Осень
}

enum SystemPower {
    Низкая,
    Средняя,
    Высокая
}

enum Fullness {
    Низкая,
    Средняя,
    Высокая
}

public class RoomEnvironmentRecommendation {
    public static int[] getRecommendedTemperature(TimeOfDay currentTimeOfDay, TimeOfYear currentTimeOfYear) {
        int[] temperatureRange = new int[2];

        if (currentTimeOfYear == TimeOfYear.Зима) {
            if (currentTimeOfDay == TimeOfDay.Утро) {
                temperatureRange[0] = 18;
                temperatureRange[1] = 20;
            } else if (currentTimeOfDay == TimeOfDay.День) {
                temperatureRange[0] = 20;
                temperatureRange[1] = 22;
            } else if (currentTimeOfDay == TimeOfDay.Вечер) {
                temperatureRange[0] = 19;
                temperatureRange[1] = 21;
            } else { // НОЧЬ
                temperatureRange[0] = 17;
                temperatureRange[1] = 19;
            }
        } else { // Остальные времена года
            if (currentTimeOfDay == TimeOfDay.Утро) {
                temperatureRange[0] = 21;
                temperatureRange[1] = 23;
            } else if (currentTimeOfDay == TimeOfDay.День) {
                temperatureRange[0] = 23;
                temperatureRange[1] = 25;
            } else if (currentTimeOfDay == TimeOfDay.Вечер) {
                temperatureRange[0] = 22;
                temperatureRange[1] = 24;
            } else { // НОЧЬ
                temperatureRange[0] = 20;
                temperatureRange[1] = 22;
            }
        }

        return temperatureRange;
    }

    public static int[] getRecommendedWet(TimeOfYear currentTimeOfYear, SystemPower currentSystemPower) {
        int[] wetRange = new int[2];

        if (currentTimeOfYear == TimeOfYear.Лето) {
            if (currentSystemPower == SystemPower.Высокая) {
                wetRange[0] = 50;
                wetRange[1] = 60;
            } else if (currentSystemPower == SystemPower.Средняя) {
                wetRange[0] = 45;
                wetRange[1] = 55;
            } else { // Низкая
                wetRange[0] = 40;
                wetRange[1] = 50;
            }
        } else {
            if (currentSystemPower == SystemPower.Высокая) {
                wetRange[0] = 45;
                wetRange[1] = 55;
            } else if (currentSystemPower == SystemPower.Средняя) {
                wetRange[0] = 40;
                wetRange[1] = 50;
            } else { // Низкая
                wetRange[0] = 35;
                wetRange[1] = 45;
            }
        }

        return wetRange;
    }

    public static int[] getRecommendedAirQuality(TimeOfYear currentTimeOfYear, Fullness currentFullness) {
        int[] airQualityRange = new int[2];

        if (currentTimeOfYear == TimeOfYear.Осень) {
            if (currentFullness == Fullness.Высокая) {
                airQualityRange[0] = 75;
                airQualityRange[1] = 85;
            } else if (currentFullness == Fullness.Средняя) {
                airQualityRange[0] = 70;
                airQualityRange[1] = 80;
            } else { // Низкая
                airQualityRange[0] = 65;
                airQualityRange[1] = 75;
            }
        } else {
            if (currentFullness == Fullness.Высокая) {
                airQualityRange[0] = 70;
                airQualityRange[1] = 80;
            } else if (currentFullness == Fullness.Средняя) {
                airQualityRange[0] = 65;
                airQualityRange[1] = 75;
            } else { // Низкая
                airQualityRange[0] = 60;
                airQualityRange[1] = 70;
            }
        }

        return airQualityRange;
    }

    public static TimeOfDay getCurrentTimeOfDay() {
        // Логика определения текущего времени суток
        int currentHour = java.time.LocalTime.now().getHour();

        if (currentHour >= 5 && currentHour < 12) {
            return TimeOfDay.Утро;
        } else if (currentHour >= 12 && currentHour < 18) {
            return TimeOfDay.День;
        } else if (currentHour >= 18 && currentHour < 22) {
            return TimeOfDay.Вечер;
        } else {
            return TimeOfDay.Ночь;
        }
    }

    public static TimeOfYear getCurrentSeason() {
        // Логика определения текущего времени года

        int currentMonth = java.time.LocalDate.now().getMonthValue();

        if (currentMonth >= 3 && currentMonth <= 5) {
            return TimeOfYear.Весна;
        } else if (currentMonth >= 6 && currentMonth <= 8) {
            return TimeOfYear.Лето;
        } else if (currentMonth >= 9 && currentMonth <= 11) {
            return TimeOfYear.Осень;
        } else {
            return TimeOfYear.Зима;
        }
    }

}
