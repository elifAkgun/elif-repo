package code.elif;

import code.elif.util.Util;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheSparkDemo {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Hadoop home dizinini ayarlayarak Hadoop konfigürasyonunu yapıyoruz.
        System.setProperty("hadoop.home.dir", "c:/hadoop");

        // Spark'ı daha ayrıntılı düzeyde log yazdırması için ayarlıyoruz
        Logger.getLogger("org.apache").setLevel(Level.FINE);

        // Spark uygulama yapılandırmasını oluşturuyoruz.
        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");

        // JavaSparkContext oluşturuyoruz, bu Spark işlemlerini yürütmek için kullanılır.
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Veriyi bir RDD'ye yüklüyoruz. Bu örnekte metin dosyasından veri okuyoruz.
        JavaRDD<String> initialRdd = sc.textFile("src/main/resources/subtitles/input.txt");

        // Verideki metinleri küçük harfe çeviriyoruz.
        JavaRDD<String> lettersOnlyRdd = initialRdd.map(sentence -> sentence.replaceAll("[^a-zA-Z\\s]", "").toLowerCase());

        // Boş satırları kaldırıyoruz.
        JavaRDD<String> removedBlankLines = lettersOnlyRdd.filter(sentence -> sentence.trim().length() > 0);

        // Kelimeleri ayırarak tek bir liste haline getiriyoruz.
        JavaRDD<String> justWords = removedBlankLines.flatMap(sentence -> Arrays.asList(sentence.split(" ")).iterator());

        // Boş kelimeleri kaldırıyoruz.
        JavaRDD<String> blankWordsRemoved = justWords.filter(word -> word.trim().length() > 0);

        // İlgilenilen kelimeleri (sıkıcı olmayan kelimeleri) seçiyoruz.
        JavaRDD<String> justInterestingWords = blankWordsRemoved.filter(word -> Util.isNotBoring(word));

        // Kelimeleri çiftlere dönüştürerek her kelimenin sayısını sayıyoruz.
        JavaPairRDD<String, Long> pairRdd = justInterestingWords.mapToPair(word -> new Tuple2<>(word, 1L));

        // Aynı anahtara sahip çiftlerin değerlerini topluyoruz.
        JavaPairRDD<String, Long> totals = pairRdd.reduceByKey((value1, value2) -> value1 + value2);

        // Anahtar ve değeri yer değiştiriyoruz ve sıralıyoruz.
        JavaPairRDD<Long, String> switched = totals.mapToPair(tuple -> new Tuple2<Long, String>(tuple._2, tuple._1));
        JavaPairRDD<Long, String> sorted = switched.sortByKey(false);

        // Sonuçları alıyoruz ve ilk 10 sonucu yazdırıyoruz.
        List<Tuple2<Long, String>> results = sorted.take(10);
        results.forEach(System.out::println);

        // Spark Context'i kapatıyoruz.
        sc.close();
    }
}