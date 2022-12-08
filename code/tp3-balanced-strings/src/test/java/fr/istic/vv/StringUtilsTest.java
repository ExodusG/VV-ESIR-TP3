package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;


public class StringUtilsTest {

	@Test
	  public void testEmptyString(){
	    String test="";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithBraces(){
	    String test="{}";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithParenthesis(){
	    String test="()";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithCroche(){
	    String test="[]";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithCrocheNotEnding(){
	    String test="[";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithBracesNotEndingLeft(){
	    String test="{{}";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithBracesNotEndingRight(){
	    String test="{}}";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithBracesAndParenthensis(){
	    String test="{()}";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithBracesAndCroche(){
	    String test="{[]}";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithCrocheAndParenthensis(){
	    String test="[()]";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithParenthesisAndCroche(){
	    String test="([])";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithParenthesisAndBraces(){
	    String test="({})";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithCrocheAndBraces(){
	    String test="[{}]";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void test(){
	    String test="[{[]}]{()}[]";
	    assertEquals(true,StringUtils.isBalanced(test));
	  }

	@Test
	  public void test2(){
	    String test="[[]}]{()}]";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }

	@Test
	  public void test3(){
	    String test="(()}){})";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }

	@Test
	  public void test4(){
	    String test="{{}]}[]}";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }

	@Test
	  public void testWithoutSomeOperator(){
	    String test="{}]}[})";
	    assertEquals(false,StringUtils.isBalanced(test));
	  }
}
