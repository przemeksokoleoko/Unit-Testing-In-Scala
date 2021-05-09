package assertions

import org.scalatest.flatspec.AnyFlatSpec
import com.h2.entities.Dollars

class DollarsSpec extends AnyFlatSpec {
  
    behavior of "A Dollar"

    it should "create a correct Dollar object for number 10 as input" in {
        val tenDollars = Dollars(10)

        assert("$10" === tenDollars.toString)
    }

    it should "correctly identify that $10 > $5" in {
        val tenDollars = Dollars(10)
        val fiveDollars = Dollars(5)

        assert(tenDollars > fiveDollars)
    }

    it should "correctly identify that $2 < $10" in {
        val tenDollars = Dollars(10)
        val twoDollars = Dollars(2)

        assert(twoDollars < tenDollars)
    }

    it should "correctly add two Dollars amount" in {
        val tenDollars = Dollars(10)
        val twoDollars = Dollars(2)

        assertResult("$12") {
            (tenDollars + twoDollars).toString
        }
    }

    it should "correctly subtract two Dollars amount" in {
        val tenDollars = Dollars(10)
        val twoDollars = Dollars(2)

        assertResult("$8") {
            (tenDollars - twoDollars).toString
        }
    }

    it should "correctly identify that $4 == $4" in {
        val fourDollars = Dollars(4)

        assertResult(true) {
            fourDollars === fourDollars
        }
    }

    it should "throw an exception when an invalid integer is provided to create Dollars" in {
        assertThrows[ArithmeticException] {
            Dollars(10 / 0)
        }
    }

    it should "have every dollar more than 0 for non empty list" in {
        val dollars : List[Dollars] = List(Dollars(1), Dollars(20), Dollars(100))

        dollars.foreach{dollar =>
            assert(dollar.amount > 0)
        }
    }

    it should "have every dollar more than 0 for empty (test cancelled)" in {
        val dollars : List[Dollars] = List.empty

        assume(dollars.nonEmpty)

        dollars.foreach{dollar =>
            assert(dollar.amount > 0)
        }
    }
}
