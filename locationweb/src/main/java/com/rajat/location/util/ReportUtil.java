package com.rajat.location.util;

import java.util.List;

public interface ReportUtil {
	void generatePieChart(String path,List<Object[]> data);
	//path where we want final jpeg to live in
	//second parapemeter is dataset
}
