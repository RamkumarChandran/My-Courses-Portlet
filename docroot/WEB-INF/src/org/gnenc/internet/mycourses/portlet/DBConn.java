/**
*  Copyright (c) 2010-2011 Educational Service Unit 10. 
*
*  This file is part of the My Courses portlet.
*  
*  My Courses portlet is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
* 
*  My Courses is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with the My Courses portlet.  If not, see <http://www.gnu.org/licenses/>.
**/

package org.gnenc.internet.mycourses.portlet;

import java.sql.*;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
public class DBConn {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList findCoursesByEmail(String userEmail, String dbUrl,
			String dbUser, String dbPass) {
		ArrayList courseInfo = new ArrayList();
		try {
			String sql = "SELECT DISTINCT u.username AS userEmail," +
					"c.Fullname AS courseName,c.id AS courseId " +
					"FROM course AS c, role_assignments AS i, " +
					"context AS x,user AS u WHERE i.userid = u.id " +
					"AND i.contextid =x.id AND x.instanceid = c.id	" +
					"AND u.username = '" + userEmail + "'";

			Connection dbConn = connectToDB(dbUrl, dbUser, dbPass);

			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			courseInfo.add(new ArrayList<String>());
			courseInfo.add(new ArrayList<String>());

			while (rs.next()) {
				((ArrayList) courseInfo.get(0)).add(rs.getString(2));
				((ArrayList) courseInfo.get(1)).add(rs.getString(3));

			}
			dbConn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return courseInfo;

	}

	public static List<String> findPeerIdByUrl(String peerUrl, String dbUrl,
			String dbUser, String dbPass) {
		List<String> peers = new ArrayList<String>();
		try {
			String sql = "SELECT id FROM mnet_host WHERE wwwroot = '" + peerUrl
					+ "'";

			Connection dbConn = connectToDB(dbUrl, dbUser, dbPass);

			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				peers.add(rs.getString(0));

			}
			dbConn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return peers;

	}

	public static Connection connectToDB(String dbUrl, String dbUser,
			String dbPass) {
		String url = "jdbc:mysql://" + dbUrl;
		Connection dbConn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection(url, dbUser, dbPass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return dbConn;

	}

}