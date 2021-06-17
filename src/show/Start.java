package show;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Graph.MGraph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import Graph.MGraph;
public class Start extends JFrame implements ActionListener{
	 	
		 private JLabel lblPerNum=new JLabel("请输入人员数量：");
		 private JTextField txtPerNum=new JTextField("");
		 private JLabel lblRelaNum=new JLabel("请输入人员关系数量：");
		 private JLabel lblRela=new JLabel("请输入所有的人员关系：");
		 private JTextField txtRela=new JTextField("");   //人员关系
		 private JTextField txtRelaNum=new JTextField();   //人员关系数量
		 private JButton btnOk1=new JButton("确认");    //确认输入完成，邻接矩阵建立好
		 private JButton btnOk2=new JButton("确认");    //确认查找圈子的按钮
		 private JButton btnCancel=new JButton("关闭");   	
		 private JLabel lblAllPer=new JLabel("请输入所有人员");
		 private JTextArea txtAllPer=new JTextArea("");    //所有人员输入框
		 private JLabel lblCentre=new JLabel("核心人物为：");
		 private JTextField txtCentre=new JTextField();    //核心人员输出框
		 private JLabel lblSide=new JLabel("边缘人物为：");
		 private JLabel lblActi=new JLabel("活跃人物为：");
		 private JTextArea txtSide=new JTextArea("");    //边缘人物输出框
		 private JTextArea txtActi=new JTextArea("");    //活跃人物输出框
		 private JLabel lblCir=new JLabel("输入人物，查找圈子");
		 private JTextField txtCir=new JTextField("");   //查找人员圈子输入
		 private JLabel lblshowCir=new JLabel("该人物的圈子为：");
		 private JTextArea txtquanzi=new JTextArea("");    //人员圈子输出
		 private JLabel lblGroup=new JLabel("该图的小团体分别为：");
		 private JTextArea txtGroup=new JTextArea("");    //小团体输出
		  public Start() {    
		    JPanel jp=(JPanel)this.getContentPane();//获取当前JFrame的内容面板
		    jp.setLayout(new BorderLayout(10, 5));// 设置布局
		    //jp.setLayout(new GridLayout(10,2));//设置布局
		    JPanel jp1 = new JPanel();
		    JPanel jp2=new JPanel();
		    JPanel jp3=new JPanel();
		    jp1.setLayout(new GridLayout(4,4));
		    jp2.setLayout(new GridLayout(10,2));
		    jp3.setLayout(new GridLayout(4,4));
		    jp1.add(lblPerNum);jp1.add(txtPerNum);
		    jp1.add(lblRelaNum);jp1.add(txtRelaNum);
		    
		    jp2.add(lblAllPer);jp2.add(txtAllPer);
		    jp2.add(lblRela);jp2.add(txtRela);
		    jp2.add(lblCentre);jp2.add(txtCentre);
		    jp2.add(lblSide);jp2.add(txtSide);
		    jp2.add(lblActi);jp2.add(txtActi);
		    jp2.add(lblGroup);jp2.add(txtGroup);
		    jp2.add(btnOk1);
		    
		    jp3.add(lblCir);jp3.add(txtCir);
		    jp3.add(lblshowCir);jp3.add(txtquanzi);
		    jp3.add(btnOk2);jp3.add(btnCancel);
		    jp.add(jp1, BorderLayout.NORTH);
		    jp.add(jp2,BorderLayout.CENTER);
		    jp.add(jp3,BorderLayout.SOUTH);
		    this.setTitle("社会网络分析系统");
		    this.setSize(800, 700);
		    this.setVisible(true);
		    btnOk1.addActionListener(this);
		    btnOk2.addActionListener(this);
		    btnCancel.addActionListener(this);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  }
		  
		  
		  @Override
		  public void actionPerformed(ActionEvent e) {
			 // MGraph.createGraph(vexNum,arcNum,per,relation);
		    if(e.getSource()==btnOk1) {
		    	
		       if(txtPerNum.getText()!=null && txtRelaNum!=null 
		    	&& txtAllPer.getText()!=null && txtRela.getText()!=null
		    	) {
		    	   
		       int vexNum=Integer.valueOf(txtPerNum.getText());
		       int arcNum=Integer.valueOf(txtRelaNum.getText());
		       String person=txtAllPer.getText();
		       String rela=txtRela.getText();
		       String temp1="";
		       String temp2="";
		      //
		       int[] per=new int[vexNum];
		       char[] arr=new char[vexNum*2];
		       char[] arrRela=new char[arcNum*2];
		       int[] relation=new int[arcNum*2];
		       int j=0;
		       int k=0;
		       arr=person.toCharArray();
		       arrRela=rela.toCharArray();
		       for(int i=0;i<arr.length ;i++) {
		    	   
		    	   
		    	   if(arr[i]!=' ') {
		    		   temp1+=String.valueOf(arr[i]);
		    		   //System.out.println(temp1);
		    	   }
		    	   else if(arr[i]==' ') {
		    		  // int num=Integer.parseInt(String.valueOf(arr[i]));
		    		   int num=Integer.parseInt(temp1);
		    	   		System.out.println(num);
		    	   		per[j]=num;
		    	   		j++;
		    	   		temp1="";
		    	   }
		    	  
		    	   
		       }
		       
		       for(int i=0;i<arrRela.length;i++) {
		    	  
		    	    
		    	   if(arrRela[i]!=' ') {
		    		   temp2+=String.valueOf(arrRela[i]);
		    		   //int num=Integer.parseInt(String.valueOf(arrRela[i]));
		    	   }
		    	   else if(arrRela[i]==' ') {
		    		   int num=Integer.parseInt(temp2);
		    		   System.out.println(num);
		    		   relation[k]=num;
		    		   k++;
		    		   temp2="";
		    	   }
		       }
		       MGraph.createGraph(vexNum,arcNum,per,relation);
		     // MGraph.createGraph(vexNum,arcNum,per,relation);
		       //char a[]=new char[12];
		      MGraph.PrintGraph();
		      
		      txtCentre.setText(MGraph.centre());
		      txtSide.setText(MGraph.bianyuan());
		      txtActi.setText(MGraph.huoyue());
		      txtGroup.setText(MGraph.DFSTraverse());
		       }
		      
		       else {
		    	   JOptionPane.showMessageDialog(this, "有未输入的数据");
		       }
		    }
		    
		    
		    else if(e.getSource()==btnCancel) {
		      if(JOptionPane.showConfirmDialog(this, "确认关闭当前窗口吗？",
		                                    "关闭窗口",JOptionPane.OK_CANCEL_OPTION)
		          ==JOptionPane.OK_OPTION) {
		        this.dispose();
		      }
		    }
		    
		    else if(e.getSource()==btnOk2) {
		    	if(txtCir.getText()!=null) {
		    	   int vexNum=Integer.valueOf(txtPerNum.getText());
			       int arcNum=Integer.valueOf(txtRelaNum.getText());
			       String person=txtAllPer.getText();
			       String rela=txtRela.getText();
			       String temp1="";
			       String temp2="";
			       int[] per=new int[vexNum];
			       char[] arr=new char[vexNum*2];
			       char[] arrRela=new char[arcNum*2];
			       int[] relation=new int[arcNum*2];
			       int j=0;
			       int k=0;
			       arr=person.toCharArray();
			       arrRela=rela.toCharArray();
			       for(int i=0;i<arr.length ;i++) {
			    	   
			    	   
			    	   if(arr[i]!=' ') {
			    		   temp1+=String.valueOf(arr[i]);
			    		   //System.out.println(temp1);
			    	   }
			    	   else if(arr[i]==' ') {
			    		   int num=Integer.parseInt(temp1);
			    	   		System.out.println(num);
			    	   		per[j]=num;
			    	   		j++;
			    	   		temp1="";
			    	   }
			    	  
			    	   
			       }
			       
			       for(int i=0;i<arrRela.length;i++) {	
			    	   if(arrRela[i]!=' ') {
			    		   temp2+=String.valueOf(arrRela[i]);
			    	   }
			    	   else if(arrRela[i]==' ') {
			    		   int num=Integer.parseInt(temp2);
			    		   System.out.println(num);
			    		   relation[k]=num;
			    		   k++;
			    		   temp2="";
			    	   }
			       }
		    	 MGraph.createGraph(vexNum,arcNum,per,relation);
		    	 int v=Integer.valueOf(txtCir.getText());
		    	 txtquanzi.setText(MGraph.quanzi(v));
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(this, "请输入要查询的人物圈子");
		    	}
			  }
		  }
		  
		  public static void main(String[] args)throws Exception {
			  new Start();
		  }
	}


