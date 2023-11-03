package Day16;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener {
    //data代表装图片Label的坐标:定义final表示地址不变，值可以变
    private static int x,y;
    private static int count = 0;
    private final static int[][] data = new int[4][4];
    private static final int[][] win = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    private static String path = "JAVA基础\\src\\Day16\\image\\animal\\animal3\\";

    //构造方法，可以初始化数据：创建最外面的窗体，
    public GameFrame(){
        initJFrame();
        initJMenuBar();
        initData();
        initImage();
        //并且让界面可视: 建议写在最后
        this.setVisible(true);
    }

    //初始化窗口
    private void initJFrame(){
        //设置标题
        this.setTitle("拼图单机版");
        //设置窗口大小
        this.setSize(603,680);
        //设置关闭模式：关掉这个界面——程序停止，3：每个数字代表一种关闭模式，这个是关掉虚拟机
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置JFrame界面居中
        this.setLocationRelativeTo(null);
        //取消默认的居中模式,不然添加组件会默认居中
        this.setLayout(null);
        //添加键盘监听事件，在这里相当于这个对象实现了接口，也就是说，这个类既是JF的子类，也是AL的实现类，所以能传这个类的对象（好抽象的写法）
        //第一个this：给本界面添加键盘监听。第二个this：事件被触发，会执行本类中的重写实现KeyListener中的方法
        this.addKeyListener(this);
    }

    //初始化菜单
    private void initJMenuBar(){
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //菜单上面的两个对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");
        JMenu changePicturesMenu = new JMenu("更换图片");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");

        JMenuItem animalItem = new JMenuItem("动物");
        JMenuItem girlItem = new JMenuItem("美女");
        JMenuItem sportItem = new JMenuItem("运动");

        //在选项中加入条目对象
        functionMenu.add(changePicturesMenu);
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);
        aboutMenu.add(accountItem);
        changePicturesMenu.add(animalItem);
        changePicturesMenu.add(girlItem);
        changePicturesMenu.add(sportItem);

        //在菜单中加入两个选项
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        //在窗体中加入菜单
        this.setJMenuBar(jMenuBar);

        //绑定点击事件
        //重新开始
        replayItem.addActionListener(e -> {
            System.out.println("重新游戏");
            initData();
            initImage();
        });
        //重新登录
        reLoginItem.addActionListener(e -> {
            //关闭当前界面，打开登陆界面，登录界面先不做了。。。
            this.setVisible(false);
        });
        //关闭游戏
        closeItem.addActionListener(e -> System.exit(0));
        //公众号
        accountItem.addActionListener(e -> {
            System.out.println("弹出公众号");
            //创建弹框
            JDialog dialog = new JDialog();
            JLabel label = new JLabel(new ImageIcon("JAVA基础\\src\\Day16\\image\\about.png"));
            label.setBounds(0,0,258,258);
            dialog.getContentPane().add(label);
            dialog.setSize(344,344);
            dialog.setAlwaysOnTop(true);
            dialog.setLocationRelativeTo(null);
            //弹框不关闭无法设置下面的界面
            dialog.setModal(true);
            dialog.setVisible(true);
        });

        Random random = new Random();
        //动物更换
        animalItem.addActionListener(e -> {
            path = "JAVA基础\\src\\Day16\\image\\animal\\animal"+(random.nextInt(8)+1)+"\\";
            initData();
            initImage();
        });
        //美女更换
        girlItem.addActionListener(e -> {
            path = "JAVA基础\\src\\Day16\\image\\girl\\girl"+(random.nextInt(11)+1)+"\\";
            initData();
            initImage();
        });
        //运动更换
        sportItem.addActionListener(e -> {
            path = "JAVA基础\\src\\Day16\\image\\sport\\sport"+(random.nextInt(10)+1)+"\\";
            initData();
            initImage();
        });
    }

    //初始化二维数组数据:先打乱一维数组再放到二维数组里面。当然如果可以的话也能直接打乱二维，这里就不尝试了
    private void initData() {
        //计步器清零
        count = 0;
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] =  arr[index];
            arr[index] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4] = arr[i];
        }
    }

    //初始化图片
    //看完老师的写法之后再简化代码：原本的做法是用了JLabel数组和String数组，还需要记数组下标，不太方便。
    //这里就是直接再循环里面使用data数组创建新的对象就可以了。
    private void initImage(){
        //删除已经出现的所有图片
        this.getContentPane().removeAll();
        if(winOrNot()){
            showWin();
        }
        showStepCount();
        //添加拼图
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //关于坐标0：找不到图片不会显示：但是本身这里传进去的是一个错误的地址，还是能够new一个JLabel。
                String str = path+num+".jpg";
                JLabel jLabel = new JLabel(new ImageIcon(str));
                jLabel.setBounds(j*105+83,i*105+134,105,105);
                //这里传进去的是接口，可以传Java中已经实现的类：传递的值代表不同样式：因为是变量静态的所以可以直接使用类名调用
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }
        showImageBackground();
        //刷新界面
        this.getContentPane().repaint();
    }

    //加载背景图片，添加图片，先写的图片在上层，后写的图片在下层
    private void showImageBackground(){
        //绝对路径：从盘符开始的路径。相对路径基于当前项目
        String backgroundPath = "JAVA基础\\src\\Day16\\image\\background.png";
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundPath));
        backgroundLabel.setBounds(40,40,508,560);
        this.getContentPane().add(backgroundLabel);
    }

    //展示步数
    private void showStepCount(){
        JLabel stepCount = new JLabel("步数："+count);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);
    }

    //展示完整图片
    private void showImageAll(){
        this.getContentPane().removeAll();
        JLabel jLabel = new JLabel(new ImageIcon(path+"all.jpg"));
        jLabel.setBounds(83,134,420,420);
        this.getContentPane().add(jLabel);
        showImageBackground();
        this.getContentPane().repaint();
    }

    //作弊胜利
    private void cheat(){
        //这里之前的做法是复制的initImage方法：但是不需要这么做：可以直接改数组！！！！！！
        for (int i = 0; i < 16; i++) {
            data[i/4][i%4]=win[i/4][i%4];
        }
        //发现全部复位之后，空格的位置没有变，多出来了空格，全局变量再改改
        x=3;y=3;
        initImage();
    }

    //判断是否胜利，可以返回bool类型，减少变量定义
    private boolean winOrNot() {
        for (int i = 0; i < 16; i++) {
            if (data[i/4][i%4]!=win[i/4][i%4]){
                return false;
            }
        }
        return true;
    }

    //展示胜利
    private void showWin(){
        String winPath = "JAVA基础\\src\\Day16\\image\\win.png";
        JLabel winLabel = new JLabel(new ImageIcon(winPath));
        winLabel.setBounds(203,283,197,73);
        this.getContentPane().add(winLabel);
    }

    //由于实现了KeyListener，所以不用写多个匿名内部类了，调用自己重写的方法即可
    @Override
    public void keyReleased(KeyEvent e) {
        if(winOrNot()){
            return;
        }
        //在刷新界面的时候：需要把图片清空！再刷新图片！两步写在initImage里面
        int code = e.getKeyCode();//左上右下37- 40；
        if (code==37){
            System.out.println("向左移动");
            if (y==3) return;
            //我的xy一直都整反了。x代表纵向位置，y代表横向位置
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            //空白方块的位置变了！记得跟踪。
            y++;
            count++;
            initImage();
        }else if (code==38){
            System.out.println("向上移动");
            if (x==3)return;
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            count++;
            initImage();
        }else if (code==39){
            System.out.println("向右移动");
            if (y==0)return;
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            count++;
            initImage();
        }else if(code == 40){
            System.out.println("向下移动");
            if (x==0)return;
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            count++;
            initImage();
        }else if ('A'==e.getKeyCode()){
            initImage();
        }else if('W'==e.getKeyCode()){
            System.out.println("按下W直接胜利！");
            cheat();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(winOrNot()){
            return;
        }
        //按住A显示完整图片，松开A显示随机打乱的图片
        if ('A'==e.getKeyCode()){
            System.out.println("按下A");
            showImageAll();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
}
