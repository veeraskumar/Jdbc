package com.rvk.jdbc.player.dao.app;

import com.rvk.jdbc.player.dao.*;

public class Player {
	public static void main(String[] args) {
		PlayerDao pd = new PlayerDao();
		int x = 2;
		switch (x) {
		case 1: {
			pd.addPlayer();
			break;
		}
		case 2: {
			pd.findAllPlayerByCountry();
			break;
		}
		case 3: {
			pd.findAllPlayerByIplTeam();
			break;
		}
		case 4: {
			pd.findPlayerBetweenAge();
			break;
		}
		case 5: {
			pd.updatePlayerSalaryById();
			break;
		}
		case 6: {
			pd.updatePlayerSalaryBetweenAge();
			break;
		}
		case 7: {
			pd.deleteAllPlayerByCountry();
			break;
		}
		case 8: {
			pd.deletePlayerById();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + x);
		}
	}
}
