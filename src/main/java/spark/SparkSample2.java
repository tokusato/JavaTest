package spark;

import static spark.Spark.*;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SparkSample2 {


	static final ObjectMapper om = new ObjectMapper();

	public static void main(String[] args) {

		// run and try to access -> http://localhost:4567/helloJackson
		get("/helloJackson", (req, res) -> {

			//レスポンスのコンテンツタイプをJSONに変換
			res.type("application/json");

			//JSON Parser Jacksonを用いて、REST APIっぽいものを返す。
			//Javaのオブジェクトをjacksonで文字列に変換しているだけ
			return om.writeValueAsString(Arrays.asList(
											new String[] { "Hello", "World" }));
		});

	}

}
