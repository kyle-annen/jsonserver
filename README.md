# JSON TicTacToe Server 
[![Build Status](https://travis-ci.org/kyle-annen/jsonserver.svg?branch=master)](https://travis-ci.org/kyle-annen/jsonserver)
[![Coverage Status](https://coveralls.io/repos/github/kyle-annen/jsonserver/badge.svg?branch=coveralls)](https://coveralls.io/github/kyle-annen/jsonserver?branch=coveralls)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/445754ade8ca486897f910c5d145e825)](https://www.codacy.com/app/kyle-annen/jsonserver?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=kyle-annen/jsonserver&amp;utm_campaign=Badge_Grade)

A JSON TicTacToe server that provides a JSON API interface for a TicTacToe engine.

# Tests

To run tests:

```bash
sbt test
```

# Use the server

1. Clone repository.
2. Run the server
```bash
sbt run
```

# Deploy to Heroku

1. Clone repository
2. Set the heroku app name in `build.sbt`
3. Run the assembly deploy command to deploy a fat jar to heroku

```bash
sbt assembly deployHeroku
```

# Interfacing with JSON API

To interact with the JSON server, send a post request with the JSON in the body of the request.

The JSON requires two fields: `board` and `move`

Example:

```javascript
{
    "board": "1,2,3,4,5,6,7,8,9",
    "move": "1"
}
```

The response JSON contains the updated board, and messages to display.

Example Response:

```javascript
{
    "board": 
        "X,2,3,4,O,6,7,8,9",
    "messages": 
        [
            "Please select an open space.",
            "That space is not available."
        ]
}
      
```
