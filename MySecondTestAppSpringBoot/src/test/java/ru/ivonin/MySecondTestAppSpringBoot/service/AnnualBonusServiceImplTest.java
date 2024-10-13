package ru.ivonin.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.ivonin.MySecondTestAppSpringBoot.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnualBonusServiceImplTest {

    @Test
    void calculateAnnualBonus() {
        // given
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        // when
        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bonus, workDays, 2024);

        // then
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyBonus_WhenManager_ReturnsExpectedBonus() {
        // given
        Positions positions = Positions.MANAGER;
        double salary = 100000.00;
        double quarterlyBonus = 0.25;

        // when
        double result = new AnnualBonusServiceImpl().calculateQuarterlyBonus(positions, salary, quarterlyBonus);

        // then
        double expected = 25000.0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyBonus_WhenNotManager_ThrowsException() {
        // given
        Positions positions = Positions.DEV;
        double salary = 100000.00;
        double quarterlyBonus = 0.25;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            // when
            new AnnualBonusServiceImpl().calculateQuarterlyBonus(positions, salary, quarterlyBonus);
        });
    }
}