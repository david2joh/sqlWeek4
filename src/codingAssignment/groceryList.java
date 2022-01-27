package codingAssignment;

import java.sql.SQLException;

import java.util.Map;

import groceryListDao.GLDao;
import groceryListDao.GLDao.glcolumns;

public class groceryList {

	private int gID;
	private Map<Integer,groceryListDao.GLDao.glcolumns> glists;


	private final static GLDao gld  = new GLDao();		

	//
	//  -- to be used later as a learning exercise
	//  private Map<Integer,groceryItem> items;
	//	private int itemID;
	//	

	public groceryList() {
		gID = 0;
	}

	private int getgID() {
		return gID;
	}

	private void setgID(int gID) {
		this.gID = gID;
	}

	public int displayGroceryLists() throws SQLException {
		int glsize = 0;
		Map<Integer,glcolumns> glMap = gld.getGroceryLists();
		for (Map.Entry<Integer, glcolumns> gl : glMap.entrySet()) {
			System.out.println(gl.getKey()  + " : " + gl.getValue().toString() +"\n");
			glsize++;
		}
		return glsize;
	}

	public void addGroceryList(String gname) throws SQLException {
		//-- for later  TreeMap<Integer,groceryListDao.GLDao.glcolumns> glists = new TreeMap<Integer,groceryListDao.GLDao.glcolumns>();
		// -- for later INSERT INTO THE GROCERY LIST AND RETRIEVE THE DB Values of id and date/time
		gld.newGList(gname);
		return;
	}

	public void changeGroceryList(int glID, String gName) throws SQLException {
		gld.changeGLName(glID,gName);

	}

	public void deleteGroceryList(int glID) throws SQLException {
		gld.deleteGL(glID);
	}

			

	//
	//  -- to be used later as a learning exercise
	//  Add items into grocercy lists 
	//	private Map<Integer, groceryItem> getItems() {
	//		return items;
	//	}
	//
	//	private void setItems(Map<Integer, groceryItem> items) {
	//		this.items = items;
	//	}
	//
	//	private int getItemID() {
	//		return itemID;
	//	}
	//
	//	private void setItemID(int itemID) {
	//		this.itemID = itemID;
	//	}
	//

	//  -- to be used later as a learning exercise	
	//	public String toString() {
	//		//to do implement
	//		StringBuilder sb = new StringBuilder("");
	//		for (Map.Entry<Integer, groceryItem> item : items.entrySet()) {
	//			sb.append(item.getKey()  + " : " + item.getValue() +"\n");
	//		}
	//		return sb.toString();
	//	}


}
