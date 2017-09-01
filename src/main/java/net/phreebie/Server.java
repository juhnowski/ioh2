package net.phreebie;

import static spark.Spark.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import spark.ModelAndView;


// http://localhost:4567
public class Server {
    public static int temperature = 19;

    public static int temperatureStart = 22;
    public static int temperatureStop = 28;

    public static String start = "19:00";
    public static String stop = "9:00";
    public static String currentTime = "19:05";
    public static boolean contur1 = false;
    public static boolean contur2 = false;

    private String encoding;


    public static void main(String[] args) {
        get("/", (req, res) -> "<html><body><h1>Дом</h1><ul><li>Temperature: " + temperature + "</li></ul></body></html>");

        get("/temperature", (req, res) -> "17");
        post("/temperature", (request, response) -> {
            //задать абсолютную величину температуры
            return "18";
        });
        put("/", (request, response) -> {
            // задать относительную величину температуры
            return "19";
        });

        get("/heater", (req, res) -> "{\"1\":\"false\",\"2\":\"false\"}");
        post("/temperature", (request, response) -> {
            //задать значения
            return "{\"1\":\"false\",\"2\":\"true\"}";
        });
        put("/temperature", (request, response) -> {
            //сменить значение на противоположное
            return "{\"1\":\"true\",\"2\":\"false\"}";
        });

        get("/timer/now", (req, res) -> "12:00");
        post("/timer/now", (req, res) -> "13:01");
        put("/timer/now", (req, res) -> "13:02");

        get("/timer/start", (req, res) -> "19:00");
        post("/timer/start", (req, res) -> "19:01");
        put("/timer/start", (req, res) -> "19:02");

        get("/timer/stop", (req, res) -> "9:00"); //получить время окончания работы автоматики
        post("/timer/stop", (req, res) -> "9:01"); //установить время окончания работы автоматики
        put("/timer/stop", (req, res) -> "9:02"); //изменить время окончания работы автоматики

        get("/on", (req, res) -> "true"); // получить состояние системы
        post("/on", (req, res) -> "false"); // установить состояние системы
        put("/on", (req, res) -> "true"); //изменить состояние системы

    }

}
