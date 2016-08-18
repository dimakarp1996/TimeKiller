import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Comparer /*extends TimeKiller*/
{


	
static void printf(TimeKiller a)	
{
	System.out.printf("Timekiller date is %d/%d/%d/%d/%d",a.day,a.month,a.year,a.hour,a.minute);
}

static long TimeTransformer(TimeKiller a)
{
	a.month=a.month-1;
	String date = new String ();
	date=date+a.day+"/"+a.month+"/"+a.year+"/"+a.hour+"/"+a.minute+"/"+a.second;

System.out.print("Timetransforming date \n");
System.out.print(date);
System.out.print("\n");
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy/HH/mm/ss");

try {
    Date date1 =  simpleDateFormat.parse(date);
    System.out.println("Date is parsed");
    return ((long)date1.getTime());//неправильно парсит!!!!!!!!

} catch (java.text.ParseException e) {
	System.out.println("Error parsing date");
    return -1;
} 
}
/*
 public class MyClass
{
   public void myMethod()
   {
      myNonStaticMethod(); 
   }
 
   public void myNonStaticMethod()
   {
   }
}
 */

public static long Compare(TimeKiller a) //вставить аргументы
{
int count=0;
Calendar calendar = Calendar.getInstance();
int day=calendar.get(calendar.DAY_OF_MONTH);
int month=calendar.get(calendar.MONTH)+1;
int year=calendar.get(calendar.YEAR);
int hour=calendar.get(calendar.HOUR_OF_DAY);
int minute=calendar.get(calendar.MINUTE);
int second=calendar.get(calendar.SECOND);
System.out.print("Setting TimeKiller as current date and time");
TimeKiller b=new TimeKiller(day,month,year,hour,minute,second);
//long begin= System.currentTimeMillis(); //это сколько миллисекунд прошло от начала 1970 года
System.out.print("System interpreted current TimeKiller date is \n");
printf(b);
System.out.print("\n");
System.out.print("System interpreted end TimeKiller date is \n");
printf(a);//here we find out that a is the same as b, why????????????
long end=TimeTransformer(a);
System.out.print("a is transformed \n");
long begin=TimeTransformer(b);
System.out.print("b is transformed \n");
Date begindate=new Date(begin);
//пишем старую дату

System.out.print("\n");
System.out.print("System interpreted current date is \n");
System.out.print(begindate);
System.out.print("\n");
Date enddate=new Date(end);
System.out.print("System interpreted end date is \n");
System.out.print(enddate);
System.out.print("\n");
if(end<=begin) 
{
	System.out.println("Error: end date has already come ");
	return -1;
}


	long currenttime=0;
	double percent=0;
	String filename=new String ();

	
	//пишем старую дату
	System.out.print("System interpreted current date is \n");
	System.out.print(begindate);
	
	System.out.print("System interpreted end date is \n");
	System.out.print(enddate);
	filename=filename+calendar.get(calendar.DAY_OF_MONTH)+"."+calendar.get(calendar.MONTH)+"."+calendar.get(calendar.YEAR)+"."+calendar.get(calendar.HOUR_OF_DAY)+"."+calendar.get(calendar.MINUTE)+"."+calendar.get(calendar.SECOND)+"-";
	filename=filename+a.day+"."+a.month+"."+a.year+"."+a.hour+"."+a.minute+"."+a.second+".txt";//это мы записали финальную дату
	System.out.print("Filename is ");
	System.out.print(filename);
		File file = new File(filename);//txt файл имя - нач кон время
			try
			{
		        if(!file.exists())
			        {
			            file.createNewFile();
			            System.out.print("File created");
			        }
			}
	       catch(IOException e)
			{
				System.out.print("Exception occurred while creating file");
				return -1;
			}
	 


	try
	{
	 PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	
	
	do
	{
		currenttime=System.currentTimeMillis();
		percent= ((double)(end-currenttime)/(double)(end-begin));
		 out.printf("%f \n",percent);
		//пишем в файл расстояние в процентах
	}
	while(currenttime<end);

	System.out.println("All is recorded");
	out.close();
	}
	catch(FileNotFoundException e)
	{
		System.out.print("File not found");
		return -1;
	}
    
    return 0;
}

public static void main(String[] args){
	System.out.print("Input date in format DAY MONTH YEAR HOUR MINUTE");
	
	Scanner in=new Scanner(System.in);
	int count=0;
	int day=0;
	int month=0;
	int year=0;
	int second=0;
	int minute=0;
	int hour=0;
	//do {
		switch (count)
		{
		case 0:
		System.out.print("Input day \n");
		day=in.nextInt();
		System.out.printf("Final day is %d \n", day);
		count++;
		case 1:
		System.out.print("Input month \n");	
		month=in.nextInt();
		System.out.printf("Final month is %d \n",month);
		count++;
		case 2:
		System.out.print("Input year \n");	
		year=in.nextInt();
		System.out.printf("Final year is %d  \n",year);
		count++;
		case 3:
		System.out.print("Input hour \n");	
		hour=in.nextInt();
		System.out.printf("Final hour is %d \n",hour);
		count++;
		case 4:
		System.out.print("Input minute \n");	
		minute=in.nextInt();
		System.out.printf("Final minute is %d \n",minute);
		count++;
		case 5:
		//second=in.nextInt();
		second=0;
		System.out.printf("Final second is %d \n",second);
		count++;
		in.close();

		}
		System.out.print("Setting TimeKiller with final date");
		//if((0=<year<9999)&&(0<=month<13)&&(0<=day<32)&&(0<=hour<24)&&(0<=minute<60))
		 TimeKiller a = new TimeKiller(day,month,year,hour,minute,second);
		//a.MaxLengthCheck(day,month,year,hour,minute,second);

	
	  
	   Comparer.Compare(a);
	   in.close();

	}

}
	
	
	
	