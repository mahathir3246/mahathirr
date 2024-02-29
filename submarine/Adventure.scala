package o1.submarine

/** The class `Adventure` represents text adventure games. An adventure consists of a player and
  * a number of areas that make up the game world. It provides methods for playing the game one
  * turn at a time and for checking the state of the game.
  *
  * N.B. This version of the class has a lot of “hard-coded” information that pertains to a very
  * specific adventure game that involves a small trip through a twisted forest. All newly created
  * instances of class `Adventure` are identical to each other. To create other kinds of adventure
  * games, you will need to modify or replace the source code of this class. */
class Adventure:

  /** the name of the game */
  val title = "Project Submarine"

  

  private val crewcorner    = Area("Crew corner", "You are in the crew corner. This is where you chill and rest with the crew but now they're unconscious zzzzzzzzzz......")
  private val communicationAndControl = Area("Communication and control room", "You are in the Communication and control room THE C&C!!.\nYou control the submarine and communicate from this room.")
  private val engineRoom    = Area("Engine room", "You are in the engine room. VROOMM VROOMM!!\nThis room is a sensitive area and you have to be very careful with the engines.")
  private val storgae      = Area("Storage", "You are in the storage.\nThis room contains lots of spare parts and necessary tools :).")
  private val oxygen= Area("Oxygen room", "This controls the oxygen levels of the submarine.")

  private val ongelmaAlueet=Vector(communicationAndControl,engineRoom,oxygen)

  crewcorner.setNeighbors(Vector("left" -> communicationAndControl, "down" -> storgae))
  communicationAndControl.setNeighbors(Vector("up" -> engineRoom, "right" -> crewcorner))
  engineRoom.setNeighbors(Vector("down" -> communicationAndControl,"right"->oxygen))
  storgae.setNeighbors(Vector("up"-> crewcorner))
  oxygen.setNeighbors(Vector("left"->engineRoom))


  // TODO: Uncomment the two lines below. Improve the code so that it places the items in clearing and southForest, respectively.
  crewcorner.addItem(Item("screwdriver", "You will need it in the oxygen room",oxygen))
  storgae.addItem(Item("antenna", "It's used to communicate with the people in NASA and is missing form the communicationb room",communicationAndControl))
  communicationAndControl.addItem(Item("duct tape","You will need it in the engine room",engineRoom))





  /** The character that the player controls in the game. */
  val player = Player(crewcorner)

  /** The number of turns that have passed since the start of the game. */
  var turnCount = 0
  /** The maximum number of turns that this adventure game allows before time runs out. */
  val timeLimit = 20


  /** Determines if the adventure is complete, that is, if the player has won. */
  def isComplete =
    ongelmaAlueet(0).fullDescription.contains(" This room is fixed!") && ongelmaAlueet(1).fullDescription.contains(" This room is fixed!") && ongelmaAlueet(2).fullDescription.contains(" This room is fixed!")


  /** Determines whether the player has won, lost, or quit, thereby ending the game. */
  def isOver =this.isComplete || this.player.hasQuit || this.turnCount == this.timeLimit

  /** Returns a message that is to be displayed to the player at the beginning of the game. */
  def welcomeMessage = "Welcome to NASA's first ever water project. HURRAAYYY!!!! You are in a submarine with your crew. Due to the low oxygen levels the emergency alarm has gone off and your crew members are in need of medical assistance. They might die lol.\nThere is also no connection to the headquarters.\nFix the problems and hurry up before your homies are dead. Type help for more information."
  
  

  /** Returns a message that is to be displayed to the player at the end of the game. The message
    * will be different depending on whether or not the player has completed their quest. */
 
  
  def goodbyeMessage =
    if this.isComplete then
      "Yay you made it! Too bad your homies are passed out... A win is a win tho."
    else if this.turnCount == this.timeLimit then
      "Oh no! There's no time left. You die of panic."
    else  // game over due to player quitting
      "I knew you couldn't do it."


  /** Plays a turn by executing the given in-game command, such as “go west”. Returns a textual
    * report of what happened, or an error message if the command was unknown. In the latter
    * case, no turns elapse. */
  def playTurn(command: String) =
    val action = Action(command)
    val outcomeReport = action.execute(this.player)
    if outcomeReport.isDefined then
      this.turnCount += 1
    outcomeReport.getOrElse(s"Unknown command: \"$command\".")

end Adventure

