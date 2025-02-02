package edu.ferris.seng355.stock;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Stock Test Suite")
@SelectClasses({StockValidatorTest.class})
public class StockTestSuite {
}
