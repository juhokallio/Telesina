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
 * A class that models a situation in the game.
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

	/**
	 *	Constructor
	 * @param playerCount How many players are in.
	 * @param stackSizes Stack sizes of the players.
	 */
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

	/**
	 * Gives the last solution.
	 * @return The last solution.
	 */
	public Solution getLastSolution() {
		return lastSolution;
	}

	/**
	 *	Sets the last solution.
	 * @param lastSolution The last solution.
	 */
	public void setLastSolution(Solution lastSolution) {
		this.lastSolution = lastSolution;
	}

	/**
	 *	Constructor
	 * @param playersCount How many players are in.
	 */
	public Situation(int playersCount) {
		this(playersCount, Telesina.DEFAULT_STACK);
	}

	/**
	 *	The clone method.
	 * @return The clone.
	 */
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
	/**
	 *	Decrease the number of players that have still their turn on the street.
	 */
	public void decreasePlayersLeft() {
		playersLeft--;
	}
	/**
	 *	Gives the number of players that wait for their turn. 
	 * @return The number of players that may still act.
	 */
	public int getPlayersLeft() {
		return playersLeft;
	}
	/**
	 *	Moves the situation to the next street.
	 */
	public void moveToNextStreet() {
		street++;
		playersLeft = playerCount;
	}

	/**
	 *	Sets how many players are still left to act on the street.
	 * @param playersLeft The number of players that may still act.
	 */
	public void setPlayersLeft(int playersLeft) {
		this.playersLeft = playersLeft;
	}
	/**
	 *	Gives a sub-situation where the active player's range is limited.
	 * @param activePercentageStart Lower end of the limit.
	 * @param activePercentageEnd Higher end of the limit.
	 * @return
	 */
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
	/**
	 * Sets active player's range limits.
	 * @param activePercentageStart Lower end of the limit.
	 * @param activePercentageEnd Higher end of the limit.
	 */
	public void setActivePlayersRanges(int activePercentageStart, int activePercentageEnd) {
		HandRange range = getActivePlayer().getRange();
		List<Integer> values = range.getValues();
		int valuesLength = values.size();
		int start = valuesLength * activePercentageStart / 100;
		int end = valuesLength * activePercentageEnd / 100;
		range.setValues(values.subList(start, end));
	}

	/**
	 * Setter of the players map.
	 * @param players Players that are in the situation.
	 */
	public void setPlayers(Map<Integer, Player> players) {
		this.players = players;
	}

	/**
	 * Gets the list of the players' ids.
	 * @param playerIds List of the players' ids.
	 */
	public void setPlayerIds(List<Integer> playerIds) {
		this.playerIds = playerIds;
	}

	/**
	 * Sets the id of the active player.
	 * @param activePlayerId The id of the active player.
	 */
	public void setActivePlayerId(int activePlayerId) {
		this.activePlayerId = activePlayerId;
	}

	/**
	 * Sets the number of the players in the game.
	 * @param playerCount Number of the players in the game.
	 */
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	/**
	 *	Gives the map of the players in the game.
	 * @return The map of the players.
	 */
	public Map<Integer, Player> getPlayers() {
		return players;
	}

	/**
	 * Gives the number of the players in the game.
	 * @return The number of the players in the game.
	 */
	public int getPlayerCount() {
		return playerCount;
	}

	/**
	 *	Gives a player that has the given id.
	 * @param playerId Player's id.
	 * @return Player.
	 */
	public Player getPlayer(int playerId) {
		return players.get(playerId);
	}

	/**
	 * Gives the list of the players' ids.
	 * @return The list of the players' ids.
	 */
	public List<Integer> getPlayerIds() {
		return playerIds;
	}

	/**
	 *	Gives the id of the active player.
	 * @return Id of the active player.
	 */
	public int getActivePlayerId() {
		return activePlayerId;
	}

	/**
	 * Gives the active player.
	 * @return The active player.
	 */
	public Player getActivePlayer() {
		return players.get(activePlayerId);
	}

	/**
	 *	Sets the active player.
	 * @param activePlayerId The id of the active player.
	 */
	public void setActivePlayer(int activePlayerId) {
		this.activePlayerId = activePlayerId;
	}

	/**
	 * Removes a player from the game.
	 * @param playerNumber Player's number.
	 */
	public void removePlayer(int playerNumber) {
		players.remove(playerNumber);
		playerIds.remove(playerNumber);
		playerCount--;
	}

	/**
	 *	Removes the active player.
	 */
	public void removeActivePlayer() {
		players.remove(activePlayerId);
		playerCount--;
		playerIds.remove(activePlayerId);
	}

	/**
	 *	Adds chips to the pot.
	 * @param amount Number of chips to be add to the pot.
	 */
	public void addToPot(int amount) {
		potSize += amount;
	}

	/**
	 *	Gives the size of the pot.
	 * @return Integer representation of the size of the pot.
	 */
	public int getPotSize() {
		return potSize;
	}

	/**
	 *	Sets the size of the pot.
	 * @param potSize Size of the pot.
	 */
	public void setPotSize(int potSize) {
		this.potSize = potSize;
	}

	/**
	 * Gives the number of the street.
	 * @return The number of the current street.
	 */
	public int getStreet() {
		return street;
	}

	/**
	 *	Sets the number of the street.
	 * @param street The number of the street.
	 */
	public void setStreet(int street) {
		this.street = street;
	}
	/**
	 * Gives an array that includes every other player than the active one.
	 * @return An array that includes every other player than the active one.
	 */
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
	/**
	 * Gives an array that includes every other player's id than the active one's.
	 * @return An array that includes every other player's id than the active one's.
	 */
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
