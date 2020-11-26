package com.example.learnfremwork.Service;

import com.example.learnfremwork.model.po.CustomerPo;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author meideng.zh <br/>
 * date: 2020/11/26/0026 14:58:50 <br/>
 * comment: 学习ThreadLocal类
 */
public class LnThreadLocalService {
    /**
     * 可以看到在队列中（ReferenceQueue），调用gc之前是没有内容的，调用gc之后，对象被回收了，并且弱引用对象appleWeakReference和appleWeakReference2被放入了队列中。
     *
     * 关于其他三种引用，强引用、软引用、虚引用，可以参考http://www.cnblogs.com/gudi/p/6403953.html
     *
     */
    public void lnWeakRefrence() {
        ReferenceQueue<CustomerPo> appleReferenceQueue = new ReferenceQueue<>();
        WeakReference<CustomerPo> appleWeakReference = new WeakReference<>(new CustomerPo("青苹果", "可口"), appleReferenceQueue);
        WeakReference<CustomerPo> appleWeakReference2 = new WeakReference<>(new CustomerPo("毒苹果","坏"), appleReferenceQueue);

        System.out.println("=====gc调用前=====");
        Reference<? extends CustomerPo> reference = null;
        while ((reference = appleReferenceQueue.poll()) != null ) {
            //不会输出，因为没有回收被弱引用的对象，并不会加入队列中
            System.out.println(reference);
        }
        System.out.println(appleWeakReference);
        System.out.println(appleWeakReference2);
        System.out.println(appleWeakReference.get());
        System.out.println(appleWeakReference2.get());

        System.out.println("=====调用gc=====");
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=====gc调用后=====");

        //下面两个输出为null,表示对象被回收了
        System.out.println(appleWeakReference.get());
        System.out.println(appleWeakReference2.get());

        //输出结果，并且就是上面的appleWeakReference、appleWeakReference2，再次证明对象被回收了
        Reference<? extends CustomerPo> reference2 = null;
        while ((reference2 = appleReferenceQueue.poll()) != null ) {
            //如果使用继承的方式就可以包含其他信息了
            System.out.println("appleReferenceQueue中：" + reference2);
        }
        
    }
    public static void main(String[] args){
        LnThreadLocalService lnThreadLocalService = new LnThreadLocalService();
        lnThreadLocalService.lnWeakRefrence();
    }
}
