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
	public final static int[][] DEFAULT_1ST_ACTION_PERCENTAGES = {{100, 0, 0, 0, 0}, {0, 0, 100, 0, 0}, {50, 0, 50, 0, 0}, {25, 0, 75, 0, 0},  {75, 0, 25, 0, 0}};
	public final static int[][] DEFAULT_2ST_ACTION_PERCENTAGES = {{0, 100, 0, 0, 0}, {0, 0, 0, 100, 0}, {0, 0, 0, 0, 100}, {0, 50, 0, 50, 0},  {0, 0, 0, 75, 25}};
}
