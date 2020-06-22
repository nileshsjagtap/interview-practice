package Domain

import Error._

sealed trait Direction

case object E extends Direction

case object W extends Direction

case object N extends Direction

case object S extends Direction

object Direction {

  def getDirection = List(E, W, N, S)

  def validateDirection(orientation: String) = orientation match {
    case "E" => Right(E)
    case "W" => Right(W)
    case "N" => Right(N)
    case "S" => Right(S)
    case _ => Left(InvalidOrientation)
  }

}
