package com.cve.reader.jsondb;

import org.jfree.data.xy.XYDataset;

import com.cve.model.CveListObject;
import com.util.dataVisual.TimeSeriesChartGenerator;
import com.util.json.JSONFileTransformer;

public class CVEDatasetProcessor {
	private final CVEDatasetUtil util;
	private final JSONFileTransformer<CveListObject> transformer;
	private final TimeSeriesChartGenerator chartGenerator;
	private final String filePath;
	
	public CVEDatasetProcessor(CVEDatasetUtil util, JSONFileTransformer<CveListObject> transformer,
			TimeSeriesChartGenerator chartGenerator, String filePath) {
		this.util = util;
		this.transformer = transformer;
		this.chartGenerator = chartGenerator;
		this.filePath = filePath;
	}

	public void process() throws Exception {
		XYDataset dataSet = util.getDataset(transformer.transformJson(filePath));
		chartGenerator.buildChart(dataSet);		
	}

}
