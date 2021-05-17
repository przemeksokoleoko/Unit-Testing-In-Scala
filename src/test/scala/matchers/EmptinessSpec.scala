package matchers

import com.h2.services.CustomerService
import com.h2.services.Currency

class EmptinessSpec extends UnitSpec {
    val customerService: CustomerService = new CustomerService {}

    behavior of "Customer for emptiness"

    it should "return empty for customer's last name" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.last should be (empty)
    }

    behavior of "Currencies inside wallet"

    it should "be empty when no currencies are added to wallet" in {
        val wallet: List[Currency] = List.empty

        wallet should be (empty)
    }
}
