package Domain

import Error._

case class Position(xCordinate: Int, yCordinate: Int, orientation: Direction)

object Position {

  def apply(xCordinate: Int, yCordinate: Int, orientation: String, plateau: Plateau): Either[Error, Position] = {
    for{
      validXCordinate <- validateXCordinate(xCordinate, plateau)
      validYCordinate <- validateYCordinate(yCordinate, plateau)
      validOrientation <- validateOrientation(orientation)
    } yield Position(validXCordinate, validYCordinate, validOrientation)
  }

  private def validateXCordinate= (xCordinate: Int, plateau: Plateau) => Either.cond(xCordinate < plateau.upperXCordinate, xCordinate, InvalidXCordinate)

  private def validateYCordinate= (yCordinate: Int, plateau: Plateau) => Either.cond(yCordinate < plateau.upperYCordinate, yCordinate, InvalidYCordinate)

  private def validateOrientation= (orientation: String) => Direction.validateDirection(orientation)


}
