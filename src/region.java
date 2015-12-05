

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JPanel;

import javafx.scene.shape.Circle;

import java.awt.Polygon;

@SuppressWarnings("serial")
public class region extends JPanel
{
	private boolean initial = false;
	private  boolean flag = false;
	private boolean flag2 = false;
	private boolean flag3 = false;
	private boolean flag4 = false;
	private boolean flag5 = false;
	private boolean flag6 = false;
	private boolean flag7 = false;
	private boolean flag8 = false;
	private boolean flag9 = false;
	private boolean flag10 = false;
	private boolean flag11 = false;
	private boolean flag12 = false;
	private boolean flag13 = false;
	private boolean flag14 = false;
	private boolean flag15 = false;
	private boolean flag16 = false;
	

	private ArrayList<Integer> x;
	private ArrayList<Integer> y;
	private ArrayList<Polygon> list = new ArrayList<>();
	private ArrayList<Ellipse2D> clist = new ArrayList<>();
	private ArrayList<Ellipse2D> plist = new ArrayList<>();
	private HashMap<String,Polygon> map = new HashMap<>();
	private HashMap<String,Ellipse2D> cmap = new HashMap<>();
	private HashMap<String,Ellipse2D> pmap = new HashMap<>();
	private ArrayList<String> str_id = new ArrayList<>();
	private ArrayList<String> str_x = new ArrayList<>();
	private ArrayList<String> str_y = new ArrayList<>();

	public region()
	{
		super();
	}
	
	public void paintComponent(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;
//		File f = new File("/Users/shitaichen/region.txt");
		Scanner in = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:homework", "system", "Cstgyxlove1993");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select r.region_id as id, t.X as X, t.Y as Y from region r, table(SDO_UTIL.GETVERTICES(r.shape)) t order by id");//不能有；号！！！
			StringBuilder temp = new StringBuilder();
			while(rs.next())
			{
				str_id.add(rs.getString("id").trim());
				str_x.add(rs.getString("X"));
				str_y.add(rs.getString("Y"));
			}
		}catch(Exception err){
			System.out.println(err.toString());
		}
			int count = 1;
			int num = 0;
			while(num < str_id.size())
			{
				count = 0;
				x = new ArrayList<>();
				y = new ArrayList<>();
				while(count < 4)
				{
				
					x.add(Integer.parseInt(str_x.get(num)));
					y.add(500 - Integer.parseInt(str_y.get(num)));
					count ++;
					num ++;
				}
				Polygon p = new Polygon();
				for(int i = 0; i < x.size(); i++)
				{
					p.addPoint(x.get(i), y.get(i));
				}
				map.put(str_id.get(num), p);
				list.add(p);
				num ++;
			}
		System.out.println(str_id);
		g2.setColor(Color.black);
		for(int i = 0; i < list.size(); i++)
		{
			g2.draw(list.get(i));
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////
		str_id  = new ArrayList<>();
		str_x  = new ArrayList<>();
		str_y  = new ArrayList<>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:homework", "system", "Cstgyxlove1993");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select pond_id as id, t.X as X, t.Y as Y from pond p, table(SDO_UTIL.GETVERTICES(p.shape)) t");//不能有；号！！！
			while(rs.next())
			{
				str_id.add(rs.getString("id").trim());
				str_x.add(rs.getString("X"));
				str_y.add(rs.getString("Y"));
			}
		}catch(Exception err){
			System.out.println(err.toString());
		}
		System.out.println(str_id);
			count = 0;
			num = 0;
			while(num < str_id.size())
			{
				count = 0;
				x = new ArrayList<>();
				y = new ArrayList<>();
				while(count < 2)
				{
				
					x.add(Integer.parseInt(str_x.get(num)));
					y.add(500 - Integer.parseInt(str_y.get(num)));
					count ++;
					num ++;
				}
				Ellipse2D.Double circle = new Ellipse2D.Double(x.get(0) - 15, y.get(0), 15, 15);
				cmap.put(str_id.get(num), circle);
				clist.add(circle);
				num ++;		
			}
			
		for(int i = 0; i < clist.size(); i++)
		{
			g2.setColor(Color.black);
			g2.draw(clist.get(i));
			g2.setColor(Color.blue);
			g2.fill(clist.get(i));
		}
		
		
