package mocking

import matchers.UnitSpec
import com.h2.services.Currency
import org.scalamock.scalatest.MockFactory
import tags.Fast

class FunctionMockTest extends UnitSpec with MockFactory {

    behavior of "Currency's Mocking"

    it should "be able to mock a higher-order function for any input argument and anyNumberOfTime" taggedAs(Fast) in {
        val currency: List[Currency] = List("100 USD", "20 EUR", "1000 CAD", "1 USD")

        def getCurrency(criteria: Currency => Boolean): List[Currency] = currency.filter(criteria)

        val mocked = mockFunction[Currency, Boolean]

        mocked.expects(*).anyNumberOfTimes()

        getCurrency(mocked)
    }
}