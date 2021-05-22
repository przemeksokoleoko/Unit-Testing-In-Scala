package fixtures

import org.scalatest.BeforeAndAfterAll
import matchers.UnitSpec
import com.h2.entities.Customer
import com.h2.services.CustomerService

class BeforeAndAfterAllSpec extends UnitSpec with BeforeAndAfterAll {
    var customers: List[Customer] = List.empty

    override protected def beforeAll(): Unit = {
        val service: CustomerService = new CustomerService {}
        val johnId = service.createNewCustomer("John", "Smith", "john@smith.com", "2000/01/01")
        val amyId = service.createNewCustomer("Amy", "Smith", "amy@smith.com", "2001/02/02")
        
        customers = List(johnId, amyId).map(id => service.getCustomer(id).get)
    }

    override protected def afterAll(): Unit = {
        customers = List.empty
    }

    it should "report 2 existing customers available" in {
        customers should have size 2
    }

    it should "correctly match that all customer have email from 'smith'" in {
        customers.map { customer =>
            customer.email.toString should include("smith")
        }
    }
}
