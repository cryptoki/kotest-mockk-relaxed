class SimpleService constructor(val simpleDataClassProducer: SimpleDataClassProducer) {

  fun stuff(): Int {
    val response = simpleDataClassProducer.produce()
    return response.a?.let { a ->
      println("yeah not null $a")
      1
    } ?: run {
      -1
    }
  }
}


