package Domain

import Error._

case class Plateau(upperXCordinate: Int, upperYCordinate: Int)

object Plateau {

  def apply(upperXCordinate: Int, upperYCordinate: Int): Either[Error, Plateau] = {
    for {
      validUpperXCordinate <- validateUpperXCordinate(upperXCordinate)
      validUpperYCordinate <- validateUpperYCordinate(upperYCordinate)
    } yield new Plateau(validUpperXCordinate, validUpperYCordinate)
  }

  private def validateUpperXCordinate = (upperXCordinate: Int) => Either.cond(upperXCordinate > 0, upperXCordinate, InvalidPlateauXCordinate)

  private def validateUpperYCordinate = (upperYCordinate: Int) => Either.cond(upperYCordinate > 0, upperYCordinate, InvalidPlateauCordinate)

}