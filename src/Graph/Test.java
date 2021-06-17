package Graph;
import java.util.*;
public class Test {
	
    public static void main(String[] args) throws Exception{
    	MGraph g=new MGraph();
    	Scanner input=new Scanner(System.in);
    	
       // g.createGraph();
        g.PrintGraph();
        g.centre();
        g.bianyuan();
        g.huoyue();
        //g.DFS(0, 1005);
        g.DFSTraverse();
        //g.DFSq(1,1005);
        int v=input.nextInt();
        g.quanzi(v);
        
      
    	   
    	 //String a="D:\\Study\structurepro";
    	
    	// g.readText("D:\\temp.txt");
    	
    //	System.out.print(
    		//	g.readtxt("D:\\email-Eu-core.txt");
    			//);
    	
    }
}
