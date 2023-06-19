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
    public static double[] getRecommendedTemperature(TimeOfDay currentTimeOfDay, TimeOfYear currentTimeOfYear) {
        double[] temperatureRange = new double[2];

        if (currentTimeOfYear == TimeOfYear.Зима) {
            if (currentTimeOfDay == TimeOfDay.Утро) {
                temperatureRange[0] = 18.0;
                temperatureRange[1] = 20.0;
            } else if (currentTimeOfDay == TimeOfDay.День) {
                temperatureRange[0] = 20.0;
                temperatureRange[1] = 22.0;
            } else if (currentTimeOfDay == TimeOfDay.Вечер) {
                temperatureRange[0] = 19.0;
                temperatureRange[1] = 21.0;
            } else { // НОЧЬ
                temperatureRange[0] = 17.0;
                temperatureRange[1] = 19.0;
            }
        } else { // Остальные времена года
            if (currentTimeOfDay == TimeOfDay.Утро) {
                temperatureRange[0] = 21.0;
                temperatureRange[1] = 23.0;
            } else if (currentTimeOfDay == TimeOfDay.День) {
                temperatureRange[0] = 23.0;
                temperatureRange[1] = 25.0;
            } else if (currentTimeOfDay == TimeOfDay.Вечер) {
                temperatureRange[0] = 22.0;
                temperatureRange[1] = 24.0;
            } else { // НОЧЬ
                temperatureRange[0] = 20.0;
                temperatureRange[1] = 22.0;
            }
        }

        return temperatureRange;
    }

    public static double[] getRecommendedWet(TimeOfYear currentTimeOfYear, SystemPower currentSystemPower) {
        double[] wetRange = new double[2];

        if (currentTimeOfYear == TimeOfYear.Лето) {
            if (currentSystemPower == SystemPower.Высокая) {
                wetRange[0] = 50.0;
                wetRange[1] = 60.0;
            } else if (currentSystemPower == SystemPower.Средняя) {
                wetRange[0] = 45.0;
                wetRange[1] = 55.0;
            } else { // Низкая
                wetRange[0] = 40.0;
                wetRange[1] = 50.0;
            }
        } else {
            if (currentSystemPower == SystemPower.Высокая) {
                wetRange[0] = 45.0;
                wetRange[1] = 55.0;
            } else if (currentSystemPower == SystemPower.Средняя) {
                wetRange[0] = 40.0;
                wetRange[1] = 50.0;
            } else { // Низкая
                wetRange[0] = 35.0;
                wetRange[1] = 45.0;
            }
        }

        return wetRange;
    }

    public static double[] getRecommendedAirQuality(TimeOfYear currentTimeOfYear, Fullness currentFullness) {
        double[] airQualityRange = new double[2];

        if (currentTimeOfYear == TimeOfYear.Осень) {
            if (currentFullness == Fullness.Высокая) {
                airQualityRange[0] = 75.0;
                airQualityRange[1] = 85.0;
            } else if (currentFullness == Fullness.Средняя) {
                airQualityRange[0] = 70.0;
                airQualityRange[1] = 80.0;
            } else { // Низкая
                airQualityRange[0] = 65.0;
                airQualityRange[1] = 75.0;
            }
        } else {
            if (currentFullness == Fullness.Высокая) {
                airQualityRange[0] = 70.0;
                airQualityRange[1] = 80.0;
            } else if (currentFullness == Fullness.Средняя) {
                airQualityRange[0] = 65.0;
                airQualityRange[1] = 75.0;
            } else { // Низкая
                airQualityRange[0] = 60.0;
                airQualityRange[1] = 70.0;
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
