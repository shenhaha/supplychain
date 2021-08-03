package com.luer.demo.test;


import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

public class GroupServiceImpl {

    /*@Autowired
    private IGroupDao groupDao;*/

    //静态变量存储最大值
    private static final AtomicInteger atomicNum = new AtomicInteger();
    //初始化分组编号
    private static final int INIT_GROUP_NUM = 0;

    /**
     * @Author javaloveiphone
     * @Description :初始化设置分组编号最大值
     * @throws Exception
     * void
     */
    /*@PostConstruct
    public static void initMaxNum(){
        try{
            //int maxGroupNum = groupDao.getMaxGroupNum();
            int maxGroupNum = 2;
            if(maxGroupNum<INIT_GROUP_NUM){
                maxGroupNum = INIT_GROUP_NUM;
            }
            if(logger.isDebugEnabled()){
                logger.debug("初始化分组编号最大值为："+maxGroupNum);
            }
            atomicNum.set(maxGroupNum);
        }catch(Exception e){
            logger.error("初始化获取分组编号最大值异常",e);
        }
    }
*/

    /**
     * @return int
     * 注：此方法并没有使用synchronized进行同步，因为共享的编号自增操作是原子操作，线程安全的
     * @Author javaloveiphone
     * @Description :获取最新分组编号
     */
    public static String getNewAutoNum() {
        //线程安全的原子操作，所以此方法无需同步
        int newNum = atomicNum.incrementAndGet();
        //数字长度为5位，长度不够数字前面补0
        String newStrNum = String.format("%05d", newNum);
        System.out.println(newStrNum);
        return newStrNum;
    }


    public static String bornCount(String param) {
        if (param == null) {
            param = "00000";
        }
        int s = Integer.parseInt(param);
        s = ++s;
        s = s == 100000 ? 1 : s;  //这里将规定最大数字设定为小于100000
        String reslut = s >= 10 ? (s >= 100 ? (s >= 1000 ? (s >= 10000 ? s + "" : "0" + s) : "00" + s) : "000" + s) : "0000" + s; // 计算 转型  
        System.out.println(reslut);
        return reslut;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            getNewAutoNum();
        }
        System.out.println("-----------------------------------");
        bornCount("00011");

    }


}
