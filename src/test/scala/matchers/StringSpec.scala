package matchers

import com.h2.services.CustomerService
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class StringSpecextends extends AnyFlatSpec with Matchers {
    val customerService: CustomerService = new CustomerService {}

    behavior of "Customer Service for Strings"

    it should "correctly match the customer email string with first name" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "Smith", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.email.toString should startWith(firstName.toLowerCase) 
    }

    it should "correctly match the customer email ending with ''.com'" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "Smith", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.email.toString should endWith(".com") 
    }

    it should "correctly match the customer email including '@'" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "Smith", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.email.toString should include("@") 
    }

    it should "correctly match the customer email as regular expression" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "Smith", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.email.toString should include regex "[a-z]+[@.]com"
    }

    it should "correctly match the customer dataOfBirth as fullyMatch regular expression" in {
        val (firstName, lastName, email, dataOfBirth) = ("John", "Smith", "john@smith.com", "2000/01/01")

        val customerId = customerService.createNewCustomer(firstName, lastName, email, dataOfBirth)
        val customer = customerService.getCustomer(customerId).get

        customer.dateOfBirth.toString should fullyMatch regex """[0-9]{4}-[0-9]{2}-[0-9]{2}"""
    }
}
