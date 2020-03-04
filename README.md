# JPageReport

[![license](https://img.shields.io/github/license/BrendonCurmi/JPageReport)](https://github.com/BrendonCurmi/JPageReport/blob/master/LICENSE)

Usage
====
Firstly, you will need to create an API key on [WebPageTest](https://www.webpagetest.org/getkey.php).

[More information](https://github.com/BrendonCurmi/JPageTest)

**Sample.java**
```java
import io.BrendonCurmi.JPageReport.JPageReport;

public class Sample {

    public static void main(String[] args) {
        // Pass the API key from WebPageTest to the class handler
        JPageReport jPageReport = new JPageReport("sample_key");

        try {
            // Run 5 tests on "https://www.example.com/" (total 5 tests (first view only))
            // and generate a report at Desktop\report-single.csv
            jPageReport.runTest("Desktop\\report-single.csv", 5, "https://www.example.com");

            // Run 5 tests on "https://www.example.com/" and "https://www.example.org/" each (total 10 tests (first view only))
            // and generate a report at Desktop\report-comparative.csv
            jPageReport.runTest("Desktop\\report-comparative.csv", 5, "https://www.example.com", "https://www.example.org");
        }  catch (Exception ex) {
            // If there are issues retrieving data, with the JSON, with I/O, or with the thread
            // Non-existent string keys will not result in an exception here - default values will be returned
            System.err.println(ex.getMessage());
        }
    }
}
```

Dependencies
====
- [JPageTest](https://github.com/BrendonCurmi/JPageTest)