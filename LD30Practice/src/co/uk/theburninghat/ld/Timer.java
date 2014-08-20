package co.uk.theburninghat.ld;

public class Timer {

	public int startTime;
	public int count, counter;

	public Timer() {
	}

	public void start(int count) {
		this.count = count;
		this.startTime = Main.globalTicks;
		this.counter = 0;
	}

	public boolean isDone() {
		if (startTime + counter >= startTime + count) {
			return true;
		}
		counter++;
		return false;
	}

}
