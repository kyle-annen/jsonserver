package org.clojars.kyleannen.jsonserver

import org.clojars.kyleannen.javaserver.{ConfigureServer, Router}

import scala.util.Properties

object JsonServer {
  def start(): Unit = {
    val router = new Router()
    router.addRoute("POST", "/", new ControllerTicTacToeJSON)
    router.addRoute("GET", "/", new ControllerTicTacToeJSON)
    router.disableDirectoryRouting()
    router.disableFileRouting()
    val baseDirectory: String = System.getProperty("user.dir")
    val webDirectory: String = baseDirectory + "/"
    val port = Properties.envOrElse("PORT", "3434")
    val args: Array[String] = Array("-p", port, "-d", webDirectory)
    val gameServer = new ConfigureServer().configure(args, router)
    gameServer.run()
  }

  def main(args: Array[String]): Unit = {
    start()
  }
}
