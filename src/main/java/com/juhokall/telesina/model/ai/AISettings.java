/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model.ai;

/**
 *
 * @author juho
 */
public class AISettings {

	public final static int RANGE_ITERATIONS = 100000;
	public final static int STRATEGY_CANDIDATE_COUNT = 4;
	public final static Boolean HEADS_UP_MODE = true;
	//bet, call, check, fold, raise
	public final static int[][] DEFAULT_1ST_ACTION_PERCENTAGES = {{100, 0, 0, 0, 0}, {0, 0, 100, 0, 0}, {65, 0, 35, 0, 0}, {35, 0, 65, 0, 0}};
	public final static int[][] DEFAULT_2ST_ACTION_PERCENTAGES = {{0, 100, 0, 0, 0}, {0, 0, 0, 100, 0}, {0, 0, 0, 0, 100}, {0, 0, 0, 75, 25}};
	public static final int[] DEFAULT_BREAKPOINTS = {25, 50, 75, 100};
}
