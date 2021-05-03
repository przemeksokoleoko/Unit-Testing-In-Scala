import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen

class HelloWorldFeatureSpec extends AnyFeatureSpec with GivenWhenThen {
    info("As a developer")
    info("I want to test Strings")
    Feature("A String") {
        Scenario("When a user A provides 'Hello World' as input") {
            Then("The input must start with 'Hello'")
            assert("Hello World".startsWith("Hello"))
        }

        Scenario("When a user B provides 'Hello World' as input") {
            Then("The input must end with 'World'")
            assert("Hello World".endsWith("World"))
        }
    }
}