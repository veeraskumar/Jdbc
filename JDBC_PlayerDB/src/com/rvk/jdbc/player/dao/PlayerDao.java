package com.rvk.jdbc.player.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PlayerDao {

	static Scanner sc = new Scanner(System.in);

	public static Connection buildConn() {
		Connection con = null;
		try {
			FileReader fn = new FileReader("Db_connection.properties");
			Properties p = new Properties();
			p.load(fn);
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_player", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void printDB() {
		Connection con = null;
		System.out.println("player_Id Player_Name Player_Age Player_Country IPL team IPL_Salary");
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM PLAYER;");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5) + "\t" + rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void printDB(ResultSet rs) {
		System.out.println("player_Id Player_Name Player_Age Player_Country IPL team IPL_Salary");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5) + "\t" + rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addPlayer() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("INSERT INTO PLAYER VALUES(?,?,?,?,?,?)");
			System.out.println("Enter the Player Id : ");
			pstm.setInt(1, sc.nextInt());
			System.out.println("Enter the Player Name : ");
			sc.nextLine();
			pstm.setString(2, sc.nextLine());
			System.out.println("Enter the Player Age : ");
			pstm.setInt(3, sc.nextInt());
			System.out.println("Enter the Player Country : ");
			pstm.setString(4, sc.next());
			System.out.println("Enter the IPL Team : ");
			pstm.setString(5, sc.next());
			System.out.println("Enter the IPL Salayer : ");
			pstm.setInt(6, sc.nextInt());
			pstm.executeUpdate();
			System.out.println("Done");
			printDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void findAllPlayerByCountry() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM PLAYER WHERE PLAYERCOUNTRY = ?");
			System.out.println("Enter the Country to Find player where the From ? ");
			pstm.setString(1, sc.next());
			ResultSet rs = pstm.executeQuery();
			printDB(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void findAllPlayerByIplTeam() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM PLAYER WHERE IPLTEAM = ?");
			System.out.println("Enter the Ipl Team to Find player which team these playing ? ");
			pstm.setString(1, sc.next());
			ResultSet rs = pstm.executeQuery();
			printDB(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void findPlayerBetweenAge() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM PLAYER WHERE PLAYERAGE BETWEEN ? AND ? ;");
			System.out.println("Enter the Two age to Find player range in Between  ? ");
			pstm.setInt(1, sc.nextInt());
			pstm.setInt(2, sc.nextInt());
			ResultSet rs = pstm.executeQuery();
			printDB(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void updatePlayerSalaryById() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("SELECT IPLSALARY FROM PLAYER WHERE PLAYERID = ?");
			int id = sc.nextInt();
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			PreparedStatement pstmupdate = con.prepareStatement("UPDATE PLAYER SET IPLSALARY = ? WHERE PLAYERID = ?");
			while (rs.next()) {
				int current = rs.getInt("IPLSALARY") + 5000;
				pstmupdate.setLong(1, current);
				pstmupdate.setInt(2, id);
				pstmupdate.executeUpdate();
			}
			printDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void updatePlayerSalaryBetweenAge() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con
					.prepareStatement("SELECT IPLSALARY FROM PLAYER WHERE PLAYERAGE BETWEEN ? AND ?");
			System.out.println("Enter Range of Age to Upadate the Salary : ");
			pstm.setInt(1, sc.nextInt());
			pstm.setInt(2, sc.nextInt());
			ResultSet rs = pstm.executeQuery();
			PreparedStatement pstmupdate = con.prepareStatement("UPDATE PLAYER SET IPLSALARY = ? WHERE PLAYERID = ?");
			while (rs.next()) {
				int id = rs.getInt(1);
				int current = rs.getInt("IPLSALARY") + 5000;
				pstmupdate.setInt(1, current);
				pstmupdate.setInt(2, id);
				pstmupdate.executeUpdate();
			}
			printDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deleteAllPlayerByCountry() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("DELETE FROM PLAYER WHERE IPLTEAM = ?");
			System.out.println("Enter the Country name to delete the Player from the DB ");
			pstm.setString(1, sc.next());
			pstm.executeUpdate();
			printDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deletePlayerById() {
		Connection con = null;
		try {
			con = buildConn();
			PreparedStatement pstm = con.prepareStatement("DELETE FROM PLAYER WHERE PLAYERID = ?");
			System.out.println("Enter the Player Id to Delete From DB");
			pstm.setInt(1, sc.nextInt());
			pstm.executeUpdate();
			printDB();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
