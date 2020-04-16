# Beecon
## Add a position in the app
You just have to send a **POST** Request to the API via the following URL `http://localhost:4910/position`
The posted data must be a array of position encoded as `application/json`following the format below

    [
    {"addresseMacDispositif":"yourStringValue",
    "addresseMacBalise":"yourStringValue",
    "timestamp":yourLongValue,
    "attenuation":yourFloatValue
    },
    {"addresseMacDispositif":"anotherStringValue",
    "addresseMacBalise":"anotherStringValue",
    "timestamp":anotherLongValue,
    "attenuation":anotherFloatValue
    }
    ]
