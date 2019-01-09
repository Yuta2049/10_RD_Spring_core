package org.shop.annotation;

import org.springframework.stereotype.Component;

@Component
public class InjectRandomIntTestClass {

    @InjectRandomInt
    private int intDefault;

    @InjectRandomInt(min = 20, max = 30)
    private int int20_30;

    @Override
    public String toString() {
        return "InjectRandomIntTestClass{" +
                "intDefault=" + intDefault +
                ", int20_30=" + int20_30 +
                '}';
    }
}
