public class ComplexNumber {
	private double real;
	private double imaginary;
	
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	
	public double abs() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	}
	
	
	public ComplexNumber mult(ComplexNumber other) {
		double realPart = (this.real * other.getReal()) - (this.imaginary * other.getImaginary());
		double imaginaryPart = (this.real * other.getImaginary()) + (this.imaginary * other.getReal());
		
		return new ComplexNumber(realPart, imaginaryPart);
	}
	
	
	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(this.real + other.getReal(), this.imaginary + other.getImaginary());
	}
	
	
	public double getReal() {
		return this.real;
	}
	

	public double getImaginary() {
		return this.imaginary;
	}
	
	
	@Override
	public String toString() {
		return this.real + " + " + this.imaginary + "i";
	}

}
