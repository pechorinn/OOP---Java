package docs;

import java.util.Random;

public abstract class Document {

	protected String title;
	protected int difficulty;
	protected boolean handled;
	protected int id;
	protected static int idNumber = 0;

	public Document() {
		super();
		this.id = ++idNumber;
		this.title = "Document " + id;
		Random rnd = new Random();
		this.difficulty = rnd.nextInt(20) + 1;
		this.handled = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + difficulty;
		result = prime * result + (handled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (difficulty != other.difficulty)
			return false;
		if (handled != other.handled)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getTitle() {
		return title;
	}

	public void changeStatus() {
		handled = true;
	}

	@Override
	public String toString() {
		return "Document [title=" + title + ", difficulty=" + difficulty + ", handled=" + handled + ", id=" + id + "]";
	}

	public int getDifficulty() {
		return difficulty;
	}
	

}
