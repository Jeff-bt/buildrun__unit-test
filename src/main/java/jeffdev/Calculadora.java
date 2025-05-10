package jeffdev;

class Calculadora {
	public int somar(int a, int b) {
		return a + b;
	}
	public int subtrair(int a, int b) {
		return a - b;
	}
	public int multiplicar(int a, int b) {
		return a * b;
	}
	public double dividir(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Divisão por zero não permitida.");
		}
		return (double) a / b;
	}
	public double potencia(double base, double expoente) {
		return Math.pow(base, expoente);
	}
	public double raizQuadrada(double numero) {
		if (numero < 0) {
			throw new ArithmeticException("Número negativo não tem raiz real.");
		}
		return Math.sqrt(numero);
	}
	public int absoluto(int numero) {
		return Math.abs(numero);
	}
	public boolean ehPar(int numero) {
		return numero % 2 == 0;
	}
	public boolean ehPrimo(int numero) {
		if (numero < 2) return false;
		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) return false;
		}
		return true;
	}
	public int maximo(int a, int b) {
		return Math.max(a, b);
	}
	public int minimo(int a, int b) {
		return Math.min(a, b);
	}
}
