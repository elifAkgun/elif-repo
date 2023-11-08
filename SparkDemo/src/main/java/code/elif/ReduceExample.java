package code.elif;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


import java.util.ArrayList;
import java.util.List;

public class ReduceExample {

    public static void main(String[] args) {

        List<Double> doubleList = new ArrayList<>();

        doubleList.add(1.34);
        doubleList.add(1.232);
        doubleList.add(14.37874);
        doubleList.add(9.094);
        doubleList.add(6.68);
        doubleList.add(4.8654);

        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Double> initialRdd = sc.parallelize(doubleList);

        Double sum = initialRdd.reduce((a, b) -> Double.sum(a, b));

        System.out.println("Sum : " + sum);

        sc.close();
    }
}
