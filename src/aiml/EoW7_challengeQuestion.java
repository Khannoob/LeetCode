package aiml;

import java.util.Random;

public class EoW7_challengeQuestion {
	public static void main(String[] args) {
		/**
		* Usage (WITH self-defined random seed): java EoW7_challengeQuestion <probability> <iterations> <random seed>
		* e.g. java EoW7_challengeQuestion 0.7 10 1
		*
		* or
		*
		* Usage (WITHOUT self-defined random seed): java EoW7_challengeQuestion <probability> <iterations>
		* e.g. java EoW7_challengeQuestion 0.7 10
		*/
		if (args.length == 0) {
			System.out.println("Usage: ");
			System.out.println("1. WITH self-defined random seed: java EoW7_challengeQuestion <probability> <iterations> <random seed>");
			System.out.println("2. WITHOUT self-defined random seed: java EoW7_challengeQuestion <probability> <iterations>");
			System.exit(0);
		}

		if (args.length < 2 || args.length > 3) {
			System.err.println("The number of arguements is less than 2 or larger than 3. (Error code: 1)");
			System.exit(1);
		}
		
		double probability = Double.parseDouble(args[0]);
		int iterations = Integer.parseInt(args[1]);

		if (probability < 0.0 || probability > 1.0) {
			System.err.println("\"probability\" should be between 0 and 1. (Error code: 2)");
			System.exit(2);
		} else if (iterations <= 0) {
			System.err.println("\"iterations\" should be larger than 0. (Error code: 3)");
			System.exit(3);
		}

		Random rand;

		if (args.length == 3) {
			long randomSeed = Long.parseLong(args[2]);
			if (randomSeed < 0) {
				System.err.println("\"randomSeed\" should be larger than 0. (Error code: 3)");
				System.exit(3);
			}
			rand = new Random(randomSeed);
			System.out.println("Probability: " + probability + " | Total iterations: " + iterations + " | Random Seed: " + randomSeed);
		} else {
			rand = new Random();
			System.out.println("Probability: " + probability + " | Total iterations: " + iterations);
		}
		System.out.println("-------------------------------------------------------------------------------");


		for (int i = 0; i < iterations; ++i) {
			String to_print = "iteration " + String.valueOf(i+1) + ": ";
			if (rand.nextDouble() < probability) {
				to_print += "currentSolution = randomNeighbour";
			} else {
				to_print += "Discard randomNeighbour and keep currentSolution";
			}
			System.out.println(to_print);
		}

	}
}