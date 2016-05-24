package com.example.yeasangkug.vocabulary.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.yeasangkug.vocabulary.DTO.Item_Word;

import java.util.ArrayList;

/**
 * Created by yeasangkug on 2016. 5. 24..
 */
public class DBManager extends SQLiteOpenHelper{

    private final String TAG = "MyVocabulary";

    private final static int DB_VERSION = 1;
    private static SQLiteDatabase mSql;
    private static DBManager mDbManager;

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BookMark.DB_SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {

    }

    public void DB_Open()
    {
        mSql = getWritableDatabase();
    }

    public void DB_Close()
    {
        mSql.close();
    }

    public static DBManager get_DbManager(Context context)
    {
        if(mDbManager == null)
            mDbManager = new DBManager(context, BookMark.DB_NAME, null, DB_VERSION);

        return mDbManager;
    }


    // 모든 데이터 선택
    public ArrayList<Item_Word> allData()
    {
        if(mSql == null)
            DB_Open();

        ArrayList<Item_Word> list = new ArrayList<Item_Word>(1);
        Cursor c = null;


        c = mSql.rawQuery(BookMark.DB_SQL_ALL_SELECT,null);

        while(c.moveToNext())
        {
            String word = (String)c.getString(1);
            String mean = (String)c.getString(2);

            Item_Word item = new Item_Word(word, mean);
            list.add(item);
        }

        c.close();

        return list;
    }

    // 단어 찾기
    public ArrayList<Item_Word> selectData(String find)
    {
        if(mSql == null)
            DB_Open();

        ArrayList<Item_Word> list = new ArrayList<Item_Word>(1);
        Cursor c = null;
        c = mSql.rawQuery(BookMark.DB_SQL_SELECT+find,null);

        while(c.moveToNext())
        {
            String word = (String)c.getString(1);
            String mean = (String)c.getString(2);

            Item_Word item = new Item_Word(word, mean);
            list.add(item);
        }

        c.close();

        return list;
    }



    // 입력 메소드
    public void insert(String word, String mean)
    {
        if(mSql == null)
            DB_Open();

        SQLiteStatement statement = mSql.compileStatement(BookMark.DB_SQL_INSERT);

        statement.bindString(1,word);
        statement.bindString(2,mean);

        long result = statement.executeInsert();
        Log.i(TAG,"DB 입력 결과 : "+result);

        statement.close();
    }

    // 삭제 메소드
    public void delete(String word)
    {
        if(mSql == null)
            DB_Open();

        SQLiteStatement statement = mSql.compileStatement(BookMark.DB_SQL_DELETE);

        statement.bindString(1,word);

        long result = statement.executeUpdateDelete();
        Log.i(TAG,"DB 삭제 결과 : "+result);

        statement.close();

    }


    // 수정 메소드
    public void modify(String word, String mean)
    {
        if(mSql == null)
            DB_Open();

        SQLiteStatement statement = mSql.compileStatement(BookMark.DB_SQL_UPDATE);

        statement.bindString(1,word);
        statement.bindString(2,mean);

        long result = statement.executeUpdateDelete();
        Log.i(TAG,"DB 수정 결과 : "+result);

        statement.close();
    }


}
