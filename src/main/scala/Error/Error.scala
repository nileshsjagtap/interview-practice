package Error

sealed trait Error

case object InvalidPlateauXCordinate extends Error
case object InvalidPlateauCordinate extends Error
case object InvalidXCordinate extends Error
case object InvalidYCordinate extends Error
case object InvalidOrientation extends Error
case object InvalidInstruction extends Error
case object EmptyInstruction extends Error


