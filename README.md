# JPageReport

[![license](https://img.shields.io/github/license/BrendonCurmi/JPageReport)](https://github.com/BrendonCurmi/JPageReport/blob/master/LICENSE)

JPageReport is a library for compiling reports from [JPageTest](https://github.com/BrendonCurmi/JPageTest).

Usage
====
Firstly, you will need to create an API key on [WebPageTest](https://www.webpagetest.org/getkey.php).

For more information, see [JPageTest docs](https://github.com/BrendonCurmi/JPageTest)

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

Outputs
====

**> report-single.csv**
```csv
Site,Load Time,First Contentful Paint,Speed Index,Document Complete Time,Fully Loaded Time,
https://www.example.com,0.262,0.308,0.400,0.262,0.334,
https://www.example.com,0.294,0.306,0.300,0.294,0.342,
https://www.example.com,0.260,0.313,0.400,0.260,0.338,
https://www.example.com,0.255,0.310,0.300,0.255,0.338,
https://www.example.com,0.233,0.286,0.300,0.233,0.312,
```

| Site                    | Load Time | First Contentful Paint | Speed Index | Document Complete Time | Fully Loaded Time |
| ----------------------- | --------- | ---------------------- | ----------- | ---------------------- | ----------------- |
| https://www.example.com | 0.262     | 0.308                  | 0.400       | 0.262                  | 0.334             |
| https://www.example.com | 0.294     | 0.306                  | 0.300       | 0.294                  | 0.342             |
| https://www.example.com | 0.260     | 0.313                  | 0.400       | 0.260                  | 0.338             |
| https://www.example.com | 0.255     | 0.310                  | 0.300       | 0.255                  | 0.338             |
| https://www.example.com | 0.233     | 0.286                  | 0.300       | 0.233                  | 0.312             |

**> report-comparative.csv**
```csv
Site,Load Time,First Contentful Paint,Speed Index,Document Complete Time,Fully Loaded Time,
https://www.example.com,0.241,0.289,0.300,0.241,0.317,
https://www.example.org,0.303,0.354,0.300,0.303,0.378,
https://www.example.com,0.245,0.300,0.300,0.245,0.333,
https://www.example.org,0.301,0.316,0.400,0.301,0.356,
https://www.example.com,0.249,0.309,0.400,0.249,0.344,
https://www.example.org,0.253,0.300,0.300,0.253,0.324,
https://www.example.com,0.241,0.297,0.300,0.241,0.322,
https://www.example.org,0.233,0.315,0.300,0.233,0.357,
https://www.example.com,0.249,0.312,0.300,0.249,0.333,
https://www.example.org,0.259,0.308,0.300,0.259,0.332,
```

| Site                    | Load Time | First Contentful Paint | Speed Index | Document Complete Time | Fully Loaded Time |
| ----------------------- | --------- | ---------------------- | ----------- | ---------------------- | ----------------- |
| https://www.example.com | 0.241     | 0.289                  | 0.300       | 0.241                  | 0.317             |
| https://www.example.org | 0.303     | 0.354                  | 0.300       | 0.303                  | 0.378             |
| https://www.example.com | 0.245     | 0.300                  | 0.300       | 0.245                  | 0.333             |
| https://www.example.org | 0.301     | 0.316                  | 0.400       | 0.301                  | 0.356             |
| https://www.example.com | 0.249     | 0.309                  | 0.400       | 0.249                  | 0.344             |
| https://www.example.org | 0.253     | 0.300                  | 0.300       | 0.253                  | 0.324             |
| https://www.example.com | 0.241     | 0.297                  | 0.300       | 0.241                  | 0.322             |
| https://www.example.org | 0.233     | 0.315                  | 0.300       | 0.233                  | 0.357             |
| https://www.example.com | 0.249     | 0.312                  | 0.300       | 0.249                  | 0.333             |
| https://www.example.org | 0.259     | 0.308                  | 0.300       | 0.259                  | 0.332             |

Dependencies
====
- [JPageTest](https://github.com/BrendonCurmi/JPageTest)