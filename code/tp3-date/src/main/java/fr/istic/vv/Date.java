package fr.istic.vv;


class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;

    public Date(int day, int month, int year) {
    	if(!isValidDate(day,month,year))  throw new IllegalArgumentException("Date is not valide");
    	this.day=day;
    	this.month=month;
    	this.year=year;
    }

    public static boolean isValidDate(int day, int month, int year) {
    	if(day <1 || day>31) {
    		return false;
    	}

    	if(month < 1 || month > 12) {
    		return false;
    	}

    	if(year < 0) {
    		return false;
    	}

    	if((month ==4 || month ==6 || month ==9 || month ==11) && day>=31) {
    		return false;
    	}

    	if(!isLeapYear(year) && month==2 && day>=29) {
    		return false;
    	}
    	return true;
    }

    public static boolean isLeapYear(int year) {
    	if(year <0 ) {
    		return false;
    	}
    	boolean ret=true;
    	if((year % 4) !=0) {
    		ret=false;
    	}

    	if((year%100)==0) {
    		if((year%400)!=0){
    			ret=false;
    		}
    	}

    	return ret;
    }

    public Date nextDate() {

    	if((this.month ==4 || this.month ==6 || this.month ==9 || this.month ==11) && this.day==30) {
    		return new Date(1,this.month+1,this.year);
    	}
    	if(this.day==31) {
    		if(this.month==12) {
    			return new Date(1,1,this.year+1);
    		}else {
    			return new Date(1,this.month+1,this.year);
    		}
    	}

    	if( this.month==2 && this.day==28 && isLeapYear(this.year)) {
    		return new Date(this.day+1,this.month,this.year);
    	}

    	if(this.month==2 && this.day==28) {
    		return new Date(1,this.month+1,this.year);
    	}

    	return new Date(this.day+1,this.month,this.year);
    }

    public Date previousDate() {

    	if(this.day==1) {
    		if(this.month==5 || this.month==7 || this.month==10 || this.month==12) {
    			return new Date(30,this.month-1,this.year);
    		}

    		if(this.month==1) {
    			return new Date(31,12,this.year-1);
    		}

    		if(this.month==3) {
    			if(isLeapYear(year)) {
    				return new Date(29,this.month-1,this.year);
    			}else {
    				return new Date(28,this.month-1,this.year);
    			}
    		}
    		return new Date(31,this.month-1,this.year);
    	}
    	return new Date(this.day-1,this.month,this.year);
    }

    public int compareTo(Date other) {

    	if(this.year > other.year) {
    		return 1;
    	}

    	if((other.year==this.year) &&(this.month > other.month)) {
    		return 1;
    	}

    	if((other.year==this.year) && (this.month==other.month) && (this.day > other.day)) {
    		return 1;
    	}
    	if((other.year==this.year) && (this.month==other.month) && (this.day == other.day)) {
    		return 0;
    	}
    	return -1;
    }

    public String toString() {
    	return this.day+"/"+this.month+"/"+this.year;
    }


}
