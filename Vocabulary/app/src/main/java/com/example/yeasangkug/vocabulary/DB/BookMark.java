package com.example.yeasangkug.vocabulary.DB;

/**
 * Created by yeasangkug on 2016. 5. 24..
 */
public class BookMark {

    public final static String DB_NAME = "MyVocabulary.db";
    public final static String DB_TABLE_WORD = "WORD";
    public final static String DB_COL_WORD = "WORD";
    public final static String DB_COL_MEAN = "MEAN";

    public final static String DB_SQL_CREATE = "CREATE TABLE "+DB_TABLE_WORD+" "
            + "(_id Integer PRIMARY KEY AUTOINCREMENT, "
            +DB_COL_WORD+" TEXT, "+DB_COL_MEAN+" TEXT);";

    public final static String DB_SQL_ALL_SELECT = "SELECT * FROM "+DB_TABLE_WORD;

    public final static String DB_SQL_SELECT = "SELECT "+DB_COL_WORD+","+DB_COL_MEAN+" FROM "
            +DB_TABLE_WORD+" "+"WHERE "+DB_COL_WORD+" = ";

    public final static String DB_SQL_INSERT = "INSERT INTO "+DB_TABLE_WORD+" "
            +"("+DB_COL_WORD+","+DB_COL_MEAN+") VALUES (?,?);";

    public final static String DB_SQL_DELETE = "DELETE FROM "+DB_TABLE_WORD+" "
            +"WHERE "+DB_COL_WORD+" = ?;";

    public final static String DB_SQL_UPDATE = "UPDATE "+DB_TABLE_WORD+" SET "
            +DB_COL_WORD+" =?, "+DB_COL_MEAN+" =? WHERE "+DB_TABLE_WORD+" =?;";

}
