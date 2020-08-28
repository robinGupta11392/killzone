package com.utilities;

@FunctionalInterface
interface MyLambda {
	String sampleMethod(String in);
}

public class LambdaTest {
	public static void main(String[] args) {
		MyLambda lambda = s -> s + " help me!";
		MyLambda lambda2 = s -> s + " DONT help me!";
		System.out.println(lambda.sampleMethod("Testing IT"));
		System.out.println(lambda2.sampleMethod("Testing IT"));
	}

}
