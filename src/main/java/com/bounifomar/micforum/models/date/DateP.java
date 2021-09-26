package com.bounifomar.micforum.models.date;

import java.util.Calendar;
import java.util.Date;

public class DateP {
	
	/*
	 * This class is used only in jsp pages in order the ease of manipulation of Date api
	 */
	
	private Date date;
	private Calendar calendar;
	
	public DateP()
	{
		//Default constructor 
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		
		if(date != null)
		{
			this.calendar = Calendar.getInstance();
			this.calendar.setTime(date);
		}
	}

	public Integer getYear()
	{
		if( this.calendar != null)
			return this.calendar.get(Calendar.YEAR);
		
		return null;
	}
	
	public String getMonth()
	{
		if( this.calendar != null)
		{
			Integer month = this.calendar.get(Calendar.MONTH)+1;
			if(month >= 10)
				return String.valueOf(month);
			else
				return "0"+month;
		}
		
		return null;
	}
	
	public String getDay()
	{
		if( this.calendar != null)
		{
			Integer day = this.calendar.get(Calendar.DAY_OF_MONTH);
			if(day >= 10)
				return String.valueOf(day);
			else
				return "0"+day;
		}
		
		return null;
	}
}	
