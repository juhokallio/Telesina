/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juhokall.telesina.model;

import java.util.List;

/**
 *
 * @author juho
 */
public class Situation {
List<Player> players;
int street;
int potSize;
List<Integer> playersLeft;
int activePlayersNumber;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getActivePlayersNumber() {
		return activePlayersNumber;
	}

	public void setActivePlayersNumber(int activePlayersNumber) {
		this.activePlayersNumber = activePlayersNumber;
	}

	public void removePlayer(int playerNumber) {
		players.remove(playerNumber);
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

	public List<Integer> getPlayersLeft() {
		return playersLeft;
	}

	public void setPlayersLeft(List<Integer> playersLeft) {
		this.playersLeft = playersLeft;
	}



	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

}
