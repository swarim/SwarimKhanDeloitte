import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
public class MainClass {
	private int id;
    private String name;
    private String showDate;
    private String showTime;
    private String status;
	public MainClass(int id, String name, String showDate, String showTime,String status) {
		super();
		this.id = id;
		this.name = name;
		this.showDate = showDate;
		this.showTime = showTime;
		this.status = status;
	}
	public MainClass() {
		System.out.println("Enter ID, Name, Showdate, Showtime, Status");
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowdate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public static void main(String[] Args)
	{   Scanner input= new Scanner(System.in);
	    List<MainClass> mainList = new ArrayList<>();
		MainClass mainObj = new MainClass();
		 int id=input.nextInt();
		 String name=input.nextLine();
		 String showdate=input.nextLine();
		 String showtime=input.nextLine();
		 String status=input.nextLine();
		 input.nextLine();
		 mainObj = new MainClass(id,name,showdate,showtime,status);
		 mainList.add(mainObj);
		 System.out.println(mainList);
		 
      		
		
	}
	
	}



