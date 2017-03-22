package spark;

import static spark.Spark.*;

import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SparkSample3 {


	static final ObjectMapper om = new ObjectMapper();

    public static void main(String[] args) {
        get("/prime", (req, res) -> {

        	// access -> http://localhost:4567/prime?n=167

        	//クエリストリング中のパラメタnの値を読み込む。(req属性のパラメタ)
            long n = Long.parseLong(req.queryParams("n"));

            boolean isPrime = isPrime(n);
            Map<String, Object> map = new TreeMap<>();
            map.put("prime", isPrime);
            map.put("n", n);
            res.type("application/json");
            return om.writeValueAsString(map);
        });
    }

    /**
     * 素数判定のメソッド
     * ⇒loopは本来はnの平方根まででOK
     *
     * */
    static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
            	//割り切れた。
                return false;
            }
        }
        //割り切れなかった。
        return true;
    }

}
