package capitalone.ses17.insightsquirrel.speech;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


import capitalone.ses17.insightsquirrel.summary.*;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResponseController {
    @Autowired
    private SummaryMaker summaryMaker;
    /*
    POST endpoint that receives JSON data and formulates a response to send to Alexa.
    Default response is null if no response can be created.
     */
    @RequestMapping(value = "/response", method = RequestMethod.POST,
            consumes = "application/json")
    public String response(@RequestBody String payload) {
        String intent = JsonPath.read(payload, "$.request.intent.name");
        //SummaryMaker instance = new SummaryMaker();
        String response = "TEST";

        switch (intent) {
            case "Budget":
                BudgetSummary budgetSummary = null;
                response = budgetResponse(budgetSummary);
                break;
            case "Data":
                DataSummary dataSummary = summaryMaker.getAllSummary();
                response = dataResponse(dataSummary);
                break;
            case "Location":
                LocationSummary locationSummary = null;
                response = locationResponse(locationSummary);
                break;
            case "Schedule":
                List<ScheduleSummary> scheduleSummary = summaryMaker.getScheduleSummaries();
                response = scheduleResponse(scheduleSummary);
                break;
            default:
                break;
        }
        return response;
    }

    public String budgetResponse(BudgetSummary summary) {

        String response = "You have spent " + " percent of your budget on food, " + " percent on ";
        return response;
    }

    public String dataResponse(DataSummary summary) {
        String r = null;
        return r;
    }

    public String locationResponse(LocationSummary summary) {

        String response = "You spent " +  " dollars in ";
        return response;
    }

    public String scheduleResponse(List<ScheduleSummary> summary) {

        String r = null;
        return r;
    }
}
