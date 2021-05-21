package mocking

import matchers.UnitSpec
import com.h2.services.Currency

class FunctionMockTest extends UnitSpec {

    behavior of "Currency's MOcking"

    it should "be able to mock a higher-order function for any input argument and anyNumberOfTime" in {
        val currency: List[Currency] = List("100 USD", "20 EUR", "1000 CAD", "1 USD")

        def getCurrency(criteria: Currency => Boolean): List[Currency] = currency.filter(criteria)

        def criteria: Currency => Boolean = (c: Currency) => c.code === "USD"

        getCurrency(criteria) should have size 2
    }
}