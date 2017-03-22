package spark;

import static spark.Spark.*;

public class SparkSample {

	public static void main(String[] args) {
		// run and try to access -> http://localhost:4567/helloWorld
		get("/helloWorld", (req, res) -> "Wonderfull WebServer is included");

		// who stop this server? and how?
		stop();
	}

}
