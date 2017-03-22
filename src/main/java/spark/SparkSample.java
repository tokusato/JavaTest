package spark;

import static spark.Spark.*;

public class SparkSample {

	public static void main(String[] args) {

		//to change the port. it is deprecated but easy.
//		setPort(6789);

        //beforeによるリクエスト前の処理
        before((req, res) -> {
            System.out.println("全てのリクエスト共通");
        });

        before("/helloWorld", (req, res) -> {
            System.out.println("peculiar action. only performed when accessed to /helloWorld");
        });

		// run and try to access -> http://localhost:4567/helloWorld
		get("/helloWorld", (req, res) -> "Wonderfull WebServer is included");

		// who stop this server? and how?
		stop();
	}

}
