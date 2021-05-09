import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen

class HelloWorldFeatureSpec extends AnyFeatureSpec with GivenWhenThen {
    info("As a developer")
    info("I want to test Strings")
    Feature("A String") {
        Scenario("When a user provides 'Hello World' as input") {
            Then("The input must start with 'Hello'")
            assert("Hello World".startsWith("Hello"))
        }
    }
}