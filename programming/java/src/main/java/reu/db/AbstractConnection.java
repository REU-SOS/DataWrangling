package reu.db;

import java.sql.ResultSet;

public abstract class AbstractConnection 
{
	public abstract void Init(String db, String user, String pass);
	public abstract ResultSet Query(String q);
}
