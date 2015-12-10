package com.learning.functions;

import java.sql.*;

/**
 * Created by Syam on 23-10-2015.
 */
public class DB {

    static Connection connection = null;
    static Statement statement;
    static String DB_URL="jdbc:mysql://localhost:3306/automation";
    static String DB_USERNAME="root";
    static String DB_PASSWORD="root";

    public static void SetUp()throws Exception{
        try{

            String dbClass = "com.mysql.jdbc.Driver";
            Class.forName(dbClass).newInstance();

            //get DB Connection
          connection=  DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
           statement =connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void tearDown() throws SQLException {
        if ( connection!=null){
            connection.close();
        }
    }
    public static String GetData( String tableName,String columnName,String columnValue,String sExpectedValue) throws Exception{
        SetUp();
        String query;
        //query= "Select * from " +tableName +" where " +columnName+ " = '" + sColumnValue +"'";
          query="Select * from " +tableName +" WHERE " +columnName + " = '" + columnValue +"'";
            ResultSet results;
        String ID=null;
       try{

            results=statement.executeQuery(query);
           if(results.next()){
            ID=results.getString(sExpectedValue);
            //  System.out.println(ID);
            }
           
        }
        catch (Exception e){
            e.printStackTrace();
        }
        tearDown();
        return ID ;
    }


}
