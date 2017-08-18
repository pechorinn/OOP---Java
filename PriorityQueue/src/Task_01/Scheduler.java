package homework.homework07.Task_01;

import java.util.PriorityQueue;

public class Scheduler implements ITask {

	private PriorityQueue<ITask> queue;

	Scheduler() {
		queue = new PriorityQueue<>((a1, a2) -> a2.getX() - a1.getX());
	}

	@Override
	public void doWork() {
		System.out.println("Task priority: " + queue.poll().getX());
		System.out.println("Removing the task from the Queue.");
	}

	public void push(ITask iTask) {
		System.out.println("Adding a task to the Queue. Task priority: " + iTask.getX());
		queue.add(iTask);
	}

	@Override
	public int getX() {
		return 0;
	}

	public static void main(String[] args) {

		Scheduler sch = new Scheduler();
		ITask firstITask = new ITask() {
			private int x = 10;

			@Override
			public void doWork() {
				System.out.println("Cleaning job!");
				sch.doWork();
			}

			@Override
			public int getX() {
				return x;
			}

		};

		ITask secondITask = new ITask() {
			private int x = 5;

			@Override
			public void doWork() {
				System.out.println("Answering e-mails of the clients!");
				sch.doWork();
			}

			@Override
			public int getX() {
				return x;
			}
		};

		ITask thirdITask = new ITask() {
			private int x = 7;

			@Override
			public void doWork() {
				System.out.println("Having a meeting!");
				sch.doWork();
			}

			@Override
			public int getX() {
				return x;
			}
		};

		ITask fourthITask = new ITask() {
			private int x = 15;

			@Override
			public void doWork() {
				System.out.println("Let's have a rest!");
				sch.doWork();
			}

			@Override
			public int getX() {
				return x;
			}
		};

		sch.push(firstITask);
		sch.push(secondITask);
		sch.push(thirdITask);
		sch.push(fourthITask);

		while (!sch.queue.isEmpty()) {

			ITask iTask = sch.queue.peek();
			iTask.doWork();
		}
	}
}
