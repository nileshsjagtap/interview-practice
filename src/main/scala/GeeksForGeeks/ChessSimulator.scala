package GeeksForGeeks

object ChessSimulator extends App{

  def upWard(cell : Cell) = cell.copy(y = cell.y + 1)

  def downWard(cell : Cell) = cell.copy(y = cell.y - 1)

  def right(cell : Cell) = cell.copy(x = (cell.x + 1).toChar)

  def left(cell : Cell) = cell.copy(x = (cell.x - 1).toChar)


  def moveUpward(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = upWard(cell) match {
    case d if(chessBoard.contains(d)) => moveUpward(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveDownward(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = downWard(cell) match {
    case d if(chessBoard.contains(d)) => moveDownward(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveRight(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = right(cell) match {
    case d if(chessBoard.contains(d)) => moveRight(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveLeft(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = left(cell) match {
    case d if(chessBoard.contains(d)) => moveLeft(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveUpwardDiagonalRight(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = right(upWard(cell)) match {
    case d if(chessBoard.contains(d)) => moveUpwardDiagonalRight(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveUpwardDiagonalLeft(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = left(upWard(cell)) match {
    case d if(chessBoard.contains(d)) => moveUpwardDiagonalLeft(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveDownWardDiagonalRight(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = right(downWard(cell)) match {
    case d if(chessBoard.contains(d)) => moveDownWardDiagonalRight(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }

  def moveDownWardDiagonalLeft(cell: Cell, chessBoard: List[Cell], cellList: List[Cell] = Nil): List[Cell] = left(downWard(cell)) match {
    case d if(chessBoard.contains(d)) => moveDownWardDiagonalLeft(d, chessBoard, cellList.:+(d))
    case _ => cellList
  }


  def createChessBoard(n : Int) ={
    val alphabetSeq = (1 to n).map(x => (64+x).toChar)
    val numericSeq = (1 to n)
    for{
      r <- alphabetSeq
      c <- numericSeq
    }yield Cell(r,c)
  }

  println(createChessBoard(8))
  println(moveUpward(Cell('A', 5), createChessBoard(8).toList) ::: moveDownward(Cell('A', 5), createChessBoard(8).toList) ::: moveRight(Cell('A', 5), createChessBoard(8).toList) ::: moveLeft(Cell('A', 5), createChessBoard(8).toList))
  println(moveDownWardDiagonalLeft(Cell('C', 5), createChessBoard(8).toList))


}


trait Steps

case object Single extends Steps
case object Multiple extends Steps


case class Cell(x: Char, y: Int)