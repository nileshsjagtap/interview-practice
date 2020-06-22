


object IntToBinary extends App {

  def toBinary(number: Int): String = {
    def iterate(reminder: Int, binary: String): String = reminder match {
      case 1 => binary.concat("1").reverse
      case _ => iterate(reminder/2, binary.concat((reminder%2).toString))
    }
    iterate(number, "")
  }

  println(toBinary(6))


}
