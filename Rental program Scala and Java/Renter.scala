package mahaRentalPackage
import scala.collection.mutable.{Buffer, Map}
import java.time.*

case class Renter (val name:String,val contact:Int):
  val managaerii= new Manager
  def renteditems=
    val pyorat= Map[Bikes,Int]()
    for pyora <- pyorat do
      if pyorat.get(pyora._1).get< 0 then pyorat.remove(pyora._1)
    pyorat

  var comment=""
  

  def reserveditems=
    val pyoria= Map[Bikes,Int]()
    for pyora <- pyoria do
      if pyoria.get(pyora._1).get< 0 then pyoria.remove(pyora._1)
    pyoria


  override def toString: String = s"$name, $contact"

