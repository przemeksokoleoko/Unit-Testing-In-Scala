import org.scalatest.funsuite.AnyFunSuite

class HelloWorldFunSuiteSpec extends AnyFunSuite {
    test("A String 'Hello World' should start with 'Hello'") {
        assert("Hello World".startsWith("Hello"))
    }

    test("A String 'Hello World' should end with 'World'") {
        assert("Hello World".endsWith("World"))
    }
}