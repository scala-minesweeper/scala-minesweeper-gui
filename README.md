# scala-minesweeper-gui

This is a scala swing project. The application is a user interface
for minesweeper game. It connects to a running minesweeper game with actor configuration.

## Running

The configuration for the connection to a running minesweeper core actor system
is located in ```src/main/resources/application.conf``` under

```
akka {
  ...
  minesweeper {
    systemName = "minesweeper-gui"
    controllerActor = "akka.tcp://minesweeper@127.0.0.1:5555/user/controller"
    publisherActor = "akka.tcp://minesweeper@127.0.0.1:5555/user/publisher"
  }
}
```

Run this using [sbt](http://www.scala-sbt.org/).

```
sbt run
```

The main class for running this application ist named ```GuiMinesweeperMain```.