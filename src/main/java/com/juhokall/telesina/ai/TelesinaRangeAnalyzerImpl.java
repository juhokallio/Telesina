/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.ai;

import com.google.inject.Inject;
import com.juhokall.telesina.model.AISettings;
import com.juhokall.telesina.model.HandRange;
import com.juhokall.telesina.model.Player;
import com.juhokall.telesina.model.Situation;
import com.juhokall.telesina.model.TelesinaValuedCard;
import java.util.Map;

/**
 *
 * @author juho
 */
public class TelesinaRangeAnalyzerImpl implements TelesinaRangeAnalyzer {

	private HandSimulator simulator;

	@Inject
	public TelesinaRangeAnalyzerImpl(HandSimulator simulator) {
		this.simulator = simulator;
	}

	@Override
	public HandRange[] getRanges(Situation situation) {
		Map<Integer, Player> players = situation.getPlayers();
		HandRange[] ranges = new HandRange[situation.getPlayerCount()];
		for (Player player : players.values()) {
			simulator.addPlayedHand(player.getHand());
		}
		HandRange range;
		Player player;
		TelesinaValuedCard valuedCard;
		for (int i = 0; i < situation.getPlayerCount(); i++ ) {
			player = situation.getPlayer(i);
			range = player.getRange();
			for (int iteration = 0; iteration < AISettings.RANGE_ITERATIONS; iteration++) {
				valuedCard = simulator.getValuedCard(player.getHand());
				range.addValuedCard(valuedCard);
			}
			range.sortValues();	
			ranges[i] = range;
		}

		return ranges;
	}
}
