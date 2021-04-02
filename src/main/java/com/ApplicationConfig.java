package com;

import com.interceptors.TokenInterceptor;
import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;

import com.jfinal.plugin.hikaricp.HikariCpPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

import com.model._MappingKit;
import com.routes.ApiRoute;

/**
 * @Author WeiWei Zhang
 * @Date 2020-06-23 15:00
 */
public class ApplicationConfig extends JFinalConfig {
    private static Prop prop;
    //public static DelayQueue<ItemVo<WorkSchedule>> queue;

    static {
        prop = PropKit.useFirstFound("config/config-pro.txt");
        //queue = new DelayQueue<>(); //存放日程信息的队列
    }
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(false);
        me.setViewType(ViewType.FREE_MARKER);
        me.setViewExtension(".ftl");

//        me.setBaseUploadPath(".");
        me.setBaseUploadPath("/");
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new ApiRoute());
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        HikariCpPlugin hp = new HikariCpPlugin(prop.get("jdbcUrl"),prop.get("userName"),prop.get("password"),prop.get("driverClass"));
        me.add(hp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(hp);
        arp.setDialect(new MysqlDialect());
        me.add(arp);
        _MappingKit.mapping(arp);

        //定时任务
       /* Cron4jPlugin cron4jPlugin = new Cron4jPlugin();
        //cron4jPlugin.addTask("0 0 * * *",new ScheduleTask()); //每天凌晨0点执行
        cron4jPlugin.addTask("0/3 * * * *  ",new PushService());
        me.add(cron4jPlugin);*/
       /* ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(new PushService(), 10, 30, TimeUnit.SECONDS);*/
    }

    @Override
    public void configInterceptor(Interceptors me) {
        me.addGlobalActionInterceptor(new TokenInterceptor()); //配置全局拦截token
    }

    @Override
    public void configHandler(Handlers me) {

    }

    @Override
    public void onStart() {
        //重新加载一次
       //new ScheduleTask().run();
        System.out.println("项目启动完成");
        //启动线程
      /*  Thread pushThread = new Thread(new PushService());
        pushThread.start();*/

    }

    public static HikariCpPlugin createDruidPlugin() {
        return new HikariCpPlugin(prop.get("jdbcUrl"),prop.get("userName"),prop.get("password"),prop.get("driverClass"));
    }

}
