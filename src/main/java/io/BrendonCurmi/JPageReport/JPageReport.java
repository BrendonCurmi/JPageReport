package io.BrendonCurmi.JPageReport;

import io.BrendonCurmi.JPageTest.Data;
import io.BrendonCurmi.JPageTest.JPageTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JPageReport extends JPageTest {

    public JPageReport(String apiKey) {
        super(apiKey);
    }

    /**
     * Runs a single test on the specified pages for the specified number of runs,
     * and saves the report to the specified path.
     *
     * @param path    the path to save the report file to.
     * @param runs    the number of runs per page.
     * @param pageURL the URL of the page to test.
     * @throws Exception if an Exception occurs.
     */
    public void runTest(String path, int runs, String pageURL) throws Exception {
        StringBuilder builder = new StringBuilder()
                .append("Site").append(",")
                .append("Load Time").append(",")
                .append("First Contentful Paint").append(",")
                .append("Speed Index").append(",")
                .append("Document Complete Time").append(",")
                .append("Fully Loaded Time").append(",")
                .append("\n");

        List<Data> results = runSingleTest(runs, pageURL);
        for (Data data : results) {
            getData(data, builder);
        }
        write(path, builder);
    }

    /**
     * Runs a comparative test on the 2 specified pages for the specified number of runs,
     * and saves the report to the specified path.
     *
     * @param path     the path to save the report file to.
     * @param runs     the number of runs per page.
     * @param page1URL the url of the first page to test.
     * @param page2URL the url of the second page to test.
     * @throws Exception if an Exception occurs.
     */
    public void runTest(String path, int runs, String page1URL, String page2URL) throws Exception {
        StringBuilder builder = new StringBuilder()
                .append("Site").append(",")
                .append("Load Time").append(",")
                .append("First Contentful Paint").append(",")
                .append("Speed Index").append(",")
                .append("Document Complete Time").append(",")
                .append("Fully Loaded Time").append(",")
                .append("\n");

        List<Data[]> results2 = runComparativeTest(runs, page1URL, page2URL);
        for (Data[] dataPairs : results2) {
            for (Data data : dataPairs) {
                getData(data, builder);
            }
        }
        write(path, builder);
    }

    private void getData(Data data, StringBuilder builder) {
        builder
                .append(data.getURL()).append(",")
                .append(data.getSeconds("loadTime")).append(",")
                .append(data.getSeconds("firstContentfulPaint")).append(",")
                .append(data.getSeconds("SpeedIndex")).append(",")
                .append(data.getSeconds("docTime")).append(",")
                .append(data.getSeconds("fullyLoaded")).append(",")
                .append("\n");
    }

    /**
     * Writes the specified StringBuilder to the specified path.
     *
     * @param path    the path to write to.
     * @param builder the contents
     * @throws IOException if an I/O exception occurs.
     */
    private void write(String path, StringBuilder builder) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.append(builder);
        writer.close();
    }
}
