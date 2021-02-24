package com.cve.reader.jsondb.dataVisual;


import com.cve.reader.jsondb.pojo.MonthYear;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ChartGenerator extends JFrame {

    TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
    TimeSeries timeSeriesLow = new TimeSeries("Low");
    TimeSeries timeSeriesMedium = new TimeSeries("Medium");
    TimeSeries timeSeriesHigh = new TimeSeries("High");
    TimeSeries timeSeriesCritical = new TimeSeries("Critical");

    public void chartBuilder() {
        timeSeriesCollection.addSeries(timeSeriesLow);
        timeSeriesCollection.addSeries(timeSeriesMedium);
        timeSeriesCollection.addSeries(timeSeriesHigh);
        timeSeriesCollection.addSeries(timeSeriesCritical);
        XYDataset xyDataset = timeSeriesCollection;

        JFreeChart chart = ChartFactory.createTimeSeriesChart("Impact Occurrences",
                "Date", "Occurrences", xyDataset);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 228, 196));
        ChartPanel chartPanel = new ChartPanel(chart);

        setContentPane(chartPanel);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void extracted(HashMap[] maps) {
        for (int i = 0; i < maps.length; i++) {
            HashMap<MonthYear, Integer> currentMap = maps[i];

            if (i == 0) {
                currentMap.keySet().forEach(k ->
                        timeSeriesLow.add(new Month(k.getMonth(), k.getYear()), currentMap.get(k)));
            } else if (i == 1) {
                currentMap.keySet().forEach(k ->
                        timeSeriesMedium.addOrUpdate(new Month(k.getMonth(), k.getYear()), currentMap.get(k)));
            } else if (i == 2) {
                currentMap.keySet().forEach(k ->
                        timeSeriesHigh.addOrUpdate(new Month(k.getMonth(), k.getYear()), currentMap.get(k)));

            } else {
                currentMap.keySet().forEach(k ->
                        timeSeriesCritical.addOrUpdate(new Month(k.getMonth(), k.getYear()), currentMap.get(k)));
            }
        }
    }

}
