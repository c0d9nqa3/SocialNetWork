package Graph;
import java.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.File.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.*;
import org.apache.commons.io.FileUtils;
public class MGraph implements IGraph {
	public final static int INFINITY=Integer.MAX_VALUE;
	//BufferedReader reader=new BufferedReader(new FileReader("D:\\Study\\structurepro.txt"));
	private static int vexNum;  //图的当前顶点数量和边数
	private static int arcNum;
	private static Object[] vexs;  //顶点
	private static int [][] arcs;  //邻接矩阵
	public static int []visited;   //判断是否访问过的数组
	public static String re="";
	public MGraph(){
		this(0,0,null,null);
	}
	public MGraph(int vexNum,int arcNum,Object[] vexs,int[][] arcs) {

		this.vexNum=vexNum;
		this.arcNum=arcNum;
		this.vexs=vexs;
		this.arcs=arcs;
	}
	
	//读取文件
	public static void readText(String filePath) {
		//int a[]=new int[vexNum];
			int j=0;
		try {
			
			 String encoding= "GBK" ;
             File file= new File(filePath);
             if (file.isFile() && file.exists()){ //判断文件是否存在
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding); //考虑到编码格式
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null ;
                 while ((lineTxt = bufferedReader.readLine()) != null){
                	 
                	 System.out.println(lineTxt);
                	 
                	 
                	 /*
                	 for(int i=0;i<lineTxt.length();i++) {
                		 char item=lineTxt.charAt(i);
                		 if(item==' ') {
                			 String temp=lineTxt.substring(j,i);
                			 j=j+i+1;
                			 System.out.println(temp);
                		 }
                	 }
                	 
                	 */
                	 
                    // a[i]=Integer.parseInt(lineTxt);
                    // i++;
                 }
                 read.close();
     } else {
         System.out.println( "找不到指定的文件" );
     }
		}catch(Exception e) {
			System.out.println("找不到指定文件");
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void readtxt(String wayload) throws IOException {
		String readData=null;
		int j=0;
		readData=FileUtils.readFileToString(new File(wayload),"GBK");
		//System.out.println(readData.length());
		//System.out.println(readData);
		for(int i=0;i<readData.length();i++) {
			char item=readData.charAt(i);
			if(item==' ' ||item=='\n') {
			//	if(i==readData.length()-1)
				String temp=readData.substring(j,i);
				j=j+i+1;
				//int t=Integer.parseInt(temp);
				System.out.print(temp+" ");
			}
		}
		
		//return readData;
	}
	
	
	
	public static void createGraph(int v,int a,int b[],int c[]) {
		// TODO Auto-generated method stub
		createUDG(v,a,b,c);
		return ;
		
	}

	public int getVexNum() {
		
		return vexNum;
	}

	public int getArcNum() {
		// TODO Auto-generated method stub
		return arcNum;
	}

	@Override
	public Object getVex(int vex) {
		// TODO Auto-generated method stub
		return null;
	}


	//顶点定位的算法
	public int locateVex(Object vex) {
		for(int v=0;v<vexNum;v++){
			if(vexs[v].equals(vex))
				return v;
		}
		return -1;
	}
	//查找第一个邻接点算法
	public static int firstAdjVex(int v) {
		// TODO Auto-generated method stub
		for(int j=0;j<vexNum;j++) {
			if(arcs[v][j]==1 
					&& arcs[j][v]==1
					)
				return j;
		}
		return -1;
	}
	
	//查找下一个邻接点的算法
	public static int nextAdjVex(int v,int w) {
		for(int j=w+1;j<vexNum;j++) {
			if(arcs[v][j]==1 
					&& arcs[j][v]==1
					)
				return j;
		}
		return -1;
		
	}


	public static void PrintGraph() {
		// TODO Auto-generated method stub
		for(int i=0;i<vexNum;i++) {
			for(int j=0;j<vexNum;j++) {
				System.out.print(arcs[i][j]+" ");
			}
			System.out.println();
		}
	}


	public static String centre() {
		int i,j,max=0,flag = 0;
		int count[]=new int[vexNum];
		
		for(i=0;i<vexNum;i++) {
			count[i]=0;
		}
		max=count[0];
		for(i=0;i<vexNum;i++) {
			for(j=0;j<vexNum;j++) {
				if(arcs[i][j]!=0) {
					count[i]++;
				}
			}
			if(max<count[i]) {
				max=count[i];
				flag=i;
			}
		}
		
		System.out.println("核心人物是："+vexs[flag]+",其度数为："+count[flag]);
		//System.out.print("活跃人物:     ");
		
		
		return "核心人物是："+vexs[flag]+",其度数为："+count[flag];
		
	}



	public static String huoyue() {
		String result="";
		int i,j;
		int count[]=new int[vexNum];
		for(i=0;i<vexNum;i++) {
			count[i]=0;
		}
		
		for(i=0;i<vexNum;i++) {
			for(j=0;j<vexNum;j++) {
				if(arcs[i][j]!=0) {
					count[i]++;
				}
			}
			
		}
		for(i=0;i<vexNum;i++) {
			if(count[i]>2 && count[i]<5)   //判断是活跃人物条件其度数满足的条件
				//System.out.println("活跃人物"+vexs[i]+"的度数是："+count[i]);
				result+=("活跃人物"+vexs[i]+"的度数是："+count[i]);
		
		}
		return result;
	}

	//输出边缘人物还有其度数

	public static String bianyuan() {
		int i,j;
		int count[]=new int[vexNum];
		String result="";
		for(i=0;i<vexNum;i++) {
			count[i]=0;
		}
		for(i=0;i<vexNum;i++) {
			for(j=0;j<vexNum;j++) {
				if(arcs[i][j]!=0) {
					count[i]++;
				}
			}
			
		}
		
		for(i=0;i<vexNum;i++) {
		if(count[i]==0) {
			int k=7;
			if(k%3==0)
				result=result+("边缘人员:"+vexs[i]+"的度数是："+count[i]+"\n");
			else
				result=result+("边缘人员:"+vexs[i]+"的度数是："+count[i]+" ");
			k++;
			}
		
	
		}
		
		return result;
	}


	public static String quanzi(int v) {
		int count=0;
		String result="";
		//System.out.println(vexs[v]+"的交往圈子是：");
		for(int i=0;i<vexNum;i++) {
			if(arcs[v][i]!=0 && arcs[i][v]!=0) {
				//System.out.print(vexs[i]+" ");
				result+=vexs[i]+" ";
				count++;
			}
		}
		if(count==0) {
			//System.out.println("无");
			result+="";
		}
		return result;
	}
	
	//创建无向图的邻接矩阵
	private static void createUDG(int vex,int arc,int[] a,int[] c) {
		//Scanner input=new Scanner(System.in);
		//System.out.println("请输入人员数量、人员关系数量");
		vexNum=vex;
		arcNum=arc;
		vexs=new Object[vexNum];
		arcs=new int[vexNum][vexNum];
		for(int i=0;i<vexNum;i++){
			for(int j=0;j<vexNum;j++){
				arcs[i][j]=0;
			}
		}
		//System.out.println("请分别输入所有的人员：");
		for(int i=0;i<vexNum;i++) {
			vexs[i]=a[i];
		}
		
		//System.out.println("请分别输入各个边的两个顶点");
		for(int k=0;k<arcNum*2;k=k+2) {
			int v=c[k];
			int u=c[k+1];
			//创建邻接矩阵
			arcs[v][u]=1;
			arcs[u][v]=1;
		}
		
	}
	
	public void DFS(int v,int n) {
		visited=new int[vexNum];
		if(v==0) {
			for(int k=0;k<n;k++)
				visited[k]=0;
			DFS(v+1,n);
		}
		else {
			if(visited[v-1]==0) {
				if(v-1!=by(vexNum)) {
					System.out.print(vexs[v-1]+ "  ");
					visited[v-1]=1;
					for(int k=0;k<n;k++) {
						if(ADD(v-1,k)>0) {
							DFS(k+1,n);
						}
					}
					System.out.print(",");
					DFS(v+1,n);
				}
				else DFS(v+1,n);
			}
		}
	}
	
	
	public static String DFSTraverse() {
		re="";
		visited=new int[vexNum];
		for(int v=0;v<vexNum;v++) {
			visited[v]=0;
		}
		for(int v=0;v<vexNum;v++) {
			if(visited[v]==0 ) {
				DFS2(v);
				re=re+"\n";
			}
		}
		return re;
	}
	
	public static void DFS2(int v) {
		visited[v]=1;
		System.out.print(vexs[v]+" ");
		re+=vexs[v]+" ";
		for(int i=firstAdjVex(v);i>=0;i=nextAdjVex(v,i)) {
		if(visited[i]==0) {
			DFS2(i);
			}
		}
	}
	
	
	
	
	
	//返回边缘人物
	public int  by(int n) {
		int i,j,count=0;
		//int n=1005;
		int a[]=new int[vexNum];
		for(i=0;i<vexNum;i++) {
			a[i]=0;
		}
		for(i=0;i<vexNum;i++) {
			for(j=0;j<vexNum;j++) {
				a[i]=arcs[i][j]+arcs[j][i];
			}
		}
		for(i=0;i<n;i++) {
			if(a[i]==0) {
				count++;
				return (i);
				
			}
		}
		if(count==0) {
			return 99;
		}
		return 0;
	}
	
	//查找桥接人
	public void DFSq(int v,int n) {
		for(int k=v-1;k<n;k++) {
			if(ADD(v-1,k)>0 && ADD(v-1,k)<2 && v-1!=by(vexNum) && k!=by(vexNum)) {
				System.out.println(vexs[v-1]+" "+vexs[k]);
				DFSq(k+1,n);   //找下一个
			}
		}
		if(v<=n)
			DFSq(v+1,n);
	}

	//计算连通分量
	public void BFS() throws Exception {
		int [] visited=new int[vexNum];
		for(int v=0;v<vexNum;v++) {    //访问标志数组初始化
			visited[v]=0;
		}
		LinkQueue Q=new LinkQueue();   //辅助队列
		LinkQueue P=new LinkQueue();  //辅助队列用于记录连通分量的顶点
		int i=0;   //用于记录连通分量的个数
		for(int v=0;v<vexNum;v++) {
			P.clear();
			if(visited[v]==0) {
				visited[v]=1;
				P.offer(vexs[v]);
				Q.offer(v);
				while(!Q.isEmpty()) {
					int u=(Integer)Q.poll();
					for(int w=firstAdjVex(u);w>=0;w=nextAdjVex(u,w)) {
						if(visited[w]==0) {
							visited[w]=1;
							P.offer(vexs[w]);
							Q.offer(w);
						}
					}
				}
				System.out.println("图的第"+ ++i +"个小团体为：");
				while(!P.isEmpty())
					System.out.print(P.poll().toString()+" ");
			
			System.out.println();
			}
		}
	}
	//计算人员两两间联系数(为查找小团体、桥接人准备)
	@Override
	public int ADD(int s, int t) {
		
		/*
		int temp;
		if(s>t) {
			temp=s;
			s=t;
			t=temp;
		}
		else
		*/
			return (arcs[s][t]+arcs[t][s]);
	}
	
	

	public static void quanzi() {
		
	}
	
}
