package Graph;

public interface IGraph {
	static void createGraph() {
	}
	int getVexNum();
	int getArcNum();
	Object getVex(int vex);
	static int locateVex(Object vex) {
		return 0;
		
	}
	static int firstAdjVex(int v) {
		return v;
		
	}
	static void PrintGraph() //输出邻接矩阵
	{
	}
	static void centre() //核心人员函数
	{
		
	}
	static void huoyue()  //活跃人物函数
	{
		
	}
	static void bianyuan()  //边缘人物函数
	{
		
	}
	static void quanzi()  //查找交往圈子函数
	{
		
	}
	int ADD(int s,int t);  //计算人员之间的联系数量
	
}
