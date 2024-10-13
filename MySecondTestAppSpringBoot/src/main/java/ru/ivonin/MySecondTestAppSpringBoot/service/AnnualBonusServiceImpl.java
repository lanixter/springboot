package ru.ivonin.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.ivonin.MySecondTestAppSpringBoot.model.Positions;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays, int year) {
        int daysInYear = isLeapYear(year) ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    public double calculateQuarterlyBonus(Positions positions, double salary, double quarterlyBonus) {
        if (!positions.isManager()) {
            throw new IllegalArgumentException("Квартальная премия доступна только для менеджеров.");
        }
        return salary * quarterlyBonus;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}