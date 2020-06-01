package lab.simulazioneEsame;

public class ClosestPair {

	public static double[] closestPair(double[] num) {
		int j = 0;
		double min = 0d;
		double diff = 0d;
		if ((num[0] - num[1]) < 0d) {
			min = (num[0] - num[1]) * -1;
		} else {
			min = num[0] - num[1];
		}
		double[] pair = new double[2];
		pair[0] = num[0];
		pair[1] = num[1];

		while (j < num.length) {
			for (int i = 0; i < num.length; i++) {
				if (j != i) {
					diff = num[j] - num[i];
					if (diff < 0d) {
						diff = diff * -1;
					}
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
		double num[] = new double[] { -0.2, -0.1, 0.0, 0.3, 0.1, 0.6, 0.8, 0.7, 1.1 };
		double result[] = closestPair(num);

		System.out.println("{" + result[0] + ", " + result[1] + "}");

	} // method main

}
