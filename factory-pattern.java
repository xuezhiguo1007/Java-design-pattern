package com.xzg.factory;

/**
 * 产品的抽象接口 人类
 * @author xuezhiguo
 *
 */
public interface Human {
	public void say();
}


package com.xzg.factory;

/**
 * man 男人
 * @author xuezhiguo
 *
 */
public class Man implements Human{
	public void say() {
		System.out.println("男人");
	}
}

package com.xzg.factory;

/**
 * 女人
 * @author xuezhiguo
 *
 */
public class Woman implements Human{
	public void say() {
		System.out.println("女人");
	}
}


package com.xzg.factory;

/**
 * 简单工厂
 * @author xuezhiguo
 *
 */
public class SampleFactory {
	public static Human makeHuman(String type) {
		if(type.equals("man")) {
			Human man=new Man();
			return man;
		}else if(type.equals("woman")) {
			Human woman=new Woman();
			return woman;
		}else {
			System.out.println("生产不出来");
			return null;
		}
	}
}


package com.xzg.factory;
/**
 * 简单工厂测试
 * @author xuezhiguo
 *
 */
public class Client {
	public static void main(String[] args) {
		Human man=SampleFactory.makeHuman("man");
		man.say();
		Human woman=SampleFactory.makeHuman("woman");
		woman.say();
		Human test=SampleFactory.makeHuman("tttt");
	}
}



