package com.tavant.aayush.training;

public class ArgumentBasedAnnonymousInnerDemo {
	public static void main(String[] args) {
//		I want to call Other's doSomething
		Other ref = new Other();
		ref.doSomething(new Fab() {
		@Override
			public void work() {
				System.out.println("Magical stuff this...");
			}
		});
	}
}

interface Fab{
	void work();
}

//class Sub implements Fab{
//	@Override
//	public void work() {
//		// TODO Auto-generated method stub
//		
//	}
//}

class Other{
	void doSomething(Fab theFab) {
		theFab.work();
	}
	
}





