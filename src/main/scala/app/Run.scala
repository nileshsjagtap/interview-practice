package app

import Domain.{Instruction, Plateau, Position, Rover}

object Run extends App{


  val rover = for {
    plateau <- Plateau(5,5)
    position <- Position(1,2,"N", plateau)
    instruction <- Instruction("LMLMLMLMM")
    rover <- Rover(position, instruction)
    updatedRover <- Rover.move(rover)
  } yield updatedRover

  rover.fold(y => println(y), x => println(x))



}
