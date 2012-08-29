/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import com.juhokall.telesina.model.core.Telesina;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juho
 */
public class Situation {

	private Map<Integer, Player> players;
	private List<Integer> playerIds;
	private int street;
	private int potSize;
	private int activePlayerId;
	private int playerCount;
	private Solution lastSolution;
	private int playersLeft;

	public Situation(int playerCount, int stackSizes) {
		Player temp;

		players = new HashMap<Integer, Player>();
		playerIds = new ArrayList<Integer>();
		for (int i = 0; i < playerCount; i++) {
			temp = new Player();
			temp.setStack(stackSizes);
			players.put(i, temp);
			playerIds.add(i);
		}
		this.playerCount = playerCount;
		activePlayerId = 0;
		potSize = 0;
		street = 0;
		lastSolution = new Solution(SolutionType.CHECK);
		playersLeft = playerCount;
	}

	public Solution getLastSolution() {
		return lastSolution;
	}

	public void setLastSolution(Solution lastSolution) {
		this.lastSolution = lastSolution;
	}

	public Situation(int playersCount) {
		this(playersCount, Telesina.DEFAULT_STACK);
	}

	@Override
	public Situation clone() {
		Situation s = new Situation(playerCount);
		s.setStreet(street);
		s.setPotSize(potSize);
		s.setPlayerCount(playerCount);
		List<Integer> ids = new ArrayList<Integer>();
		Map<Integer, Player> ps = new HashMap<Integer, Player>();
		for(int id : playerIds) {
			ids.add(id);
			ps.put(id, players.get(id).clone());
		}
		s.setPlayerIds(ids);
		s.setPlayers(ps);
		s.setActivePlayerId(activePlayerId);
		s.setPlayersLeft(playersLeft);
		return s;
	}
	public void decreasePlayersLeft() {
		playersLeft--;
	}
	public int getPlayersLeft() {
		return playersLeft;
	}
	public void moveToNextStreet() {
		street++;
		playersLeft = playerCount;
	}

	public void setPlayersLeft(int playersLeft) {
		this.playersLeft = playersLeft;
	}
	public Situation subSituation(int activePercentageStart, int activePercentageEnd) {
		Situation clone = this.clone();
		Player player = clone.getActivePlayer();
		HandRange range = player.getRange();
		List<Integer> values = range.getValues();
		int valuesLength = values.size();
		int start = valuesLength * activePercentageStart / 100;
		int end = valuesLength * activePercentageEnd / 100;
		range.setValues(values.subList(start, end));
		return clone;
	}
	public void setActivePlayersRanges(int activePercentageStart, int activePercentageEnd) {
		HandRange range = getActivePlayer().getRange();
		List<Integer> values = range.getValues();
		int valuesLength = values.size();
		int start = valuesLength * activePercentageStart / 100;
		int end = valuesLength * activePercentageEnd / 100;
		range.setValues(values.subList(start, end));
	}

	public void setPlayers(Map<Integer, Player> players) {
		this.players = players;
	}

	public void setPlayerIds(List<Integer> playerIds) {
		this.playerIds = playerIds;
	}

	public void setActivePlayerId(int activePlayerId) {
		this.activePlayerId = activePlayerId;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public Map<Integer, Player> getPlayers() {
		return players;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public Player getPlayer(int playerId) {
		return players.get(playerId);
	}

	public List<Integer> getPlayerIds() {
		return playerIds;
	}

	public int getActivePlayerId() {
		return activePlayerId;
	}

	public Player getActivePlayer() {
		return players.get(activePlayerId);
	}

	public void setActivePlayer(int activePlayerId) {
		this.activePlayerId = activePlayerId;
	}

	public void removePlayer(int playerNumber) {
		players.remove(playerNumber);
		playerIds.remove(playerNumber);
	}

	public void removeActivePlayer() {
		players.remove(activePlayerId);
		playerCount--;
		playerIds.remove(activePlayerId);
	}

	public void addToPot(int amount) {
		potSize += amount;
	}

	public int getPotSize() {
		return potSize;
	}

	public void setPotSize(int potSize) {
		this.potSize = potSize;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}
	public Player[] getNonActivePlayers() {
		Player[] naPlayers = new Player[playerCount - 1];
		int i = 0;
		for(int playerNumber : players.keySet()) {
			if(playerNumber != activePlayerId) {
				naPlayers[i++] = getPlayer(playerNumber);
			}
		}
		return naPlayers;
	}
	public int[] getNonActivePlayerIds() {
		int[] naPlayers = new int[playerCount - 1];
		int i = 0;
		for(int playerNumber : players.keySet()) {
			if(playerNumber != activePlayerId) {
				naPlayers[i++] = playerNumber;
			}
		}
		return naPlayers;
	}

}
