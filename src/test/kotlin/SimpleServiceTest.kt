import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class SimpleServiceTest : DescribeSpec() {

  private val simpleDataClassProducer = mockk<SimpleDataClassProducer>(relaxed = true)
  private val simpleService = SimpleService(simpleDataClassProducer = simpleDataClassProducer)

  init {
    describe("stuff") {
      it("should return -1 for missing a - relaxed mode") {
        val result = simpleService.stuff()

        result shouldBe -1
      }

      it("should return -1 for missing a - without relaxed mode") {
        every { simpleDataClassProducer.produce() } returns SimpleDataClass(a = null)
        val result = simpleService.stuff()

        result shouldBe -1
      }

      it("should return 1") {
        every { simpleDataClassProducer.produce() } returns SimpleDataClass(a = 2)
        val result = simpleService.stuff()

        result shouldBe 1
      }
    }
  }
}
