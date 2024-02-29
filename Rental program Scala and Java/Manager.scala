package mahaRentalPackage
import javafx.scene.control.DatePicker

import java.io.{File, PrintWriter}
import scala.collection.mutable.*
import java.time.*
import scala.collection.mutable
import scala.io.Source
import java.io.*


class Manager:

 //kaikki bikes mitä on olemassa

  val bikesrecord : Map[Bikes,Int] =Map[Bikes,Int]()

  val bikesinGarage : Map[Bikes,Int]=
    Map[Bikes,Int]()



 // renter ja niide vuokratut tavara ja kuinka monta kappale
  val rentersandrenteditems=
    Map[Renter,Map[Bikes,Int]]()

  val reserversandreserveditems =
    Map[Renter,Map[Bikes,Int]]()

 // pitää kirjaa vuokrauksista
  val kirjanPito=Buffer[Accounting]()

  val reservations = Buffer[Reservations]()

  val returnrecord= Buffer[Returnrecords]()
  //lisää pyörän bikesingragein
  def addNewBike (pyora: Bikes, kappale:Int):Unit=
   if bikesinGarage.contains(pyora) then
     bikesinGarage.put(pyora,bikesinGarage.get(pyora).get + kappale)
   else
     bikesinGarage+= pyora -> kappale

  def addnewtobikrecords(pyora: Bikes, kappale:Int):Unit=
   if bikesrecord.contains(pyora) then
     bikesrecord.put(pyora,bikesrecord.get(pyora).get + kappale)
   else
     bikesrecord +=pyora-> kappale

  //poista pyora bikesingarageista
  def deleteBike(pyora:Bikes,kappale:Int):Unit=
   if bikesinGarage.contains(pyora) && kappale<bikesinGarage.get(pyora).get then bikesinGarage.put(pyora,bikesinGarage.get(pyora).get - kappale)
   else 
    if bikesinGarage.contains(pyora) && (bikesinGarage.get(pyora).get-kappale)<=0 then bikesinGarage.remove(pyora)

  //vuokraus tapahtuu
  def rent(tavara:Bikes,kelleVuokraan:Renter, kappale:Int,vuokrauksenalkupv:LocalDateTime, vuokrauksenloppupv:LocalDateTime)=
    require(bikesinGarage.contains(tavara))
    // tapahtuu vuokraus vuokranantaajan ja vuokraajan välillä
    val aikavali=Duration.between(vuokrauksenalkupv,vuokrauksenloppupv).toHours.toInt // muuttaa päivät tunniksi
    val hinta= tavara.rentalPrice(kappale*aikavali) // laskee vuokraushinanan
    kirjanPito += Accounting(kelleVuokraan,tavara,kappale,vuokrauksenalkupv,vuokrauksenloppupv,hinta) //lisää kirjanpitoon tämän vuokraustiedon
    deleteBike(tavara,kappale) // poista tavaran bikesiGaragesta
    if kelleVuokraan.renteditems.contains(tavara) then kelleVuokraan.renteditems.put(tavara,kelleVuokraan.renteditems.get(tavara).get + kappale) else kelleVuokraan.renteditems+=tavara ->kappale
      //jos vuokraaajal on jo tämä pyörä vuokrattu nii lisää vain sen määrän mutta jos ei ole vuokrattu niin lisää sen vuokraajan vuokrattuun tavaroihin
    if !(rentersandrenteditems.contains(kelleVuokraan))   //jos rentersandrenteditems ei containaa vuokraaja eli ei myöskää tavara
    then rentersandrenteditems+=kelleVuokraan->Map(tavara->kappale) // lisää vuokraajan ja sen vuokratun tavaran ja kuinka monta kappaletta
    else
      if rentersandrenteditems.get(kelleVuokraan).get.keys.toBuffer.contains(tavara) // jos vuokraaja on listal ja sil on  samanlainen tavara
      then
        val rentersrenteditemsinMapBikesInt=rentersandrenteditems.get(kelleVuokraan).get //Map[Bikes,Int]
        rentersrenteditemsinMapBikesInt.put(tavara,rentersrenteditemsinMapBikesInt.get(tavara).get +kappale) // niin lisää vaa sen tavarn määräm
      else rentersandrenteditems.get(kelleVuokraan).get+=tavara -> kappale //jos vuokraaja on listal ja sil ei oo tavara nii lisää sen tavarn siihen
    Accounting(kelleVuokraan,tavara,kappale,vuokrauksenalkupv,vuokrauksenloppupv,hinta)


  def rentforfile(tavara:Bikes,kelleVuokraan:Renter, kappale:Int,vuokrauksenalkupv:LocalDateTime, vuokrauksenloppupv:LocalDateTime)=
    require(bikesrecord.contains(tavara))
    // tapahtuu vuokraus vuokranantaajan ja vuokraajan välillä
    val aikavali=Duration.between(vuokrauksenalkupv,vuokrauksenloppupv).toHours.toInt // muuttaa päivät tunniksi
    val hinta= tavara.rentalPrice(kappale*aikavali) // laskee vuokraushinanan
    kirjanPito += Accounting(kelleVuokraan,tavara,kappale,vuokrauksenalkupv,vuokrauksenloppupv,hinta) //lisää kirjanpitoon tämän vuokraustiedon
    deleteBike(tavara,kappale) // poista tavaran bikesiGaragesta
    if kelleVuokraan.renteditems.contains(tavara) then kelleVuokraan.renteditems.put(tavara,kelleVuokraan.renteditems.get(tavara).get + kappale) else kelleVuokraan.renteditems+=tavara ->kappale
      //jos vuokraaajal on jo tämä pyörä vuokrattu nii lisää vain sen määrän mutta jos ei ole vuokrattu niin lisää sen vuokraajan vuokrattuun tavaroihin
    if !(rentersandrenteditems.contains(kelleVuokraan))   //jos rentersandrenteditems ei containaa vuokraaja eli ei myöskää tavara
    then rentersandrenteditems+=kelleVuokraan->Map(tavara->kappale) // lisää vuokraajan ja sen vuokratun tavaran ja kuinka monta kappaletta
    else
      if rentersandrenteditems.get(kelleVuokraan).get.keys.toBuffer.contains(tavara) // jos vuokraaja on listal ja sil on  samanlainen tavara
      then
        val rentersrenteditemsinMapBikesInt=rentersandrenteditems.get(kelleVuokraan).get //Map[Bikes,Int]
        rentersrenteditemsinMapBikesInt.put(tavara,rentersrenteditemsinMapBikesInt.get(tavara).get +kappale) // niin lisää vaa sen tavarn määräm
      else rentersandrenteditems.get(kelleVuokraan).get+=tavara -> kappale //jos vuokraaja on listal ja sil ei oo tavara nii lisää sen tavarn siihen
    Accounting(kelleVuokraan,tavara,kappale,vuokrauksenalkupv,vuokrauksenloppupv,hinta)

  def returned (tavara:Bikes,vuokraaja :Renter, kpl:Int)=
    //vuokraaja palauttaa tavaran
    var vuokrattumaara=0
    val returnaaja= kirjanPito.filter( a => a.vuokraaja.equals(vuokraaja) && a.tavarat.equals(tavara))
    for alkio <- returnaaja do
      vuokrattumaara+=alkio.kappale
    val returnaajapart2=returnrecord.filter(a=>a.lessor.equals(vuokraaja) && a.item.equals(tavara))
    for i <- returnaajapart2 do
      vuokrattumaara-=i.amount
    if kpl <= vuokrattumaara then addNewBike(tavara,kpl) else addNewBike(tavara,vuokrattumaara) //tavara lisääntyy takasin varastoon
    if vuokraaja.renteditems.contains(tavara) then vuokraaja.renteditems.put(tavara,vuokraaja.renteditems.get(tavara).get - kpl) // poistaa vuokraajan vuokratusta tavaroista tavarann
    val rentersrenteditemsinMapBikesInt=rentersandrenteditems.get(vuokraaja).get //Map[Bikes,Int]
    rentersrenteditemsinMapBikesInt.put(tavara,rentersrenteditemsinMapBikesInt.get(tavara).get -kpl)//vähentää tavaran määrä
    for alkio <- rentersandrenteditems do
      if alkio._2.size==1 && alkio._2.head._2 <= 0 then rentersandrenteditems.remove(alkio._1)
      else
       for mappi <- alkio._2 do
        if mappi._2<=0 then alkio._2.remove(mappi._1)
    returnrecord+=Returnrecords(tavara,vuokraaja,kpl)


  def getbike(pyo:Bikes) =
    val sebike=bikesinGarage.keys.filter(a=>a==pyo)
    sebike.head

  def reservattu(pyora:Bikes)=
    var reservattu=0
    for i <- reserversandreserveditems do
      if i._2.contains(pyora) then reservattu+=i._2.get(pyora).get



  def checkInfo(pyora:Bikes)=
    require(bikesinGarage.contains(pyora))
    pyora match
      case a:cityBike =>
        var vuokrattupyoramaara=0
        val samapyora=kirjanPito.filter(a=>a.tavarat.equals(pyora))
        for bike<- samapyora do
         vuokrattupyoramaara+=bike.kappale
        var palautettumaara=0
        val pyorat=returnrecord.filter(a=>a.item.equals(pyora))
        for bike<- pyorat do
         palautettumaara += bike.amount
        s"It is a citybike and the name of the bike is ${a.name}. It has ${a.gearNumbers} gears and the material of the frame is ${a.frameMaterial}. It cost you ${a.ownprice}.\nThe hourly rental price for this bike is ${a.rentalPrice(1)} and daily rental price is ${a.rentalPrice(24)} and monthlly rental price is ${a.rentalPrice(24*30)}Other info about this bike: ${a.comment} and the added comment: ${getbike(pyora).addcomment}.\n Currently there are ${bikesinGarage.get(a).get} bikes available in the store. ${vuokrattupyoramaara-palautettumaara} is now rented to customers and ${reservattu(pyora)} is reserved for different customers.\nYou can get more information by clicking 'rentersandrentedinfo' or 'view renter's info'. "
      case b:electricBikes =>
        var vuokrattupyoramaara=0
        val samapyora=kirjanPito.filter(a=>a.tavarat.equals(pyora))
        for bike<- samapyora do
         vuokrattupyoramaara+=bike.kappale
        var palautettumaara=0
        val pyorat=returnrecord.filter(a=>a.item.equals(pyora))
        for bike<- pyorat do
         palautettumaara += bike.amount
        s"It is an electricbike and the name of the bike is ${b.name}. The battery of the bike lasts up to ${b.batteryRangeinKM} km.\nIt takes ${b.chargingTime} hours for the battery to charge fully. It cost you ${b.ownprice}.\nThe hourly rental price for this bike is ${b.rentalPrice(1)} and daily rental price is ${b.rentalPrice(24)} and monthlly rental price is ${b.rentalPrice(24*30)}.\nOther info about this bike: ${b.comment} and the added comment: ${getbike(pyora).addcomment}.\nCurrently there are ${bikesinGarage.get(b).get} bikes available in the store and ${vuokrattupyoramaara-palautettumaara} is now rented to customers\nand ${reservattu(pyora)} is reserved for different customers.\nYou can get more information by clicking 'rentersandrentedinfo' or 'view renter's info'. "
      case c:motorCycles =>
        var vuokrattupyoramaara=0
        val samapyora=kirjanPito.filter(a=>a.tavarat.equals(pyora))
        for bike<- samapyora do
         vuokrattupyoramaara+=bike.kappale
        var palautettumaara=0
        val pyorat=returnrecord.filter(a=>a.item.equals(pyora))
        for bike<- pyorat do
         palautettumaara += bike.amount
        s"It is a motorcycle and the name of the bike is ${c.name} and the manufacturer is ${c.brand}.\nThe engine size is ${c.engineSizecubiCentimeters} cubiCentimeters. It has ${c.horsepower} horsepowers. It cost you ${c.ownprice}.\nThe hourly rental price for this bike is ${c.rentalPrice(1)} and daily rental price is ${c.rentalPrice(24)} and monthlly rental price is ${c.rentalPrice(24*30)}.\nOther info about this bike: ${c.comment} and the added comment: ${getbike(pyora).addcomment}.\nCurrently there are ${bikesinGarage.get(c).get} bikes available in the store and ${vuokrattupyoramaara-palautettumaara} is now rented to customers\nand ${reservattu(pyora)} is reserved for different customers.\nYou can get more information by clicking 'rentersandrentedinfo' or 'view renter's info'. "
      case d:mountainBike =>
        var vuokrattupyoramaara=0
        val samapyora=kirjanPito.filter(a=>a.tavarat.equals(pyora))
        for bike<- samapyora do
         vuokrattupyoramaara+=bike.kappale
        var palautettumaara=0
        val pyorat=returnrecord.filter(a=>a.item.equals(pyora))
        for bike<- pyorat do
         palautettumaara += bike.amount
        s"It is a mountainbike and the name of the bike is ${d.name}.\nThe size of the wheels are ${d.wheelSize} inches.  It has ${d.gears} gears. It cost you ${d.ownprice}.\nThe hourly rental price for this bike is ${d.rentalPrice(1)} and daily rental price is ${d.rentalPrice(24)} and monthlly rental price is ${d.rentalPrice(24*30)}.\nOther info about this bike: ${d.comment} and the added comment: ${getbike(pyora).addcomment}.\nCurrently there are ${bikesinGarage.get(d).get} bikes available in the store and ${vuokrattupyoramaara-palautettumaara} is now rented to customers \nand ${reservattu(pyora)} is reserved for different customers.\nYou can get more information by clicking 'rentersandrentedinfo' or 'view renter's info'. "
      case e:scooter =>
        var vuokrattupyoramaara=0
        val samapyora=kirjanPito.filter(a=>a.tavarat.equals(pyora))
        for bike<- samapyora do
         vuokrattupyoramaara+=bike.kappale
        var palautettumaara=0
        val pyorat=returnrecord.filter(a=>a.item.equals(pyora))
        for bike<- pyorat do
         palautettumaara += bike.amount
        s"It is a scooter and the name of the bike is ${e.name} and the manufacturer is ${e.brand}.It cost you ${e.ownprice}.\nThe hourly rental price for this bike is ${e.rentalPrice(1)} and daily rental price is ${e.rentalPrice(24)} and monthlly rental price is ${e.rentalPrice(24*30)}.\nOther info about this bike: ${e.comment} and the added comment: ${getbike(pyora).addcomment}.\nCurrently there are ${bikesinGarage.get(e).get} bikes available in the store and ${vuokrattupyoramaara-palautettumaara} is now rented to customers\nand ${reservattu(pyora)} is reserved for different customers.\nYou can get more information by clicking 'rentersandrentedinfo' or 'view renter's info'. "
      case _ =>
        "No such bike here"

  def situation=
    val availablebikemaara=bikesinGarage.values.sum
    var vuokrattujenbikemaara=0
    for i<- rentersandrenteditems.values do
      vuokrattujenbikemaara+=i.values.sum
    var reservattumaara=0
    for ii<- reserversandreserveditems.values do
      reservattumaara+=ii.values.sum
    s"There are $availablebikemaara bikes available in your garage. You have rented $vuokrattujenbikemaara bikes to different people and $reservattumaara item is reserved.\nClick on rentersandrenteditems or reservations to view more inofrmation about the renters and their rented and reserved bikes"


  def commentadder(cycle:Bikes, teksti: String)=
    if bikesinGarage.contains(cycle) then
      val sebike=bikesinGarage.keys.filter(a=>a==cycle)
      sebike.head.addcomment=teksti
      "Comment added succesfully. Click on the ¨Check info of a bike' button to view the added comment"
    else "This bike is not available in your garage"


  def tarkistaikavali (aloitus:LocalDateTime,lopetus:LocalDateTime)=
    var income=0
    var tekstiken=Buffer[String]()
    val buff= kirjanPito.filter(a=> a.alkupv==aloitus && a.loppupv == lopetus || aloitus.isBefore(a.alkupv) && lopetus.isAfter(a.loppupv))
    for transaction <- buff do
      if Duration.between(transaction.alkupv,transaction.loppupv).toHours.toInt <= Duration.between(aloitus,lopetus).toHours.toInt
      then
        income+=transaction.rentalcost
        tekstiken+=s"For the given period of time a bike named ${transaction.tavarat.name} has produced ${transaction.rentalcost} euros.\n"
      else
        income += (transaction.rentalcost/Duration.between(transaction.alkupv,transaction.loppupv).toHours.toInt)*Duration.between(aloitus,lopetus).toHours.toInt
        tekstiken+=s"For the period of time a bike named ${transaction.tavarat.name} has produced ${(transaction.rentalcost/Duration.between(transaction.alkupv,transaction.loppupv).toHours.toInt)*Duration.between(aloitus,lopetus).toHours.toInt} euros.\n"

    tekstiken+=s"The income of this period of time from all bikes is "+income+ "euros."
    tekstiken


  def reservation(tavara:Bikes,kelleVuokraan:Renter, kappale:Int,vuokrauksenalkupv:LocalDateTime, vuokrauksenloppupv:LocalDateTime)=
    require(bikesinGarage.contains(tavara))
    deleteBike(tavara,kappale) // poista tavaran bikesiGaragesta
    reservations+=Reservations(tavara,kelleVuokraan,kappale,vuokrauksenalkupv,vuokrauksenloppupv)
    if kelleVuokraan.reserveditems.contains(tavara) then kelleVuokraan.reserveditems.put(tavara,kelleVuokraan.renteditems.get(tavara).get + kappale) else kelleVuokraan.reserveditems+=tavara ->kappale
      //jos vuokraaajal on jo tämä pyörä vuokrattu nii lisää vain sen määrän mutta jos ei ole vuokrattu niin lisää sen vuokraajan vuokrattuun tavaroihin
    if !(reserversandreserveditems.contains(kelleVuokraan))   //jos rentersandrenteditems ei containaa vuokraaja eli ei myöskää tavara
    then reserversandreserveditems+=kelleVuokraan->Map(tavara->kappale) // lisää vuokraajan ja sen vuokratun tavaran ja kuinka monta kappaletta
    else
      if reserversandreserveditems.get(kelleVuokraan).get.keys.toBuffer.contains(tavara) // jos vuokraaja on listal ja sil on  samanlainen tavara
      then
        val reserverandrenteditemsinMapBikesInt=reserversandreserveditems.get(kelleVuokraan).get //Map[Bikes,Int]
        reserverandrenteditemsinMapBikesInt.put(tavara,reserverandrenteditemsinMapBikesInt.get(tavara).get +kappale) // niin lisää vaa sen tavarn määräm
      else reserversandreserveditems.get(kelleVuokraan).get+=tavara -> kappale //jos vuokraaja on listal ja sil ei oo tavara nii lisää sen tavarn siihen
    Reservations(tavara,kelleVuokraan,kappale,vuokrauksenalkupv,vuokrauksenloppupv)

  def reservationforfile(tavara:Bikes,kelleVuokraan:Renter, kappale:Int,vuokrauksenalkupv:LocalDateTime, vuokrauksenloppupv:LocalDateTime)=
    require(bikesrecord.contains(tavara))
    deleteBike(tavara,kappale) // poista tavaran bikesiGaragesta
    reservations+=Reservations(tavara,kelleVuokraan,kappale,vuokrauksenalkupv,vuokrauksenloppupv)
    if kelleVuokraan.reserveditems.contains(tavara) then kelleVuokraan.reserveditems.put(tavara,kelleVuokraan.renteditems.get(tavara).get + kappale) else kelleVuokraan.reserveditems+=tavara ->kappale
      //jos vuokraaajal on jo tämä pyörä vuokrattu nii lisää vain sen määrän mutta jos ei ole vuokrattu niin lisää sen vuokraajan vuokrattuun tavaroihin
    if !(reserversandreserveditems.contains(kelleVuokraan))   //jos rentersandrenteditems ei containaa vuokraaja eli ei myöskää tavara
    then reserversandreserveditems+=kelleVuokraan->Map(tavara->kappale) // lisää vuokraajan ja sen vuokratun tavaran ja kuinka monta kappaletta
    else
      if reserversandreserveditems.get(kelleVuokraan).get.keys.toBuffer.contains(tavara) // jos vuokraaja on listal ja sil on  samanlainen tavara
      then
        val reserverandrenteditemsinMapBikesInt=reserversandreserveditems.get(kelleVuokraan).get //Map[Bikes,Int]
        reserverandrenteditemsinMapBikesInt.put(tavara,reserverandrenteditemsinMapBikesInt.get(tavara).get +kappale) // niin lisää vaa sen tavarn määräm
      else reserversandreserveditems.get(kelleVuokraan).get+=tavara -> kappale //jos vuokraaja on listal ja sil ei oo tavara nii lisää sen tavarn siihen
    Reservations(tavara,kelleVuokraan,kappale,vuokrauksenalkupv,vuokrauksenloppupv)


  def cancelReservation (esine:Bikes,vuokraaja :Renter, kpl:Int)=
    //vuokraaja palauttaa tavaran
    var vuokrattumaara=0
    val returnaaja= reservations.filter( a => a.vuokraaja.equals(vuokraaja) && a.tavara.equals(esine))
    for alkio <- returnaaja do
      vuokrattumaara+=alkio.kappale
    if kpl <= vuokrattumaara then addNewBike(esine,kpl) else addNewBike(esine,vuokrattumaara) //tavara lisääntyy takasin varastoon
    if vuokraaja.reserveditems.contains(esine) then vuokraaja.reserveditems.put(esine,vuokraaja.reserveditems.get(esine).get - kpl) // poistaa vuokraajan vuokratusta tavaroista tavarann
    val reservedinMapBikesInt=reserversandreserveditems.get(vuokraaja).get //Map[Bikes,Int]
    reservedinMapBikesInt.put(esine,reservedinMapBikesInt.get(esine).get -kpl)//vähentää tavaran määrä
    for alkio <- reserversandreserveditems do
      if alkio._2.size==1 && alkio._2.head._2 <= 0 then reserversandreserveditems.remove(alkio._1)
      else
       for mappi <- alkio._2 do
        if mappi._2<=0 then alkio._2.remove(mappi._1)





  def getrenter(vuokraaja: Renter): Renter =
    val ren = rentersandrenteditems.keys.filter(a => a == vuokraaja)
    ren.head

  def rentercommentadder(vuorkaja:Renter, teksti: String)=
    if rentersandrenteditems.contains(vuorkaja) then
      getrenter(vuorkaja).comment=teksti
      "Comment added succesfully."
    else "This renter is not in your list"

  def bikeluoja(riviarvo : Array[String]) : Bikes =
    if riviarvo.size==6 then motorCycles(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3),riviarvo(4).toInt,riviarvo(5))
    else if riviarvo.size==4 then  scooter(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3))
    else if riviarvo.size ==5 && riviarvo.lift(2).flatMap(_.toIntOption).isDefined && riviarvo.lift(3).flatMap(_.toIntOption).isDefined then electricBikes(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3).toInt,riviarvo(4))
    else if riviarvo.size ==5 && riviarvo.lift(2).flatMap(_.toIntOption).isDefined && riviarvo(3).isInstanceOf[String] then mountainBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3),riviarvo(4).toInt)
    else if riviarvo.size ==5 && riviarvo(2).isInstanceOf[String] && riviarvo.lift(3).flatMap(_.toIntOption).isDefined then cityBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3).toInt,riviarvo(4))
    else cityBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3).toInt,riviarvo(4))


  def recordfile(recordit:Buffer[Accounting] , name:String)=
    val file = new File(name)
    val kirjota= new PrintWriter(file)
    for record <- recordit do
      kirjota.println(s"${record.vuokraaja.name},${record.vuokraaja.contact}/${record.tavarat}/${record.kappale}/${record.alkupv.getYear},${record.alkupv.getMonth},${record.alkupv.getDayOfMonth},${record.alkupv.getHour},${record.alkupv.getMinute}/${record.loppupv.getYear},${record.loppupv.getMonth},${record.loppupv.getDayOfMonth},${record.loppupv.getHour},${record.loppupv.getMinute}/${record.rentalcost}")
    kirjota.close()
  def luorecordit(name:String)=
     val tiedosto=new File(name)
     val lahde=Source.fromFile(tiedosto)
     for line <- lahde.getLines() do
       val arvo=line.split("/")
       rentforfile(bikeluoja(arvo(1).split(",")),new Renter(arvo(0).split(",").head,arvo(0).split(",")(1).toInt),arvo(2).toInt,LocalDateTime.of(arvo(3).split(",")(0).toInt,Month.valueOf(arvo(3).split(",")(1)),arvo(3).split(",")(2).toInt,arvo(3).split(",")(3).toInt,arvo(3).split(",")(4).toInt),LocalDateTime.of(arvo(4).split(",")(0).toInt,Month.valueOf(arvo(4).split(",")(1)),arvo(4).split(",")(2).toInt,arvo(4).split(",")(3).toInt,arvo(4).split(",")(4).toInt))
     lahde.close()

  def reservationfile(reservationit:Buffer[Reservations],name:String)=
    val file = new File(name)
    val kirjota= new PrintWriter(file)
    for record <- reservationit do
      kirjota.println(s"${record.tavara}/${record.vuokraaja.name},${record.vuokraaja.contact}/${record.kappale}/${record.alkamispv.getYear},${record.alkamispv.getMonth},${record.alkamispv.getDayOfMonth},${record.alkamispv.getHour},${record.alkamispv.getMinute}/${record.loppumispv.getYear},${record.loppumispv.getMonth},${record.loppumispv.getDayOfMonth},${record.loppumispv.getHour},${record.loppumispv.getMinute}")
    kirjota.close()
  def luoreservit(name:String)=
     val tiedosto=new File(name)
     val lahde=Source.fromFile(tiedosto)
     for line <- lahde.getLines() do
       val arvo=line.split("/")
       reservationforfile(bikeluoja(arvo(0).split(",")),new Renter(arvo(1).split(",").head,arvo(1).split(",")(1).toInt),arvo(2).toInt,LocalDateTime.of(arvo(3).split(",")(0).toInt,Month.valueOf(arvo(3).split(",")(1)),arvo(3).split(",")(2).toInt,arvo(3).split(",")(3).toInt,arvo(3).split(",")(4).toInt),LocalDateTime.of(arvo(4).split(",")(0).toInt,Month.valueOf(arvo(4).split(",")(1)),arvo(4).split(",")(2).toInt,arvo(4).split(",")(3).toInt,arvo(4).split(",")(4).toInt))
     lahde.close()

  def returnfile(returnit:mutable.Buffer[Returnrecords],name:String)=
    val file = new File(name)
    val kirjota= new PrintWriter(file)
    for record <- returnit do
      kirjota.println(s"${record.item}/${record.lessor.name},${record.lessor.contact}/${record.amount}")
    kirjota.close()

  def luoreturnit(name:String)=
    val tiedosto=new File(name)
     val lahde=Source.fromFile(tiedosto)
     for line <- lahde.getLines() do
       val arvo=line.split("/")
       returned(bikeluoja(arvo(0).split(",")),new Renter(arvo(1).split(",").head,arvo(1).split(",")(1).toInt),arvo(2).toInt)
     lahde.close()



  def file(biket:Map[Bikes,Int],nimi:String)=
    val tiedosto=new File(nimi)
    val kirjota=new PrintWriter(tiedosto)
    for i <- biket do
      i._1 match
        case a :mountainBike =>kirjota.println(s"${a.name},${a.wheelSize},${a.gears},${a.comment},${a.ownprice}>${i._2}")
        case b: cityBike => kirjota.println(s"${b.name},${b.gearNumbers},${b.frameMaterial},${b.ownprice},${b.comment}>${i._2}")
        case c: motorCycles => kirjota.println(s"${c.name},${c.engineSizecubiCentimeters},${c.horsepower},${c.brand},${c.ownprice},${c.comment}>${i._2}")
        case d :scooter => kirjota.println(s"${d.name},${d.ownprice},${d.brand},${d.comment}>${i._2}")
        case e : electricBikes => kirjota.println(s"${e.name},${e.batteryRangeinKM},${e.chargingTime},${e.ownprice},${e.comment}>${i._2}")
    kirjota.close()


  def bikecommentfile(biket:Map[Bikes,Int],nimi:String)=
    val tiedosto=new File(nimi)
    val kirjota=new PrintWriter(tiedosto)
    for i <- biket do
      i._1 match
        case a :mountainBike => kirjota.println(s"${a.name},${a.wheelSize},${a.gears},${a.comment},${a.ownprice}>\"${a.addcomment}\"")
        case b: cityBike => kirjota.println(s"${b.name},${b.gearNumbers},${b.frameMaterial},${b.ownprice},${b.comment}>\"${b.addcomment}\"")
        case c: motorCycles => kirjota.println(s"${c.name},${c.engineSizecubiCentimeters},${c.horsepower},${c.brand},${c.ownprice},${c.comment}>\"${c.addcomment}\"")
        case d :scooter => kirjota.println(s"${d.name},${d.ownprice},${d.brand},${d.comment}>\"${d.addcomment}\"")
        case e : electricBikes => kirjota.println(s"${e.name},${e.batteryRangeinKM},${e.chargingTime},${e.ownprice},${e.comment}>\"${e.addcomment}\"")
    kirjota.close()

  def renterkommentitfile(renterrented:Map[Renter,Map[Bikes,Int]],nimi:String)=
    val tiedosto=new File(nimi)
    val kirjota=new PrintWriter(tiedosto)
    for i <- renterrented do
      kirjota.println(s"${i._1.name},${i._1.contact}=\"${i._1.comment}\"")
    kirjota.close()

  def loadrentercomments(name:String)=
    val tiedosto=new File(name)
    val lahde=Source.fromFile(tiedosto)
    for i <-lahde.getLines() do
      val toine=i.split("=")
      rentercommentadder(Renter(toine(0).split(",")(0),toine(0).split(",")(1).toInt),toine(1))

  def luokommentiti(nimi:String)=
    val tiedosto=new File(nimi)
    val lahde=Source.fromFile(tiedosto)
    for i <-lahde.getLines() do
      val int= i.split(">")
      if bikesinGarage.contains(bikeluoja(int(0).split(","))) then this.commentadder(getbike(bikeluoja(int(0).split(","))),int(1))






  def luoPyorat(nimi:String)=
    val tiedosto=new File(nimi)
    val lahde=Source.fromFile(tiedosto)
    var items=Map[Bikes,Int]()
    for i <-lahde.getLines() do
      val riviarvo=i.split(",")
      val int= i.split(">")
      if riviarvo.size==6 then  addNewBike(new motorCycles(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3),riviarvo(4).toInt,riviarvo(5).split(">")(0)), int(1).toInt)
      else if riviarvo.size==4 then  addNewBike(new scooter(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3).split(">")(0)), int(1).toInt)
      else if riviarvo.size ==5 && riviarvo.lift(2).flatMap(_.toIntOption).isDefined && riviarvo.lift(3).flatMap(_.toIntOption).isDefined then  addNewBike(new electricBikes(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3).toInt,riviarvo(4).split(">")(0)), int(1).toInt)
      else if riviarvo.size ==5 && riviarvo.lift(2).flatMap(_.toIntOption).isDefined && riviarvo(3).isInstanceOf[String] then addNewBike(new mountainBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3),riviarvo(4).split(">")(0).toInt) , int(1).toInt)
      else if riviarvo.size ==5 && riviarvo(2).isInstanceOf[String] && riviarvo.lift(3).flatMap(_.toIntOption).isDefined then addNewBike(new cityBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3).toInt,riviarvo(4).split(">")(0)), int(1).toInt)
    lahde.close()
    items

  def luoPyoratrec(nimi:String)=
    val tiedosto=new File(nimi)
    val lahde=Source.fromFile(tiedosto)
    var items=Map[Bikes,Int]()
    for i <-lahde.getLines() do
      val riviarvo=i.split(",")
      val int= i.split(">")
      if riviarvo.size==6 then  addnewtobikrecords(new motorCycles(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3),riviarvo(4).toInt,riviarvo(5).split(">")(0)), int(1).toInt)
      else if riviarvo.size==4 then  addnewtobikrecords(new scooter(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3).split(">")(0)), int(1).toInt)
      else if riviarvo.size ==5 && riviarvo.lift(2).flatMap(_.toIntOption).isDefined && riviarvo.lift(3).flatMap(_.toIntOption).isDefined then  addnewtobikrecords(new electricBikes(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3).toInt,riviarvo(4).split(">")(0)), int(1).toInt)
      else if riviarvo.size ==5 && riviarvo.lift(2).flatMap(_.toIntOption).isDefined && riviarvo(3).isInstanceOf[String] then addnewtobikrecords(new mountainBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2).toInt,riviarvo(3),riviarvo(4).split(">")(0).toInt) , int(1).toInt)
      else if riviarvo.size ==5 && riviarvo(2).isInstanceOf[String] && riviarvo.lift(3).flatMap(_.toIntOption).isDefined then addnewtobikrecords(new cityBike(riviarvo.head,riviarvo(1).toInt,riviarvo(2),riviarvo(3).toInt,riviarvo(4).split(">")(0)), int(1).toInt)
    lahde.close()
    items



  def saverecords= recordfile(kirjanPito,"records.csv")
  def savereservations= reservationfile(reservations,"reservations.csv")
  def saveretun=returnfile(returnrecord,"returnrecords.csv")
  def tallenna() =
    file(bikesinGarage,"pyorat.csv")
  def savekaikkibikes=file(bikesrecord,"all_time_bikes.csv")
  def savecomment=bikecommentfile(bikesinGarage,"Bike_comments.csv")
  def saverenterkom=renterkommentitfile(rentersandrenteditems,"Renters' comments")

  def loadreservation=luoreservit("reservations.csv")
  def loadrecord=luorecordit("records.csv")
  def lata =
    luoPyorat("pyorat.csv")
  def loadrentercomment=loadrentercomments("Renters' comments")
  def luo=luoPyoratrec("all_time_bikes.csv")
  def loadreturn=luoreturnit("returnrecords.csv")
  def loadcomments=luokommentiti("Bike_comments.csv")





  
  
 



