package fixtures

import matchers.UnitSpec
import com.h2.services.{CustomerService, ProductService}
import com.h2.entities.{Customer, Deposits, Dollars}
import java.util.UUID

class ScalaFixtureContextSpec extends UnitSpec {
    trait ACustomer {
        private val service: CustomerService = new CustomerService {}
        private val customerId: UUID = service.createNewCustomer("John", "Smith", "john@smith.com", "2000/01/01")
        val customer: Customer = service.getCustomer(customerId).get
    }

    trait AProduct {
        private val service: ProductService = new ProductService {}
        private val productId: UUID = service.addNewDepositProduct("CoreChecking", 2000, 0.02, 10)
        val product: Deposits = service.getDepositProduct(productId).get
    }

    trait ADollars {
        val fiveThousandDollars = Dollars(5000)
    }

    behavior of "ACustomer"
    it should "return a customer with non-empty emial address" in new ACustomer {
        customer.email.toString should not be empty
    }

    behavior of "AProduct"
    it should "return a valid product with more 1000 dollars minimum balance requirement" in new AProduct {
        product.minimumBalancePerMonth.amount should be >(1000)
    }

    behavior of "A Product with some Money"
    it should "return true for 5000 dollars be grater than the product minimum balance requirement" in new ADollars with AProduct {
        fiveThousandDollars should be > product.minimumBalancePerMonth
    }
}