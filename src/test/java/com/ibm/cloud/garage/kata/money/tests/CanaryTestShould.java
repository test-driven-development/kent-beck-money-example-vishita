package com.ibm.cloud.garage.kata.money.tests;

import com.ibm.cloud.garage.kata.money.Canary;
import com.ibm.cloud.garage.kata.money.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CanaryTestShould {
    @Test
    public void showTheTestInfrastructureWorks() {
        assertThat((new Canary().doesTestInfrastructureWork))
                .isEqualTo(true);
    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertThat(Money.dollar(10)).isEqualTo(five.times(2));
        assertThat(Money.dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    public void testEquality() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
        assertThat(Money.franc(5)).isNotEqualTo(Money.dollar(5));
    }

    @Test
    public void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money sum = Money.dollar(5).plus(Money.dollar(5));
        assertThat(Money.dollar(10)).isEqualTo(sum);
    }
}
