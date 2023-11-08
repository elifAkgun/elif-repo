package code.elif;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class MapExample {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        integerList.add(9);
        integerList.add(25);
        integerList.add(49);
        integerList.add(16);
        integerList.add(4);

        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> initialRdd = sc.parallelize(integerList);

        JavaRDD<Double> squaredValues = initialRdd.map((a) -> Math.sqrt(a));

        squaredValues.foreach(d -> System.out.println(d));

        sc.close();
    }
}
