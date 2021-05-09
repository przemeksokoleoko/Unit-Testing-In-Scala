package assertions

import org.scalatest.flatspec.AnyFlatSpec
import com.h2.entities.Email

class EmailSpec extends AnyFlatSpec {
    behavior of "An Email"

    it should "return an Email object for a valid string" in {
        val email = Email("foo@foo.com")

        assert("foo" === email.localPart)
        assert("foo.com" === email.domain)
    }
    
    it should "return another Emial object for another valid String" in {
        assertResult("foo_foo") {
            Email("foo_foo@foo.com").localPart
        }
    }

    it should "throw an exception when a string does not contain '@' symbol" in {
        assertThrows[Exception] {
            Email("foo.foo.com")
        }
    }
}
