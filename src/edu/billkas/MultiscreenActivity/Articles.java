package edu.billkas.MultiscreenActivity;

import java.io.Serializable;

public class Articles implements Serializable{
	int id;
	String title;
	String date;

    private static final long serialVersionUID = 2304865599345677437L;

    public Articles(){
        super();
    }
/*
	public Articles(int id, String name, String date){
        super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	*/

    @Override
    public String toString(){
        return this.title;
    }
}
