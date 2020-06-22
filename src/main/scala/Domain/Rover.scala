package Domain

case class Rover(position: Position, instruction: List[Instruction])

object Rover{

  def apply(position: Position, instruction: List[Instruction]) = {
    Right(new Rover(position, instruction))
  }

  def move(rover: Rover) = {
      val updatedPosition = rover.instruction.foldLeft(rover.position)((acc, validInstruction) => {
        (validInstruction, acc.orientation) match {

          case (L, E) => acc.copy(orientation = N)
          case (L, W) => acc.copy(orientation = S)
          case (L, N) => acc.copy(orientation = W)
          case (L, S) => acc.copy(orientation = E)

          case (R, E) => acc.copy(orientation = S)
          case (R, W) => acc.copy(orientation = N)
          case (R, N) => acc.copy(orientation = E)
          case (R, S) => acc.copy(orientation = W)

          case (M, E) => acc.copy(xCordinate = acc.xCordinate +1)
          case (M, W) => acc.copy(xCordinate = acc.xCordinate -1)
          case (M, N) => acc.copy(yCordinate = acc.yCordinate +1)
          case (M, S) => acc.copy(yCordinate = acc.yCordinate -1)

        }
      })
      Right(rover.copy(position = updatedPosition))
  }

}
