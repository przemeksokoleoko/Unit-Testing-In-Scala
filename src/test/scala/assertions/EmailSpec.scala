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
        assertThrows[IllegalArgumentException] {
            Email("foo.foo.com")
        }
    }

    it should "throw an exception when a string contains more than one '@' symbol" in {
        assertThrows[IllegalArgumentException] {
            Email("foo@foo@com")
        }
    }

    it should "intercept the correct error message when a string does not contain '@' symbol" in {
        val exception = intercept[IllegalArgumentException] {
            Email("foo.foo.com")
        }

        assert(exception.isInstanceOf[IllegalArgumentException])
        assert(exception.getMessage.contains("does not contain '@'"))
    }

        it should "intercept the correct error message when a string contains more than one '@' symbol" in {
        val exception = intercept[IllegalArgumentException] {
            Email("foo@foo@com")
        }

        assert(exception.isInstanceOf[IllegalArgumentException])
        assert(exception.getMessage.contains("should not contain '@'"))
    }

    ignore should "fail" in {
        fail()
    }
}
