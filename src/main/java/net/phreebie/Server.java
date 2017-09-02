package net.phreebie;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import spark.ModelAndView;


// http://localhost:4567
public class Server {
    public static Data data = new Data();


    private static final int TEMPERATURE_START_MAX = 32;
    private static final int TEMPERATURE_START_MIN = 10;

    public static final int TEMPERATURE_STOP_MAX = TEMPERATURE_START_MAX + 2;
    public static final int TEMPERATURE_STOP_MIN = TEMPERATURE_START_MIN + 2;

    public static void main(String[] args) {
        get("/", (req, res) -> "<html><header><meta http-equiv=\"refresh\" content=\"0; url=http://192.168.0.149:3000\" /></header></html>");

        get("/temperature/now", (req, res) -> {
            return data.getTemperature();
        });

        get("/temperature/start", (req, res) -> {
            return data.getTemperature().getStart();
        });
        post("/temperature/start", (request, response) -> {
            int val = Integer.valueOf(request.params("value"));
            if ((val<TEMPERATURE_START_MAX)&&(val>TEMPERATURE_START_MIN)){
                data.getTemperature().setStart(val);
            }
            return data.getTemperature().getStart();
        });
        put("/temperature/start", (request, response) -> {
            if (data.getTemperature().getStart() < TEMPERATURE_START_MAX) {
                data.getTemperature().setStart(data.getTemperature().getStart()+1);
            }
            return data.getTemperature().getStart();
        });
        delete("/temperature/start", (request, response) -> {
            if (data.getTemperature().getStart() > TEMPERATURE_START_MIN)
                data.getTemperature().setStart(data.getTemperature().getStart()-1);
            return data.getTemperature().getStart();
        });

        get("/temperature/stop", (req, res) -> "28");
        post("/temperature/stop", (request, response) -> {
            //задать абсолютную величину температуры
            return "28";
        });
        put("/temperature/stop", (request, response) -> {
            // задать относительную величину температуры
            return "29";
        });

        get("/contur1", (req, res) -> "false");
        post("/contur1", (request, response) -> {
            //задать значения
            return "false";
        });
        put("/contur1", (request, response) -> {
            //сменить значение на противоположное
            return "true";
        });

        get("/contur2", (req, res) -> "false");
        post("/contur2", (request, response) -> {
            //задать значения
            return "false";
        });
        put("/contur2", (request, response) -> {
            //сменить значение на противоположное
            return "true";
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

        get("/switched", (req, res) -> "true"); // получить состояние системы
        post("/switched", (req, res) -> "false"); // установить состояние системы
        put("/switched", (req, res) -> "true"); //изменить состояние системы

        get("/state",(req,res) -> getState());
    }

    private static String getState(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String json ="";
        try {
            json = mapper.writeValueAsString(data);
        } catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }

}
