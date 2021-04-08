package code.elif.interceptor;

public class PrimeGenerator {

    public static int[] generatePrimes(int maxValue) {

        if (maxValue >= 2) { //geçerli koşul
            int s = maxValue + 1; // array boyutu
            boolean[] f = new boolean[s];
            int i;

            //array'in tüm elemanlarını true setle
            for (i = 0; i < s; i++) {
                f[i] = true;
            }

            //asal sayı olmayanlardan kurtul
            f[0] = f[1] = false;

            //diğer sayıları ele
            int j;
            for (i = 2; i < Math.sqrt(s) + 1; i++) {
                if (f[i]) {
                    // eğer i çaprazlanmamışsa katlarını geç
                    for (j = 2 * i; j < s; j += i) {
                        f[j] = false; //katlı sayı asal değil.
                    }
                }
            }

            //kaç asal sayı var
            int count = 0;
            for (i = 0; i < s; i++) {
                if (f[i])
                    count++;
            }

            int[] primes = new int[count];

            //asal sayıları diziye yerleştir
            for (i = 0, j = 0; i < s; i++) {
                //asal bir sayı ise
                if (f[i])
                    primes[j++] = i;
            }
            return primes;


        } else // maxValue<2
            return new int[0]; //boş dizi dön
    }
}
