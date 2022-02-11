package model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeTest {
	
	private Recipe recipe;
	private String n = "azucar";
	private double w = 10; 
	
	
	String[] nam = new String[] {"pimenton" , "arroz", "pepinillo"};
	double[] weight = new double [] {520, 58, 320};
	

	public void setupStage1() {
		
		recipe = new Recipe();
		
	}
	
	public void setupStage2() {
		recipe = new Recipe();
		
		for(int i=0 ; i < nam.length; i++) {
			recipe.addIngredient(nam[i],weight[i]);
		}
	}
	

	@Test
	void test1() {
		
		setupStage1();
		
		recipe.addIngredient(n,w);
		
		assertEquals(1, recipe.getIngredients().size());
		assertTrue(recipe.findIngredient(n)>=0);
		
	}
	
	@Test
	void test2() {
		setupStage2();
		String n = "pimenton";
		double w = 6;
		
		recipe.addIngredient(n, w);
		
		assertEquals(4,recipe.getIngredients().size());
		assertTrue(recipe.findIngredient(n)>=0);
		assertEquals(recipe.getIngredients().get(recipe.findIngredient(n)).getWeight(),6);
		
	}
	
	@Test
	void test3() {
		setupStage2();
		String n = "arroz";
		double w = 21;
		
		recipe.addIngredient(n, w);
		
		assertEquals(3,recipe.getIngredients().size());
		
		assertEquals(recipe.getIngredients().get(recipe.findIngredient(n)).getWeight(),79);
		
}
}