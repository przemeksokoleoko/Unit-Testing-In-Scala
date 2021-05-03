import org.scalatest.funspec.AnyFunSpec

class HelloWorldFunSpec extends AnyFunSpec {
    describe("A 'Hello World' String") {
        it ("should start with 'Hello'") {
            assert("Hello World".startsWith("Hello"))
        }
    }

    describe("A 'Hello World' String") {
        it ("should end with 'World'") {
            assert("Hello World".endsWith("World"))
        }
    }
}