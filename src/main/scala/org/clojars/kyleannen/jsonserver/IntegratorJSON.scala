package org.clojars.kyleannen.jsonserver

import org.clojars.kyleannen.tictactoe.{Board, GameState, TicTacToeAPI}


object IntegratorJSON {

  def submitRound(json: String): String = {
    val jsonArray = json.substring(2, json.length-1).split(": |:|\",\"|\"").filter(_.nonEmpty)
    val jsonMap: Map[String, String] = Map(jsonArray(0) -> jsonArray(1), jsonArray(2) -> jsonArray(3))
    val receivedBoard: List[String] = jsonMap("board").split(",").toList
    val receivedMove = jsonMap("move")
    val initialGameState = generateGameState(receivedBoard, receivedMove)
    val resultGameState = TicTacToeAPI.playRound(initialGameState)
    this.buildResponseJson(resultGameState.board, resultGameState.messages)
  }

  def generateGameState(board: List[String], humanMove: String): GameState = {
    val validSubmission =
      humanMove.toInt > 0 &&
        humanMove.toInt < 10 &&
        board.length == 9 &&
        Board.returnValidInputs(board).contains(humanMove)

    new GameState(
      board = board,
      gameOver = false,
      messages = List(),
      humanMove = humanMove.toInt,
      computerMove = -1,
      humanToken = "X",
      computerToken = "O",
      gameOutcome = "none",
      gameWinner = "none",
      validSubmission = validSubmission,
      language = "EN")
  }

  def buildResponseJson(board: List[String], messages: List[String]): String = {
    val boardString = board.mkString(",")
    val messagesString = messages.map(x => "\"" + x + "\"").mkString(", ")

    "{ \"board\": \"" + boardString + "\", \"messages\": [" + messagesString + "]}"
  }
}
