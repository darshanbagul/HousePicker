import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;



public class Main {
	ArrayList<Float> userPref=new ArrayList<Float>();
	String filename="C:/Users/shweta/Documents/darshan/workspace/House Picker/HousingData.xls";
	ArrayList<Integer> indices=new ArrayList<Integer>();
	ArrayList<Float> bestPossibleConf=new ArrayList<Float>();
	public Main(){
		final JFrame frame = new JFrame("House Picker 1.0");
		final JFrame frame1 = new JFrame("House Picker 1.0");
		//frame.setLayout(new GridLayout(2, 1));
		final JPanel panel1= new JPanel(new GridLayout(40,1));
		panel1.setSize(400, 750);
		JLabel label1=new JLabel("Enter Number of rooms(>3)");
		final TextField tf1=new TextField(3);
		JLabel label2=new JLabel("Do you prefer it river side?");
		final CheckboxGroup cg=new CheckboxGroup();
		Checkbox yes1= new Checkbox("Yes", cg, true);
		Checkbox no1= new Checkbox("No", cg, false);
		
		JLabel label3=new JLabel("Construction Age");
		final CheckboxGroup cg2=new CheckboxGroup();
		Checkbox new1= new Checkbox("New", cg2, true);
		Checkbox med1= new Checkbox("Medieval", cg2, false);
		Checkbox old1= new Checkbox("Old", cg2, false);
		
		JLabel label4=new JLabel("Choose max allowable distance from top 5 employment centres");
		final CheckboxGroup cg3=new CheckboxGroup();
		Checkbox Nearest= new Checkbox("Very Close", cg3, true);
		Checkbox near= new Checkbox("Nearby", cg3, false);
		Checkbox medium= new Checkbox("Driving distance", cg3, false);
		Checkbox far= new Checkbox("Far? No problem,I'll take a bus", cg3, false);
		Checkbox farthest= new Checkbox("I just need a place to stay", cg3, false);
		
		JLabel label5=new JLabel("Select index of accessibility to radial highways ");
		final CheckboxGroup cg4=new CheckboxGroup();
		Checkbox One= new Checkbox("1", cg4, true);
		Checkbox Two= new Checkbox("2", cg4, false);
		Checkbox Three= new Checkbox("3", cg4, false);
		Checkbox Four= new Checkbox("4", cg4, false);
		Checkbox Five= new Checkbox("5", cg4, false);
		Checkbox Six= new Checkbox("6", cg4, false);
		Checkbox Seven= new Checkbox("7", cg4, false);
		Checkbox Eight= new Checkbox("8", cg4, false);
		Checkbox Twnty4= new Checkbox("24", cg4, false);
		
		JLabel label6=new JLabel("Suggest need of educational institutes around your house");
		final CheckboxGroup cg5=new CheckboxGroup();
		Checkbox NotReqd= new Checkbox("Not much", cg5, true);
		Checkbox mod= new Checkbox("Moderate", cg5, false);
		Checkbox High= new Checkbox("I need educational institutes around", cg5, false);
		
		JLabel label7=new JLabel("Finally, please tell us about your budget(in $1000)");
		final CheckboxGroup cg6=new CheckboxGroup();
		Checkbox Cheapest= new Checkbox("less than 10", cg6, true);
		Checkbox cheap= new Checkbox("10-20", cg6, false);
		Checkbox oktypes= new Checkbox("20-30", cg6, false);
		Checkbox hifi= new Checkbox("30-40", cg6, false);
		Checkbox lavish= new Checkbox("Money not a factor", cg6, false);
		
		panel1.add(label1);
		panel1.add(tf1);
		panel1.add(label2);
		panel1.add(yes1);
		panel1.add(no1);
		panel1.add(label3);
		panel1.add(new1);
		panel1.add(med1);
		panel1.add(old1);
		panel1.add(label4);
		panel1.add(Nearest);
		panel1.add(near);
		panel1.add(medium);
		panel1.add(far);
		panel1.add(farthest);
		panel1.add(label5);
		panel1.add(One);
		panel1.add(Two);
		panel1.add(Three);
		panel1.add(Four);
		panel1.add(Five);
		panel1.add(Six);
		panel1.add(Seven);
		panel1.add(Eight);
		panel1.add(Twnty4);
		panel1.add(label6);
		panel1.add(NotReqd);
		panel1.add(mod);
		panel1.add(High);
		panel1.add(label7);
		panel1.add(Cheapest);
		panel1.add(cheap);
		panel1.add(oktypes);
		panel1.add(hifi);
		panel1.add(lavish);
		
		JButton submit =new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int roomNo;
				String temp1=tf1.getText();
				if(temp1.length()>0){
					roomNo=Integer.parseInt(temp1);
				}
				else{
					roomNo=3;
				}
				int riverside;
				int age;
				float dist;
				int accesInd;
				float pptrratio;
				float budget;
				if(cg.getSelectedCheckbox().getLabel()=="Yes"){
					riverside=1;
				}
				else{
					riverside=0;
				}
				//
				if(cg2.getSelectedCheckbox().getLabel()=="New"){
					age=3 + (int)(Math.random() * ((50 - 3) + 1));
				}
				else if(cg2.getSelectedCheckbox().getLabel()=="Medieval"){
					age=50 + (int)(Math.random() * ((80 - 50) + 1));
				}
				else{
					age=80 + (int)(Math.random() * ((100 - 80) + 1));
				}
				//
				if(cg3.getSelectedCheckbox().getLabel()=="Very Close"){
					dist=1+ (float)(Math.random() * ((2 - 1)));
				}
				else if(cg3.getSelectedCheckbox().getLabel()=="Nearby"){
					dist=2+ (float)(Math.random() * ((3 - 2)));
				}
				else if(cg3.getSelectedCheckbox().getLabel()=="Driving distance"){
					dist=3+ (float)(Math.random() * ((4 - 3)));
				}
				else if(cg3.getSelectedCheckbox().getLabel()=="Far? No problem,I'll take a bus"){
					dist=4+ (float)(Math.random() * ((8 - 4)));
				}
				else{
					dist=8+ (float)(Math.random() * ((13 - 8)));
				}
				//
				int temp=Integer.parseInt(cg4.getSelectedCheckbox().getLabel());
				if(temp==1){
					accesInd=1;
				}
				else if(temp==2){ accesInd=2;}
				else if(temp==3){ accesInd=3;}
				else if(temp==4){ accesInd=4;}
				else if(temp==5){ accesInd=5;}
				else if(temp==6){ accesInd=6;}
				else if(temp==7){ accesInd=7;}						
				else if(temp==8){ accesInd=8;}
				else{ 
					accesInd=24;
				}
				//
				if(cg5.getSelectedCheckbox().getLabel()=="Not much"){
					pptrratio=(float) (12.5+ (float)(Math.random() * ((16 - 12.5))));
				}
				else if(cg5.getSelectedCheckbox().getLabel()=="Moderate"){
					pptrratio= 16+ (float)(Math.random() * ((19 - 16)));
				}
				else{
					pptrratio= 19+ (float)(Math.random() * ((22 - 16)));
				}
				//budget
				if(cg6.getSelectedCheckbox().getLabel()=="less than 10")
				{
					budget=5+ (float)(Math.random() * ((10 - 5)));
				}
				else if(cg6.getSelectedCheckbox().getLabel()=="10-20"){
					budget=10+ (float)(Math.random() * ((20 - 10)));
				}
				else if(cg6.getSelectedCheckbox().getLabel()=="20-30"){
					budget=20+ (float)(Math.random() * ((30 - 20)));
				}
				else if(cg6.getSelectedCheckbox().getLabel()=="30-40"){
					budget=30+ (float)(Math.random() * ((40 - 30)));
				}
				else{
					budget=40+ (float)(Math.random() * ((50 - 40)));
				}
				
				System.out.println(roomNo+" "+riverside+" "+age+" "+dist+" "+accesInd+" "+pptrratio+" "+budget);
				userPref.add((float)roomNo);
				userPref.add((float)riverside);
				userPref.add((float) age);
				userPref.add(dist);
				userPref.add((float) accesInd);
				userPref.add(pptrratio);
				userPref.add(budget);
				
				bestPossibleConf=computeCosineSimilarity(userPref);
				JPanel panelOut=new JPanel(new GridLayout(15, 1));
				JLabel label10=new JLabel("The house that utmost satisfies your need has following features:");
				JLabel label11=new JLabel("No. of rooms: "+bestPossibleConf.get(5).toString());
				JLabel label12=new JLabel("Distance from Boston's top 5 employment centres: "+bestPossibleConf.get(7).toString());
				JLabel label13=new JLabel("The Highway access Index: "+bestPossibleConf.get(8).toString());
				JLabel label14=new JLabel();
				if(bestPossibleConf.get(10)>15){
					label14.setText("Educational facilities: Very Good; in terms of pupil-teacher ratio: "+bestPossibleConf.get(10).toString());
				}
				else{
					label14.setText("Educational facilities: Good; in terms of pupil-teacher ratio: "+bestPossibleConf.get(10).toString());
				}
				JLabel label15=new JLabel("Tax: $"+bestPossibleConf.get(13)/10 * bestPossibleConf.get(9));
				JLabel label16=new JLabel("And, budget for this house is: $"+bestPossibleConf.get(13)*1000);
				JLabel label17=new JLabel();
				
				panelOut.add(label10);
				panelOut.add(label11);
				panelOut.add(label12);
				panelOut.add(label13);
				panelOut.add(label14);
				panelOut.add(label15);
				panelOut.add(label16);
				if(bestPossibleConf.get(0)>3){
					label17.setText("Warning! The per capita crime rate in the area is reported high at:"+bestPossibleConf.get(0).toString() );
					panelOut.add(label17);
				}
				/*frame.remove(panel1);
				frame.add(panelOut);
				frame.setSize(400, 850);
				frame.setVisible(true);*/
				frame.setVisible(false);
				frame.dispose();
				frame1.add(panelOut);
				frame1.setSize(500, 350);
				frame1.setVisible(true);
				
			}

				
			
	
			
		});
		
		//JPanel panel2= new JPanel();
		submit.setSize(50, 40);
		panel1.add(submit);
		frame.add(panel1);
		//frame.add(panel2);
		frame.setSize(400, 850);
		frame.setVisible(true);
		
		
	}
	public static void main(String args[]){
		Main obj= new Main();
		
	}
	private ArrayList<Float> computeCosineSimilarity(ArrayList<Float> userPref) {
		// TODO Auto-generated method stub
		System.out.println(userPref);
		ArrayList<Float> availableHouse=new ArrayList<Float>();
		ArrayList<Float> cosSimilarity=new ArrayList<Float>();
		ArrayList<Float> bestHouseConfig=new ArrayList<Float>();
		File housingDatain= new File(filename);
		float budgetrangeUp;
		float budgetrangeDown;
		if(userPref.get(6)<=10){
			budgetrangeDown=4;
			budgetrangeUp=10;
		}
		else if(userPref.get(6)>10 && userPref.get(6)<=20){
			budgetrangeDown=10;
			budgetrangeUp=20;
		}
		else if(userPref.get(6)>20 && userPref.get(6)<=30){
			budgetrangeDown=20;
			budgetrangeUp=30;
		}
		else if(userPref.get(6)>30 && userPref.get(6)<=40){
			budgetrangeDown=30;
			budgetrangeUp=40;
		}
		else{
			budgetrangeDown=40;
			budgetrangeUp=50;
		}
		
		Workbook w;
		try{
			w=Workbook.getWorkbook(housingDatain);
			Sheet sheet=w.getSheet(0);
			Cell cell;
			int i=1;
			int j=0;
			int flag=0;
			int startInd = 0;
			float similarity;
			while(Float.parseFloat(sheet.getCell(13, i).getContents())<budgetrangeUp){
				cell=sheet.getCell(13,i);
				if(Float.parseFloat(cell.getContents())>budgetrangeDown){
					if(flag==0){
						startInd=i;
					}
					//System.out.println(cell.getContents()+" "+userPref.get(6));
					availableHouse.add(Float.parseFloat(sheet.getCell(5, i).getContents()));
					availableHouse.add(Float.parseFloat(sheet.getCell(3, i).getContents()));
					availableHouse.add(Float.parseFloat(sheet.getCell(6, i).getContents()));
					availableHouse.add(Float.parseFloat(sheet.getCell(7, i).getContents()));
					availableHouse.add(Float.parseFloat(sheet.getCell(8, i).getContents()));
					availableHouse.add(Float.parseFloat(sheet.getCell(10, i).getContents()));
					availableHouse.add(Float.parseFloat(sheet.getCell(13, i).getContents()));
					//System.out.println(availableHouse);
					similarity=cosineSimilarity(userPref,availableHouse);
					cosSimilarity.add(similarity);
					flag=1;
					//System.out.println(similarity);
				}
				i++;
				
				availableHouse.clear();
			}
			System.out.println(cosSimilarity);
			bestHouseConfig=computeBest5Houses(cosSimilarity,startInd);
		}
		catch(Exception e){
			e.printStackTrace();	
		}
		return bestHouseConfig;
	}
	private ArrayList<Float> computeBest5Houses(ArrayList<Float> cosSimilarity, int startInd) {
		// TODO Auto-generated method stub
		ArrayList<Float> bestHouseConfig=new ArrayList<Float>();
		int index = 0;
		System.out.println("Best House Available\n");
		//for(int j=0;j<5;j++){
			float max=cosSimilarity.get(0);
			for(int i=1;i<cosSimilarity.size();i++){
				if(cosSimilarity.get(i)>max){
					max=cosSimilarity.get(i);
					index=i;
				}
			}
			try{
			Workbook w=Workbook.getWorkbook(new File(filename));
			Sheet sheet=w.getSheet(0);
			//Cell cell=sheet.getCell(5, index+startInd);
				for(int i=0;i<14;i++){
					//System.out.println(sheet.getCell(i, startInd+index).getContents());
					bestHouseConfig.add(Float.parseFloat(sheet.getCell(i, startInd+index).getContents()));
				}
				System.out.println(bestHouseConfig);
				System.out.println(cosSimilarity.get(index));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//indices.add(index);
			//System.out.println(indices.get(j)+" "+cosSimilarity.get(index));
			
			//cosSimilarity.remove(index);
			return bestHouseConfig;
		//}	
	}
	private float cosineSimilarity(ArrayList<Float> userPref2,
			ArrayList<Float> availableHouse) {
		// TODO Auto-generated method stub
		float numerator=0;
		float denominator=0;
		float temp1=0;
		float temp2=0;
		for(int i=0;i<userPref2.size();i++){
			numerator=numerator+userPref2.get(i)*availableHouse.get(i);
			temp1=temp1+userPref2.get(i)*userPref2.get(i);
			temp2=temp2+availableHouse.get(i)*availableHouse.get(i);
		}
		denominator=(float) (Math.sqrt(temp1)*Math.sqrt(temp2));
		if(denominator!=0){
			return numerator/denominator;
		}
		else{
			return 0;
		}
	}
	
}
