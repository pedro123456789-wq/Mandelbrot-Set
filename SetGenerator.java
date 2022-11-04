public class SetGenerator {
	public static int iterationNumber(ComplexNumber c) {
		ComplexNumber z = new ComplexNumber(0, 0);
		int iterationNumber = 0;
		
		while (iterationNumber < Constants.maxIterations && z.abs() <= 2) {
			iterationNumber += 1;
			z = z.mult(z).add(c);
		}
		
		return iterationNumber;
	
	}
}
