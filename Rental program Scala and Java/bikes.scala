package mahaRentalPackage
import javafx.scene.image.Image

abstract class Bikes(val name:String,val ownprice:Int,val comment:String):
  def rentalPrice(tunnit:Int):Int
  var addcomment:String
  var kuva:Image

  override def toString: String = name



case class mountainBike(override val name:String, val wheelSize:Int,val gears:Int, override val comment:String, override  val ownprice:Int) extends Bikes(name:String,ownprice:Int,comment:String):
  def rentalPrice(tunnit:Int):Int = if tunnit<24 then tunnit*5 else if tunnit>=24 && tunnit<168 then tunnit*1 else if tunnit>=168 && tunnit<=720 then (tunnit*0.62).toInt else (tunnit*0.41).toInt
  //tuntihinta=5 euro ja päivähinta 24 euro ja viikko hinta 104 euro ja kuukausihinta on 295 euro

  var addcomment: String = ""
  var kuva:Image=Image("https://as2.ftcdn.net/v2/jpg/00/89/07/63/1000_F_89076312_sbxXwcGITdbVARuWd4PNsyMVvtBazKYi.jpg")

  override def toString: String = s"${name},${wheelSize},${gears},${comment},${ownprice}"

case class cityBike(override val name:String, val gearNumbers:Int, val frameMaterial: String,override val ownprice:Int, override val comment:String) extends Bikes(name:String, ownprice:Int,comment:String):
  def rentalPrice(tunnit:Int) = if tunnit<24 then tunnit*3 else if tunnit>=24 && tunnit<168 then (tunnit*0.83).toInt else if tunnit>=168 && tunnit<=720 then (tunnit*0.51).toInt else (tunnit*0.28).toInt
  // tuntihinta 3 euro ja päivä hinta 19 euro ja viikko hinta on 89 euro kuukausihinta on 201 euro
  override def toString: String = s"${name},${gearNumbers},${frameMaterial},${ownprice},${comment}"
  var addcomment: String = ""
  var kuva:Image=Image("https://as2.ftcdn.net/v2/jpg/00/89/07/63/1000_F_89076312_sbxXwcGITdbVARuWd4PNsyMVvtBazKYi.jpg")

case class motorCycles(override val name:String, val engineSizecubiCentimeters:Int, val horsepower:Int,val brand:String,override val ownprice:Int,override val comment:String) extends Bikes(name:String, ownprice:Int,comment:String):
  def rentalPrice(tunnit:Int) = if tunnit<24 then tunnit*20 else if tunnit>=24 && tunnit<168 then (tunnit*4.16).toInt else if tunnit>=168 && tunnit<=720 then (tunnit*2.97).toInt else (tunnit*2.08).toInt
  // tuntihinta 20 euro ja päivä hinta 100 euro ja viikko hinta on 498 euro kuukausihinta on 1497 euro
  var kuva:Image=Image("https://as2.ftcdn.net/v2/jpg/00/89/07/63/1000_F_89076312_sbxXwcGITdbVARuWd4PNsyMVvtBazKYi.jpg")
  override def toString: String = s"${name},${engineSizecubiCentimeters},${horsepower},${brand},${ownprice},${comment}"
  var addcomment: String = ""
case class scooter(override val name:String, override val ownprice:Int,val brand:String,override val comment:String) extends Bikes(name:String, ownprice:Int, comment:String):
  def rentalPrice(tunnit:Int)= if tunnit<24 then tunnit*15 else if tunnit>=24 && tunnit<168 then (tunnit*2.5).toInt else if tunnit>=168 && tunnit<=720 then (tunnit*1.24).toInt else (tunnit*1.3).toInt
  // tuntihinta 15 euro ja päivä hinta 60 euro ja viikko hinta on 235 euro kuukausihinta on 936 euro
  override def toString: String = s"${name},${ownprice},${brand},${comment}"
  var addcomment: String = ""
  var kuva:Image=Image("https://as2.ftcdn.net/v2/jpg/00/89/07/63/1000_F_89076312_sbxXwcGITdbVARuWd4PNsyMVvtBazKYi.jpg")

case class electricBikes(override val name:String,val batteryRangeinKM:Int,val chargingTime:Int,override val ownprice:Int,override val comment:String) extends Bikes(name:String, ownprice:Int,comment:String):
  def rentalPrice(tunnit:Int)=if tunnit<24 then tunnit*10 else if tunnit>=24 && tunnit<168 then (tunnit*2.08).toInt else if tunnit>=168 && tunnit<=720 then (tunnit*0.28).toInt else (tunnit*0.83).toInt
  // tuntihinta 10 euro ja päivä hinta 49 euro ja viikko hinta on 201 euro kuukausihinta on 597 euro

  override def toString: String = s"${name},${batteryRangeinKM},${chargingTime},${ownprice},${comment}"
  var addcomment: String = ""
  var kuva:Image=Image("https://as2.ftcdn.net/v2/jpg/00/89/07/63/1000_F_89076312_sbxXwcGITdbVARuWd4PNsyMVvtBazKYi.jpg")

