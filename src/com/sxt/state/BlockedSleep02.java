package com.sxt.state;


/*
 * sleepģ����Ϣ
 * 
 */
public class BlockedSleep02 {
	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
		}
	
 class Racer implements Runnable{
		   private String winner; //ʤ����
			@Override
			public void run() {
				// TODO Auto-generated method stub
			for (int steps = 0; steps <=100; steps++) {
				//ģ����Ϣ
				if (Thread.currentThread().getName().equals("rabbit")&&steps%10==0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"-->"+steps);
				//�����Ƿ����
				boolean flag = gameOver(steps);
				if (flag) {
					break;
				}
			}	
			}
			
		private boolean gameOver(int steps) {
			if (winner!=null) { //����ʤ����
				return true;
			}else {
				if (steps ==100) {
					winner = Thread.currentThread().getName();
					System.out.println("winner==>"+winner);
			        return true;		
				}
			}
			return false;
		}
 }
		
			

	

