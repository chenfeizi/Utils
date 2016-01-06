package com.sjq_education.sampsipapp.utils.network_request.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.widget.Toast;

/**
 * 线程池工具类
 * @author hongwei
 *
 */
public class ThreadPoolUtils {
	
	private static ThreadPoolExecutor threadPoolExecutor;
	
	static Context mContext;
	public ThreadPoolUtils(Context context){ 
		mContext = context;
	}
	
	
	public static ThreadPoolExecutor getThreadPoolExecutor(){
		if(threadPoolExecutor == null) {
			synchronized (ThreadPoolUtils.class) {
				if(threadPoolExecutor == null){
					threadPoolExecutor = new ThreadPoolExecutor(
								1,                 // 设置核心池大小(最小个数)
								30,                // 设置最大线程数(最大个数)
								30L,               // 设置没有任务时线程销毁时间
								TimeUnit.SECONDS,  // 设置时间单位
								new SynchronousQueue<Runnable>());   // 不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
					initSingleCoreThread();
				}
			}
		}
		return threadPoolExecutor;
	}

	/**
	 * 初始化一个核心线程
	 */
	private static void initSingleCoreThread(){
		threadPoolExecutor.prestartCoreThread();
	}
	
	/**
	 * 初始化所有核心线程
	 */
	@SuppressWarnings("unused")
	private static void initAllCoreThread(){
		threadPoolExecutor.prestartAllCoreThreads();
	}
	/**
	 * 执行任务
	 * @param runnable
	 */
	public static void execute(Runnable runnable){
		createThreadPool();
		if(runnable == null){
			throw new NullPointerException("runnble 不能为空");
		}
		try {
			threadPoolExecutor.execute(runnable);
		} catch (Exception e) {
			Toast.makeText(mContext, "网络繁忙，请稍候", Toast.LENGTH_SHORT).show();
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 打印线程池的相关信息
	 */
	public static void printThreadPoolInfo(){
		createThreadPool();
		System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+  threadPoolExecutor.getQueue().size()+"，已执行玩别的任务数目："+threadPoolExecutor.getCompletedTaskCount());
	}

	public static int size(){
		BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
		return queue.size();
	}
	
	/**
	 * 设置核心池大小
	 * @param size
	 */
	public static void setCorePoolSize(int size){
		createThreadPool();
		threadPoolExecutor.setCorePoolSize(size);
	}
	
	/**
	 * 设置线程池最大能创建的线程数目大小
	 * @param size
	 */
	public static void setMaximumPoolSize(int size){
		createThreadPool();
		threadPoolExecutor.setMaximumPoolSize(size);
	}
	
	/**
	 * 判断线程池是否为空,为空则创建
	 */
	private static void createThreadPool(){
		if(threadPoolExecutor == null){
			getThreadPoolExecutor();
		}
	}
	
	/**
	 * 发送终止命令,不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
	 */
	public static void shutdown(){
		if(threadPoolExecutor != null){
			threadPoolExecutor.shutdown();
		}
	}
	
	/**
	 * 立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务
	 */
	public static void shutdownNew(){
		if(threadPoolExecutor != null){
			threadPoolExecutor.shutdownNow();
		}
	}
}
