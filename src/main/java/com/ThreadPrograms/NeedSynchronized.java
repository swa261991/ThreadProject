package com.ThreadPrograms;

public class NeedSynchronized {
    public static int counter = 0;

    public static Thread getThread() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter++;
                }
            }
        });
        t.start();
        return t;
    }

    public static void process() {
        Thread t1 = getThread();
        Thread t2 = getThread();
        Thread t3 = getThread();
        Thread t4 = getThread();
        Thread t5 = getThread();
        Thread t6 = getThread();
        Thread t7 = getThread();
        Thread t8 = getThread();
        Thread t9 = getThread();
        Thread t10 = getThread();
        Thread t11 = getThread();
        Thread t12 = getThread();
        Thread t13 = getThread();
        Thread t14 = getThread();
        Thread t15 = getThread();
        Thread t16 = getThread();
        Thread t17 = getThread();
        Thread t18 = getThread();
        Thread t19 = getThread();
        Thread t20 = getThread();
        Thread t21 = getThread();
        Thread t22 = getThread();
        Thread t23 = getThread();
        Thread t24 = getThread();
        Thread t25 = getThread();
        Thread t26 = getThread();
        Thread t27 = getThread();
        Thread t28 = getThread();
        Thread t29 = getThread();
        Thread t30 = getThread();
        Thread t31 = getThread();
        Thread t32 = getThread();
        Thread t33 = getThread();
        Thread t34 = getThread();
        Thread t35 = getThread();
        Thread t36 = getThread();
        Thread t37 = getThread();
        Thread t38 = getThread();
        Thread t39 = getThread();
        Thread t40 = getThread();
        Thread t41 = getThread();
        Thread t42 = getThread();
        Thread t43 = getThread();
        Thread t44 = getThread();
        Thread t45 = getThread();
        Thread t46 = getThread();
        Thread t47 = getThread();
        Thread t48 = getThread();
        Thread t49 = getThread();
        Thread t50 = getThread();
        Thread t51 = getThread();
        Thread t52 = getThread();
        Thread t53 = getThread();
        Thread t54 = getThread();
        Thread t55 = getThread();
        Thread t56 = getThread();
        Thread t57 = getThread();
        Thread t58 = getThread();
        Thread t59 = getThread();
        Thread t60 = getThread();
        Thread t61 = getThread();
        Thread t62 = getThread();
        Thread t63 = getThread();
        Thread t64 = getThread();
        Thread t65 = getThread();
        Thread t66 = getThread();
        Thread t67 = getThread();
        Thread t68 = getThread();
        Thread t69 = getThread();
        Thread t70 = getThread();
        Thread t71 = getThread();
        Thread t72 = getThread();
        Thread t73 = getThread();
        Thread t74 = getThread();
        Thread t75 = getThread();
        Thread t76 = getThread();
        Thread t77 = getThread();
        Thread t78 = getThread();
        Thread t79 = getThread();
        Thread t80 = getThread();
        Thread t81 = getThread();
        Thread t82 = getThread();
        Thread t83 = getThread();
        Thread t84 = getThread();
        Thread t85 = getThread();
        Thread t86 = getThread();
        Thread t87 = getThread();
        Thread t88 = getThread();
        Thread t89 = getThread();
        Thread t90 = getThread();
        Thread t91 = getThread();
        Thread t92 = getThread();
        Thread t93 = getThread();
        Thread t94 = getThread();
        Thread t95 = getThread();
        Thread t96 = getThread();
        Thread t97 = getThread();
        Thread t98 = getThread();
        Thread t99 = getThread();
        Thread t100 = getThread();
        Thread t101 = getThread();
        Thread t102 = getThread();
        Thread t103 = getThread();
        Thread t104 = getThread();
        Thread t105 = getThread();
        Thread t106 = getThread();
        Thread t107 = getThread();
        Thread t108 = getThread();
        Thread t109 = getThread();
        Thread t110 = getThread();
        Thread t111 = getThread();
        Thread t112 = getThread();
        Thread t113 = getThread();
        Thread t114 = getThread();
        Thread t115 = getThread();
        Thread t116 = getThread();
        Thread t117 = getThread();
        Thread t118 = getThread();
        Thread t119 = getThread();
        Thread t120 = getThread();
        Thread t121 = getThread();
        Thread t122 = getThread();
        Thread t123 = getThread();
        Thread t124 = getThread();
        Thread t125 = getThread();
        Thread t126 = getThread();
        Thread t127 = getThread();
        Thread t128 = getThread();
        Thread t129 = getThread();
        Thread t130 = getThread();
        Thread t131 = getThread();
        Thread t132 = getThread();
        Thread t133 = getThread();
        Thread t134 = getThread();
        Thread t135 = getThread();
        Thread t136 = getThread();
        Thread t137 = getThread();
        Thread t138 = getThread();
        Thread t139 = getThread();
        Thread t140 = getThread();

        /*t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t20.start();*/
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
            t15.join();
            t16.join();
            t17.join();
            t18.join();
            t19.join();
            t20.join();
            t21.join();
            t22.join();
            t23.join();
            t24.join();
            t25.join();
            t26.join();
            t27.join();
            t28.join();
            t29.join();
            t30.join();
            t31.join();
            t32.join();
            t33.join();
            t34.join();
            t35.join();
            t36.join();
            t37.join();
            t38.join();
            t39.join();
            t40.join();
            t41.join();
            t42.join();
            t43.join();
            t44.join();
            t45.join();
            t46.join();
            t47.join();
            t48.join();
            t49.join();
            t50.join();
            t51.join();
            t52.join();
            t53.join();
            t54.join();
            t55.join();
            t56.join();
            t57.join();
            t58.join();
            t59.join();
            t60.join();
            t61.join();
            t62.join();
            t63.join();
            t64.join();
            t65.join();
            t66.join();
            t67.join();
            t68.join();
            t69.join();
            t70.join();
            t71.join();
            t72.join();
            t73.join();
            t74.join();
            t75.join();
            t76.join();
            t77.join();
            t78.join();
            t79.join();
            t80.join();
            t81.join();
            t82.join();
            t83.join();
            t84.join();
            t85.join();
            t86.join();
            t87.join();
            t88.join();
            t89.join();
            t90.join();
            t91.join();
            t92.join();
            t93.join();
            t94.join();
            t95.join();
            t96.join();
            t97.join();
            t98.join();
            t99.join();
            t100.join();
            t101.join();
            t102.join();
            t103.join();
            t104.join();
            t105.join();
            t106.join();
            t107.join();
            t108.join();
            t109.join();
            t110.join();
            t111.join();
            t112.join();
            t113.join();
            t114.join();
            t115.join();
            t116.join();
            t117.join();
            t118.join();
            t119.join();
            t120.join();
            t121.join();
            t122.join();
            t123.join();
            t124.join();
            t125.join();
            t126.join();
            t127.join();
            t128.join();
            t129.join();
            t130.join();
            t131.join();
            t132.join();
            t133.join();
            t134.join();
            t135.join();
            t136.join();
            t137.join();
            t138.join();
            t139.join();
            t140.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while (true) {
            process();
            if (counter<140000)
                System.out.println(counter);
            counter=0;
        }
    }
}
