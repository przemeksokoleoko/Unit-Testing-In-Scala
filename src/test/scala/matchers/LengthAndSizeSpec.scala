package matchers

import com.h2.services.CustomerService
import java.util.UUID

class LengthAndSizeSpec extends UnitSpec {
    val customerService: CustomerService = new CustomerService {}

    behavior of "CustomerService for length"

    it should "return correct lenght for customer's first and last name" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "Smith", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.first should have length firstName.length
        customer.last should have length lastName.length
    }

    behavior of "CustomerService for size"
    it should "return correct size for number of customers created" in {
        val newCustomers: Seq[(String, String, String, String)] = List(
            ("John", "Smith", "john@smith.com", "2000/01/01"),
            ("Adam", "Smith", "adam@smith.com", "1999/01/01")
        )

        val customerIds: Seq[UUID] = newCustomers.map(newCustomer =>
            customerService.createNewCustomer(newCustomer._1, newCustomer._2, newCustomer._3, newCustomer._4)
        )

        customerIds should have size 2
    }
}
