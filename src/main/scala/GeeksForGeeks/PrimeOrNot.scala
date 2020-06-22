package GeeksForGeeks

object PrimeOrNot extends App {

  def isPrime(n: Long) =  {

    def iterate(x: Long, divisor: Int):Int = (x % divisor == 0) match {
      case true if(divisor == x) => 1
      case true if(divisor != x) => divisor
      case false => iterate(x, divisor+1)
    }

    iterate(n, 2)
  }

  println(isPrime(5))

}
