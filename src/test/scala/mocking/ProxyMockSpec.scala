package mocking

import matchers.UnitSpec
import org.scalamock.scalatest.MockFactory
import com.h2.services.AccountService
import java.util.UUID
import com.h2.entities.Dollars
import tags.{Fast, Slow}

class ProxyMockSpec extends UnitSpec with MockFactory {
    
    behavior of "AccountService with mocks"

    it should "mock a Trait" taggedAs(Slow) in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID
        val productId = UUID.randomUUID
        val tenDollars = Dollars(10)

        (mocked.openDepositAccount _).expects(customerId, productId, tenDollars)

        mocked.openDepositAccount(customerId, productId, tenDollars)
    }

    it should "mock return value" taggedAs(Fast) in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID
        val productId = UUID.randomUUID
        val accountId = UUID.randomUUID
        val tenDollars = Dollars(10)

        (mocked.openDepositAccount _).expects(customerId, productId, tenDollars) returning accountId

        mocked.openDepositAccount(customerId, productId, tenDollars) should be (accountId)
    }

    it should "throw an exception" in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID
        val productId = UUID.randomUUID
        val tenDollars = Dollars(10)

        (mocked.openDepositAccount _).expects(customerId, productId, tenDollars) throwing new IllegalArgumentException

        an [IllegalArgumentException] should be thrownBy mocked.openDepositAccount(customerId, productId, tenDollars)
    }

    it should "match wildcard pattern" in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID

        (mocked.openDepositAccount _).expects(customerId, *, *)

        mocked.openDepositAccount(customerId, UUID.randomUUID(), Dollars(100))
    }

    it should "count number of times" in {
        val mocked = mock[AccountService]

        val customerId = UUID.randomUUID

        (mocked.openDepositAccount _).expects(customerId, *, *).atLeastTwice()

        mocked.openDepositAccount(customerId, UUID.randomUUID(), Dollars(100))
        mocked.openDepositAccount(customerId, UUID.randomUUID(), Dollars(100))
    }
}
