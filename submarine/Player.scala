package o1.submarine

import scala.collection.mutable.Map

/** A `Player` object represents a player character controlled by the real-life user
  * of the program.
  *
  * A player object’s state is mutable: the player’s location and possessions can change,
  * for instance.
  *
  * @param startingArea  the player’s initial location */
class Player(startingArea: Area):

  private var currentLocation = startingArea        // gatherer: changes in relation to the previous location
  private var quitCommandGiven = false
  private var items=Map[String,Item]()
  

  // one-way flag

  /** Determines if the player has indicated a desire to quit the game. */
  def hasQuit = this.quitCommandGiven

  def get(itemName: String): String =
    if this.location.contains(itemName) then
      val jotai = location.removeItem(itemName).get
      this.items.put(jotai.name,jotai)
      s"You pick up the $itemName."
    else
      s"There is no $itemName here to pick up."

  def drop(itemname:String):String=
    val remove=items.remove(itemname) 
    for esine <- remove do
      this.location.addItem(esine)
      
    if remove.isDefined then s"You drop the $itemname" else s"You don't have that"

  def help=
    "There are 3 problems to fix. The problems are in Communication and control room, Engine room and Oxygen room.\nYou can fix them by picking up items that are situated in different rooms. \nFind and get all the items and use them to fix the submarine.\nNew commands:\n use itemname: By using the correct item you fix a certain room.\n hint: Gives you a hint on what to use and where.\n where itemname: Tells you where a certain tool is situated assuming it isn't in your inventory already."


  def use(itemname:String):String=
    if this.has(itemname) && this.location==items(itemname).desiredLocation then
      this.location.problems = " This room is fixed!"
      s"You use $itemname.\nYay! You fixed the ${items(itemname).desiredLocation.name}"
    else
      s"You can't use it here"



  def examine(itemName: String): String=
    if items.contains(itemName) then
      s"You look closely at the: $itemName.\n${items(itemName).description}"
    else
      s"If you want to examine something, you need to pick it up first"

  def has(itemName:String):Boolean=
    items.contains(itemName)

  def hint=
    s"screwdriver is used in the Oxygen room.\nantenna is used in the Communication and control room.\nduct tape is used in the Engine room."


  def where(itemname:String)=
   if itemname=="screwdriver" then s"Crew corner"
   else if  itemname=="antenna" then s"Storage"
   else if itemname=="duct tape" then s"Communication and control room."
   else s"This item doesn't exist"


  def inventory:String=
    if this.items.isEmpty then
      s"You are empty-handed."
    else
      s"You are carrying:\n${this.items.keys.mkString("\n")}"


  /** Returns the player’s current location. */
  def location = this.currentLocation


  /** Attempts to move the player in the given direction. This is successful if there
    * is an exit from the player’s current location towards the direction name. Returns
    * a description of the result: "You go DIRECTION." or "You can't go DIRECTION." */
  def go(direction: String) =
    val destination = this.location.neighbor(direction)
    this.currentLocation = destination.getOrElse(this.currentLocation)
    if destination.isDefined then "You go " + direction + "." else "You can't go " + direction + "."


  /** Causes the player to rest for a short while (this has no substantial effect in game terms).
    * Returns a description of what happened. */
  def rest() =
    "You rest for a while. Better get a move on, though."


  /** Signals that the player wants to quit the game. Returns a description of what happened within
    * the game as a result (which is the empty string, in this case). */
  def quit() =
    this.quitCommandGiven = true
    ""

  /** Returns a brief description of the player’s state, for debugging purposes. */
  override def toString = "Now at: " + this.location.name

end Player

