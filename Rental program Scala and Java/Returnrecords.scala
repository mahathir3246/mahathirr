package mahaRentalPackage

case class Returnrecords(val item:Bikes,val lessor :Renter, val amount:Int):
  override def toString: String = s"Renter ${lessor.name} has returned $amount ${item.name}."
