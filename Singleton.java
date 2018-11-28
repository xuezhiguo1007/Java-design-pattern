/*确保某个类只有一个实例，而且自行实例化并向整个系统创建这个实例
三个要点：一是某个类只能有一个实例：二是必须自行创建这个实例，三是必须向整个系统提供这个实例
七种书写方式
第一种是懒汉式，线程不安全,多线程不能正常工作。*/
public class Singleton {
	private static Singleton instance;
	private Singleton() {}
	public static Singleton getInstance() {
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
}
/*第二种也是懒汉式，线程安全，多线程很好的工作，但是，效率很低，99%情况下不需要同步
多了一个synchronized*/
public class Singleton {
	private static Singleton instance;
	private Singleton() {}
	public static synchronized Singleton getInstance() {
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
}
//第三种饿汉，这种基于classloader机制避免了多线程的同步问题，不过，instance在类加载时就实例化，在单例模式大多数调用getInstance方法，但也不能确定有其他方式导致类加载，没有达到lazy loading的效果
public class Singleton {
	private static Singleton instance=new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return instance;
	}
}
//第四种饿汉，变种，和第三种差不多
public class Singleton {
	private static Singleton instance=null;
	static {
		instance=new Singleton();
	}
	private Singleton() {}
	public static Singleton getInstance() {
		return this.instance;
	}
}
//第五种静态内部类。同样利用了classloader的机制来保证初始化instance时只有一个线程，这种方式是Singleton类被装载了，instance不一定被实例化。只有显示通过调用getInstance方法时，才会显示装载Singleton类，从而实例化instance。
public class Singleton {
	private static class SingletonHolder{
		private static final Singleton INSTANCE=new Singleton();
	}
	private Singleton() {}
	public static final Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
//第六种（枚举）不仅能避免多线程同步问题，而且还能反序列化重新创建新的对象
public enum Singleton{
	INSTANCE;
	public void whateverMethod() {
}
//第七种(双重校验锁)，在jdk1.5以后，双重锁定才能够正常达到单例效果。
public class Singleton{
	private volatile static Singleton singleton;
	private Singleton() {}
	public static Singleton getSingleton() {
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null)
				{
					singleton=new Singleton();
				}
			}
		}
		return singleton;
	}
}

