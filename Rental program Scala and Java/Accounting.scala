package mahaRentalPackage
import java.time.*

import scala.collection.mutable.*

class Accounting(val vuokraaja:Renter, val tavarat:Bikes, val kappale:Int, val alkupv:LocalDateTime, val loppupv:LocalDateTime, var rentalcost:Int):
  override def toString: String = "A rental between Maha rental company and "+vuokraaja.name+ " has been completed succefully.\n"+vuokraaja.name+ " rented "+kappale + tavarat.name+" starting from "+alkupv+" to "+loppupv+" which cost "+rentalcost+"."
  val manageri=new Manager
  def incomefromabike(itemi:Bikes)=
    val samapyora=manageri.kirjanPito.filter(_.tavarat.equals(itemi))
    var income=0
    for pyora <-samapyora do
      income+=pyora.rentalcost
    income

  def mostrentedItemsinorder=
    var mostrented= Map[Bikes,Int]()
    def addNewBike (pyora: Bikes, kappale:Int):Unit=
      if mostrented.contains(pyora) then mostrented.put(pyora,mostrented.get(pyora).get + kappale) else mostrented+= pyora -> kappale
    for transaction <- manageri.kirjanPito do
      addNewBike(transaction.tavarat,transaction.kappale)
    val sorted = mostrented.toSeq.sortBy((k, v) => v).reverse
    sorted.toMap


  def mostsellingItemsinorder=
    var mostselling= Map[Bikes,Int]()
    def addNewBike (pyora: Bikes, kappale:Int):Unit=
      if mostselling.contains(pyora) then mostselling.put(pyora,mostselling.get(pyora).get + kappale) else mostselling+= pyora -> kappale
    for transaction <- manageri.kirjanPito do
      addNewBike(transaction.tavarat,transaction.rentalcost)
    val sorted = mostselling.toSeq.sortBy((k, v) => v).reverse
    sorted.toMap


  def expensesforaAbike(pyora:Bikes)=
    val samapyora=manageri.kirjanPito.filter(_.tavarat.equals(pyora))
    var income=0
    for bike <- samapyora do
      income+=bike.tavarat.ownprice*bike.kappale
    for i <- manageri.bikesinGarage do
      income+=i._1.ownprice*i._2
    income










  