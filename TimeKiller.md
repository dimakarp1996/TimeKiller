import java.util.Date;
import java.util.Scanner;
public class TimeKiller
{

static int year;
static int month;//перебор от 0 до 12 - arrayем или как там было
static int day;
static int hour;
static int minute;
static int second;
int errorflag;
static int MaxLength(int month, int year)
{
	/*if(month==1) return 31;
	if((month==2)&&(year%4==0)) return 28;
	if((month==2)&&(year%4!=0)) return 29;
	if(month==3) return 31;
	if(month==4) return 30;
	if(month==5) return 31;
	if(month==6) return 30;
	if(month==7) return 31;
	if(month==8) return 31;
	if(month==9) return 30;
	if(month==10) return 31;
	if(month==12) return 31;
	if(month==11) return 30;
	if((month<1)||(month>12)||(year<0))
	{
		System.out.println("Error");
		return -1;
	}*/


switch(month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12: 
	    return 31;
	case 4:
	case 6:
	case 9:
	case 11:
	return 30;

	case 2: 
	if(year%4==0) return 28;
	else return 29;
		default: 
		System.out.println("No such month");
	    return -1;
}
}
static int MaxLengthCheck(int day,int month,int year,int hour,int minute,int second)
{
	
	if((MaxLength(month,year)==-1)||(day<1)||(day>31)||(MaxLength(month,year)<day)||(hour>24)||(hour<0)||(minute>59)||(minute<0)||(second>59)||(second<0))
	{return -1;}
	else
	{return 1;}
		
}
TimeKiller()
{	
	System.out.println("Write wanted date in format DAY MONTH YEAR HOUR MIN SEC");
	Scanner in=new Scanner(System.in);
	int count=0;
	do {
		switch (count)
		{
		case 0:
		day=in.nextInt();
		System.out.printf("day is %d \n", day);
		count++;
		case 1:
		month=in.nextInt();
		System.out.printf("month is \n",month);
		count++;
		case 2:
		year=in.nextInt();
		System.out.printf("year is \n",year);
		count++;
		case 3:
		hour=in.nextInt();
		System.out.printf("hour is \n",hour);
		count++;
		case 4:
		minute=in.nextInt();
		System.out.printf("minute is \n",minute);
		count++;
		case 5:
		second=in.nextInt();
		System.out.printf("second is \n",second);
		count++;
		}
	}
	while(in.hasNextInt());
	if(count<7)
	{
		System.out.println ("Wrong date format");
		in.close();
		errorflag=1;
	}
	else
	{
		System.out.println ("Right date format");
		int d=MaxLengthCheck(day,month,year,hour,minute,second);
		in.close();
	}
}
}
/*String date = "2015-06-18T14:10:15.945158Z";

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

try {
    Date date1 =  simpleDateFormat.parse(date);

    Log.i("parse date :", date1.getTime() + "");

} catch (java.text.ParseException e) {
    e.printStackTrace();
} */	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
