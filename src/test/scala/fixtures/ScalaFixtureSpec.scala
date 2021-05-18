package fixtures

import com.h2.services.Currency
import matchers.UnitSpec
import com.h2.entities.Dollars

class ScalaFixtureSpec extends UnitSpec {
    behavior of "Currency Equals"

    it should "match two 10 USD currencies as equal when using 'should equal' syntax" in {
        val currency1: Currency = "10 USD"
        val currency2: Currency = "10 USD"

        currency1 should equal(currency2)
    }

    it should "match two 10 USD currencies as equal when using 'should ===' syntax" in {
        val currency1: Currency = "10 USD"
        val currency2: Currency = "10 USD"

        currency1 should ===(currency2)
    }

    it should "add two 10 USD together" in {
        val currency1: Currency = "10 USD"
        val currency2: Currency = "10 USD"

        (currency1.costInDollars + currency2.costInDollars) should be >= Dollars(20)
    }
}
