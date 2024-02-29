package mahaRentalPackage
import javafx.collections.FXCollections
import javafx.scene.chart.PieChart
import scalafx.scene.control.ComboBox
import scalafx.application.JFXApp3
import javafx.scene.image.Image
import scalafx.Includes.*
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.layout.Pane
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.scene.text.Font
import scala.collection.mutable.*
import scalafx.scene.paint.Color.*
import java.time.*
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.layout.Pane
import scalafx.scene.control.MenuBar
import scalafx.scene.control.Menu
import scalafx.scene.layout.VBox
import scalafx.scene.control.Label
import scalafx.scene.control.TextField
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.DatePicker
import java.awt.MenuBar
import java.util.IllegalFormatException
import scala.collection.mutable.*
import java.time.LocalDate
import javafx.scene.control.{Cell, DatePicker}
import javafx.scene.layout.GridPane
import mahaRentalPackage.Main.stage
import scala.collection.mutable
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.chart.{BarChart, CategoryAxis, NumberAxis, XYChart}
import javafx.scene.layout.StackPane
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import javafx.stage.FileChooser
import javafx.scene.control.ScrollPane
import javafx.scene.image.ImageView
import javafx.scene.paint.Color
import javafx.scene.Group
import java.io.FileInputStream


object Main extends JFXApp3:

  def start(): Unit =

    /*
    Creation of a new primary stage (Application window).
    We can use Scala's anonymous subclass syntax to get quite
    readable code.
    */


    stage = new JFXApp3.PrimaryStage:
      title = "Maha Rental"
      width = 600
      height = 450

    /*
    Create root gui component, add it to a Scene
    and set the current window scene.
    */
    val root = Pane() // Simple pane component
    var scene = Scene(parent = root)
    val manager= new Manager
    val aloitus=Pane()
    var alkascene=Scene(parent=aloitus)
    stage.scene = alkascene
    val la=Label(s"Hello! Welcome to Mahathir Rental.\n              Le's get started!")
    aloitus.children+=la
    la.layoutX = 420
    la.layoutY=220
    la.font = Font(30)
    la.textFill = DarkGreen
    val starrt=Button("START")
    aloitus.children+=starrt
    starrt.layoutX = 620
    starrt.layoutY = 350
    starrt.onAction=(event) =>
      stage.scene = scene
    // Scene acts as a container for the scene graph
    // Assigning the new scene as the current scene for the stage
    val availablebikeroot=Pane()
    var availablescene= Scene(parent = availablebikeroot)
    val renterrentedroot =Pane()
    var renterdscene=Scene(parent=renterrentedroot)
    val checkinforoot=Pane()
    var checkinfoscene=Scene(parent=checkinforoot)
    val situationroot=Pane()
    var situationscene= Scene(parent=situationroot)



    val button1= Button("addBike")
    val button = Button("deleteBike")
    button.layoutX = 70
    button.layoutY = 0
    val button2= Button("availableBikes")
    val button3=Button("rentersandrenteditems")
    val button4=Button("Rent")
    button4.layoutX = 400
    button3.layoutX = 250
    root.children+=button3
    root.children+=button4
    button2.layoutX = 150
    def mountainBiketekstiforaddbike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write name,wheelsize,gears,comment, ownprice")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 110
      boxi.layoutX = 70
      boxi.layoutY = 70
      val nappi=Button("Enter")
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 140
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val wheelsize=
            value(1).toInt
          val gears=
            value(2).toInt
          val comment=value(3)
          val ownprice=
            value(4).toInt
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.addNewBike(mountainBike(nimi,wheelsize,gears,comment,ownprice),amount)
          manager.addnewtobikrecords(mountainBike(nimi,wheelsize,gears,comment,ownprice),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    def mountainbikefordeletebike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write name,wheelsize,gears,comment, ownprice")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 140
      boxi.layoutX = 70
      boxi.layoutY = 100
      val nappi=Button("Enter")
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 170
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val wheelsize=
            value(1).toInt
          val gears=
            value(2).toInt
          val comment=value(3)
          val ownprice=
            value(4).toInt
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.deleteBike(mountainBike(nimi,wheelsize,gears,comment,ownprice),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    def scrolli(root:Pane,parametri:Label)=
     val scroll=new ScrollPane()
     scroll.setPrefSize(1000,600)
     scroll.setContent(parametri)
     root.children+=scroll
     scroll.layoutX = 40
     scroll.layoutY=30

    def scrollit(root:Pane,parametri:PieChart)=
     val scroll=new ScrollPane()
     scroll.setPrefSize(1000,600)
     scroll.setContent(parametri)
     root.children+=scroll
     scroll.layoutX = 40
     scroll.layoutY=30


    def citybiketekstiforaddbike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
      boxi.children+=tekstiinput
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 140
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 110
      boxi.layoutX = 70
      boxi.layoutY = 70
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val gearnumbers=
            value(1).toInt
          val framematerial=
            value(2)
          val ownprice=
            value(3).toInt
          val comment=value(4)
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.addNewBike( cityBike(nimi,gearnumbers, framematerial, ownprice, comment),amount)
          manager.addnewtobikrecords(cityBike(nimi,gearnumbers, framematerial, ownprice, comment),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")
    def citybikefordeletebike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 170
      boxi1.layoutX = 130
      boxi1.layoutY = 150
      boxi.layoutX = 70
      boxi.layoutY = 100
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val gearnumbers=
            value(1).toInt
          val framematerial=
            value(2)
          val ownprice=
            value(3).toInt
          val comment=value(4)
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.deleteBike( cityBike(nimi,gearnumbers, framematerial, ownprice, comment),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    def motorcycletekstiforaddbike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 140
      boxi1.layoutX = 130
      boxi1.layoutY = 110
      boxi.layoutX = 70
      boxi.layoutY = 70
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val engineSizecubiCentimeters=
            value(1).toInt
          val horsepower=
            value(2).toInt
          val brand=value(3)
          val ownprice=
            value(4).toInt
          val comment=value(5)
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.addNewBike( motorCycles(nimi,engineSizecubiCentimeters, horsepower, brand, ownprice, comment),amount)
          manager.addnewtobikrecords(motorCycles(nimi,engineSizecubiCentimeters, horsepower, brand, ownprice, comment),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")


    def motorcycletekstifordeletebike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 170
      boxi1.layoutX = 130
      boxi1.layoutY = 150
      boxi.layoutX = 70
      boxi.layoutY = 100
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val engineSizecubiCentimeters=
            value(1).toInt
          val horsepower=
            value(2).toInt
          val brand=value(3)
          val ownprice=
            value(4).toInt
          val comment=value(5)
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.deleteBike(motorCycles(nimi,engineSizecubiCentimeters, horsepower, brand, ownprice, comment),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")


    def scootertekstiforaddbike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 140
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("write in the exact format name, ownprice, brand, comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 110
      boxi.layoutX = 70
      boxi.layoutY = 70
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val ownprice=
            value(1).toInt
          val brand = value(2)
          val comment=value(3)
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.addNewBike(scooter(nimi, ownprice, brand, comment),amount)
          manager.addnewtobikrecords(scooter(nimi, ownprice, brand, comment),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException => throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    def scootertekstifordeletebike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("write in the exact format name, ownprice, brand, comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 140
      boxi.layoutX = 70
      boxi.layoutY = 100
      val nappi=Button("Enter")
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 170
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val nimi=value.head
          val ownprice=
            value(1).toInt
          val brand = value(2)
          val comment=value(3)
          val value2=tekstiinput2.text.value
          val amount=value2.toInt
          manager.deleteBike(scooter(nimi, ownprice, brand, comment),amount)
          boxi.visible = false
          boxi1.visible = false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException => throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")



    def electricbikeforaddbike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      root.children+=boxi
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 140
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 110
      boxi.layoutX = 70
      boxi.layoutY = 70
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val value2=tekstiinput2.text.value
          val nimi=value.head
          val batteryRangeinKM=
            value(1).toInt
          val charginTizme=
            value(2).toInt
          val ownprice=
            value(3).toInt
          val comment=value(4)
          val amount=value2.toInt
          manager.addNewBike(electricBikes(nimi,batteryRangeinKM,charginTizme,ownprice, comment),amount)
          manager.addnewtobikrecords(electricBikes(nimi,batteryRangeinKM,charginTizme,ownprice, comment),amount)
          boxi.visible = false
          boxi1.visible=false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException => throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")


    def electricbikefordeletebike=
      val boxi=VBox()
      val boxi1= VBox()
      val tekstiinput= new TextField
      val tekstiinput2= new TextField
      root.children+=boxi1
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        boxi.visible = false
        boxi1.visible=false
        back.visible=false
      back.layoutX = 70
      back.layoutY = 170
      root.children+=boxi
      boxi1.children+= Label("Write the amount of bike you want to add")
      boxi.children+=
        Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
      boxi.children+=tekstiinput
      tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
      boxi1.children+=tekstiinput2
      boxi1.layoutX = 130
      boxi1.layoutY = 140
      boxi.layoutX = 70
      boxi.layoutY = 100
      val nappi=Button("Enter")
      boxi1.children+=nappi
      boxi.children+=nappi
      nappi.onAction= (event)=>
        try
          val value=tekstiinput.text.value.split(",")
          val value2=tekstiinput2.text.value
          val nimi=value.head
          val batteryRangeinKM=
            value(1).toInt
          val charginTime=
            value(2).toInt
          val ownprice=
            value(3).toInt
          val comment=value(4)
          val amount=value2.toInt
          manager.deleteBike(electricBikes(nimi,batteryRangeinKM,charginTime,ownprice, comment),amount)
          boxi.visible = false
          boxi1.visible=false
          back.visible = false
          nappi.visible = false
        catch
          case e:IndexOutOfBoundsException => throw Exception("put the inputs as aksed")
          case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    button1.onAction = (event) =>
      val box = new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
      val back= Button("Back")
      root.children+=back
      back.onAction= (event)=>
        box.visible = false
        back.visible=false
      back.layoutY = 180
      box.onAction = (event) =>
        box.value.apply() match
          case "mountainBike" => mountainBiketekstiforaddbike
          case "cityBike" => citybiketekstiforaddbike
          case "motorcycle" => motorcycletekstiforaddbike
          case "scooter" => scootertekstiforaddbike
          case "electricBike" => electricbikeforaddbike
      root.children+=box
      box.layoutY =30
    root.children+=button1
    root.children +=button
    root.children +=button2

     button.onAction = (event) =>
        val box = new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
        box.layoutX =80
        val back= Button("Back")
        root.children+=back
        back.onAction= (event)=>
          box.visible = false
          back.visible=false
        back.layoutY = 200
        box.onAction = (event) =>
          box.value.apply() match
            case "mountainBike" => mountainbikefordeletebike
            case "cityBike" => citybikefordeletebike
            case "motorcycle" => motorcycletekstifordeletebike
            case "scooter" => scootertekstifordeletebike
            case "electricBike" => electricbikefordeletebike
        root.children+=box
        box.layoutY =40

     button4.onAction = (event) =>
        val bikebox= new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
        bikebox.layoutY = 40
        root.children+=bikebox
        val bakkii=Button("Back")
        root.children+=bakkii
        bakkii.layoutY=70
        bakkii.onAction=(event)=>
          bikebox.visible  =false
          bakkii.visible = false
        bikebox.onAction = (event) =>
          bikebox.value.apply() match
            case "mountainBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write name,wheelsize,gears,comment, ownprice")
              boxi.children+=tekstiinput
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              root.children+=back
              back.layoutX = 105
              back.layoutY = 510
              root.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val kalenteri= new DatePicker((LocalDate.now))
              root.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                toinekalenteri.visible=false
                kalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt)
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.rent(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "cityBike"=>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              val kalenteri= new DatePicker((LocalDate.now))
              root.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.rent(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "motorcycle" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val kalenteri= new DatePicker((LocalDate.now))
              root.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              val toinekalenteri= new DatePicker(LocalDate.now)
              root.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.rent(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "scooter"=>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name, ownprice, brand, comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              val kalenteri= new DatePicker((LocalDate.now))
              root.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=scooter(value.head,value(1).toInt,value(2),value(3))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.rent(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "electricBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              val kalenteri= new DatePicker((LocalDate.now))
              root.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.rent(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    button2.onAction = (event) =>
      stage.scene = availablescene
      var stringi=""
      for bike<-manager.bikesinGarage do
        stringi+= s"${bike._1} -> ${bike._2}\n"
        println(bike._1)
      println(manager.bikesrecord)
      val labeli=Label(stringi)
      availablebikeroot.children+=labeli
      labeli.layoutX = 150
      labeli.layoutY = 30
      val takan=Button("Exit available bikes")
      availablebikeroot.children+=takan
      labeli.textFill = Violet
      labeli.font = Font(18)
      scrolli(availablebikeroot,labeli)
      takan.onAction = (event) =>
        labeli.visible = false
        takan.visible = false
        stage.scene = scene



    button3.onAction = (event) =>
      stage.scene = renterdscene
      var stringi=""
      for alkio<-manager.rentersandrenteditems do
        stringi+= s"${alkio._1.name},${alkio._1.contact} -> ${alkio._2}\n"
      val labeli=Label(stringi)
      val scroll=new ScrollPane()
      scroll.setPrefSize(1000,600)
      scroll.setContent(labeli)
      renterrentedroot.children+=scroll
      scroll.layoutX = 40
      scroll.layoutY=30
      labeli.layoutX = 20
      labeli.layoutY = 30
      labeli.font = Font(18)
      labeli.textFill = IndianRed
      val takan=Button("Exit rentersandrenteditems")
      renterrentedroot.children+=takan
      takan.onAction = (event) =>
        labeli.visible = false
        takan.visible = false
        stage.scene = scene

    def kuville(kuva:Image)=
      val showkuva= Button("Show the pic")
      checkinforoot.children+=showkuva
      showkuva.layoutY = 400
      showkuva.onAction= (event) =>
        val ta= Button ("Back to check the info of the bike")
        ta.layoutY = 470
        val image=kuva
        val imageview= new ImageView()
        imageview.setImage(image)
        imageview.setX(10)
        imageview.setY(10)
        imageview.setFitWidth(595)
        imageview.setPreserveRatio(true)
        println(image)
        val group=new Group(imageview)
        group.children +=ta
        ta.onAction = (event) =>
          stage.scene=checkinfoscene
          imageview.visible = false
        val hitonscene=new Scene(group,400,400)
        stage.scene=hitonscene
        stage.show()



    val chekinfobutton= Button("Check the info of a bike from you garage")
    root.children+=chekinfobutton
    chekinfobutton.layoutX =  460
    chekinfobutton.onAction = (event) =>
      val lista = new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
        lista.layoutX =500
        val back= Button("Back")
        root.children+=back
        back.onAction= (event)=>
          lista.visible = false
          back.visible=false
        back.layoutX = 500
        back.layoutY = 200
        lista.onAction = (event) =>
          lista.value.apply() match
            case "mountainBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write name,wheelsize,gears,comment,ownprice")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 500
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              boxi.children+=nappi
              boxi.children+=back
              back.onAction=(event)=>
                nappi.visible = false
                back.visible=false
                boxi.visible=false
              nappi.onAction=(event)=>
                try
                  stage.scene=checkinfoscene
                  val value=tekstiinput.text.value.split(",")
                  val lab=Label(s"${manager.checkInfo(mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt))}")
                  lab.textFill = Blue
                  lab.font=Font.font(25)
                  checkinforoot.children+=lab
                  val goback=Button("Back to main page")
                  checkinforoot.children+=goback
                  lab.layoutY = 30
                  scrolli(checkinforoot,lab)
                  goback.onAction = (event) =>
                    lab.visible = false
                    stage.scene=scene
                  kuville(manager.getbike(new mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt)).kuva)
                  nappi.visible = false
                  back.visible = false
                  boxi.visible = false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")



            case "cityBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
              boxi.children+=tekstiinput
              boxi.layoutX = 500
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              boxi.children+=nappi
              boxi.children+=back
              val calendar=new DatePicker(LocalDate.now)

              root.children+=calendar
              calendar.layoutX = 500
              calendar.layoutY = 70
              back.onAction=(event)=>
                nappi.visible = false
                back.visible=false
                boxi.visible=false
                calendar.visible  = false
              nappi.onAction=(event)=>
                try
                  stage.scene=checkinfoscene
                  val value=tekstiinput.text.value.split(",")
                  val lab=Label(s"${manager.checkInfo(cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4)))}")
                  lab.textFill = Blue
                  lab.font=Font.font(25)
                  checkinforoot.children+=lab
                  val goback=Button("Back to main page")
                  checkinforoot.children+=goback
                  lab.layoutY = 30
                  scrolli(checkinforoot,lab)
                  goback.onAction = (event) =>
                    lab.visible = false
                    stage.scene=scene
                  kuville(manager.getbike(cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))).kuva)
                  nappi.visible = false
                  back.visible = false
                  boxi.visible = false
                  calendar.visible= false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")

            case "motorcycle" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 500
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              boxi.children+=nappi
              boxi.children+=back
              back.onAction=(event)=>
                nappi.visible = false
                back.visible=false
                boxi.visible=false
              nappi.onAction=(event)=>
                try
                  stage.scene=checkinfoscene
                  val value=tekstiinput.text.value.split(",")
                  val lab=Label(s"${manager.checkInfo(motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5)))}")
                  lab.textFill = Blue
                  lab.font=Font.font(25)
                  checkinforoot.children+=lab
                  val goback=Button("Back to main page")
                  checkinforoot.children+=goback
                  lab.layoutY = 30
                  scrolli(checkinforoot,lab)
                  goback.onAction = (event) =>
                    lab.visible=false
                    stage.scene=scene
                  kuville(manager.getbike(motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))).kuva)
                  nappi.visible = false
                  back.visible = false
                  boxi.visible = false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "scooter" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name, ownprice, brand, comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 500
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              boxi.children+=nappi
              boxi.children+=back
              back.onAction=(event)=>
                nappi.visible = false
                back.visible=false
                boxi.visible=false
              nappi.onAction=(event)=>
                try
                  stage.scene=checkinfoscene
                  val value=tekstiinput.text.value.split(",")
                  val lab=Label(s"${manager.checkInfo(scooter(value.head,value(1).toInt,value(2),value(3)))}")
                  lab.textFill = Blue
                  lab.font=Font.font(25)
                  checkinforoot.children+=lab
                  val goback=Button("Back to main page")
                  checkinforoot.children+=goback
                  lab.layoutY = 30
                  scrolli(checkinforoot,lab)
                  goback.onAction = (event) =>
                    lab.visible=false
                    stage.scene=scene
                  kuville(manager.getbike(scooter(value.head,value(1).toInt,value(2),value(3))).kuva)
                  nappi.visible = false
                  back.visible = false
                  boxi.visible = false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "electricBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 500
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              boxi.children+=nappi
              boxi.children+=back
              back.onAction=(event)=>
                nappi.visible = false
                back.visible=false
                boxi.visible=false
              nappi.onAction=(event)=>
                try
                  stage.scene=checkinfoscene
                  val value=tekstiinput.text.value.split(",")
                  val lab=Label(s"${manager.checkInfo(electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4)))}")
                  lab.textFill = Blue
                  lab.font=Font.font(25)
                  checkinforoot.children+=lab
                  val goback=Button("Back to main page")
                  checkinforoot.children+=goback
                  lab.layoutY = 30
                  scrolli(checkinforoot,lab)
                  goback.onAction = (event) =>
                    lab.visible = false
                    stage.scene=scene
                  kuville(manager.getbike(electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))).kuva)
                  nappi.visible = false
                  back.visible = false
                  boxi.visible = false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
        root.children+=lista
        lista.layoutY =40

    val returnitem=Button("Return the item")
    root.children+=returnitem
    returnitem.layoutX = 700
    returnitem.onAction=(event) =>
     val bikebox= new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
      bikebox.layoutY = 40
      root.children+=bikebox
      val bakkii=Button("Back")
      root.children+=bakkii
      bakkii.layoutY=70
      bakkii.onAction=(event)=>
        bikebox.visible  =false
        bakkii.visible = false
      bikebox.onAction = (event) =>
        bikebox.value.apply() match
          case "mountainBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root.children+=boxi
            boxi.children+=
              Label("Write name,wheelsize,gears,comment, ownprice")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            root.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt)
                val vuokraaja= Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.returned(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "cityBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            root.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                val vuokraaja= Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.returned(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")




          case "motorcycle" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            val alkupvboxi=VBox()
            val alkupvinput=new TextField
            root.children+=alkupvboxi
            root.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                val vuokraaja= new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.returned(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "scooter" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root.children+=boxi
            boxi.children+=
              Label("Write in the exact format name, ownprice, brand, comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            val alkupvboxi=VBox()
            val alkupvinput=new TextField
            root.children+=alkupvboxi
            root.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= scooter(value.head,value(1).toInt,value(2),value(3))
                val vuokraaja= new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.returned(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "electricBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            val alkupvboxi=VBox()
            val alkupvinput=new TextField
            root.children+=alkupvboxi
            root.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                val vuokraaja= new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.returned(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    val situationbutton = Button("Situation")
    root.children+=situationbutton
    situationbutton.layoutX =810
    situationbutton.onAction = (event) =>
      stage.scene=situationscene
      val lebel=Label(manager.situation)
      situationroot.children+=lebel
      lebel.layoutY = 30
      lebel.font = Font(22)
      lebel.textFill = DarkGreen
      val exitbutton=Button("Back to main page")
      situationroot.children+=exitbutton
      exitbutton.onAction = (event) =>
        lebel.visible = false
        stage.scene = scene
      val calendar=new DatePicker(LocalDate.now)
      calendar.layoutX = 810
      calendar.layoutY=40

    val recordroot=Pane()
    var recordscene=Scene(parent=recordroot)
    val rentalrecordroot=Pane()
    var rentalrecordscene=Scene(parent=rentalrecordroot)
    val returnroot= Pane()
    var returnscene=Scene(parent=returnroot)
    val kirjanpitoButton= Button("Record")
    val reservationroot=Pane()
    var reservationscen = Scene(parent=reservationroot)
    root.children+=kirjanpitoButton
    kirjanpitoButton.layoutX = 890
    kirjanpitoButton.onAction = (event) =>
      stage.scene=recordscene
      val goback=Button("Back to main page")
      recordroot.children+=goback
      goback.onAction=(event)=>
          stage.scene = scene
      val butt=Button("Rental record")
      recordroot.children+=butt
      butt.layoutX=130
      butt.onAction= (event) =>
        var layou=20
        stage.scene=rentalrecordscene
        val goback=Button("Back to main page")
        rentalrecordroot.children += goback
        goback.onAction=(event)=>
          stage.scene = scene
        manager.kirjanPito.foreach(a =>
          val labb=Label(s"$a")
          rentalrecordroot.children+=labb
          labb.layoutY=layou
          labb.font=Font(20)
          labb.textFill=Red
          scrolli(rentalrecordroot,labb)
          layou+=57)
      val reserve=Button("Resevation Record")
      recordroot.children+=reserve
      reserve.layoutX = 300
      reserve.onAction=(event)=>
        var numero=20
        stage.scene=reservationscen
        val goback=Button("Back to main page")
        reservationroot.children += goback
        goback.onAction=(event)=>
          stage.scene = scene
        manager.reservations.foreach(b =>
          val labbi=Label(s"$b")
          reservationroot.children+=labbi
          labbi.layoutY=numero
          labbi.font=Font(20)
          labbi.textFill=Red
          scrolli(reservationroot,labbi)
          numero+=25)

     val returna=Button("Return Record")
      recordroot.children+=returna
      returna.layoutX = 500
      returna.onAction=(event)=>
        var nummer=20
        stage.scene=returnscene
        val goback = Button("Back to main page")
        goback.onAction= (event) =>
          stage.scene = scene
        returnroot.children += goback
        manager.returnrecord.foreach(c =>
          val labbii=Label(s"$c")
          returnroot.children+=labbii
          labbii.layoutY=nummer
          labbii.font=Font(20)
          labbii.textFill=Red
          scrolli(returnroot,labbii)
          nummer+=25)



    val root2=Pane()
    var skene=Scene(parent=root2)
    val accountingbutton= Button("Accounting")
    root.children+=accountingbutton
    val backbutton=Button("Back")
    root2.children+=backbutton
    backbutton.layoutY = 50
    backbutton.onAction=(event)=>stage.scene = scene
    accountingbutton.layoutY = 290
    accountingbutton.onAction = (event) =>
      stage.scene=skene


    val mostrentedroot=Pane()
    var mostrentedscene=Scene(parent=mostrentedroot)
    val popular=Button("Most rented products")
    root2.children+=popular
    popular.onAction = (event) =>
      try
       stage.scene= mostrentedscene
       var mostrented= Map[Bikes,Int]()
       def addNewBike (pyora: Bikes, kappale:Int):Unit=
         if mostrented.contains(pyora) then mostrented.put(pyora,mostrented.get(pyora).get + kappale) else mostrented+= pyora -> kappale
       for transaction <- manager.kirjanPito do
         addNewBike(transaction.tavarat,transaction.kappale)
       val sorted = mostrented.toSeq.sortBy((k, v) => v).reverse
       var piedata= FXCollections.observableArrayList[PieChart.Data]()
       for pyora <- sorted.toMap do
         piedata.add(new Data(s"${pyora._1} (${pyora._2} times)",pyora._2))
       val cumlab=Label(s"Most rented products :")
       val pie=new PieChart(piedata)
       pie.setLabelsVisible(false)
       scrollit(mostrentedroot,pie)
       pie.layoutX = 300
       pie.layoutY=120
       mostrentedroot.children+=pie
       mostrentedroot.children+=cumlab
       cumlab.layoutY=28
       cumlab.textFill=Purple
       cumlab.font=Font(24)
       val backback=Button("Go to previous page")
       backback.onAction=(event)=>
         stage.scene=skene
         cumlab.visible=false
         pie.visible=false

       mostrentedroot.children+=backback

      catch
        case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
        case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    val profitproducts= Button("Profiting Products")
    profitproducts.layoutX = 150
    root2.children+=profitproducts
    profitproducts.onAction = (event) =>
      stage.scene = mostrentedscene
      var mostselling= Map[Bikes,Int]()
      def addNewBike (pyora: Bikes, kappale:Int):Unit=
        if mostselling.contains(pyora) then mostselling.put(pyora,mostselling.get(pyora).get + kappale) else mostselling+= pyora -> kappale
      for transaction <- manager.kirjanPito do
        addNewBike(transaction.tavarat,transaction.rentalcost)
      val sorted = mostselling.toSeq.sortBy((k, v) => v).reverse
      var piedata= FXCollections.observableArrayList[PieChart.Data]()
       for pyora <- sorted.toMap do
         piedata.add(new Data(s"${pyora._1} (${pyora._2} euros)",pyora._2))
       val cumlab=Label(s"Most sold bikes :")
       val pie=new PieChart(piedata)
       pie.layoutX = 300
       pie.layoutY=120
       scrollit(mostrentedroot,pie)
       pie.setLabelsVisible(false)
       mostrentedroot.children+=pie
       mostrentedroot.children+=cumlab
       cumlab.layoutY=28
       cumlab.textFill=Purple
       cumlab.font=Font(24)
       val backback=Button("Go to previous page")
       backback.onAction=(event)=>
         stage.scene=skene
         cumlab.visible=false
         pie.visible=false
       mostrentedroot.children+=backback


    val expenseroot=Pane()
    var expensescene=Scene(parent=expenseroot)
    val expences=Button("Expenses of a bike")
    expences.layoutX = 280
    root2.children+=expences
    expences.onAction =(event) =>
      val valikoima= new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
      valikoima.layoutX = 280
      valikoima.layoutY = 30
      root2.children+=valikoima
      val bak=Button("Back")
      bak.layoutX = 280
      bak.layoutY = 70
      root2.children+=bak
      bak.onAction =(event) =>
        valikoima.visible = false
        bak.visible = false
      valikoima.onAction = (event) =>
        valikoima.value.apply() match
          case "mountainBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write name,wheelsize,gears,comment, ownprice")
            boxi.children+=tekstiinput
            boxi.layoutX = 280
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 310
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 310
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                val arvo=tekstiinput.text.value.split(",")
                def expensesforaAbike(pyora:Bikes) =
                  val samapyora=manager.kirjanPito.filter(_.tavarat.equals(pyora))
                  var income=0
                  for bike <- samapyora do
                    income+=bike.tavarat.ownprice*bike.kappale
                  for i <- manager.bikesinGarage do
                    income+=i._1.ownprice*i._2
                  income
                stage.scene = expensescene
                val rivi=Label(s"Overall expenses for this bike is ${expensesforaAbike(mountainBike(arvo(0),arvo(1).toInt,arvo(2).toInt,arvo(3),arvo(4).toInt))}")
                val taku=Button("Go to previous page")
                expenseroot.children+=taku
                expenseroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "cityBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 280
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 310
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 310
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                def expensesforaAbike(pyora:Bikes) =
                  val samapyora=manager.kirjanPito.filter(_.tavarat.equals(pyora))
                  var income=0
                  for bike <- samapyora do
                    income+=bike.tavarat.ownprice*bike.kappale
                  for i <- manager.bikesinGarage do
                    income+=i._1.ownprice*i._2
                  income
                val value=tekstiinput.text.value.split(",")
                val bike=cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                stage.scene = expensescene
                val rivi=Label(s"Overall expenses for this bike is ${expensesforaAbike(bike)} euros")
                val taku=Button("Go to previous page")
                expenseroot.children+=taku
                expenseroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "motorcycle" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 280
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 310
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 310
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                def expensesforaAbike(pyora:Bikes) =
                  val samapyora=manager.kirjanPito.filter(_.tavarat.equals(pyora))
                  var income=0
                  for bike <- samapyora do
                    income+=bike.tavarat.ownprice*bike.kappale
                  for i <- manager.bikesinGarage do
                    income+=i._1.ownprice*i._2
                  income
                val value=tekstiinput.text.value.split(",")
                val bike=motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                stage.scene = expensescene
                val rivi=Label(s"Overall expenses for this bike is ${expensesforaAbike(bike)} euros")
                val taku=Button("Go to previous page")
                expenseroot.children+=taku
                expenseroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "scooter" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("write in the exact format name, ownprice, brand, comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 280
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 310
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 310
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                def expensesforaAbike(pyora:Bikes) =
                  val samapyora=manager.kirjanPito.filter(_.tavarat.equals(pyora))
                  var income=0
                  for bike <- samapyora do
                    income+=bike.tavarat.ownprice*bike.kappale
                  for i <- manager.bikesinGarage do
                    income+=i._1.ownprice*i._2
                  income
                val value=tekstiinput.text.value.split(",")
                val bike=scooter(value.head,value(1).toInt,value(2),value(3))
                stage.scene = expensescene
                val rivi=Label(s"Overall expenses for this bike is ${expensesforaAbike(bike)} euros")
                val taku=Button("Go to previous page")
                expenseroot.children+=taku
                expenseroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "electricBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 280
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 310
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 310
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                def expensesforaAbike(pyora:Bikes) =
                  val samapyora=manager.kirjanPito.filter(_.tavarat.equals(pyora))
                  var income=0
                  for bike <- samapyora do
                    income+=bike.tavarat.ownprice*bike.kappale
                  for i <- manager.bikesinGarage do
                    income+=i._1.ownprice*i._2
                  income
                val value=tekstiinput.text.value.split(",")
                val bike=electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                stage.scene = expensescene
                val rivi=Label(s"Overall expenses for this bike is ${expensesforaAbike(bike)} euros")
                val taku=Button("Go to previous page")
                expenseroot.children+=taku
                expenseroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")


    def incomefromabike(itemi:Bikes)=
      val samapyora=manager.kirjanPito.filter(_.tavarat.equals(itemi))
      var income=0
      for pyora <-samapyora do
        income+=pyora.rentalcost
      income

    val incomeroot=Pane()
    var incomescene= Scene(parent=incomeroot)
    val income=Button("Income from a bike")
    income.layoutX = 420
    root2.children+=income
    income.onAction =(event) =>
      val valikoima= new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
      valikoima.layoutX = 350
      valikoima.layoutY = 30
      root2.children+=valikoima
      val bak=Button("Back")
      bak.layoutX = 350
      bak.layoutY = 70
      root2.children+=bak
      bak.onAction =(event) =>
        valikoima.visible = false
        bak.visible = false
      valikoima.onAction = (event) =>
        valikoima.value.apply() match
          case "mountainBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write name,wheelsize,gears,comment, ownprice")
            boxi.children+=tekstiinput
            boxi.layoutX = 350
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 380
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 380
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                val arvo=tekstiinput.text.value.split(",")
                stage.scene = incomescene
                val rivi=Label(s"Overall income from this bike is ${incomefromabike(mountainBike(arvo(0),arvo(1).toInt,arvo(2).toInt,arvo(3),arvo(4).toInt))} euros")
                val taku=Button("Go to previous page")
                incomeroot.children+=taku
                incomeroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "cityBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 350
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 380
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 380
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                val value=tekstiinput.text.value.split(",")
                val bike=cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                stage.scene = incomescene
                val rivi=Label(s"Overall income from this bike is ${incomefromabike(bike)} euros")
                val taku=Button("Go to previous page")
                incomeroot.children+=taku
                incomeroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "motorcycle" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 350
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 380
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 380
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                val value=tekstiinput.text.value.split(",")
                val bike=motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                stage.scene = incomescene
                val rivi=Label(s"Overall income from this bike is ${incomefromabike(bike)} euros")
                val taku=Button("Go to previous page")
                incomeroot.children+=taku
                incomeroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "scooter" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("write in the exact format name, ownprice, brand, comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 350
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 380
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 380
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                val value=tekstiinput.text.value.split(",")
                val bike=scooter(value.head,value(1).toInt,value(2),value(3))
                stage.scene = incomescene
                val rivi=Label(s"Overall income from this bike is ${incomefromabike(bike)} euros")
                val taku=Button("Go to previous page")
                incomeroot.children+=taku
                incomeroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "electricBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root2.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
            boxi.children+=tekstiinput
            boxi.layoutX = 350
            boxi.layoutY = 110
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 380
            back.layoutY = 195
            root2.children+=nappi
            root2.children+=back
            nappi.layoutX = 380
            nappi.layoutY = 160
            back.onAction =(event) =>
              boxi.visible = false
              tekstiinput.visible = false
              back.visible = false
              nappi.visible = false
            nappi.onAction =(event)=>
              try
                val value=tekstiinput.text.value.split(",")
                val bike=electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                stage.scene = incomescene
                val rivi=Label(s"Overall income from this bike is ${incomefromabike(bike)} euros")
                val taku=Button("Go to previous page")
                incomeroot.children+=taku
                incomeroot.children+=rivi
                rivi.layoutY = 30
                rivi.font=Font(25)
                rivi.textFill=Blue
                taku.onAction = (event) =>
                  rivi.visible=false
                  stage.scene=skene
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                valikoima.visible = false
                bak.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")


    val addcom= Button("Edit comment of a bike")
    addcom.layoutX = 960
    root.children+=addcom
    addcom.onAction=(event) =>
      val komb=new ComboBox(List("mountainbike","citybike","motorcycle","scooter","electricbike"))
      komb.layoutX = 940
      komb.layoutY = 50
      root.children+=komb
      val taakse=Button("Back")
      taakse.layoutX = 940
      taakse.layoutY = 80
      root.children+=taakse
      taakse.onAction =(event) =>
        komb.visible = false
        taakse.visible = false
      komb.onAction = (event) =>
        komb.value.apply() match
          case "mountainbike" =>
            try
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write name,wheelsize,gears,comment, ownprice")
              boxi.children+=tekstiinput
              boxi.layoutX = 900
              boxi.layoutY = 110
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 940
              back.layoutY = 235
              root.children+=nappi
              root.children+=back
              nappi.layoutX = 920
              nappi.layoutY = 200
              val toine=VBox()
              val toieninput=new TextField
              root.children+=toine
              toine.children+=Label("Write the comment you want to add")
              toine.children+=toieninput
              toine.layoutX=900
              toine.layoutY = 150
              back.onAction =(event) =>
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                toine.visible = false
              nappi.onAction =(event)=>
                val value=tekstiinput.text.value.split(",")
                val bike=mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt)
                println(manager.commentadder(mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt),toieninput.text.value))
                println(bike.addcomment)
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                back.visible = false
                nappi.visible = false
                komb.visible = false
                taakse.visible = false
                toine.visible = false
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "citybike" =>
            try
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
              boxi.children+=tekstiinput
              boxi.layoutX = 900
              boxi.layoutY = 110
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 940
              back.layoutY = 235
              root.children+=nappi
              root.children+=back
              nappi.layoutX = 920
              nappi.layoutY = 200
              val toine=VBox()
              val toieninput=new TextField
              root.children+=toine
              toine.children+=Label("Write the comment you want to add")
              toine.children+=toieninput
              toine.layoutX=900
              toine.layoutY = 150
              back.onAction =(event) =>
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                toine.visible = false
              nappi.onAction =(event)=>
                val value=tekstiinput.text.value.split(",")
                val bike=cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                println(manager.commentadder(bike,toieninput.text.value))
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                komb.visible = false
                taakse.visible = false
                toine.visible = false
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")


          case "motorcycle" =>
            try
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
              boxi.children+=tekstiinput
              boxi.layoutX = 900
              boxi.layoutY = 110
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 940
              back.layoutY = 235
              root.children+=nappi
              root.children+=back
              nappi.layoutX = 920
              nappi.layoutY = 200
              val toine=VBox()
              val toieninput=new TextField
              root.children+=toine
              toine.children+=Label("Write the comment you want to add")
              toine.children+=toieninput
              toine.layoutX=900
              toine.layoutY = 150
              back.onAction =(event) =>
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                toine.visible = false
              nappi.onAction =(event)=>
                val value=tekstiinput.text.value.split(",")
                val bike=motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                println(manager.commentadder(bike,toieninput.text.value))
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                komb.visible = false
                taakse.visible = false
                toine.visible = false
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")


          case "scooter" =>
            try
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("write in the exact format name, ownprice, brand, comment")
              boxi.children+=tekstiinput
              boxi.layoutX = 900
              boxi.layoutY = 110
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 940
              back.layoutY = 235
              root.children+=nappi
              root.children+=back
              nappi.layoutX = 920
              nappi.layoutY = 200
              val toine=VBox()
              val toieninput=new TextField
              root.children+=toine
              toine.children+=Label("Write the comment you want to add")
              toine.children+=toieninput
              toine.layoutX=900
              toine.layoutY = 150
              back.onAction =(event) =>
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                toine.visible = false
              nappi.onAction =(event)=>
                val value=tekstiinput.text.value.split(",")
                val bike=scooter(value.head,value(1).toInt,value(2),value(3))
                println(manager.commentadder(bike,toieninput.text.value))
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                komb.visible = false
                taakse.visible = false
                toine.visible = false
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")


          case "electricbike" =>
            try
              val boxi=VBox()
              val tekstiinput= new TextField
              root.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
              boxi.children+=tekstiinput
              boxi.layoutX = 900
              boxi.layoutY = 110
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 940
              back.layoutY = 235
              root.children+=nappi
              root.children+=back
              nappi.layoutX = 920
              nappi.layoutY = 200
              val toine=VBox()
              val toieninput=new TextField
              root.children+=toine
              toine.children+=Label("Write the comment you want to add")
              toine.children+=toieninput
              toine.layoutX=900
              toine.layoutY = 150
              back.onAction =(event) =>
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                toine.visible = false
              nappi.onAction =(event)=>
                val value=tekstiinput.text.value.split(",")
                val bike=electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                println(manager.commentadder(bike,toieninput.text.value))
                boxi.visible = false
                tekstiinput.visible = false
                back.visible = false
                nappi.visible = false
                komb.visible = false
                taakse.visible = false
                toine.visible = false
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    val checkincomeroot=Pane()
    var checkincomscene=Scene(parent=checkincomeroot)
    val aikavalichecker = Button("Check income for a period of time")
    aikavalichecker.layoutX= 570
    root2.children+=aikavalichecker
    aikavalichecker.onAction= (event) =>
      val alkupvboxi=VBox()
      root2.children+=alkupvboxi
      alkupvboxi.children+=Label("Put the starting date")
      alkupvboxi.layoutX = 570
      alkupvboxi.layoutY=60
      val kalenteri= new DatePicker((LocalDate.now))
      root2.children+=kalenteri
      kalenteri.setLayoutX(570.0)
      kalenteri.setLayoutY(80.0)
      val alkukloboxi=VBox()
      val alkukloinput=new TextField
      root2.children+=alkukloboxi
      alkukloboxi.children+=Label("Put the starting time Hour:Minute")
      alkukloboxi.children+=alkukloinput
      alkukloboxi.layoutX = 570
      alkukloboxi.layoutY=120
      val loppupvbox=VBox()
      root2.children+=loppupvbox
      loppupvbox.children+=Label("Put the ending date of the rental")
      loppupvbox.layoutX = 570
      loppupvbox.layoutY=170
      val toinekalenteri= new DatePicker(LocalDate.now)
      root2.children+=toinekalenteri
      toinekalenteri.setLayoutX(570.0)
      toinekalenteri.setLayoutY(200.0)
      val loppuklobox=VBox()
      val loppukloinput=new TextField
      root2.children+=loppuklobox
      loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
      loppuklobox.children+=loppukloinput
      loppuklobox.layoutX = 570
      loppuklobox.layoutY=240
      val enterbutt=Button("Enter")
      root2.children+=enterbutt
      enterbutt.layoutX=570
      enterbutt.layoutY=280
      val backbutt=Button("Back")
      root2.children+=backbutt
      backbutt.layoutX=570
      backbutt.layoutY=320
      enterbutt.onAction= (event) =>
        stage.scene=checkincomscene
        val undo=Button("Go back")
        checkincomeroot.children+=undo
        var numero=20
        var tesk="Results:\n"
        for stringi <- manager.tarkistaikavali(kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt , alkukloinput.text.value.split(":")(1).toInt) , toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)) do
          tesk += stringi
        var luv=Label(tesk)
        luv.layoutY = 30
        luv.font = Font(20)
        luv.textFill = Blue
        checkincomeroot.children+=luv
        scrolli(checkincomeroot,luv)
        undo.onAction= (event) =>
          stage.scene=skene
          luv.visible = false
        alkukloboxi.visible = false
        alkukloinput.visible = false
        enterbutt.visible = false
        loppuklobox.visible = false
        kalenteri.visible = false
        toinekalenteri.visible=false
        alkupvboxi.visible = false
        loppupvbox.visible = false
      backbutt.onAction = (event) =>
        alkupvboxi.visible = false
        loppupvbox.visible = false
        alkukloboxi.visible = false
        alkukloinput.visible = false
        enterbutt.visible = false
        loppuklobox.visible = false
        kalenteri.visible = false
        toinekalenteri.visible=false
        backbutt.visible = false

    val renterroot=Pane()
    var renterscene=Scene(parent=renterroot)
    val boxi=VBox()
    val root3=Pane()
    var skeenee=Scene(parent=root3)
    val renterinfobutton= Button("View renter's info")
    root.children+=renterinfobutton
    renterinfobutton.layoutX =1120
    renterinfobutton.onAction = (event) =>
      stage.scene=skeenee
      val boxiinput=new TextField
      root3.children+=boxi
      boxi.children+=Label("Write the renter's name,contactinfo")
      root3.children+=boxiinput
      boxi.children+=boxiinput
      boxi.layoutX=50
      boxi.layoutY = 100
      val syota= Button("Enter")
      syota.layoutX=50
      syota.layoutY = 145
      root3.children+=syota
      val takan= Button("Back")
      takan.layoutX = 50
      takan.layoutY = 170
      takan.onAction = (event) =>
        takan.visible = false
        boxi.visible = false
        boxiinput.visible = false
        syota.visible = false
      syota.onAction = (event) =>
        stage.scene=renterscene
        val rentterii=new Renter(boxiinput.text.value.split(",")(0),boxiinput.text.value.split(",")(1).toInt)
        if manager.rentersandrenteditems.contains(rentterii) || manager.reserversandreserveditems.contains(rentterii)
        then
          val lavl= Label(s"The name of the renter is ${rentterii.name} and contact info is ${rentterii.contact}.\nRenter's rented items are ${manager.rentersandrenteditems.get(rentterii)}.\nRenter's reserved items are ${manager.reserversandreserveditems.get(rentterii)}.\nComments attached to the renter : ${manager.getrenter(rentterii).comment}")
          renterroot.children+=lavl
          lavl.layoutY=40
          lavl.textFill = Blue
          lavl.font =Font(30)
          scrolli(renterroot,lavl)
          val bakom=Button("Go back")
          renterroot.children+=bakom
          bakom.onAction=(event) =>
            lavl.visible = false
            stage.scene = skeenee
            bakom.visible = false
        else
          val la=Label("This renter is not in your list")
          renterroot.children+=la
          la.layoutY=40
          val omback=Button("Back")
          renterroot.children+=omback
          scrolli(renterroot,la)
          omback.onAction=(event) =>
            la.visible = false
            stage.scene = skeenee
            omback.visible=false
          la.textFill = Blue
          la.font =Font(30)

    val kommentti= Button("Edit comment")
    root3.children+=kommentti
    kommentti.layoutX = 250
    kommentti.layoutY = 110
    kommentti.onAction =(event) =>
      val boxi=VBox()
      val boxiinput=new TextField
      root3.children+=boxi
      boxi.children+=Label("Write the renter's name,contactinfo")
      boxi.children+=boxiinput
      boxi.layoutX=300
      boxi.layoutY = 150
      val kirjota=VBox()
      val kirjotapu=new TextField
      kirjota.layoutX = 300
      kirjota.layoutY = 190
      kirjota.children+=Label("Write the comment here")
      kirjota.children+=kirjotapu
      root3.children+=kirjota
      val toineenter=Button("Enter")
      val toinebakki=Button("Back")
      root3.children+=toineenter
      root3.children+=toinebakki
      toineenter.layoutX = 300
      toineenter.layoutY = 230
      toinebakki.layoutX =300
      toinebakki.layoutY = 270
      toineenter.onAction= (event) =>
        val ar=boxiinput.text.value.split(",")
        val vuokra=new Renter(ar.head,ar(1).toInt)
        manager.rentercommentadder(vuokra,kirjotapu.text.value)
        boxi.visible = false
        boxiinput.visible = false
        kirjotapu.visible = false
        kirjota.visible = false
        toineenter.visible = false
        toinebakki.visible = false
      toinebakki.onAction =(event)=>
        boxi.visible = false
        boxiinput.visible = false
        kirjotapu.visible = false
        kirjota.visible = false
        toineenter.visible = false
        toinebakki.visible = false

    val camoonn= Button("Back to Maha rental")
    root3.children+=camoonn
    camoonn.layoutY = 300
    camoonn.onAction=(event) =>
      stage.scene = scene


    val root4=Pane()
    var suomiskene=Scene(parent=root4)
    val reservi = Button("Reservations")
    root.children+=reservi
    reservi.layoutY = 330
    reservi.onAction = (event) =>
      stage.scene = suomiskene



    val reservbutton=Button("Add reservation")
    root4.children+=reservbutton
    reservbutton.layoutX = 400

    reservbutton.onAction = (event) =>
        val bikebox= new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
        bikebox.layoutY = 40
        root4.children+=bikebox
        val bakkii=Button("Back")
        root4.children+=bakkii
        bakkii.layoutY=70
        bakkii.onAction=(event)=>
          bikebox.visible  =false
          bakkii.visible = false
        bikebox.onAction = (event) =>
          bikebox.value.apply() match
            case "mountainBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root4.children+=boxi
              boxi.children+=
                Label("Write name,wheelsize,gears,comment, ownprice")
              boxi.children+=tekstiinput
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              root4.children+=back
              back.layoutX = 105
              back.layoutY = 510
              root4.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root4.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root4.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root4.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val kalenteri= new DatePicker((LocalDate.now))
              root4.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root4.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root4.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root4.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root4.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                toinekalenteri.visible=false
                kalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt)
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.reservation(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "cityBike"=>
              val boxi=VBox()
              val tekstiinput= new TextField
              root4.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root4.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root4.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root4.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root4.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              val kalenteri= new DatePicker((LocalDate.now))
              root4.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root4.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root4.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root4.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root4.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root4.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.reservation(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "motorcycle" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root4.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root4.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root4.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root4.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root4.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val kalenteri= new DatePicker((LocalDate.now))
              root4.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root4.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root4.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              val toinekalenteri= new DatePicker(LocalDate.now)
              root4.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root4.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root4.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.reservation(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "scooter"=>
              val boxi=VBox()
              val tekstiinput= new TextField
              root4.children+=boxi
              boxi.children+=
                Label("Write in the exact format name, ownprice, brand, comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root4.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root4.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root4.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root4.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              val kalenteri= new DatePicker((LocalDate.now))
              root4.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root4.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root4.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root4.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root4.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root4.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=scooter(value.head,value(1).toInt,value(2),value(3))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.reservation(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")
            case "electricBike" =>
              val boxi=VBox()
              val tekstiinput= new TextField
              root4.children+=boxi
              boxi.children+=
                Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
              boxi.children+=tekstiinput
              tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
              boxi.layoutX = 100
              boxi.layoutY = 100
              val nappi=Button("Enter")
              val back= Button("Back")
              back.layoutX = 105
              back.layoutY = 510
              root4.children+=nappi
              nappi.layoutX = 105
              nappi.layoutY = 480
              val renterbox= VBox()
              val renterinput= new TextField
              root4.children+=renterbox
              renterbox.children+= Label("Write the renter's name and contact info")
              renterbox.children+=renterinput
              renterbox.layoutX = 105
              renterbox.layoutY = 168
              val amountbox=VBox()
              val amountteksti=new TextField
              root4.children+=amountbox
              amountbox.children+=Label("Put the amount of bikes you want to add")
              amountbox.children+=amountteksti
              amountbox.layoutX=105
              amountbox.layoutY=230
              val alkupvboxi=VBox()
              root4.children+=alkupvboxi
              alkupvboxi.children+=Label("Put the starting date of the rental")
              val kalenteri= new DatePicker((LocalDate.now))
              root4.children+=kalenteri
              kalenteri.setLayoutX(105.0)
              kalenteri.setLayoutY(300.0)
              alkupvboxi.layoutX = 105
              alkupvboxi.layoutY=280
              val alkukloboxi=VBox()
              val alkukloinput=new TextField
              root4.children+=alkukloboxi
              alkukloboxi.children+=Label("Put the starting time of the rental in format Hour:Minute")
              alkukloboxi.children+=alkukloinput
              alkukloboxi.layoutX = 105
              alkukloboxi.layoutY=330
              val loppupvbox=VBox()
              root4.children+=loppupvbox
              loppupvbox.children+=Label("Put the ending date of the rental")
              loppupvbox.layoutX = 105
              loppupvbox.layoutY=380
              val toinekalenteri= new DatePicker(LocalDate.now)
              root4.children+=toinekalenteri
              toinekalenteri.setLayoutX(105.0)
              toinekalenteri.setLayoutY(400.0)
              val loppuklobox=VBox()
              val loppukloinput=new TextField
              root4.children+=loppuklobox
              loppuklobox.children+=Label("Put the ending time of the rental in format Hour:Minute")
              loppuklobox.children+=loppukloinput
              loppuklobox.layoutX = 105
              loppuklobox.layoutY=430
              root4.children+=back
              back.onAction= (event)=>
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                alkupvboxi.visible=false
                alkukloboxi.visible = false
                loppupvbox.visible = false
                loppuklobox.visible=false
                nappi.visible = false
                bikebox.visible = false
                kalenteri.visible=false
                toinekalenteri.visible=false

              nappi.onAction = (event) =>
                try
                  val value=tekstiinput.text.value.split(",")
                  val bike=electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                  val vuokraaja=new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                  val kappale=amountteksti.text.value.toInt
                  val alkupv=kalenteri.getValue.atTime(alkukloinput.text.value.split(":")(0).toInt,alkukloinput.text.value.split(":")(1).toInt)
                  val loppupv=toinekalenteri.getValue.atTime(loppukloinput.text.value.split(":")(0).toInt,loppukloinput.text.value.split(":")(1).toInt)
                  manager.reservation(bike,vuokraaja,kappale,alkupv,loppupv)
                  boxi.visible = false
                  back.visible=false
                  renterbox.visible=false
                  amountbox.visible=false
                  alkupvboxi.visible=false
                  alkukloboxi.visible = false
                  loppupvbox.visible = false
                  loppuklobox.visible=false
                  nappi.visible = false
                  bikebox.visible = false
                  kalenteri.visible=false
                  toinekalenteri.visible=false
                catch
                  case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                  case b:NumberFormatException => throw Exception("put the numbers where it is asked")



    val bakbak=Button("Back to Maha rental Manager")
    root4.children+=bakbak
    bakbak.layoutY =600
    bakbak.onAction =(event)=>
      stage.scene=scene


    val cancel=Button("Cancel reservation")
    root4.children+=cancel
    cancel.layoutX = 700
    cancel.onAction=(event) =>
     val bikebox= new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
      bikebox.layoutY = 40
      root4.children+=bikebox
      val bakkii=Button("Back")
      root4.children+=bakkii
      bakkii.layoutY=70
      bakkii.onAction=(event)=>
        bikebox.visible  =false
        bakkii.visible = false
      bikebox.onAction = (event) =>
        bikebox.value.apply() match
          case "mountainBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root4.children+=boxi
            boxi.children+=
              Label("Write name,wheelsize,gears,comment, ownprice")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root4.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root4.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root4.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            root4.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= mountainBike(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt)
                val vuokraaja= Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.cancelReservation(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "cityBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root4.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root4.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root4.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root4.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            root4.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= cityBike(value.head,value(1).toInt,value(2),value(3).toInt,value(4))
                val vuokraaja= Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.cancelReservation(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")




          case "motorcycle" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root4.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root4.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root4.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root4.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            val alkupvboxi=VBox()
            val alkupvinput=new TextField
            root4.children+=alkupvboxi
            root4.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= motorCycles(value.head,value(1).toInt,value(2).toInt,value(3),value(4).toInt,value(5))
                val vuokraaja= new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.cancelReservation(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "scooter" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root4.children+=boxi
            boxi.children+=
              Label("Write in the exact format name, ownprice, brand, comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root4.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root4.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root4.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            val alkupvboxi=VBox()
            val alkupvinput=new TextField
            root4.children+=alkupvboxi
            root4.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= scooter(value.head,value(1).toInt,value(2),value(3))
                val vuokraaja= new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.cancelReservation(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")

          case "electricBike" =>
            val boxi=VBox()
            val tekstiinput= new TextField
            root4.children+=boxi
            boxi.children+=
              Label("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
            boxi.children+=tekstiinput
            tekstiinput.onAction = (event)=> println(tekstiinput.text.value)
            boxi.layoutX = 100
            boxi.layoutY = 100
            val nappi=Button("Enter")
            val back= Button("Back")
            back.layoutX = 105
            back.layoutY = 430
            root4.children+=nappi
            nappi.layoutX = 105
            nappi.layoutY = 400
            val renterbox= VBox()
            val renterinput= new TextField
            root4.children+=renterbox
            renterbox.children+= Label("Write the renter's name and contact info")
            renterbox.children+=renterinput
            renterbox.layoutX = 105
            renterbox.layoutY = 168
            val amountbox=VBox()
            val amountteksti=new TextField
            root4.children+=amountbox
            amountbox.children+=Label("Put the amount of bikes you want to add")
            amountbox.children+=amountteksti
            amountbox.layoutX=105
            amountbox.layoutY=230
            val alkupvboxi=VBox()
            val alkupvinput=new TextField
            root4.children+=alkupvboxi
            root4.children+=back
            back.onAction=(event) =>
              boxi.visible = false
              renterbox.visible = false
              amountbox.visible = false
              nappi.visible=false
              back.visible=false
            nappi.onAction = (event) =>
              try
                val value=tekstiinput.text.value.split(",")
                val bike= electricBikes(value.head,value(1).toInt,value(2).toInt,value(3).toInt,value(4))
                val vuokraaja= new Renter(renterinput.text.value.split(",")(0),renterinput.text.value.split(",")(1).toInt)
                val kappale=amountteksti.text.value.toInt
                manager.cancelReservation(bike,vuokraaja,kappale)
                boxi.visible = false
                back.visible=false
                renterbox.visible=false
                amountbox.visible=false
                nappi.visible = false
                bikebox.visible = false
              catch
                case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
                case b:NumberFormatException => throw Exception("put the numbers where it is asked")


    val reservescene=Pane()
    var ressu=Scene(parent=reservescene)
    val reservationcheck=Button("Renters and their Reservations")
    root4.children+=reservationcheck
    reservationcheck.layoutX = 50
    reservationcheck.onAction = (event) =>
      stage.scene = ressu
      var stringi=""
      for alkio<-manager.reserversandreserveditems do
        stringi+= s"${alkio._1.name},${alkio._1.contact} -> ${alkio._2}\n"
      val labeli=Label(stringi)
      reservescene.children+=labeli
      labeli.layoutX = 20
      labeli.layoutY = 30
      labeli.font = Font(18)
      labeli.textFill = IndianRed
      val takan=Button("Exit rentersandrenteditems")
      reservescene.children+=takan
      takan.onAction = (event) =>
        labeli.visible = false
        takan.visible = false
        stage.scene = scene


    val tallennus=Button("Save it")
    root.children+=tallennus
    tallennus.layoutY = 200
    tallennus.layoutX = 1200
    tallennus.onAction = (event) =>
      manager.tallenna()
      manager.savekaikkibikes
      manager.saverecords
      manager.savereservations
      manager.saveretun
      manager.savecomment
      manager.saverenterkom

    val loading= Button ("Load")
    root.children+=loading
    loading.layoutY = 230
    loading.layoutX =1200
    loading.onAction =(event) =>
      manager.lata
      manager.luo
      manager.loadrecord
      manager.loadreservation
      manager.loadreturn
      manager.loadcomments
      manager.loadrentercomment
      loading.setDisable(true)


    val addpicroot=Pane()
    var picscene= Scene(parent = addpicroot)

    def addkuvat(labelteksti:String)=
      val boxi=VBox()
      val tekstiinput= new TextField
      root.children+=boxi
      boxi.children+=
        Label(labelteksti)
      boxi.children+=tekstiinput
      boxi.layoutX = 280
      boxi.layoutY = 190
      val nappi=Button("Enter")
      val back= Button("Back")
      boxi.children+=nappi
      boxi.children+=back
      back.onAction=(event)=>
        nappi.visible = false
        back.visible=false
        boxi.visible=false
      nappi.onAction=(event)=>
          val value=tekstiinput.text.value.split(",")
          val bike= manager.bikeluoja(value)
          require(manager.bikesinGarage.contains(bike))
          stage.scene=picscene
          val choosepic=Button("Choose a picture from you files")
          val backagain=Button("Back to main page")
          addpicroot.children+=backagain
          backagain.onAction=(event) =>
            stage.scene = scene
          addpicroot.children+=choosepic
          choosepic.layoutX = 270
          choosepic.onAction = (event) =>
            val box=VBox()
            val teks=new TextField
            addpicroot.children+=teks
            teks.layoutX = 270
            teks.layoutY = 100
            box.children+=Label("Put the name of the file(Check the names by clicking the \"View Picture names\" button)")
            val enter=Button("Enter")
            val back=Button("Back")
            addpicroot.children+=enter
            addpicroot.children+=back
            enter.layoutX = 270
            enter.layoutY = 130
            back.layoutX=270
            back.layoutY = 160
            enter.onAction = (event) =>
              manager.getbike(bike).kuva=new Image(new FileInputStream(teks.text.value))
              box.visible = false
              teks.visible = false
              enter.visible = false
              back.visible = false
            back.onAction = (event) =>
              box.visible = false
              teks.visible = false
              enter.visible = false
              back.visible = false

          val choosepicweb=Button("Add a picture via link")
          addpicroot.children+=choosepicweb
          choosepicweb.layoutX = 500
          choosepicweb.onAction = (event) =>
            val box=VBox()
            val teks=new TextField
            addpicroot.children+=teks
            teks.layoutX = 500
            teks.layoutY = 100
            box.children+=Label("Put a link")
            val enter=Button("Enter")
            val back=Button("Back")
            addpicroot.children+=enter
            addpicroot.children+=back
            enter.layoutX = 500
            enter.layoutY = 130
            back.layoutX=500
            back.layoutY = 160
            enter.onAction = (event) =>
              manager.getbike(bike).kuva=new Image(teks.text.value)
              box.visible = false
              teks.visible = false
              enter.visible = false
              back.visible = false
            back.onAction = (event) =>
              box.visible = false
              teks.visible = false
              enter.visible = false
              back.visible = false



    val pic=Button("Add picture to a bike")
    root.children+=pic
    pic.layoutY=250
    pic.onAction = (event) =>
      val bokk = new ComboBox(List("mountainBike","cityBike","motorcycle","scooter","electricBike"))
      root.children+=bokk
      bokk.layoutY = 200
      bokk.layoutX = 150
      val bakkkkk=Button("Back")
      root.children+=bakkkkk
      bakkkkk.layoutX = 110
      bakkkkk.layoutY = 220
      bakkkkk.onAction= (Event) =>
        bokk.visible = false
        bakkkkk.visible = false
      val back=Button("Back")
      back.onAction = (event)=>
        bokk.visible = false
      bokk.onAction = (event) =>
        bokk.value.apply() match
          case "mountainBike" =>
            try
               val value="Write name,wheelsize,gears,comment, ownprice".split(",")
               addkuvat("Write name,wheelsize,gears,comment, ownprice")
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")
          case "cityBike" =>
            try
               addkuvat("Write in the exact format name,gearnumbers,Framematerial,ownprice,comment")
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")
          case "motorcycle" =>
            try
               addkuvat("Write in the exact format name,engineSizecubiCentimeters,horsepower,brand,ownprice,comment")
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")
          case "scooter" =>
            try
               addkuvat("write in the exact format name, ownprice, brand, comment")
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")
          case "electricBike" =>
            try
               addkuvat("Write in the exact format name,batteryRangeinKM,charginTime,ownprice,comment")
            catch
              case e:IndexOutOfBoundsException =>  throw Exception("put the inputs as aksed")
              case b:NumberFormatException => throw Exception("put the numbers where it is asked")

    var filenames = Buffer("bikes/citybike1.png","bikes/citybike2.jpg","bikes/mountain bike 1.jpg","bikes/mountainbike2.jpg","bikes/motorcycle1.jpg","bikes/motorcycle 2.jpg","bikes/elec2.png","bikes/electricbike1.jpg","bikes/scooter1.png","bikes/scooter2.webp")


    val view=Pane()
    var viewscene=Scene(parent=view)
    val files= Button("View Picture names")
    addpicroot.children+=files
    files.layoutX = 130
    files.onAction= (event) =>
      stage.scene = viewscene
      var lab=""
      for i <- filenames do
        lab+=s"$i\n"
      val back=Button("Back")
      scrolli(view,Label(lab))
      view.children+=back
      back.onAction = (event) =>
        stage.scene=picscene






















