package ru.ivonin.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.ivonin.MySecondTestAppSpringBoot.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays, int year);
    double calculateQuarterlyBonus(Positions positions, double salary, double quarterlyBonus);
}