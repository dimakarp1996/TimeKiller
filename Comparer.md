import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.timezone;

public class Comparer extends TimeKiller
{


	
	

long TimeTransformer(TimeKiller a)
{

	String date = new String ();
	date=date+day+""+month+""+year+""+hour+""+minute+""+second;


SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" dd mm yyyy HH mm ss");

try {
    Date date1 =  simpleDateFormat.parse(date);
    System.out.println("Date is parsed");
    return ((long)date1.getTime());

} catch (java.text.ParseException e) {
	System.out.println("Error");
    return -1;
} 
}

public long Compare(TimeKiller a)//вставить аргументы
{
int count=0;
long begin= System.currentTimeMillis(); //это сколько миллисекунд прошло от начала года
long end=TimeTransformer(a);
if(end>begin) 
{
	return end-begin;
}
else
{
	System.out.println("Error");
	return -1;
}
	long currenttime=0;
	double percent=0;
	String filename=new String ();
	//пишем старую дату
	Calendar.setTime(date);
	filename=filename++""+Calendar.get(Calendar.MONTH)+""+Calendar.get(Calendar.YEAR)+""+Calendar.get(Calendar.HOUR)+""+Calendar.get(Calendar.MINUTE)+""+Calendar.get(Calendar.SECOND);
	filename=filename+day+""+month+""+year+""+hour+""+minute+""+second+".txt";//это мы записали финальную дату
	try{
		File file = new File(filename);//txt файл имя - нач кон время

	        if(!file.exists())
		        {
		            file.createNewFile();
		        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 

	    } 
	catch(IOException e) 
		{
	        throw new RuntimeException(e);
	    }
	
	do
	{
		currenttime=System.currentTimeMillis();
		percent= ((double)(end-currenttime)/(double)(end-begin));
		 out.print("%f \n",percent);
		//пишем в файл расстояние в процентах
	}
	while(currenttime<end);

	System.out.println("All is recorded");
    out.close();
    return 0;
}



}
	