package Domain

import Error._

sealed trait Instruction

case object L extends Instruction

case object R extends Instruction

case object M extends Instruction


object Instruction {

  def apply(instructions: String) = isNonEmptyInstruction(instructions)

  private def isNonEmptyInstruction(instructions: String): Either[EmptyInstruction.type, List[Instruction]] = Either.cond(instructions.nonEmpty && instructions.forall(List('L', 'R', 'M').contains), instructions.map(mapInstruction).toList, EmptyInstruction)


  private def mapInstruction(instruction: Char): Instruction = instruction match {
    case 'L' => L
    case 'R' => R
    case 'M' => M
  }

  // func : String => ValidInstruction ==> ValidInstruction(List(L, M, N))
}


//trait Validation {
//  def validate[A]:Boolean
//}
//trait InstructionValidation extends Validation {
//  def validate[Instruction]:Boolean
//}
//case object NonEmptyInstructionValidation extends InstructionValidation {
//  def validate[Instruction](a:Instruction):Boolean = {
//    a.non
//  }
//}
//trait RoverValidation extends Validation {
//  def validate[Rover]:Boolean
//}
