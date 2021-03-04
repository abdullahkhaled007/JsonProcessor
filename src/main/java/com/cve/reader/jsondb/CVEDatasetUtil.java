package com.cve.reader.jsondb;

import java.time.LocalDateTime;
import java.util.List;

import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import com.cve.model.CveListObject;
import com.cve.model.CveObject;

public class CVEDatasetUtil {


    public XYDataset getDataset(CveListObject listWrapper) {
    	List<CveObject> list = listWrapper.getCVE_Items();
		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		TimeSeries timeSeriesLow = new TimeSeries("Low");
		TimeSeries timeSeriesMedium = new TimeSeries("Medium");
		TimeSeries timeSeriesHigh = new TimeSeries("High");
		TimeSeries timeSeriesCritical = new TimeSeries("Critical");
		timeSeriesCollection.addSeries(timeSeriesLow);
		timeSeriesCollection.addSeries(timeSeriesMedium);
		timeSeriesCollection.addSeries(timeSeriesHigh);
		timeSeriesCollection.addSeries(timeSeriesCritical);

        int low = 1;
        int medium = 1;
        int high = 1;
        int critical = 1;
        int counter = 0;

        for (CveObject current : list) {
        	 LocalDateTime publishDate = current.getPublishedDate();
            try {
                switch (current.getImpact().getBaseMetricV2().getSeverity()) {
                    case "LOW":
                        timeSeriesLow.addOrUpdate(new Month(publishDate.getMonthValue(), publishDate.getYear()), low++);
                        break;
                    case "MEDIUM":
                    	timeSeriesMedium.addOrUpdate(new Month(publishDate.getMonthValue(), publishDate.getYear()), medium++);
                        break;
                    case "HIGH":
                    	timeSeriesHigh.addOrUpdate(new Month(publishDate.getMonthValue(), publishDate.getYear()), high++);
                        break;
                    case "CRITICAL":
                    	timeSeriesCritical.addOrUpdate(new Month(publishDate.getMonthValue(), publishDate.getYear()), critical++);
                        break;
                }
            } catch (NullPointerException e) {
                counter++;
            }
        }
        System.out.println("Could not retrieve severity for " + counter + " entries");
        return timeSeriesCollection;
    }
}
