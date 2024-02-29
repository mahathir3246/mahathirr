package mahaRentalPackage

import java.time.LocalDateTime

case class Reservations(val tavara:Bikes,val vuokraaja:Renter,val kappale:Int,val alkamispv:LocalDateTime,val loppumispv:LocalDateTime):
  override def toString: String = s"${vuokraaja.name} has reserved a bike that"

