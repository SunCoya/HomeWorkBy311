package Day21;
/*
分块查找
现有数据：分块，如1-100，100-200，200-300，块与块之间按顺序排列
但是，块中的数据无序，这种情况可以分块查找
分块数量接近为：sqrt（总数量），target在哪一块，就在哪一块挨个查找

分块查找拓展：数据分块，但是块与块之间无序，应该怎么办？
在block类里面多加一个min代表最小值即可

分块查找数组的流程：
1.定义块类，属性值为开始下标，结束下标，最大值
2.创建根据数组（已知情况）创建块对象，放到数组中
3.创建findBlock方法（块数组，target），查找块的下标，找不到返回-1
4.创建findIndex（arr，块数组，target）根据块的下标，得到在arr数组中的查找的范围
在这个范围中查找arr，找不到返回-1
*/
public class Demo211 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 2, 15, 19, 12, 13, 25, 29, 28, 21, 35, 36, 38, 34};
        System.out.println("创建块的对象");
        Block block1 = new Block(5,0,4);
        Block block2 = new Block(19,5,8);
        Block block3 = new Block(29,9,12);
        Block block4 = new Block(38,13,16);
        System.out.println("定义数组管理块");
        Block[] blocks = {block1,block2,block3,block4};
        System.out.println("定义变量记录查找元素，先查找块再查找下标");
        int num = 38;
        System.out.println(getIndex(num,blocks,arr));
    }
    // 查找块
    private static int getBlockIndex(int num, Block[] blocks) {
        for (int i = 0; i < blocks.length; i++) {
            if (num<=blocks[i].getMax())
                return i;
        }
        return -1;
    }
    //查找下标
    private static int getIndex(int num, Block[] blocks, int[] arr) {
        int index = getBlockIndex(num, blocks);
        if (index==-1) return -1;
        Block block = blocks[index];
        int start = block.getStartIndex();
        int end = block.getEndIndex();
        for (int i = start ; i <=end; i++) {
            if(arr[i]==num)
                return i;
        }
        return -1;
    }
}

class Block {
    private int max;
    private int startIndex;
    private int endIndex;
    public Block() {
    }
    public Block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public int getEndIndex() {
        return endIndex;
    }
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
