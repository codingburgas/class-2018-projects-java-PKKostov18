package models;

import java.util.Objects;

public class Actor {
	
	private int actorId;
	private String actorName;
	
	public Actor(int actorId, String actorName) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(actorId, actor.actorId);
    }
	
    @Override
    public String toString() {
        return "Movie{" +
                " actorId = " + actorId +
                ", actorName = " + actorName +
                '}';
    }
}