//////////////////////////////////////////////////////////////////////////////////////////////
		str_id  = new ArrayList<>();
		str_x  = new ArrayList<>();
		str_y  = new ArrayList<>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:homework", "system", "Cstgyxlove1993");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select l.id as id, t.X as X, t.Y as Y from lion l, table(SDO_UTIL.GETVERTICES(l.shape)) t");//不能有；号！！！
			while(rs.next())
			{
				str_id.add(rs.getString("id").trim());
				str_x.add(rs.getString("X"));
				str_y.add(rs.getString("Y"));
			}
		}catch(Exception err){
			System.out.println(err.toString());
		}
		System.out.println(str_id);
			count = 0;
			num = 0;
			while(num < str_id.size())
			{
				count = 0;
				x = new ArrayList<>();
				y = new ArrayList<>();
				while(count < 1)
				{
				
					x.add(Integer.parseInt(str_x.get(num)));
					y.add(500 - Integer.parseInt(str_y.get(num)));
					count ++;
					num ++;
				}
				Ellipse2D.Double lion = new Ellipse2D.Double(x.get(0) - 5, y.get(0) + 5, 5, 5);
				pmap.put(str_id.get(num), lion);
				plist.add(lion);
				num ++;	
			}
		for(int i = 0; i < plist.size(); i++)
		{
//			g2.setColor(Color.black);
			g2.setColor(Color.green);
			g2.draw(plist.get(i));
			g2.fill(plist.get(i));
		}
	}

	
	
	
	private void initial()
	{
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.setColor(Color.black);
		for(int i = 0; i < list.size(); i++)
		{
			g2.draw(list.get(i));
		}
		for(int i = 0; i < clist.size(); i++)
		{
			g2.setColor(Color.black);
			g2.draw(clist.get(i));
			g2.setColor(Color.blue);
			g2.fill(clist.get(i));
		}
		for(int i = 0; i < plist.size(); i++)
		{
//			g2.setColor(Color.black);
			g2.setColor(Color.green);
			g2.draw(plist.get(i));
			g2.fill(plist.get(i));
		}
		 flag = false;
		 flag2 = false;
		 flag3 = false;
		 flag4 = false;
		 flag5 = false;
		 flag6 = false;
		 flag7 = false;
		 flag8 = false;
		 flag9 = false;
		 flag10 = false;
		 flag11 = false;
		 flag12 = false;
		 flag13 = false;
		 flag14 = false;
		 flag15 = false;
		 flag16 = false;
	}
	
	
	private void Display_1() {
		if(!flag && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R1"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R1"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R1").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R1").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag = !flag;
	}
		
	private void Display_2() {
		if(!flag2 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R2"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R2"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R2").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R2").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag2 = !flag2;
	}
	
	private void Display_3() {
		if(!flag3 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R3"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R3"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R3").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R3").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag3 = !flag3;
	}
	
	private void Display_4() {
		if(!flag4 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R4"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R4"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R4").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R4").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag4 = !flag4;
	}
	
	private void Display_5() {
		if(!flag5 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R5"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R5"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R5").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R5").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag5 = !flag5;
	}
	
	private void Display_6() {
		if(!flag6 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R6"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R6"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R6").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R6").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag6 = !flag6;
	}
	
	private void Display_7() {
		if(!flag7 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R7"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R7"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R7").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R7").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag7 = !flag7;
	}
	
	private void Display_8() {
		if(!flag8 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R7"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R7"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R8").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R8").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag8 = !flag8;
	}
	
	private void Display_9() {
		if(!flag9 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R9"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R9"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R9").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R9").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag9 = !flag9;
	}
	
	private void Display_10() {
		if(!flag10 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R10"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R10"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R10").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R10").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag10 = !flag10;
	}
	
	private void Display_11() {
		if(!flag11 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R11"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R11"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R11").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R11").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag11 = !flag11;
	}
	
	private void Display_12() {
		if(!flag12 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R12"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R12"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R12").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R12").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag12 = !flag12;
	}
	
	private void Display_13() {
		if(!flag13 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R13"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R13"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R13").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R13").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag13 = !flag13;
	}
	
	private void Display_14() {
		if(!flag14 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R14"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R14"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R14").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R14").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag14 = !flag14;
	}
	
	private void Display_15() {
		if(!flag15 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R15"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R15"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R15").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R15").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag15 = !flag15;
	}
	
	private void Display_16() {
		if(!flag16 && initial)
		{
			Graphics2D g2 = (Graphics2D) getGraphics();
			for(Map.Entry<String,Polygon> iter : map.entrySet())
			{	
				if(iter.getKey().equals("R16"))
				{
					continue;
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(iter.getValue());
				}
			}
			g2.setColor(Color.red);
			g2.draw(map.get("R16"));
			
			for(int i = 0; i < clist.size(); i++)
			{
				if(map.get("R16").contains(clist.get(i).getBounds2D()))
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.red);
					g2.fill(clist.get(i));
				}
				else
				{
					g2.setColor(Color.black);
					g2.draw(clist.get(i));
					g2.setColor(Color.blue);
					g2.fill(clist.get(i));
				}
				
			}
			for(int i = 0; i < plist.size(); i++)
			{
				if(map.get("R16").contains(plist.get(i).getBounds2D()))
				{
					g2.setColor(Color.red);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
				else
				{
					g2.setColor(Color.green);
					g2.draw(plist.get(i));
					g2.fill(plist.get(i));
				}
			}
		}
		flag16 = !flag16;
	}

	
	public void set_start()
	{
		initial();
		initial = !initial;
	}
	
	public void startDynamic_1() {
		initial();
		Display_1();
	}
	
	public void startDynamic_2()
	{
		initial();
		Display_2();
	}
	
	public void startDynamic_3()
	{
		initial();
		Display_3();
	}
	public void startDynamic_4()
	{
		initial();
		Display_4();
	}
	public void startDynamic_5()
	{
		initial();
		Display_5();
	}
	public void startDynamic_6()
	{
		initial();
		Display_6();
	}
	public void startDynamic_7()
	{
		initial();
		Display_7();
	}
	public void startDynamic_8()
	{
		initial();
		Display_8();
	}
	public void startDynamic_9()
	{
		initial();
		Display_9();
	}
	public void startDynamic_10()
	{
		initial();
		Display_10();
	}
	public void startDynamic_11()
	{
		initial();
		Display_11();
	}
	public void startDynamic_12()
	{
		initial();
		Display_12();
	}
	public void startDynamic_13()
	{
		initial();
		Display_13();
	}
	public void startDynamic_14()
	{
		initial();
		Display_14();
	}
	public void startDynamic_15()
	{
		initial();
		Display_15();
	}
	public void startDynamic_16()
	{
		initial();
		Display_16();
	}
	
	
}