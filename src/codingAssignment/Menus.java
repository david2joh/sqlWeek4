package codingAssignment;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import groceryListDao.GLDao;

public class Menus {
	private  List<String> glOptions = Arrays.asList(
			"Display Grocery Lists",
			"Choose a Grocery List",
			"Create a Grocery List",
			"Change Grocery List Name",
			"Delete a Grocery List" );
	// private GLDao gldao = new GLDao();
	private groceryList gl;
	Scanner kb;
	String selection;
	int current_gID;

	public Menus() {
		gl = new groceryList();
		current_gID = 0;
		selection  = "";
		kb = new Scanner(System.in);
	}

	public void startMenu () {
		try {
			do {
				displayGroceryListsMenu();
				selection =  kb.nextLine();
				if (selection.equals("1")) { 
					displayGroceryLists();
				} else if (selection.equals("2")) { 
					current_gID = selectGroceryList();
					//groceryListItemsMenu();  -- to be implemented later as a learning exercise
					//                         -- submenus and filling items into each grocery list
				} else if (selection.equals("3")) { 
					createGroceryList();
				} else if (selection.equals("4")) { 
					changeGroceryList();
				} else if (selection.equals("5")) { 
					deleteGroceryList();	
				} else if (selection.equals("-1")) { break; }
				else {
					System.out.println("Please Enter a valid selection   ...... -1 to exit");
				}

				System.out.println("Press enter to continue ........");
				kb.nextLine();
			} while (!selection.equals("-1"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	private int selectGroceryList() throws SQLException {
		int gSelect = 0;
		boolean validSelection = false;
		do {
			gSelect = 0;
			System.out.println("Choose a Grocery List -----------");
			int glsize = displayGroceryLists();
			if (glsize > 0) {
				gSelect = Integer.parseInt(kb.nextLine());  //Really should surround this with NumberFormat Exception
				if (gSelect > 0 && gSelect <= glsize) validSelection = true;
			} else validSelection = true;
		} while (!validSelection);
		return gSelect;
	}

	private int displayGroceryLists() throws SQLException {
		int glsize = gl.displayGroceryLists();
		return glsize;
	}

	private void displayGroceryListsMenu() {
		System.out.println("--- Grocery Lists ---");
		for (int i = 0; i < glOptions.size(); i++) {
			System.out.println(i+1 +".) " + glOptions.get(i));
		}

	}

	private void createGroceryList() throws SQLException {
		System.out.println("Enter a Grocery List Name ---");
		String gName = kb.nextLine();
		try {
			gl.addGroceryList(gName);
			System.out.println("added grocery List : " +gName);
		} catch (SQLException e) {
			throw(e);
		}
	}

	private void changeGroceryList() throws SQLException {
		displayGroceryLists();
		System.out.println("Enter a Grocery List ID to change the name of ---");
		int gID = Integer.parseInt(kb.nextLine());
		System.out.println("Enter a New Name --------------------------------");
		String gName = kb.nextLine();
		gl.changeGroceryList(gID,gName);
	}

	private void deleteGroceryList() throws SQLException {
		displayGroceryLists();
		System.out.println("Enter a Grocery List ID to delete ---");
		int gID = kb.nextInt();
		gl.deleteGroceryList(gID);
	}

	
}
