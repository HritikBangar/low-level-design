package entities;

public class Player {

    private String name;

    private int currentPosition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(Builder builder) {
        this.name = builder.getName();
        this.currentPosition = builder.currentPosition;
    }

    public static class Builder {
        private String name;
        private int currentPosition;

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public String getName() {
            return this.name;
        }

        public Player build() {
            this.currentPosition = 0;
            return new Player(this);
        }

    }

}
