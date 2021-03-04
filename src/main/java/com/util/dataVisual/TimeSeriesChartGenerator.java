package com.util.dataVisual;

import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesChartGenerator extends JFrame {

	private static final long serialVersionUID = 1L;
	private final String plotName;
	private final String xAxisName;
	private final String yAxisName;
	private final Color color;
	private final int width;
	private final int height;


	public TimeSeriesChartGenerator(String plotName, String xAxisName, String yAxisName, Color color, int width,
			int height) {
		this.plotName = plotName;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.color = color;
		this.width = width;
		this.height = height;
	}


	public void buildChart(XYDataset xyDataset) {
		JFreeChart chart = ChartFactory.createTimeSeriesChart(plotName, xAxisName, yAxisName, xyDataset);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(color);
		ChartPanel chartPanel = new ChartPanel(chart);
		setContentPane(chartPanel);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
