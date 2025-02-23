package com.example.Splitwise.models;

import com.example.Splitwise.enums.SplitType;
import com.example.Splitwise.interfaces.ISplitStrategy;

public class SplitStrategyFactory {

    public static ISplitStrategy createStrategy(SplitType splitType) {
        switch (splitType) {
            case EQUAL: return new EqualSplitStrategy();
            case EXACT: return new ExactSplitStrategy();
            case PERCENTAGE: return new PercentageSplitStrategy();
            default: return new EqualSplitStrategy();
        }
    }
}
