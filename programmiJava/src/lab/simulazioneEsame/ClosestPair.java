package lab.simulazioneEsame;

public class ClosestPair {

	public static double[] closestPair1(double[] num) {
		double[] candidato = new double[2];
		candidato[0] = num[0];
		candidato[1] = num[1];

		int lunghezza = num.length;
		int i = 0;
		int j = 1;
		while ((i != lunghezza - 2) && (j != lunghezza - 1)) {
			if (j != lunghezza -1) {
				if (Math.abs(num[i] - num[j]) < Math.abs(candidato[0] - candidato[1])) {
					candidato[0] = num[i];
					candidato[1] = num[j];
				}
				j++;
			} else {
				if (Math.abs(num[i] - num[j]) < Math.abs(candidato[0] - candidato[1])) {
					candidato[0] = num[i];
					candidato[1] = num[j];
				}
				j++;
				i++;
			}
		}

		if (Math.abs(num[i] - num[j]) < Math.abs(candidato[0] - candidato[1])) {
			candidato[0] = num[i];
			candidato[1] = num[j];
		}
		
		return candidato;
	} // method closestPair

	public static double[] closestPair(double[] num) {
		int j = 0;
		double min = 0d;
		double diff = 0d;
		min = Math.abs(num[0] - num[1]);
		double[] pair = new double[2];
		pair[0] = num[0];
		pair[1] = num[1];

		while (j < num.length) {
			for (int i = 0; i < num.length; i++) {
				if (j != i) {
					diff = Math.abs(num[j] - num[i]);
					if (diff < min) {
						min = diff;
						if (num[j] < num[i]) {
							pair[0] = num[j];
							pair[1] = num[i];
						} else {
							pair[0] = num[i];
							pair[1] = num[j];
						}
					}
				}
			}
			j++;
		}
		return pair;
	} // method closestPair

	public static void main(String[] args) {
		double num[] = new double[] { 0.0, 0.3, 0.1, 0.6, 0.8, 0.7, 1.1 };
		double result[] = closestPair1(num);

		System.out.println("{" + result[0] + ", " + result[1] + "}");

	} // method main

}
