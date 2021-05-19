package mocking

import org.scalamock.scalatest.MockFactory
import org.scalatest.funsuite.AnyFunSuite

class SimpleTest extends AnyFunSuite with MockFactory {
  test("sayHello") {
    val mockFormatter = mock[Greetings.Formatter]

    (mockFormatter.format _).expects("Mr Bond").returning("Ah, Mr Bond. I've been expecting you").once()

    Greetings.sayHello("Mr Bond", mockFormatter)
  }
}

