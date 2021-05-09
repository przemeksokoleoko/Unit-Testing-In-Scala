package matchers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.h2.services.Currency

class EqualitySpec extends AnyFlatSpec with Matchers {

    behavior of "Currency Equals"
    it should "match two 10 USD currencies as equal when using 'should equal' syntax" in {
        val currency1: Currency = "10 USD"
        val currency2: Currency = "10 USD"

        currency1 should equal (currency2)
    }
}
