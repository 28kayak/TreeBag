
public class Main 
{

	static IntBTNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//0. existing tree
		root = new IntBTNode(45,null,null);
		
		
		//1. add first one leaf to existing tree 
		//     (20 is less than 45, hence it is left)
//		IntBTNode node20 = new IntBTNode(20,null,null);  //created new leaf
//		root.setLeft(node20);
		
		//2. add second leaf node to existing tree
		// here 60 is added which is greater than 45
//		IntBTNode node60 = new IntBTNode(60,null,null);  //created new leaf
//		root.setRight(node60);
		
		//3. add third leaf node (10) 
//		IntBTNode node10 = new IntBTNode(10,null,null);  //created new leaf
		//where should I put this?
		//chech if 10 is less than root.data
		// if (10 < root.getData())
		//    if (10 < root.getLeft().getData())
		//      if (root.getLeft().getLeft().getData()==null)
		//			add node10 here!
//		node20.setLeft(node10);
		
		//4. add fourth leaf node (30)
//		IntBTNode node30 = new IntBTNode(30,null,null);  //created new leaf
		// if (30 < root.getData())
		//    if (30 < root.getLeft().getData())
		//      if (root.getLeft().getLeft()==null)
		//		{
		//			add node10 here!
		//		}else
		//		{
		//		}
		//    else
		//      if (root.getLeft().getRight()==null)
		//          add node 30 here
//		root.getLeft().setRight(node30);
		
		//      }else{ 
		//			if (30 < root.getLeft().getRight().getData())
		//int x=65;

		add(65);
		add(10);
		add(5);
		add(20);
		add(15);
		add(40);
		add(80);
		add(50);
		add(12);
		add(22);
		add(17);
		add(42);
		add(82);
		add(52);
		
		System.out.println("answer: "+root.getRight().getLeftmost().getData());
		System.out.println("answer2: "+root.getRight().getLeftmostData());
		
		root.print(5);
		remove(20);
		root.print(5);
	}

	
	public static void add(int element)
	{
		IntBTNode cursor;
		IntBTNode nodex = new IntBTNode(element, null, null);
		cursor = root;
		boolean done=false;
		while(!done)
		{
			if (element < cursor.getData())
			{
				if (cursor.getLeft() == null)
				{
					
					cursor.setLeft(nodex);
					done=true;
				}
				else
				{
					cursor=cursor.getLeft();
				}
			}
			else
			{
				if (cursor.getRight()==null){
					cursor.setRight(nodex);
					done=true;
				}
				else
				{
					cursor=cursor.getRight();
				}
			}
		}
	}
		
		
	public static boolean remove(int element)
	{
		IntBTNode cursor,previous_cursor;
	//	IntBTNode nodex = new IntBTNode(element, null, null);
		cursor = root;
		previous_cursor=root;
		boolean done=false;
		while(!done)
		{
			if (element < cursor.getData())
			{
				if (cursor.getLeft() == null)
				{
					return false;
				}
				else
				{
					previous_cursor=cursor;
					cursor=cursor.getLeft();
					
				}
			}
			else
			{
				if (element==cursor.getData())
				{
					//int value = previous_cursor.getData();
					//System.out.println("must delete this cusor position "+value);
					if (cursor.getLeft()==null && cursor.getRight()==null)
					{ //this is leaf node and just remove this node
						if (previous_cursor.getLeft()==cursor)
						{
							previous_cursor.setLeft(null);
							
						}
						else
						{
							previous_cursor.setRight(null);
						}
					}
					else
					{//this is intermediate node
						
						if (previous_cursor.getLeft()==cursor)
						{
							previous_cursor.setLeft(cursor.getRight());//?
							cursor.getRight().getLeftmost().setLeft(cursor.getLeft());
						}
						else
						{
							previous_cursor.setRight(cursor.getLeft());
							cursor.getLeft().getRightmost().setRight(cursor.getRight());
						}
					}
					return true;
				}
				if (cursor.getRight()==null)
				{
					return false;
				}
				else
				{
					previous_cursor=cursor;
					cursor=cursor.getRight();
					
				}
			}
		}
		return false;
		
	}
	
	

}
