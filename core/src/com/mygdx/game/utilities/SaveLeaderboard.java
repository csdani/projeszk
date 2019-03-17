package com.mygdx.game.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;

public class SaveLeaderboard {
	
	public static LeaderboardData lbData;
	
	public static void save() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("leaderboard.sav")
			);
			out.writeObject(lbData);
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
	
	public static void load() {
		try {
			if(!saveFileExists()) {
				init();
				return;
			}
			ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("leaderboard.sav")
			);
			lbData = (LeaderboardData) in.readObject();
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
	
	public static boolean saveFileExists() {
		File f = new File("leaderboard.sav");
		return f.exists();
	}
	
	public static void init() {
		lbData = new LeaderboardData();
		lbData.init();
		save();
	}
	
}
