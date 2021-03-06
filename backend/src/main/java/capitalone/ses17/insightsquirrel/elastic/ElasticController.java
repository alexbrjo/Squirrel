package capitalone.ses17.insightsquirrel.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by shane on 8/17/17.
 */

@Controller
public class ElasticController {

    @Autowired
    private ElasticService elasticService;

    public String getTimeLocationCategoy(String fromDate, String toDate, double lon, double lat, String category) {
        return elasticService.DateLocationCategory(fromDate, toDate, lon, lat, category);
    }

    public String getAverageTimeMerchant(String fromDate, String toDate, String merchant) {
        return elasticService.AverageTimeMerchant(fromDate, toDate, merchant);
    }

    public String getDistribution(String fromDate, String toDate) {
        return elasticService.getDistribution(fromDate, toDate);
    }

}
