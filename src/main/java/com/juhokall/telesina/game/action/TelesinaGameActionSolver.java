/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.game.action;

import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.Solution;
import com.juhokall.telesina.model.SolutionType;
import java.util.EnumMap;
import java.util.Map;

/**
 * TelesinaGameAction implemention that gives the general solution.
 * @author juho
 */
public class TelesinaGameActionSolver implements TelesinaGameAction {

	private final static Map<SolutionType, TelesinaGameAction> SOLUTION_METHODS;

	static {
		SOLUTION_METHODS = new EnumMap<SolutionType, TelesinaGameAction>(SolutionType.class);
		SOLUTION_METHODS.put(SolutionType.BET, new Bet());
		SOLUTION_METHODS.put(SolutionType.CALL, new Call());
		SOLUTION_METHODS.put(SolutionType.CHECK, new Check());
		SOLUTION_METHODS.put(SolutionType.FOLD, new Fold());
		SOLUTION_METHODS.put(SolutionType.RAISE, new Raise());
		SOLUTION_METHODS.put(SolutionType.TAKE_ANTES, new TakeAntes());
	}

	@Override
	public Boolean solve(Situation situation, Solution solution) {
		SolutionType solutionType = solution.getSolutionType();
		TelesinaGameAction action = SOLUTION_METHODS.get(solutionType);
		return action.solve(situation, solution);
	}
}
