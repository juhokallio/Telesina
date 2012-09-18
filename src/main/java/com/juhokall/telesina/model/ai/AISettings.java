/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.ai;

/**
 * A class that contains constants as the settings for the AI.
 * @author juho
 */
public class AISettings {

	/**
	 * How many times a range will be simulated for values.
	 */
	public final static int RANGE_ITERATIONS = 100000;
	/**
	 *	How many times a hand will be simulated for value.
	 */
	public final static int HAND_ITERATIONS = 1000;
	/**
	 * In how many sections the strategy will be divided. 
	 */
	public final static int STRATEGY_CANDIDATE_COUNT = 4;
	/**
	 * If we are playing always only with two players.
	 */
	public final static Boolean HEADS_UP_MODE = true;
	/**
	 * Default candidates for the action percentages, if last action was not aggressive. {bet, call, check, fold, raise}
	 */
	public final static int[][] DEFAULT_1ST_ACTION_PERCENTAGES = {{100, 0, 0, 0, 0}, {0, 0, 100, 0, 0}, {65, 0, 35, 0, 0}, {35, 0, 65, 0, 0}};
	/**
	 * Default candidates for the action percentages, if last action was aggressive. {bet, call, check, fold, raise}
	 */
	public final static int[][] DEFAULT_2ST_ACTION_PERCENTAGES = {{0, 100, 0, 0, 0}, {0, 0, 0, 100, 0}, {0, 0, 0, 0, 100}, {0, 0, 0, 75, 25}};
	/**
	 * In which points the range will be divided to new sections.
	 */
	public static final int[] DEFAULT_BREAKPOINTS = {25, 50, 75, 100};
	/**
	 * Default candidates for the lazy action percentages, if last action was not aggressive. {bet, call, check, fold, raise}
	 */
	public final static int[][] LAZY_1ST_ACTION_PERCENTAGES = {{100, 0, 0, 0, 0}, {0, 0, 100, 0, 0}};
	/**
	 * Default candidates for the lazy action percentages, if last action was aggressive. {bet, call, check, fold, raise}
	 */
	public final static int[][] LAZY_2ST_ACTION_PERCENTAGES = {{0, 100, 0, 0, 0}, {0, 0, 0, 100, 0}, {0, 0, 0, 0, 100}};
	/**
	 * In which points the range will be divided to new sections, if using lazy strategy.
	 */
	public static final int[] LAZY_BREAKPOINTS = {25, 75, 100};
}
