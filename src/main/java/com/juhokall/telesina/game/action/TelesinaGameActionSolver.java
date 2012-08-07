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
 *
 * @author juho
 */
public class TelesinaGameActionSolver implements TelesinaGameAction {

	private final static Map<SolutionType, TelesinaGameAction> solutionMethods;

	static {
		solutionMethods = new EnumMap<SolutionType, TelesinaGameAction>(SolutionType.class);
		solutionMethods.put(SolutionType.BET, new Bet());
		solutionMethods.put(SolutionType.CALL, new Call());
		solutionMethods.put(SolutionType.CHECK, new Check());
		solutionMethods.put(SolutionType.FOLD, new Fold());
		solutionMethods.put(SolutionType.RAISE, new Raise());
	}

	@Override
	public Boolean solve(Situation situation, Solution solution) {
		SolutionType solutionType = solution.getSolutionType();
		TelesinaGameAction action = solutionMethods.get(solutionType);
		return action.solve(situation, solution);
	}
}
