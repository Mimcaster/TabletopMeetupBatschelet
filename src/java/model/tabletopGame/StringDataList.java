/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tabletopGame;

import java.util.ArrayList;
import java.sql.ResultSet;


// The purpose of this class is to have a nice java object that can be converted to JSON 
// to communicate everything necessary to the web page (the array of users plus a possible 
// list level database error message). 
public class StringDataList {

    public String dbError = "";
    public ArrayList<model.tabletopGame.StringData> tabletopGameList = new ArrayList();

    // Default constructor leaves StringDataList objects nicely set with properties 
    // indicating no database error and 0 elements in the list.
    public StringDataList() {
    }

    // Adds one StringData element to the array list of StringData elements
    public void add(model.tabletopGame.StringData stringData) {
        this.tabletopGameList.add(stringData);
    }

    // Adds creates a StringData element from a ResultSet (from SQL select statement), 
    // then adds that new element to the array list of StringData elements.
    public void add(ResultSet results) {
        model.tabletopGame.StringData sd = new model.tabletopGame.StringData(results);
        this.tabletopGameList.add(sd);
    }
}
