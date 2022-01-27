package groceryListDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class GLDao {

	private Connection conn;
	private final String GET_GLIST_QUERY = "SELECT * FROM glist";
	private LocalDate gDate;
	private String INSERT_GLIST = "INSERT INTO glist ( g_name  ) VALUES (?)";
	private String DELETE_GLIST = "DELETE FROM  glist where g_id = ?";
	private String UPDATE_GLIST = "UPDATE glist SET g_name = ? WHERE g_id = ?";
	private final String QUERY_FOR_NEWEST_GID_STRING ="SELECT MAX(g_id) FROM glist";


	public class glcolumns {
		LocalDate ldate;
		String gname;

		public String toString() {
			String str = ldate.toString() + " " + gname;
			return str;
		}
	}

	public GLDao () {
		conn = DBConnection.getConnection();
	}

	public Map<Integer,glcolumns> getGroceryLists() throws SQLException  {
		ResultSet rs = conn.prepareStatement(GET_GLIST_QUERY).executeQuery();
		Map<Integer,glcolumns> glMap = new TreeMap<>();
		while (rs.next()) {
			glcolumns glc = new glcolumns();
			glc.ldate =  rs.getDate(2).toLocalDate();
			glc.gname =  rs.getString(3);
			glMap.put ( ((Integer)rs.getInt(1)) , glc);
		}
		return glMap;
	}

	public int displayGroceryLists() throws SQLException {
		int glsize = 0;
		Map<Integer,glcolumns> glMap = getGroceryLists();
		for (Map.Entry<Integer, glcolumns> gl : glMap.entrySet()) {
			System.out.println(gl.getKey()  + " : " + gl.getValue().toString() +"\n");
			glsize++;
		}
		return glsize;
	}

	public void newGList(String gname) throws SQLException {
		PreparedStatement ps =  conn.prepareStatement(INSERT_GLIST);
		ps.setString(1, gname);
		ps.executeUpdate();

	}

	public void deleteGL(int glID) throws SQLException {
		PreparedStatement ps =  conn.prepareStatement(DELETE_GLIST);
		ps.setInt(1,glID);
		ps.executeUpdate();
	}

	public void changeGLName(int glID, String gName) throws SQLException {
		PreparedStatement ps =  conn.prepareStatement(UPDATE_GLIST);
		ps.setString(1, gName);
		ps.setInt(2, glID);
		ps.executeUpdate();
	}




}
